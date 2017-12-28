package bookmanager;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bookmanager.inf.IServiceBook;
import bookmanager.svr.ServiceBook;

public class NewBook extends JFrame {
    private JPanel contentPane;
    private JTextField textInBookname;
    private JTextField textInPubli;
    private JTextField textInAuthor;
    private JTextField textInPrice;
    private MainBookMg mianbook = new MainBookMg();
    private bookmanager.model.ModelBook modelbook;
    private static IServiceBook serviceb = new ServiceBook();
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        // classpath를 이용한 설정 파일 로딩
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        
        // file을 이용한 설정 파일 로딩
        // ApplicationContext context = new ClassPathXmlApplicationContext("주소");
        
        // DI를 이용한 servicebook 인스턴스 생성
        serviceb = context.getBean("servicebook", bookmanager.svr.ServiceBook.class);
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewBook frame = new NewBook(serviceb);
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
    public NewBook(IServiceBook serviceb) {
        setTitle("책 등록");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 269, 317);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel label = new JLabel("책 제목");
        label.setBounds(28, 40, 57, 15);
        contentPane.add(label);
        
        textInBookname = new JTextField();
        textInBookname.setColumns(10);
        textInBookname.setBounds(98, 37, 132, 21);
        contentPane.add(textInBookname);
        
        textInPubli = new JTextField();
        textInPubli.setColumns(10);
        textInPubli.setBounds(98, 65, 132, 21);
        contentPane.add(textInPubli);
        
        JLabel label_1 = new JLabel("출판사");
        label_1.setBounds(28, 68, 57, 15);
        contentPane.add(label_1);
        
        JLabel label_2 = new JLabel("저자");
        label_2.setBounds(28, 96, 57, 15);
        contentPane.add(label_2);
        
        textInAuthor = new JTextField();
        textInAuthor.setColumns(10);
        textInAuthor.setBounds(98, 93, 132, 21);
        contentPane.add(textInAuthor);
        
        textInPrice = new JTextField();
        textInPrice.setColumns(10);
        textInPrice.setBounds(98, 121, 89, 21);
        contentPane.add(textInPrice);
        
        JLabel label_3 = new JLabel("가격");
        label_3.setBounds(28, 124, 57, 15);
        contentPane.add(label_3);
        
        JLabel label_4 = new JLabel("장르");
        label_4.setBounds(28, 152, 57, 15);
        contentPane.add(label_4);
        
        JLabel lblNewLabel = new JLabel("책 정보 입력");
        lblNewLabel.setBounds(86, 12, 101, 15);
        contentPane.add(lblNewLabel);
        
        JComboBox comboCategory = new JComboBox();
        comboCategory.setModel(new DefaultComboBoxModel(new String[] {"소설", "교육", "문학", "해외", "기타"}));
        comboCategory.setBounds(98, 149, 89, 21);
        contentPane.add(comboCategory);
        
        JButton btnInputBook = new JButton("등록");
        btnInputBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mianbook = new MainBookMg();
                String name = textInBookname.getText();
                String publ = textInPubli.getText();
                String auth = textInAuthor.getText();
                Integer pri = Integer.valueOf(textInPrice.getText());
                String var = (String) comboCategory.getSelectedItem();
                int result = -1;
                modelbook = new bookmanager.model.ModelBook();
                modelbook.setBookname(name);
                modelbook.setAuthor(auth);
                modelbook.setCategory(var);
                modelbook.setPublisher(publ);
                modelbook.setPrice(pri);
                try {
                    result = serviceb.insertBook(modelbook);
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    // e1.printStackTrace();
                    logger.error("actionPerformed" + e1.getMessage());
                    
                }
                if(result==-1){
                    JOptionPane.showMessageDialog(null, "에러");
                } else {
                    dispose();
                }
                
            }
        });
        btnInputBook.setBounds(40, 212, 89, 40);
        contentPane.add(btnInputBook);
        
        JButton butCancelBook = new JButton("취소");
        butCancelBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        butCancelBook.setBounds(141, 212, 89, 40);
        contentPane.add(butCancelBook);
    }
}
