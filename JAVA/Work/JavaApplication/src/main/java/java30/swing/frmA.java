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

public class frmA extends JFrame {
    
    private JPanel contentPane;
    private JTextField textField;
    private static frmA frame = null;
    /**
     * Launch the application.
     */
    
    public static void main(String[] args) {
        frame = new frmA();
        frame.setVisible(true);
        
        
        
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    
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
    public frmA() {
        setTitle("frmA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 220, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("새창띄우기");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmB frm = new frmB(frame);
                frm.setVisible(true);
                
                
            }
        });
        btnNewButton.setBounds(12, 47, 180, 23);
        contentPane.add(btnNewButton);
        
        textField = new JTextField();
        textField.setBounds(12, 177, 180, 21);
        contentPane.add(textField);
        textField.setColumns(10);
    }
    public void refresh(String value){
        textField.setText(value);
    }
    
}
