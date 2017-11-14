package java31.st3bookmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java23.jdbc.DBConnect2;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class NewBook extends JFrame {
    private static java.sql.Connection conn = null;
    private JPanel contentPane;
    private JTextField textInBookname;
    private JTextField textInPubli;
    private JTextField textInAuthor;
    private JTextField textInPrice;
    private MainBookMg mianbook = null;
    private BookD bookd;
    private static Integer count = 1;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    conn = DBConnect2.makeConnection();
                    NewBook frame = new NewBook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public NewBook() {
        setTitle("책 등록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 269, 317);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("책 제목");
        label.setBounds(28, 40, 57, 15);
        contentPane.add(label);
        
        textInBookname = new JTextField();
        textInBookname.setColumns(10);
        textInBookname.setBounds(98, 37, 132, 21);
        contentPane.add(textInBookname);
        
        textInPubli = new JTextField();
        textInPubli.setColumns(10);
        textInPubli.setBounds(98, 65, 132, 21);
        contentPane.add(textInPubli);
        
        JLabel label_1 = new JLabel("출판사");
        label_1.setBounds(28, 68, 57, 15);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("저자");
        label_2.setBounds(28, 96, 57, 15);
        contentPane.add(label_2);
        
        textInAuthor = new JTextField();
        textInAuthor.setColumns(10);
        textInAuthor.setBounds(98, 93, 132, 21);
        contentPane.add(textInAuthor);
        
        textInPrice = new JTextField();
        textInPrice.setColumns(10);
        textInPrice.setBounds(98, 121, 89, 21);
        contentPane.add(textInPrice);
        
        JLabel label_3 = new JLabel("가격");
        label_3.setBounds(28, 124, 57, 15);
        contentPane.add(label_3);
        
        JLabel label_4 = new JLabel("장르");
        label_4.setBounds(28, 152, 57, 15);
        contentPane.add(label_4);
        
        JLabel lblNewLabel = new JLabel("책 정보 입력");
        lblNewLabel.setBounds(86, 12, 101, 15);
        contentPane.add(lblNewLabel);
        
        JComboBox comboCategory = new JComboBox();
        comboCategory.setModel(new DefaultComboBoxModel(new String[] {"소설", "교육", "문학", "해외", "기타"}));
        comboCategory.setBounds(98, 149, 89, 21);
        contentPane.add(comboCategory);
        
        JButton btnInputBook = new JButton("등록");
        btnInputBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textInBookname.getText();
                String publ = textInPubli.getText();
                String auth = textInAuthor.getText();
                Integer pri = Integer.valueOf(textInPrice.getText());
                String var = comboCategory.getSelectedItem().toString();

                try {
                    String query = " insert into bookd ( no, bookname, publisher, category, author, price) ";
                           query+= "            values ( ?,?,?,?,?,?)";
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setInt(1, count);
                    stmt.setString(2, name);
                    stmt.setString(3, publ);
                    stmt.setString(4, var);
                    stmt.setString(5, auth);
                    stmt.setInt(6, pri);
                    stmt.executeUpdate();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                }
                countno();
                
                dispose();
            }
        });
        btnInputBook.setBounds(40, 212, 89, 40);
        contentPane.add(btnInputBook);
        
        JButton butCancelBook = new JButton("취소");
        butCancelBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        butCancelBook.setBounds(141, 212, 89, 40);
        contentPane.add(butCancelBook);
    }
    
    public static void countno(){
        count++;
    }
    public BookD newboo(){
        return bookd;
    }
}
