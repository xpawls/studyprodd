package java30.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmB extends JFrame{
    
    private JPanel contentPane;
    private JTextField textField;
    private frmA parent = null;
    
    public frmB(frmA parent) {
        commonConstructor();
        this.parent = parent;
    }
    
    public void commonConstructor() {
        setTitle("frmB");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 240, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(12, 80, 200, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("값 돌려주기");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.refresh(textField.getText());
            }
        });
        btnNewButton.setBounds(12, 177, 200, 23);
        contentPane.add(btnNewButton);
        
    }
    public void setText(String value){
        textField.setText(value);
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frmB frame = new frmB();
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
    public frmB() {
        setTitle("frmB");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 240, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(12, 80, 200, 21);
        contentPane.add(textField);
        textField.setColumns(10);
        
        JButton btnNewButton = new JButton("값 돌려주기");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.getText();
                
            }
        });
        btnNewButton.setBounds(12, 177, 200, 23);
        contentPane.add(btnNewButton);
        
    }
    public frmB(String val){
        this();
        
        textField.setText(val);
    }
    
}
