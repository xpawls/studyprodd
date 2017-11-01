package java31.st3bookmanagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainBookMg extends JFrame {
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainBookMg frame = new MainBookMg();
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
    public MainBookMg() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1025, 581);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 693, 105);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton joinBut = new JButton("회원등록");
        joinBut.setBounds(12, 10, 159, 85);
        panel.add(joinBut);
        
        JButton newBookBut = new JButton("책 등록");
        newBookBut.setBounds(183, 10, 159, 85);
        panel.add(newBookBut);
        
        JButton refreshBut = new JButton("새로고침");
        refreshBut.setBounds(354, 10, 159, 85);
        panel.add(refreshBut);
        
        JButton exitBut = new JButton("프로그램 종료");
        exitBut.setBounds(525, 10, 159, 85);
        panel.add(exitBut);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 103, 354, 430);
        contentPane.add(scrollPane);
    }
}
