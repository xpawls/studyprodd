package java31.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

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
		setTitle("\uD14C\uC2A4\uD2B8 \uD504\uB808\uC784");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\uC67C\uCABD \uBC84\uD2BC");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(35, 57, 97, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\uAC00\uC6B4\uB370 \uBC84\uD2BC");
		btnNewButton_1.setBounds(164, 57, 97, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC624\uB978\uCABD \uBC84\uD2BC");
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBounds(299, 57, 97, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\uCC3D \uB2EB\uAE30");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(35, 197, 361, 44);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setBounds(35, 153, 361, 21);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
