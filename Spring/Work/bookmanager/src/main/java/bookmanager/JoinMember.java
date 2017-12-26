package bookmanager;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bookmanager.model.ModelMember;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class JoinMember extends JFrame {
    private java.sql.Connection conn = null;
    private MainBookMg mainbook = new MainBookMg();
    private ModelMember newmember = null;
    private JPanel contentPane;
    private JTextField textMemName;
    private JTextField textPriNum1;
    private JTextField textPriNum2;
    private JTextField textPhonNum2;
    private JTextField textPhonNum3;
    private JTextField textPhonNum1;
    private JTextField textMailAdr;
    private PreparedStatement stmt;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JoinMember frame = new JoinMember();
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
    public JoinMember() {
        setTitle("회원가입");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("이름");
        label.setBounds(12, 29, 57, 15);
        contentPane.add(label);
        
        textMemName = new JTextField();
        textMemName.setColumns(10);
        textMemName.setBounds(81, 26, 99, 21);
        contentPane.add(textMemName);
        
        textPriNum1 = new JTextField();
        textPriNum1.setColumns(10);
        textPriNum1.setBounds(81, 54, 99, 21);
        contentPane.add(textPriNum1);
        
        JLabel label_1 = new JLabel("주민번호");
        label_1.setBounds(12, 57, 57, 15);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("-");
        label_2.setBounds(180, 57, 11, 15);
        contentPane.add(label_2);
        
        textPriNum2 = new JTextField();
        textPriNum2.setColumns(10);
        textPriNum2.setBounds(192, 54, 104, 21);
        contentPane.add(textPriNum2);
        
        textPhonNum2 = new JTextField();
        textPhonNum2.setColumns(10);
        textPhonNum2.setBounds(148, 82, 61, 21);
        contentPane.add(textPhonNum2);
        
        JLabel label_3 = new JLabel("-");
        label_3.setBounds(142, 86, 11, 15);
        contentPane.add(label_3);
        
        textPhonNum3 = new JTextField();
        textPhonNum3.setColumns(10);
        textPhonNum3.setBounds(217, 82, 60, 21);
        contentPane.add(textPhonNum3);
        
        textPhonNum1 = new JTextField();
        textPhonNum1.setColumns(10);
        textPhonNum1.setBounds(81, 82, 61, 21);
        contentPane.add(textPhonNum1);
        
        JLabel label_4 = new JLabel("전화번호");
        label_4.setBounds(12, 85, 57, 15);
        contentPane.add(label_4);
        
        JLabel label_5 = new JLabel("메일주소");
        label_5.setBounds(12, 113, 57, 15);
        contentPane.add(label_5);
        
        textMailAdr = new JTextField();
        textMailAdr.setColumns(10);
        textMailAdr.setBounds(81, 110, 99, 21);
        contentPane.add(textMailAdr);
        
        JLabel label_6 = new JLabel("@");
        label_6.setBounds(180, 113, 21, 15);
        contentPane.add(label_6);
        
        JLabel label_7 = new JLabel("-");
        label_7.setBounds(209, 86, 11, 15);
        contentPane.add(label_7);
        
        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "daem.net"}));
        comboBox.setBounds(192, 110, 129, 21);
        contentPane.add(comboBox);
        
        JButton button = new JButton("가입");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                mainbook = new MainBookMg();
                String name = textMemName.getText();
                String prino = textPriNum1.getText() +"-"+ textPriNum2.getText();
                String phone = textPhonNum1.getText()+"-"+ textPhonNum2.getText()+"-"+ textPhonNum3.getText();
                String email = textMailAdr.getText() +"@"+ comboBox.getSelectedItem().toString();
                
            
            }
        });
        button.setBounds(83, 168, 97, 48);
        contentPane.add(button);
        
        JButton button_1 = new JButton("취소");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        button_1.setBounds(187, 168, 97, 48);
        contentPane.add(button_1);
    }
}
