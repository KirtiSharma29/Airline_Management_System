package mini_project;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class AddFlight extends JPanel {
 
private MainApp app;
private JTextField txtCode, txtDeparture, txtArrival, txtPrice;
private JComboBox<String> cbSource, cbDestination;


public AddFlight(MainApp app) {
this.app = app;
setLayout(new GridLayout(7, 2, 10, 10));


add(new JLabel("Flight Code:")); txtCode = new JTextField(); add(txtCode);

add(new JLabel("Source:"));
cbSource = new JComboBox<>(new String[]{"Mumbai", "Delhi", "Bangalore", "Chennai", "Kolkata"});
add(cbSource);


add(new JLabel("Destination:"));
cbDestination = new JComboBox<>(new String[]{"Mumbai", "Delhi", "Bangalore", "Chennai", "Kolkata"});
add(cbDestination);


add(new JLabel("Departure Time:")); txtDeparture = new JTextField(); add(txtDeparture);

add(new JLabel("Arrival Time:")); txtArrival = new JTextField(); add(txtArrival);

add(new JLabel("Price:"));
 
txtPrice = new JTextField(); add(txtPrice);

JButton btnAdd = new JButton("Add Flight"); btnAdd.addActionListener(e -> addFlight()); add(btnAdd);

JButton btnBack = new JButton("Back");
btnBack.addActionListener(e -> app.showPanel("MainMenu")); add(btnBack);
}


private void addFlight() {
try (Connection conn = DBConnection.getConnection()) {
String sql = "INSERT INTO flights(flight_code,source,destination,departure_time,arrival_time,price) VALUES(?,?,?,?,?,?)"; PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, txtCode.getText());
ps.setString(2, cbSource.getSelectedItem().toString()); ps.setString(3, cbDestination.getSelectedItem().toString()); ps.setString(4, txtDeparture.getText());
ps.setString(5, txtArrival.getText());
ps.setDouble(6, Double.parseDouble(txtPrice.getText())); ps.executeUpdate();
JOptionPane.showMessageDialog(this, "Flight Added Successfully!");
} catch (Exception e) { e.printStackTrace();
}
}
}
