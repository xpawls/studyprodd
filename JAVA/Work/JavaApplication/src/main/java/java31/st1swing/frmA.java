package java31.st1swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frmA extends JFrame {
    
    private JPanel contentPane;
    private static frmA frame = null;
    private JTextField aField;
    private JButton button;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new frmA();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public void refresh( String value ) {        
        // frmB에서 넘겨 받은 값을 textField 에 설정.
        aField.setText( value );        
    }
    
    /**
     * Create the frame.
     */
    public frmA() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 261, 246);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        aField = new JTextField();
        aField.setBounds(12, 109, 204, 21);
        contentPane.add(aField);
        aField.setColumns(10);
        
        JButton btnNewButton = new JButton("새창 띄우기 : setter 방식");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                
                frmB frmb = new frmB();
                frmb.setVisible(true);
                // frmB.setText() 추가된 메서드다.
                frmb.setText( aField.getText()  );
                // frmA 정보를 frmB에 넘겨 준다.
                frmb.setParent( frame );
            }
        });
        btnNewButton.setBounds(12, 26, 204, 23);
        contentPane.add(btnNewButton);
        
        button = new JButton("새창 띄우기 : 생성자 방식");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                String val = aField.getText();              
                frmB frmb = new frmB(frame, val );
                frmb.setVisible(true);
            }
        });
        button.setBounds(12, 60, 204, 23);
        contentPane.add(button);
    }
    
}
