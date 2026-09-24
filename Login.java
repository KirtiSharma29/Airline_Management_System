package mini_project;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Login extends JPanel {
private MainApp app;
private JTextField txtEmail;
private JPasswordField txtPassword;
public Login(MainApp app) {
this.app = app;
setLayout(new GridLayout(4, 2, 10, 10));
add(new JLabel("Email:"));
txtEmail = new JTextField();
add(txtEmail);
add(new JLabel("Password:"));
txtPassword = new JPasswordField();
add(txtPassword);
JButton btnLogin = new JButton("Login");
btnLogin.addActionListener(e -> loginUser());
add(btnLogin);
JButton btnBack = new JButton("Back");
btnBack.addActionListener(e -> app.showPanel("MainMenu"));
add(btnBack);
}
private void loginUser() {
try (Connection conn = DBConnection.getConnection()) {
String sql = "SELECT * FROM users WHERE email=? AND password=?";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, txtEmail.getText());
ps.setString(2, new String(txtPassword.getPassword()));
ResultSet rs = ps.executeQuery();
if (rs.next()) {
JOptionPane.showMessageDialog(this, "Login Successful!");
app.showPanel("MainMenu");
} else {
JOptionPane.showMessageDialog(this, "Invalid Email/Password");
}
} catch (Exception e) {
e.printStackTrace();
}
}
}
