package java31.st3bookmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JoinMember extends JFrame {
    
    private MainBookMg mainbook = null;
    private MemberD newmember = null;
    private JPanel contentPane;
    private JTextField textMemName;
    private JTextField textPriNum1;
    private JTextField textPriNum2;
    private JTextField textPhonNum2;
    private JTextField textPhonNum3;
    private JTextField textPhonNum1;
    private JTextField textMailAdr;
    private JLabel label_7;
    private JComboBox comboBox;
    private static Integer count = 0;
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
        setBounds(100, 100, 382, 303);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("이름");
        label.setBounds(13, 56, 57, 15);
        contentPane.add(label);
        
        textMemName = new JTextField();
        textMemName.setColumns(10);
        textMemName.setBounds(82, 53, 99, 21);
        contentPane.add(textMemName);
        
        textPriNum1 = new JTextField();
        textPriNum1.setColumns(10);
        textPriNum1.setBounds(82, 81, 99, 21);
        contentPane.add(textPriNum1);
        
        JLabel label_1 = new JLabel("주민번호");
        label_1.setBounds(13, 84, 57, 15);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("-");
        label_2.setBounds(181, 84, 11, 15);
        contentPane.add(label_2);
        
        textPriNum2 = new JTextField();
        textPriNum2.setColumns(10);
        textPriNum2.setBounds(193, 81, 104, 21);
        contentPane.add(textPriNum2);
        
        textPhonNum2 = new JTextField();
        textPhonNum2.setColumns(10);
        textPhonNum2.setBounds(149, 109, 61, 21);
        contentPane.add(textPhonNum2);
        
        JLabel label_3 = new JLabel("-");
        label_3.setBounds(143, 113, 11, 15);
        contentPane.add(label_3);
        
        textPhonNum3 = new JTextField();
        textPhonNum3.setColumns(10);
        textPhonNum3.setBounds(218, 109, 60, 21);
        contentPane.add(textPhonNum3);
        
        textPhonNum1 = new JTextField();
        textPhonNum1.setColumns(10);
        textPhonNum1.setBounds(82, 109, 61, 21);
        contentPane.add(textPhonNum1);
        
        JLabel label_4 = new JLabel("전화번호");
        label_4.setBounds(13, 112, 57, 15);
        contentPane.add(label_4);
        
        JLabel label_5 = new JLabel("메일주소");
        label_5.setBounds(13, 140, 57, 15);
        contentPane.add(label_5);
        
        textMailAdr = new JTextField();
        textMailAdr.setColumns(10);
        textMailAdr.setBounds(82, 137, 99, 21);
        contentPane.add(textMailAdr);
        
        JLabel label_6 = new JLabel("@");
        label_6.setBounds(181, 140, 21, 15);
        contentPane.add(label_6);
        
        label_7 = new JLabel("-");
        label_7.setBounds(210, 113, 11, 15);
        contentPane.add(label_7);
        
        comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "gmail.com", "daem.net"}));
        comboBox.setBounds(193, 137, 129, 21);
        contentPane.add(comboBox);
        
        JButton btnJoin = new JButton("가입");
        btnJoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textMemName.getText();
                String prino = textPriNum1.getText() +"-"+ textPriNum2.getText();
                String phone = textPhonNum1.getText()+"-"+ textPhonNum2.getText()+"-"+ textPhonNum3.getText();
                String email = textMailAdr.getText() +"@"+ comboBox.getSelectedItem().toString();
                
                newmember = new MemberD(count, name, prino, phone, email);
                mainbook.addDatamem(newmember);
                
                countno();
                dispose();
                
                
            }
        });
        btnJoin.setBounds(84, 195, 97, 48);
        contentPane.add(btnJoin);
        
        JButton butCancelJoin = new JButton("취소");
        butCancelJoin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        butCancelJoin.setBounds(188, 195, 97, 48);
        contentPane.add(butCancelJoin);
    }
    
    public static void countno(){
        count++;
    }
}
