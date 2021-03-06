package com.ironhack;

import com.ironhack.exceptions.NoSuchValueException;

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
    private static JLabel wrongInput;
    private static JLabel dummyLabel;
    private static JLabel hint;
    private static JFrame frame;
    private static String username;

    public static MainMenu menu = new MainMenu();

    // Creates login window
    public static void login() {

        frame = new JFrame("LBL CRM SYSTEM LOGIN");
        frame.setUndecorated(true);
        frame.setSize(400, 230);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.BLACK, 2, true));

        title = new JLabel("LBL CRM SYSTEM LOGIN");
        title.setBounds(40, 10, 300, 25);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        panel.add(title);

        user = new JLabel("Username");
        user.setFont(new Font("Serif", Font.BOLD, 16));
        user.setBounds(50, 60, 120, 25);
        panel.add(user);

        userText = new JTextField(20);
        userText.setBounds(140, 60, 165, 25);
        panel.add(userText);

        password = new JLabel("Password");
        password.setFont(new Font("Serif", Font.BOLD, 16));
        password.setBounds(50, 90, 120, 25);
        panel.add(password);

        passwordText = new JPasswordField();
        passwordText.setBounds(140, 90, 165, 25);
        panel.add(passwordText);

        submit = new JButton("Login");
        submit.setBounds(223, 140, 80, 25);
        submit.addActionListener(new Login());
        panel.add(submit);

        wrongInput = new JLabel();
        wrongInput.setBounds(30, 140, 300, 25);
        panel.add(wrongInput);

        hint = new JLabel("Make your console full screen for a better experience");
        hint.setFont(new Font("Serif", Font.BOLD, 16));
        hint.setForeground(Color.red);
        hint.setBounds(20, 190, 380, 25);
        panel.add(hint);

        dummyLabel = new JLabel();
        panel.add(dummyLabel);

        frame.add(panel);

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.getRootPane().setDefaultButton(submit); // Lets you press "Submit" button using ENTER
    }

    // Method to get username input value
    public static String getUsername() {
        username = userText.getText() ;
        return username;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        char[] password = passwordText.getPassword();
        String pass = String.valueOf(password);

        // Checks if username and password input equals to any of registered users and runs OS or OSGuest menu
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


            frame.dispose(); // Closes login window
            try {
                menu.OS();
            } catch (RuntimeException | AWTException | NoSuchValueException ex) {
                System.out.println("Our server is busy! Please run the program again to login!");
            }
        } else if (getUsername().equals("Guest") && pass.equals("guest")) {
            frame.dispose(); // Closes login window
            try {
                menu.OSGuest();
            } catch (RuntimeException | AWTException | NoSuchValueException ex) {
                System.out.println("Our server is busy! Please run the program again to login!");
            }
        } else {
            wrongInput.setText("Wrong username or password!");
        }

    }
}
