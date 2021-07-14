import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Login implements ActionListener {

    private static JLabel title;
    private static JLabel user;
    private static JTextField userText;
    private static JLabel password;
    private static JPasswordField passwordText;
    private static JButton submit;
    private static JLabel success;
    private static JLabel success2;
    private static JFrame frame;
    public static JPanel panel;

    public void login() {

        frame = new JFrame("LBL CRM SYSTEM LOGIN");
        frame.setUndecorated(true);
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.BLACK, 2, true));

        title = new JLabel("LBL CRM SYSTEM LOGIN");
        title.setBounds(40, 10, 200, 25);
        title.setFont(new Font("Serif", Font.BOLD, 16));
        panel.add(title);

        user = new JLabel("Username");
        user.setBounds(40, 60, 80, 25);
        panel.add(user);

        userText = new JTextField(20);
        userText.setBounds(130, 60, 165, 25);
        panel.add(userText);

        password = new JLabel("Password");
        password.setBounds(40, 90, 80, 25);
        panel.add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(130, 90, 165, 25);
        panel.add(passwordText);

        submit = new JButton("Login");
        submit.setBounds(213, 140, 80, 25);
        submit.addActionListener(new Login());
        panel.add(submit);

        success = new JLabel();
        success.setBounds(30, 140, 300, 25);
        panel.add(success);

        success2 = new JLabel();
        panel.add(success2);

        frame.add(panel);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        char[] password = passwordText.getPassword();
        String pass = String.valueOf(password);

        if (user.equals("abc") && pass.equals("123")) {
            success.setText("Welcome to our LBL CRM SYSTEM");
            JPanel text1 = new JPanel(new BorderLayout());
            text1.setBounds(0, 0, 350, 200);
            JLabel text = new JLabel("Welcome to our LBL CRM SYSTEM");
            text.setFont(new Font("Serif", Font.BOLD, 18));
            text1.add(text);
            panel.setVisible(false);
            frame.add(text1);
        } else {
            success.setText("Wrong username or password!");
        }

    }
}
