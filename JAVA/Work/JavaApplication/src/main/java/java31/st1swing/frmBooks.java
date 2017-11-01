package java31.st1swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JList;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JTable;

public class frmBooks extends JFrame {
    
    private JPanel contentPane;
    private JTextField bookidt;
    private JTextField booknamet;
    private JTextField publishert;
    private JTextField yeart;
    private JTextField pricet;
    private JTextField dtmt;
    private JTextField authidt;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmBooks frame = new frmBooks();
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
    public frmBooks() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 515, 455);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton viewbu = new JButton("조회");
        viewbu.setBounds(12, 164, 57, 23);
        contentPane.add(viewbu);
        
        JButton addbu = new JButton("추가");
        addbu.setBounds(81, 164, 57, 23);
        contentPane.add(addbu);
        
        JButton modifybu = new JButton("수정");
        modifybu.setBounds(150, 164, 57, 23);
        contentPane.add(modifybu);
        
        JButton deletebu = new JButton("삭제");
        deletebu.setBounds(219, 164, 57, 23);
        contentPane.add(deletebu);
        
        JLabel lblNewLabel = new JLabel("bookid");
        lblNewLabel.setBounds(12, 197, 57, 15);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("bookname");
        lblNewLabel_1.setBounds(12, 223, 70, 15);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("publisher");
        lblNewLabel_2.setBounds(12, 248, 57, 15);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("year");
        lblNewLabel_3.setBounds(12, 273, 57, 15);
        contentPane.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("pirce");
        lblNewLabel_4.setBounds(12, 298, 57, 15);
        contentPane.add(lblNewLabel_4);
        
        JLabel lblNewLabel_5 = new JLabel("dtm");
        lblNewLabel_5.setBounds(12, 323, 57, 15);
        contentPane.add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("use_yn");
        lblNewLabel_6.setBounds(12, 348, 57, 15);
        contentPane.add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("authid");
        lblNewLabel_7.setBounds(12, 373, 57, 15);
        contentPane.add(lblNewLabel_7);
        
        bookidt = new JTextField();
        bookidt.setBounds(94, 194, 116, 21);
        contentPane.add(bookidt);
        bookidt.setColumns(10);
        
        booknamet = new JTextField();
        booknamet.setBounds(94, 220, 116, 21);
        contentPane.add(booknamet);
        booknamet.setColumns(10);
        
        publishert = new JTextField();
        publishert.setBounds(94, 245, 116, 21);
        contentPane.add(publishert);
        publishert.setColumns(10);
        
        yeart = new JTextField();
        yeart.setBounds(94, 270, 116, 21);
        contentPane.add(yeart);
        yeart.setColumns(10);
        
        pricet = new JTextField();
        pricet.setBounds(94, 295, 116, 21);
        contentPane.add(pricet);
        pricet.setColumns(10);
        
        dtmt = new JTextField();
        dtmt.setBounds(94, 320, 116, 21);
        contentPane.add(dtmt);
        dtmt.setColumns(10);
        
        authidt = new JTextField();
        authidt.setBounds(94, 370, 116, 21);
        contentPane.add(authidt);
        authidt.setColumns(10);
        
        JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
        chckbxNewCheckBox.setBounds(95, 344, 115, 23);
        contentPane.add(chckbxNewCheckBox);
    }
}
