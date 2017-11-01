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

public class frmB extends JFrame {
    
    private JPanel contentPane;
    private JTextField bField;
    
    private frmA parent = null;
    
    public frmA getParent() {
        return parent;
    }

    public void setParent(frmA parent) {
        this.parent = parent;
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
    
    public void setText( String value ) {
        // frmA에서 값을 받아서 frmB의 textField에 설정
        bField.setText( value );
    }
    
    /**
     * Create the frame.
     */
    public frmB() {
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 176, 272);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        bField = new JTextField();
        bField.setBounds(22, 21, 116, 21);
        contentPane.add(bField);
        bField.setColumns(10);
        
        JButton btnNewButton = new JButton("값 돌려주기");
        btnNewButton.addActionListener(  new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                String value = bField.getText();                
                // 부모창(frmA)의 메서드를 호출하여 bField 값을 frmA에 설정.
                // this 사용하면 안된다. 
                // 여기서 this는 new ActionListener() 를  의미
                parent.refresh(value);    
                
                // 자신의 창만 닫기
                dispose();
            }
        } );
        btnNewButton.setBounds(22, 114, 116, 23);
        contentPane.add(btnNewButton);
    }
    public frmB(frmA parent, String val) {
        this();  
        
        // frmA의 정보를 parent 필드에 저장.
        this.parent = parent; 
        // bField에 매개변수로 받은 val 값을 설정한다.
        bField.setText( val );        
    }
    
}
