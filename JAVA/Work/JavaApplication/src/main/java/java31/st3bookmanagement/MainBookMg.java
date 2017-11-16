package java31.st3bookmanagement;

import static org.hamcrest.CoreMatchers.nullValue;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import java.awt.Choice;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.tree.DefaultTreeModel;

import java23.jdbc.DBConnect2;

import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainBookMg extends JFrame {
    private Connection conn =null;
    private JoinMember newmember = null;
    private NewBook newbook = null;
    private static MainBookMg frame = null;
    private List<BookD> bookd = null;
    private List<MemberD> memberd = null;
    private List<MemberD> memlist = null;
    private List<BookD> booklist = null;
    private JPanel contentPane;
    private JTable table;
    private JTable tablemainbook;
    private JTextField textBookname;
    private JTextField textPublisher;
    private JTextField textauthor;
    private JTextField textPrice;
    private JTextField textVar;
    private JTextField textBookno;
    private JTextField textbookSearch;
    private JTextField textname;
    private JTextField textnumber;
    private JTextField textprinum1;
    private JTextField textprinum2;
    private JTextField textphonnum1;
    private JTextField textphonnum2;
    private JTextField textmailad1;
    private JTextField textmailad2;
    private JTextField textMemsearch;
    private JTextField textphonnum3;
    private JTable tableMember;
    private JTable tableborrow;
    private PreparedStatement stmt;
    private ResultSet result;
    public MainBookMg(List<BookD> bookd, List<MemberD> memberd)
            throws HeadlessException {
        super();
        this.bookd = bookd;
        this.memberd = memberd;
    }
    


    public List<BookD> getBookd() {
        return bookd;
    }



    public void setBookd(List<BookD> bookd) {
        this.bookd = bookd;
    }



    public List<MemberD> getMemberd() {
        return memberd;
    }



    public void setMemberd(List<MemberD> memberd) {
        this.memberd = memberd;
    }



    /**
     * Launch the application.
     */
    public static void main(String[] args) { // 메인
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new MainBookMg();
                    frame.setVisible(true);
                    frame.conn = DBConnect2.makeConnection();
                    
                    frame.refreshMemTable1(frame.tableMember, "");
                    frame.refreshTable2(frame.tablemainbook, "");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    
    public MemberD brmem(int s){
        int goal = 0;
        for(int i=0; i<memberd.size(); i++){
            if(memberd.get(i).getMemNo().equals(s)){
                goal = i;
            }
        }
        MemberD result = memberd.get(goal);
        return result;
    }
    /**
     * Create the frame.
     */
    public MainBookMg() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1140, 804);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel topButpanel = new JPanel();
        topButpanel.setBounds(0, 0, 693, 105);
        contentPane.add(topButpanel);
        topButpanel.setLayout(null);
        
        JButton joinBut = new JButton("회원등록");
        joinBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JoinMember join = new JoinMember();
                join.setVisible(true);
                
            }
        });
        joinBut.setBounds(12, 10, 159, 85);
        topButpanel.add(joinBut);
        
        JButton newBookBut = new JButton("책 등록");
        newBookBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                NewBook newbook = new NewBook();
                newbook.setVisible(true);
                
            }
        });
        newBookBut.setBounds(183, 10, 159, 85);
        topButpanel.add(newBookBut);
        
        JButton refreshBut = new JButton("새로고침");
        refreshBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.refreshTable2(tablemainbook, "");
                frame.refreshMemTable1(tableMember, "");
            }
        });
        refreshBut.setBounds(354, 10, 159, 85);
        topButpanel.add(refreshBut);
        
        JButton exitBut = new JButton("프로그램 종료");
        exitBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exitBut.setBounds(525, 10, 159, 85);
        topButpanel.add(exitBut);
        
        JScrollPane borrowscroll = new JScrollPane();
        borrowscroll.setBounds(0, 137, 354, 396);
        contentPane.add(borrowscroll);
        
        table = new JTable();
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "\uC774\uB984", "\uCC45 \uC81C\uBAA9", "\uB300\uC5EC \uB0A0\uC9DC"
            }
        ) {
            Class[] columnTypes = new Class[] {
                String.class, String.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        borrowscroll.setViewportView(table);
        
        JLabel label = new JLabel("대출 상황");
        label.setBounds(129, 112, 57, 15);
        contentPane.add(label);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(360, 115, 752, 630);
        contentPane.add(tabbedPane);
        
        JPanel panelBookInfo = new JPanel();
        tabbedPane.addTab("책 정보", null, panelBookInfo, null);
        panelBookInfo.setLayout(null);
        
        JTree treeBookinfo = new JTree();
        treeBookinfo.setModel(new DefaultTreeModel(
            new DefaultMutableTreeNode("장르") {
                {
                    
                }
            }
        ));
        treeBookinfo.setBounds(0, 0, 271, 266);
        panelBookInfo.add(treeBookinfo);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 326, 723, 167);
        panelBookInfo.add(scrollPane);
        
        tablemainbook = new JTable();
        tablemainbook.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tablemainbook.getSelectedRow();
                
                String no = tablemainbook.getValueAt(row, 0).toString();
                String bname = tablemainbook.getValueAt(row, 1).toString();
                String publi = tablemainbook.getValueAt(row, 2).toString();
                String catego = tablemainbook.getValueAt(row, 3).toString();
                String author = tablemainbook.getValueAt(row, 4).toString();
                String price = tablemainbook.getValueAt(row, 5).toString();
                
                textBookno.setText(no);
                textBookname.setText(bname);
                textPublisher.setText(publi);
                textVar.setText(catego);
                textauthor.setText(author);
                textPrice.setText(price);
                
                
            }
        });
        tablemainbook.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "No.", "\uC81C\uBAA9", "\uCD9C\uD310\uC0AC", "\uC7A5\uB974", "\uC800\uC790", "\uAC00\uACA9", "\uB300\uC5EC\uC815\uBCF4"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Integer.class, String.class, String.class, String.class, String.class, Integer.class, Boolean.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPane.setViewportView(tablemainbook);
        
        JLabel lblNewLabel = new JLabel("책 제목");
        lblNewLabel.setBounds(283, 10, 57, 15);
        panelBookInfo.add(lblNewLabel);
        
        textBookname = new JTextField();
        textBookname.setBounds(353, 7, 116, 21);
        panelBookInfo.add(textBookname);
        textBookname.setColumns(10);
        
        JLabel label_1 = new JLabel("출판사");
        label_1.setBounds(283, 38, 57, 15);
        panelBookInfo.add(label_1);
        
        textPublisher = new JTextField();
        textPublisher.setColumns(10);
        textPublisher.setBounds(353, 35, 116, 21);
        panelBookInfo.add(textPublisher);
        
        JLabel label_2 = new JLabel("저자");
        label_2.setBounds(283, 66, 57, 15);
        panelBookInfo.add(label_2);
        
        textauthor = new JTextField();
        textauthor.setColumns(10);
        textauthor.setBounds(353, 63, 116, 21);
        panelBookInfo.add(textauthor);
        
        JLabel label_3 = new JLabel("가격");
        label_3.setBounds(283, 94, 57, 15);
        panelBookInfo.add(label_3);
        
        textPrice = new JTextField();
        textPrice.setColumns(10);
        textPrice.setBounds(353, 91, 116, 21);
        panelBookInfo.add(textPrice);
        
        JLabel label_4 = new JLabel("장르");
        label_4.setBounds(283, 122, 57, 15);
        panelBookInfo.add(label_4);
        
        textVar = new JTextField();
        textVar.setColumns(10);
        textVar.setBounds(353, 119, 116, 21);
        panelBookInfo.add(textVar);
        
        JLabel label_5 = new JLabel("책 번호");
        label_5.setBounds(481, 10, 57, 15);
        panelBookInfo.add(label_5);
        
        textBookno = new JTextField();
        textBookno.setColumns(10);
        textBookno.setBounds(550, 7, 36, 21);
        panelBookInfo.add(textBookno);
        
        JLabel label_6 = new JLabel("검색");
        label_6.setBounds(283, 160, 57, 15);
        panelBookInfo.add(label_6);
        
        textbookSearch = new JTextField();
        textbookSearch.setColumns(10);
        textbookSearch.setBounds(441, 157, 116, 21);
        panelBookInfo.add(textbookSearch);
        
        JComboBox comboSearch = new JComboBox();
        comboSearch.setModel(new DefaultComboBoxModel(new String[] {"제목", "출판사", "저자", "장르", "가격"}));
        comboSearch.setBounds(353, 157, 75, 21);
        panelBookInfo.add(comboSearch);
        
        JButton btnBorrow = new JButton("대여하기");
        btnBorrow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BorrowBook borbook = new BorrowBook();                
                borbook.setVisible(true);
                
                borbook.bookborrow(borrowbn(), borrowpb(), borrowau());
                
            }
        });
        btnBorrow.setBounds(283, 243, 97, 52);
        panelBookInfo.add(btnBorrow);
        
        JButton butModify = new JButton("수정");
        butModify.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String uplb = "update bookd set ";
                       uplb+= " no =?, bookname= ?, category=?";
                       uplb+= ", author= ? , price= ? ";
                       uplb+= " where no = ? ;";
                try {
                    stmt = conn.prepareStatement(uplb);
                    stmt.setInt(1, Integer.valueOf(textBookno.getText()));
                    stmt.setString(2, textBookname.getText());
                    stmt.setString(3, textVar.getText());
                    stmt.setString(4, textauthor.getText());
                    stmt.setInt(5, Integer.valueOf(textPrice.getText()));
                    stmt.setInt(6, Integer.valueOf(textBookno.getText()));
                    stmt.executeUpdate();
                } catch (NumberFormatException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                }
                frame.refreshTable2(tablemainbook, "");
            
            }
        });
        butModify.setBounds(392, 243, 97, 52);
        panelBookInfo.add(butModify);
        
        JButton butdelete = new JButton("삭제");
        butdelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String delb = "delete from bookd where ";
                       delb+= " no =? and bookname= ? and category=?";
                       delb+= " and author= ? and price= ?;";
                try {
                    stmt = conn.prepareStatement(delb);
                    stmt.setInt(1, Integer.valueOf(textBookno.getText()));
                    stmt.setString(2, textBookname.getText());
                    stmt.setString(3, textVar.getText());
                    stmt.setString(4, textauthor.getText());
                    stmt.setInt(5, Integer.valueOf(textPrice.getText()));
                    stmt.executeUpdate();
                } catch (NumberFormatException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                }
                frame.refreshTable2(tablemainbook, "");
            
            }
        });
        butdelete.setBounds(501, 243, 97, 52);
        panelBookInfo.add(butdelete);
        
        JButton butCancel = new JButton("취소");
        butCancel.setBounds(610, 243, 97, 52);
        panelBookInfo.add(butCancel);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bscf = " where ";
                String bscs = "";
                String bsct = "";
                
                int bsc = 0;
                if(comboSearch.getSelectedItem().toString().equals("제목")){
                    bscs = " bookname ";
                } else if(comboSearch.getSelectedItem().toString().equals("출판사")){
                    bscs = " publisher ";
                } else if(comboSearch.getSelectedItem().toString().equals("저자")){
                    bscs = " author ";
                } else if(comboSearch.getSelectedItem().toString().equals("장르")){
                    bscs = " category ";
                } else if(comboSearch.getSelectedItem().toString().equals("가격")){
                    bscs = " price ";
                    bsc = 1;
                }
                if(bsc==1){
                    bsct = " = " +textbookSearch.getText();
                } else {
                    bsct = " like " +"'%"+textbookSearch.getText()+"%'";
                }
                String bsccpt = bscf + bscs + bsct;
                frame.refreshTable2(tablemainbook, bsccpt);
            }
        });
        btnSearch.setBounds(558, 156, 62, 23);
        panelBookInfo.add(btnSearch);
        
        JPanel panelMember = new JPanel();
        tabbedPane.addTab("회원 관리", null, panelMember, null);
        panelMember.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("이름");
        lblNewLabel_1.setBounds(24, 10, 57, 15);
        panelMember.add(lblNewLabel_1);
        
        textname = new JTextField();
        textname.setBounds(93, 7, 99, 21);
        panelMember.add(textname);
        textname.setColumns(10);
        
        textnumber = new JTextField();
        textnumber.setBounds(204, 7, 36, 21);
        panelMember.add(textnumber);
        textnumber.setColumns(10);
        
        JLabel label_7 = new JLabel("주민번호");
        label_7.setBounds(24, 38, 57, 15);
        panelMember.add(label_7);
        
        textprinum1 = new JTextField();
        textprinum1.setColumns(10);
        textprinum1.setBounds(93, 35, 99, 21);
        panelMember.add(textprinum1);
        
        textprinum2 = new JTextField();
        textprinum2.setColumns(10);
        textprinum2.setBounds(204, 35, 104, 21);
        panelMember.add(textprinum2);
        
        JLabel label_8 = new JLabel("전화번호");
        label_8.setBounds(24, 66, 57, 15);
        panelMember.add(label_8);
        
        textphonnum1 = new JTextField();
        textphonnum1.setColumns(10);
        textphonnum1.setBounds(93, 63, 99, 21);
        panelMember.add(textphonnum1);
        
        textphonnum2 = new JTextField();
        textphonnum2.setColumns(10);
        textphonnum2.setBounds(204, 63, 104, 21);
        panelMember.add(textphonnum2);
        
        JLabel label_9 = new JLabel("메일주소");
        label_9.setBounds(24, 94, 57, 15);
        panelMember.add(label_9);
        
        textmailad1 = new JTextField();
        textmailad1.setColumns(10);
        textmailad1.setBounds(93, 91, 99, 21);
        panelMember.add(textmailad1);
        
        textmailad2 = new JTextField();
        textmailad2.setColumns(10);
        textmailad2.setBounds(204, 91, 104, 21);
        panelMember.add(textmailad2);
        
        JLabel label_10 = new JLabel("검색");
        label_10.setBounds(24, 122, 57, 15);
        panelMember.add(label_10);
        
        textMemsearch = new JTextField();
        textMemsearch.setColumns(10);
        textMemsearch.setBounds(204, 119, 116, 21);
        panelMember.add(textMemsearch);
        
        textphonnum3 = new JTextField();
        textphonnum3.setColumns(10);
        textphonnum3.setBounds(320, 63, 104, 21);
        panelMember.add(textphonnum3);
        
        JComboBox BoxMainMem = new JComboBox();
        BoxMainMem.setModel(new DefaultComboBoxModel(new String[] {"회원번호", "이름", "주민번호", "전화번호", "메일주소"}));
        BoxMainMem.setBounds(93, 119, 99, 21);
        panelMember.add(BoxMainMem);
        
        JButton btnMemdel = new JButton("회원삭제");
        btnMemdel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String delm = "delete from memberd where ";
                       delm+= " memno=? and memname=? and ";
                       delm+= " memprinum=? and memphone=? and mememail=? ;";
                try {
                    stmt = conn.prepareStatement(delm);
                    stmt.setInt(1, Integer.valueOf(textnumber.getText()));
                    stmt.setString(2, textname.getText());
                    stmt.setString(3, textprinum1.getText()+"-"+textprinum2.getText());
                    stmt.setString(4, textphonnum1.getText()+"-"+textphonnum2.getText()+"-"+textphonnum3.getText());
                    stmt.setString(5, textmailad1.getText()+"@"+textmailad2.getText());
                    stmt.executeUpdate();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                }
                frame.refreshMemTable1(tableMember, "");
                
            }
        });
        btnMemdel.setBounds(12, 150, 152, 66);
        panelMember.add(btnMemdel);
        
        JButton butMemModi = new JButton("회원수정");
        butMemModi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String uplm = "update memberd set ";
                        uplm+= " memno=?, memname=?, ";
                        uplm+= " memprinum=?, memphone=?, mememail=? ";
                        uplm+= " where memno=? ;";
                try {
                    stmt = conn.prepareStatement(uplm);
                    stmt.setInt(1, Integer.valueOf(textnumber.getText()));
                    stmt.setString(2, textname.getText());
                    stmt.setString(3, textprinum1.getText()+"-"+textprinum2.getText());
                    stmt.setString(4, textphonnum1.getText()+"-"+textphonnum2.getText()+"-"+textphonnum3.getText());
                    stmt.setString(5, textmailad1.getText()+"@"+textmailad2.getText());
                    stmt.setInt(6 , Integer.valueOf(textnumber.getText()));
                    stmt.executeUpdate();
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                    
                }
                frame.refreshMemTable1(tableMember, "");
                
            
            }
        });
        butMemModi.setBounds(176, 150, 152, 66);
        panelMember.add(butMemModi);
        
        JButton butMemCan = new JButton("취소");
        butMemCan.setBounds(340, 150, 152, 66);
        panelMember.add(butMemCan);
        
        JScrollPane scrollMember = new JScrollPane();
        scrollMember.setBounds(12, 226, 723, 365);
        panelMember.add(scrollMember);
        
        tableMember = new JTable();
        tableMember.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {//테이블정보 텍스트필드로 복사
                int row = tableMember.getSelectedRow();
                String mno = tableMember.getValueAt(row, 0).toString();
                String mname = tableMember.getValueAt(row, 1).toString();
                String mpri = tableMember.getValueAt(row, 2).toString();
                String mphonn = tableMember.getValueAt(row, 3).toString();
                String mmail = tableMember.getValueAt(row, 4).toString();
                
                String[] mpria = mpri.split("-");
                String[] mphoa = mphonn.split("-");
                String[] mmaila = mmail.split("@");
                
                textnumber.setText(mno);
                textname.setText(mname);
                textprinum1.setText(mpria[0]);
                textprinum2.setText(mpria[1]);
                textphonnum1.setText(mphoa[0]);
                textphonnum2.setText(mphoa[1]);
                textphonnum3.setText(mphoa[2]);
                textmailad1.setText(mmaila[0]);
                textmailad2.setText(mmaila[1]);
                
            }
        });
        tableMember.setModel(new DefaultTableModel(
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
        scrollMember.setViewportView(tableMember);
        
        JLabel label_11 = new JLabel("-");
        label_11.setBounds(192, 38, 11, 15);
        panelMember.add(label_11);
        
        JLabel label_12 = new JLabel("-");
        label_12.setBounds(192, 66, 11, 15);
        panelMember.add(label_12);
        
        JLabel label_13 = new JLabel("-");
        label_13.setBounds(309, 66, 11, 15);
        panelMember.add(label_13);
        
        JLabel label_14 = new JLabel("@");
        label_14.setBounds(192, 94, 21, 15);
        panelMember.add(label_14);
        
        JButton btnMemsearch = new JButton("검색");
        btnMemsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {// 회원검색
                int mems = -1;
                String msc = " where ";
                String mstx = null;
                String mes = null;
                if(BoxMainMem.getSelectedItem().toString().equals("회원번호")){
                    mstx =  " memno ";
                    mems = 1;
                } else if (BoxMainMem.getSelectedItem().toString().equals("이름")){
                    mstx =  " memname ";
                    mems = 0;
                } else if (BoxMainMem.getSelectedItem().toString().equals("주민번호")){
                    mstx =  " memprinum ";
                    mems = 0;
                } else if (BoxMainMem.getSelectedItem().toString().equals("전화번호")){
                    mstx =  " memphone ";
                    mems = 0;
                }else if (BoxMainMem.getSelectedItem().toString().equals("메일주소")){
                    mstx =  " mememail ";
                    mems = 0;
                }
                if(mems==1){
                    mes = " = " +textMemsearch.getText();
                } else {
                    mes = " like " +"'%"+textMemsearch.getText()+"%'";
                }
                String msquery = msc+mstx+ mes ;
                refreshMemTable1(tableMember, msquery);
                
            }
        });
        btnMemsearch.setBounds(327, 118, 67, 23);
        panelMember.add(btnMemsearch);
        
        JPanel panelBorrow = new JPanel();
        tabbedPane.addTab("대여 목록", null, panelBorrow, null);
        panelBorrow.setLayout(null);
        
        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(25, 183, 697, 219);
        panelBorrow.add(scrollPane_1);
        
        tableborrow = new JTable();
        tableborrow.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "No.", "\uC774\uB984", "\uC804\uD654\uBC88\uD638", "\uC8FC\uBBFC\uBC88\uD638", "\uBA54\uC77C\uC8FC\uC18C", "\uCC45 \uC81C\uBAA9", "\uCD9C\uD310\uC0AC", "\uC7A5\uB974", "\uC800\uC790", "\uCC45\uBC88\uD638", "\uB300\uC5EC\uB0A0\uC9DC"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Integer.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        scrollPane_1.setViewportView(tableborrow);
        
        JButton btnComplete = new JButton("반납 완료");
        btnComplete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnComplete.setBounds(566, 98, 155, 75);
        panelBorrow.add(btnComplete);
    }
    
    public void refreshTable2(JTable table, String plus){// BookD리스트 출력
        Object [] tempObject = new Object[7]; // JTable의 컬럼 갯수
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // table 위치를 0 부터 시작하도록 설정.
        String query = " select * from bookd " + plus + ";";
        try {
            stmt = conn.prepareStatement(query);
            result = stmt.executeQuery();
            while(result.next()) {
                tempObject[0] = result.getInt(1); 
                tempObject[1] = result.getString(2); 
                tempObject[2] = result.getString(3); 
                tempObject[3] = result.getString(4); 
                tempObject[4] = result.getString(5); 
                tempObject[5] = result.getInt(6); 
                model.addRow(tempObject);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        // JTable 첫번째 로우에 focus 주기
        if(model.getRowCount()>0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
    }
    
    public void refreshMemTable1( JTable table , String plus){// MemberD 리스트 출력
        Object [] tempObject = new Object[5]; // JTable의 컬럼 갯수
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // table 위치를 0 부터 시작하도록 설정.
        
        String query = " select * from memberd "+ plus +";";
        try {
            stmt = conn.prepareStatement(query);
            result = stmt.executeQuery();
            while(result.next()){
                tempObject[0] = result.getInt(1);
                tempObject[1] = result.getString(2);
                tempObject[2] = result.getString(3);
                tempObject[3] = result.getString(4);
                tempObject[4] = result.getString(5);
                model.addRow(tempObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        if(model.getRowCount()>0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
        
    }
    public void refreshBrr(JTable table){
        Object [] tempObject = new Object[11]; // JTable의 컬럼 갯수
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // table 위치를 0 부터 시작하도록 설정.
        
        String query = " select * from borrowd ;";
        try {
            stmt = conn.prepareStatement(query);
            result = stmt.executeQuery();
            while(result.next()){
                tempObject[0] = result.getInt(1);
                tempObject[1] = result.getString(2);
                tempObject[2] = result.getString(3);
                tempObject[3] = result.getString(4);
                tempObject[4] = result.getString(5);
                tempObject[5] = result.getString(6);
                tempObject[6] = result.getString(7);
                tempObject[7] = result.getString(8);
                tempObject[8] = result.getString(9);
                tempObject[9] = result.getInt(10);
                tempObject[10] = result.getString(11);
                model.addRow(tempObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        if(model.getRowCount()>0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
    }
    
    public String borrowbn(){
        return textBookname.getText();
    }
    public String borrowpb(){
        return textPublisher.getText();
    }
    public String borrowau(){
        return textauthor.getText();
    }
}
