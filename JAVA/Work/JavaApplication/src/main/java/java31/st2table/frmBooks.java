package java31.st2table;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class frmBooks extends JFrame {
    // List
    private static List<Book> books = null;
    private JPanel contentPane;
    private static JTable table;
    private JTextField textbookid;
    private JTextField textbookname;
    private JTextField textpublisher;
    private JTextField textyear;
    private JTextField textprice;
    private JTextField textauthid;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
                    
                    frmBooks frame = new frmBooks();
                    frame.setVisible(true);
                    
                    // 기초 데이터 생성
                    initData();
                    
                    //데이터 바인딩
                    frame.refreshTable(books, table);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void initData(){
        books = new ArrayList<>();
        books.add( new Book(1, "operating system" , "wiley" , "2003", 30700, false, 1 ) ) ;
        books.add( new Book(2, "mysql" , "oreilly" , "2009", 58700, true , 2 ) ) ;
        books.add( new Book(3, "java" , "hall" , "2013", 40000, true , 3 ) ) ;
        books.add( new Book(4, "first sql" , "wiley" , "2015", 57700, true , 4 ) ) ;

    }
    
    /**
     * Create the frame.
     */
    public frmBooks() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 755, 540);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 715, 200);
        contentPane.add(scrollPane);
        
        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
                // 선택한 로우를 리턴.
                int row =table.getSelectedRow();
                
                String saveId = table.getValueAt(row, 0).toString();
                String name = table.getValueAt(row, 1).toString();
                String expr = table.getValueAt(row, 2).toString();
                String year = table.getValueAt(row, 3).toString();
                String price = table.getValueAt(row, 4).toString();
                String authid = table.getValueAt(row, 6).toString();
                
                
                textbookid.setText(saveId);
                textbookname.setText(name);
                textpublisher.setText(expr);
                textyear.setText(year);
                textprice.setText(price);
                textauthid.setText(authid);
                
                
            }
        });
        table.setModel(new DefaultTableModel(
            new Object[][] {
            },
            new String[] {
                "bookid", "bookname", "publisher", "year", "price", "use_yn", "authid"
            }
        ) {
            Class[] columnTypes = new Class[] {
                Integer.class, String.class, String.class, String.class, Integer.class, Boolean.class, Integer.class
            };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        });
        table.getColumnModel().getColumn(1).setPreferredWidth(118);
        table.getColumnModel().getColumn(2).setPreferredWidth(106);
        table.getColumnModel().getColumn(6).setPreferredWidth(97);
        scrollPane.setViewportView(table);
        
        JButton btnNewButton = new JButton("조회");
        btnNewButton.setBounds(12, 220, 68, 23);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("추가");
        btnNewButton_1.setBounds(92, 220, 68, 23);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("수정");
        btnNewButton_2.setBounds(172, 220, 68, 23);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("삭제");
        btnNewButton_3.setBounds(252, 220, 68, 23);
        contentPane.add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("bookid");
        lblNewLabel.setBounds(12, 253, 57, 15);
        contentPane.add(lblNewLabel);
        
        textbookid = new JTextField();
        textbookid.setBounds(102, 253, 116, 21);
        contentPane.add(textbookid);
        textbookid.setColumns(10);
        
        JLabel lblBookname = new JLabel("bookname");
        lblBookname.setBounds(12, 278, 57, 15);
        contentPane.add(lblBookname);
        
        textbookname = new JTextField();
        textbookname.setColumns(10);
        textbookname.setBounds(102, 278, 116, 21);
        contentPane.add(textbookname);
        
        JLabel lblPublisher = new JLabel("publisher");
        lblPublisher.setBounds(12, 303, 57, 15);
        contentPane.add(lblPublisher);
        
        textpublisher = new JTextField();
        textpublisher.setColumns(10);
        textpublisher.setBounds(102, 303, 116, 21);
        contentPane.add(textpublisher);
        
        JLabel lblYear = new JLabel("year");
        lblYear.setBounds(12, 328, 57, 15);
        contentPane.add(lblYear);
        
        textyear = new JTextField();
        textyear.setColumns(10);
        textyear.setBounds(102, 328, 116, 21);
        contentPane.add(textyear);
        
        JLabel lblPrice = new JLabel("price");
        lblPrice.setBounds(12, 353, 57, 15);
        contentPane.add(lblPrice);
        
        textprice = new JTextField();
        textprice.setColumns(10);
        textprice.setBounds(102, 353, 116, 21);
        contentPane.add(textprice);
        
        JLabel lblUseyn = new JLabel("use_yn");
        lblUseyn.setBounds(12, 378, 57, 15);
        contentPane.add(lblUseyn);
        
        JLabel lblAuthid = new JLabel("authid");
        lblAuthid.setBounds(12, 403, 57, 15);
        contentPane.add(lblAuthid);
        
        textauthid = new JTextField();
        textauthid.setColumns(10);
        textauthid.setBounds(102, 403, 116, 21);
        contentPane.add(textauthid);
        
        JCheckBox chkuseyn = new JCheckBox("New check box");
        chkuseyn.setBounds(102, 380, 115, 23);
        contentPane.add(chkuseyn);
    }
    
    public void refreshTable( List<Book> list , JTable table){
        Object [] tempObject = new Object[7]; // JTable의 컬럼 갯수
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        model.setRowCount(0); // table 위치를 0 부터 시작하도록 설정.
        
        for (Book obj : list) {
            tempObject[0] = obj.getBookid();
            tempObject[1] = obj.getBookname();
            tempObject[2] = obj.getPublishe();
            tempObject[3] = obj.getYear();
            tempObject[4] = obj.getPrice();
            tempObject[6] = obj.getAuthid();
            model.addRow(tempObject);
            
        }
        
        // JTable 첫번째 로우에 focus 주기
        if(model.getRowCount()>0) {
            table.setRowSelectionInterval(0, 0);
        }
        
        table.setModel(model);
        
    }
    
}
