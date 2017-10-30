package java30.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmButton extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmButton frame = new frmButton();
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
    public frmButton() {
        setTitle("테스트 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("왼쪽버튼");
        btnNewButton.setBounds(35, 24, 97, 69);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("가운데버튼");
        btnNewButton_1.setBounds(167, 24, 97, 69);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("오른쪽버튼");
        btnNewButton_2.setEnabled(false);
        btnNewButton_2.setBounds(299, 24, 97, 69);
        contentPane.add(btnNewButton_2);
        
        textField = new JTextField();
        textField.setBounds(35, 171, 361, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton_3 = new JButton("종료버튼");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnNewButton_3.setBounds(35, 215, 361, 37);
        contentPane.add(btnNewButton_3);
    }
}
