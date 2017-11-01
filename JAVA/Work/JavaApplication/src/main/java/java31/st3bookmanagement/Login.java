package java31.st3bookmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Login extends JFrame {
    
    private JPanel contentPane;
    private JTextField textID;
    private JTextField textPW;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
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
    public Login() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 472, 149);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblId = new JLabel("ID");
        lblId.setBounds(46, 22, 27, 15);
        contentPane.add(lblId);
        
        JLabel lblPw = new JLabel("PW");
        lblPw.setBounds(46, 58, 27, 15);
        contentPane.add(lblPw);
        
        textID = new JTextField();
        textID.setBounds(84, 22, 231, 21);
        contentPane.add(textID);
        textID.setColumns(10);
        
        textPW = new JTextField();
        textPW.setBounds(84, 58, 231, 21);
        contentPane.add(textPW);
        textPW.setColumns(10);
        
        JButton loginbut = new JButton("Login");
        loginbut.setBounds(327, 22, 97, 57);
        contentPane.add(loginbut);
    }
    
}
