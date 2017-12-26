package bookmanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import bookmanager.model.ModelMember;

public class BorrowBook extends JFrame {
    private java.sql.Connection conn;
    private PreparedStatement stmt;
    private MainBookMg mainbook = null;
    private List<ModelMember> brmem = null;
    private List<ModelMember> brmems = null;
    private static BorrowBook frame = null;
    private JPanel contentPane;
    private JTextField textBorrBookname;
    private JTextField textBorrPub;
    private JTextField textBorrAut;
    private JTextField textMemSearch;
    private JTable tableMemberInfo;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new BorrowBook();
                    frame.setVisible(true);
                    frame.initText();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void initText(){
        textBorrBookname.setText(mainbook.borrowbn());
        textBorrPub.setText(mainbook.borrowpb());
        textBorrAut.setText(mainbook.borrowau());
    }
    
    /**
     * Create the frame.
     */
    public BorrowBook() {
        setTitle("책 대여");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 436, 413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("책 제목");
        label.setBounds(12, 30, 57, 15);
        contentPane.add(label);
        
        textBorrBookname = new JTextField();
        textBorrBookname.setColumns(10);
        textBorrBookname.setBounds(82, 27, 193, 21);
        contentPane.add(textBorrBookname);
        
        textBorrPub = new JTextField();
        textBorrPub.setColumns(10);
        textBorrPub.setBounds(82, 55, 193, 21);
        contentPane.add(textBorrPub);
        
        JLabel label_1 = new JLabel("출판사");
        label_1.setBounds(12, 58, 57, 15);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("저자");
        label_2.setBounds(12, 86, 57, 15);
        contentPane.add(label_2);
        
        textBorrAut = new JTextField();
        textBorrAut.setColumns(10);
        textBorrAut.setBounds(82, 83, 193, 21);
        contentPane.add(textBorrAut);
        
        JLabel lblNewLabel = new JLabel("회원 번호 검색");
        lblNewLabel.setBounds(12, 127, 98, 15);
        contentPane.add(lblNewLabel);
        
        textMemSearch = new JTextField();
        textMemSearch.setBounds(98, 124, 88, 21);
        contentPane.add(textMemSearch);
        textMemSearch.setColumns(10);
        
        JButton btnBorrSearch = new JButton("검색");
        btnBorrSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                
                
                
            }
        });
        btnBorrSearch.setToolTipText("");
        btnBorrSearch.setBounds(192, 123, 88, 23);
        contentPane.add(btnBorrSearch);
        
        JButton btnBorrow = new JButton("대여");
        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String brin = " insert into borrowd ( memname, memphone, memprinum, mememail, ";
                       brin+= "bookname, publisher, category, author, bookno, borrowdate)";
                       brin+= " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
                Object[] obbo = frame.brbookk();
                Object[] obme = frame.brmemk();
                try {
                    
                    stmt = conn.prepareStatement(brin);
                    stmt.setString(1, (String)obme[1]);
                    stmt.setString(2, (String)obme[3]);
                    stmt.setString(3, (String)obme[2]);
                    stmt.setString(4, (String)obme[4]);
                    stmt.setString(5, (String)obbo[1]);
                    stmt.setString(6, (String)obbo[2]);
                    stmt.setString(7, (String)obbo[3]);
                    stmt.setString(8, (String)obbo[4]);
                    stmt.setInt(9, (Integer)obbo[0]);
                    stmt.setString(10, "2017.11");
                    stmt.executeUpdate();
                    
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                }
            }
        });
        btnBorrow.setBounds(309, 26, 97, 50);
        contentPane.add(btnBorrow);
        
        JButton butBorrCancel = new JButton("취소");
        butBorrCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        butBorrCancel.setBounds(309, 92, 97, 50);
        contentPane.add(butBorrCancel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 152, 394, 206);
        contentPane.add(scrollPane);
        
        tableMemberInfo = new JTable();
        tableMemberInfo.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "\uD68C\uC6D0\uBC88\uD638", "\uC774\uB984", "\uC8FC\uBBFC\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Integer.class, String.class, String.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPane.setViewportView(tableMemberInfo);
    }
    
    public void bookborrow(String bn, String bp, String ba){
        textBorrBookname.setText(bn);
        textBorrPub.setText(bp);
        textBorrAut.setText(ba);
        
    }
    public Object[] brbookmem(Object[] obj){
        Object[] ob = null; 
        return ob;
    }
    public Object[] brbookk(){
        ResultSet result = null;
        Object[] obj =new Object[6];
        String query = "select * from bookd where bookname=? and publisher=? and author=? ;";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, textBorrBookname.getText());
            stmt.setString(2, textBorrPub.getText());
            stmt.setString(3, textBorrAut.getText());
            result = stmt.executeQuery();
            result.next();
            for(int i =1; i<=6; i++){
                obj[i-1] = result.getObject(i);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return obj;
    }
    public Object[] brmemk(){
        ResultSet result = null;
        Object[] obj =new Object[5];
        String query = "select * from ModelMember where memno=? ";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, textMemSearch.getText());
            
            result = stmt.executeQuery();
            result.next();
            for(int i =1; i<=5; i++){
                obj[i-1] = result.getObject(i);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return obj;
    }
    
    
}
