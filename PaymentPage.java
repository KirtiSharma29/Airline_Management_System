package mini_project;

import javax.swing.*; import java.awt.*; import java.sql.*;

public class PaymentPage extends JFrame {


private MainApp app; private String email; private int flightId;

public PaymentPage(MainApp app, String email, int flightId) { this.app = app;
this.email = email; this.flightId = flightId;

setTitle("Payment"); setSize(400, 300);
setLocationRelativeTo(null); setLayout(new GridLayout(5, 2, 10, 10));

add(new JLabel("Booking Email:")); add(new JLabel(email));

double amount = getFlightPrice(); add(new JLabel("Amount to Pay:")); add(new JLabel("₹" + amount));

add(new JLabel("Payment Method:"));
JComboBox<String> cbMethod = new JComboBox<>(new String[]{"UPI", "Credit Card", "Debit Card", "Net Banking"});
add(cbMethod);


JButton btnPay = new JButton("Pay");
btnPay.addActionListener(e -> makePayment(cbMethod.getSelectedItem().toString(), amount));
add(btnPay);
 
setVisible(true);
}


private double getFlightPrice() { double price = 0;
try (Connection conn = DBConnection.getConnection()) { String sql = "SELECT price FROM flights WHERE id=?"; PreparedStatement ps = conn.prepareStatement(sql); ps.setInt(1, flightId);
ResultSet rs = ps.executeQuery();
if (rs.next()) price = rs.getDouble("price");
} catch (Exception e) { e.printStackTrace();
}
return price;
}


private void makePayment(String method, double amount) { try (Connection conn = DBConnection.getConnection()) {
String sql = "INSERT INTO payments(booking_id,user_email,amount,payment_method) " +
"VALUES((SELECT id FROM bookings WHERE flight_id=? AND user_email=? ORDER BY id DESC LIMIT 1),?,?,?)";
PreparedStatement ps = conn.prepareStatement(sql); ps.setInt(1, flightId);
ps.setString(2, email); ps.setString(3, email); ps.setDouble(4, amount); ps.setString(5, method); ps.executeUpdate();
JOptionPane.showMessageDialog(this, "Payment Successful!");
 
dispose();
} catch (Exception e) { e.printStackTrace();
}
}
}

