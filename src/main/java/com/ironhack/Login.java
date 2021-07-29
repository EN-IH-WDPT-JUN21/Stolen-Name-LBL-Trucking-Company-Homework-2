package com.ironhack;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    private static JLabel title;
    private static JPanel panel;
    private static JLabel user;
    private static JTextField userText;
    private static JLabel password;
    private static JPasswordField passwordText;
    private static JButton submit;
    private static JLabel success;
    private static JLabel success2;
    private static JLabel hint;
    private static JFrame frame;
    private static String username;


    public static MainMenu menu = new MainMenu();

    public static void login2() {

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

        hint = new JLabel("Hint: Make your console full screen for a better experience");
        hint.setBounds(10, 200, 300, 25);
        panel.add(hint);

        success2 = new JLabel();
        panel.add(success2);

        frame.add(panel);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setDefaultButton(submit); // Let's you press "Submit" button using ENTER

    }

    public static String getUsername() {
        username = userText.getText() ;
        return username;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //username = userText.getText();
        char[] password = passwordText.getPassword();
        String pass = String.valueOf(password);

        if (getUsername().equals("Lee") && pass.equals("lee")
        || getUsername().equals("Sebastian") && pass.equals("sebastian")
        || getUsername().equals("Mariana") && pass.equals("mariana")
        || getUsername().equals("NataliaS") && pass.equals("natalias")
        || getUsername().equals("Nathan") && pass.equals("nathan")
        || getUsername().equals("NataliaN") && pass.equals("natalian")
        || getUsername().equals("Katarzyna") && pass.equals("katarzyna")
        || getUsername().equals("Urszula") && pass.equals("urszula")
        || getUsername().equals("Anna") && pass.equals("anna")
        || getUsername().equals("Admin") && pass.equals("admin")) {
            //success.setText("Welcome to our LBL CRM SYSTEM");
            /*JPanel text1 = new JPanel(new BorderLayout());
            text1.setBounds(0, 0, 350, 200);
            JLabel text = new JLabel("Welcome to our LBL CRM SYSTEM");
            text.setFont(new Font("Serif", Font.BOLD, 18));
            text1.add(text);
            panel.setVisible(false);
            frame.add(text1);*/
            /*try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }*/
            frame.dispose();
            try {
                menu.OS();
            } catch (RuntimeException | AWTException ex) {
            }
        } else if (getUsername().equals("Guest") && pass.equals("guest")) {
            frame.dispose();
            try {
                menu.OSGuest();
            } catch (RuntimeException | AWTException ex) {
            }
        } else {
            success.setText("Wrong username or password!");
        }

    }
}
