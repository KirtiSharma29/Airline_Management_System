package mini_project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class SeatSelection extends JFrame {

    private MainApp app;
    private int flightId;
    private JTable seatTable;

    public SeatSelection(MainApp app, int flightId) {
        this.app = app;
        this.flightId = flightId;

        setTitle("Seat Selection");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        seatTable = new JTable(new DefaultTableModel(new Object[]{"Seat No"}, 0));
        add(new JScrollPane(seatTable), BorderLayout.CENTER);

        JButton btnBook = new JButton("Book Seat");
        btnBook.addActionListener(e -> bookSeat());
        add(btnBook, BorderLayout.SOUTH);

        loadSeats();
        setVisible(true);
    }

    private void loadSeats() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT seat_no FROM seats WHERE flight_id=? AND is_booked=FALSE";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, flightId);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) seatTable.getModel();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("seat_no")});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void bookSeat() {
        int row = seatTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a seat!");
            return;
        }
        String seatNo = seatTable.getValueAt(row, 0).toString();
        String email = JOptionPane.showInputDialog("Enter your email:");

        try (Connection conn = DBConnection.getConnection()) {
            String insertBooking = "INSERT INTO bookings(user_email, flight_id, seat_no) VALUES(?,?,?)";
            PreparedStatement ps = conn.prepareStatement(insertBooking);
            ps.setString(1, email);
            ps.setInt(2, flightId);
            ps.setString(3, seatNo);
            ps.executeUpdate();

            String updateSeat = "UPDATE seats SET is_booked=TRUE WHERE flight_id=? AND seat_no=?";
            PreparedStatement ps2 = conn.prepareStatement(updateSeat);
            ps2.setInt(1, flightId);
            ps2.setString(2, seatNo);
            ps2.executeUpdate();

            JOptionPane.showMessageDialog(this, "Seat Booked! Proceed to Payment.");
            dispose();

            new PaymentPage(app, email, flightId); // Open payment window
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
