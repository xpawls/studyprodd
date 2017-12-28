package bookmanager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookmanager.inf.IServiceBook;
import bookmanager.inf.IServiceBorrow;
import bookmanager.inf.IServiceMember;
import bookmanager.model.ModelBook;
import bookmanager.model.ModelBorrow;
import bookmanager.model.ModelMember;

public class BorrowBook extends JFrame {
    private MainBookMg mainbook = null;
    private List<ModelMember> brmem = null;
    private List<ModelMember> brmems = null;
    private List<ModelMember> mem = null;
    private static BorrowBook frame = null;
    private JPanel contentPane;
    private JTextField textBorrBookname;
    private JTextField textBorrPub;
    private JTextField textBorrAut;
    private JTextField textMemSearch;
    private JTable tableMemberInfo;
    private static IServiceBook serviceb;
    private static IServiceMember servicem;
    private static IServiceBorrow servicebr;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new BorrowBook(serviceb, servicem, servicebr);
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
    public BorrowBook(IServiceBook serviceb, IServiceMember servicem, IServiceBorrow servicebr) {
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
                
                ModelMember member = new ModelMember();
                int no = Integer.valueOf(textMemSearch.getText());
                member.setMemNo(no);
                try {
                    mem = servicem.selectEqual(member);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    // e1.printStackTrace();
                    logger.error("actionPerformed" + e1.getMessage());
                    
                }
                mainbook = new MainBookMg();
                mainbook.refreshMemTable1(tableMemberInfo, mem);
                
                
                
            }
        });
        btnBorrSearch.setToolTipText("");
        btnBorrSearch.setBounds(192, 123, 88, 23);
        contentPane.add(btnBorrSearch);
        
        JButton btnBorrow = new JButton("대여");
        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ModelBorrow br = new ModelBorrow();
                
                List<ModelBook> book = null;
                ModelBook mb = new ModelBook();
                mb.setBookname(textBorrBookname.getText());
                try {
                    book = serviceb.selectEqual(mb);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    // e1.printStackTrace();
                    logger.error("actionPerformed" + e1.getMessage());
                }
                
                java.util.Date ud = new java.util.Date();
                java.sql.Date date = new java.sql.Date(ud.getTime());
                br.setMemname(mem.get(0).getMemName());
                br.setMemprinum(mem.get(0).getMemPriNum());
                br.setMemphone(mem.get(0).getMemPhone());
                br.setMememail(mem.get(0).getMemEmail());
                
                br.setBookname(book.get(0).getBookname());
                br.setAuthor(book.get(0).getAuthor());
                br.setCategory(book.get(0).getCategory());
                br.setBorrowdate(date);
                br.setBrno(book.get(0).getNo());
                br.setPublisher(book.get(0).getPublisher());
                
                int rs = -1;
                try {
                    rs = servicebr.insertBorrow(br);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    // e1.printStackTrace();
                    logger.error("actionPerformed" + e1.getMessage());
                }
                
                if(rs != -1) {
                    /*mb = book.get(0);
                    mb.setBorrow_yn(true);
                    ModelBook wb = new ModelBook();
                    wb.setNo(mb.getNo());
                    try {
                        serviceb.updateBook(wb , mb);
                    } catch (SQLException e1) {
                        logger.error("actionPerformed" + e1.getMessage());
                        
                    }*/
                    mainbook.refreshAll();
                    dispose();
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
    
    
}
