package java31.st3bookmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BorrowBook extends JFrame {
    
    private MainBookMg mainbook = null;
    private List<MemberD> brmem = null;
    private List<MemberD> brmems = null;
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
                MainBookMg mg = new MainBookMg();
                brmem = mg.getMemberd();
                brmems = new ArrayList<>();
                brmems.clear();
                int memno = Integer.valueOf(textMemSearch.getText());
                for(int i=0; i<brmem.size(); i++){
                    if(brmem.get(i).getMemID().equals(memno)){
                        memno = i;
                    }
                }
                brmems.add(brmem.get(memno));
                frame.mainbook.refreshMemTable(brmems, tableMemberInfo);
            }
        });
        btnBorrSearch.setToolTipText("");
        btnBorrSearch.setBounds(192, 123, 88, 23);
        contentPane.add(btnBorrSearch);
        
        JButton btnBorrow = new JButton("대여");
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
    
}
