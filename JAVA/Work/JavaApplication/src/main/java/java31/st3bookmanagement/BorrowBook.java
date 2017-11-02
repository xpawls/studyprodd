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
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BorrowBook extends JFrame {
    
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
                    BorrowBook frame = new BorrowBook();
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
        btnBorrSearch.setToolTipText("");
        btnBorrSearch.setBounds(192, 123, 88, 23);
        contentPane.add(btnBorrSearch);
        
        JButton btnBorrow = new JButton("대여");
        btnBorrow.setBounds(309, 26, 97, 50);
        contentPane.add(btnBorrow);
        
        JButton butBorrCancel = new JButton("취소");
        butBorrCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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
                "No.", "\uC774\uB984", "\uC8FC\uBBFC\uBC88\uD638", "\uC804\uD654\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C"
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
    
}
