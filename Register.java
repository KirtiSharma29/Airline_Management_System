package mini_project;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class Register extends JPanel {
private MainApp app;
private JTextField txtName, txtEmail;
private JPasswordField txtPassword;
public Register(MainApp app) {
this.app = app;
setLayout(new GridLayout(5, 2, 10, 10));
add(new JLabel("Name:"));
txtName = new JTextField();
add(txtName);
add(new JLabel("Email:"));
txtEmail = new JTextField();
add(txtEmail);
add(new JLabel("Password:"));
txtPassword = new JPasswordField();
add(txtPassword);
JButton btnRegister = new JButton("Register");
btnRegister.addActionListener(e -> registerUser());
add(btnRegister);
JButton btnBack = new JButton("Back");
btnBack.addActionListener(e -> app.showPanel("MainMenu"));
add(btnBack);
}
private void registerUser() {
try (Connection conn = DBConnection.getConnection()) {
String sql = "INSERT INTO users(name,email,password) VALUES(?,?,?)";
PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, txtName.getText());
ps.setString(2, txtEmail.getText());
ps.setString(3, new String(txtPassword.getPassword()));
ps.executeUpdate();
JOptionPane.showMessageDialog(this, "Registered Successfully!");
app.showPanel("Login");
} catch (Exception e) {
e.printStackTrace();
}
}
}
