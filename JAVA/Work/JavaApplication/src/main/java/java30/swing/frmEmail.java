package java30.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmEmail extends JFrame {
    
    private JPanel contentPane;
    private JTextField nametext;
    private JTextField jobtext;
    private JTextField idtext;
    private JTextField emailText;
    private JTextField addText;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmEmail frame = new frmEmail();
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
    public frmEmail() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 480);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(12, 0, 410, 119);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(0, 0, 57, 15);
        panel_1.add(lblName);
        
        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(12, 42, 57, 15);
        panel_1.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("직책");
        lblNewLabel_1.setBounds(12, 75, 57, 15);
        panel_1.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("아이디");
        lblNewLabel_2.setBounds(202, 75, 57, 15);
        panel_1.add(lblNewLabel_2);
        
        nametext = new JTextField();
        nametext.setBounds(48, 39, 116, 21);
        panel_1.add(nametext);
        nametext.setColumns(10);
        
        jobtext = new JTextField();
        jobtext.setBounds(48, 72, 116, 21);
        panel_1.add(jobtext);
        jobtext.setColumns(10);
        
        idtext = new JTextField();
        idtext.setBounds(258, 72, 116, 21);
        panel_1.add(idtext);
        idtext.setColumns(10);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 157, 410, 211);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_3 = new JLabel("E-mail");
        lblNewLabel_3.setBounds(0, 0, 57, 15);
        panel.add(lblNewLabel_3);
        
        JLabel lblNewLabel_4 = new JLabel("이메일주소");
        lblNewLabel_4.setBounds(10, 29, 71, 15);
        panel.add(lblNewLabel_4);
        
        emailText = new JTextField();
        emailText.setBounds(73, 26, 231, 21);
        panel.add(emailText);
        emailText.setColumns(10);
        
        addText = new JTextField();
        addText.setBounds(12, 55, 292, 89);
        panel.add(addText);
        addText.setColumns(10);
        
        JLabel lblMailFormat = new JLabel("Mail Format");
        lblMailFormat.setBounds(10, 154, 93, 15);
        panel.add(lblMailFormat);
        
        JRadioButton rdbtnHtml = new JRadioButton("HTML");
        rdbtnHtml.setBounds(8, 175, 59, 23);
        panel.add(rdbtnHtml);
        
        JRadioButton rdbtnPlaintext = new JRadioButton("PlainText");
        rdbtnPlaintext.setBounds(73, 175, 85, 23);
        panel.add(rdbtnPlaintext);
        
        JRadioButton rdbtnCustom = new JRadioButton("Custom");
        rdbtnCustom.setBounds(162, 175, 121, 23);
        panel.add(rdbtnCustom);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailText.getText();
                addText.setText(email);
                
                
                
            }
        });
        btnAdd.setBounds(313, 25, 85, 23);
        panel.add(btnAdd);
        
        JButton btnEdit = new JButton("Edit");
        btnEdit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnEdit.setBounds(316, 55, 82, 23);
        panel.add(btnEdit);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.setBounds(316, 88, 85, 23);
        panel.add(btnRemove);
        
        JButton btnNewButton = new JButton("Default");
        btnNewButton.setBounds(316, 121, 85, 23);
        panel.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("OK");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_1.setBounds(216, 378, 97, 54);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("Cancel");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_2.setBounds(325, 378, 97, 54);
        contentPane.add(btnNewButton_2);
    }
}
