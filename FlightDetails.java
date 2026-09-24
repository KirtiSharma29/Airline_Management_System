package mini_project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FlightDetails extends JPanel {

    private MainApp app;
    private JTable table;

    public FlightDetails(MainApp app) {
        this.app = app;
        setLayout(new BorderLayout());

        table = new JTable(new DefaultTableModel(
                new Object[]{"ID","Code","Source","Destination","Departure","Arrival","Price"},0
        ));
        add(new JScrollPane(table), BorderLayout.CENTER);

        JButton btnLoad = new JButton("Load Flights");
        btnLoad.addActionListener(e -> loadFlights());
        add(btnLoad, BorderLayout.SOUTH);
    }

    private void loadFlights() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM flights";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0);

            while(rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("flight_code"),
                        rs.getString("source"),
                        rs.getString("destination"),
                        rs.getString("departure_time"),
                        rs.getString("arrival_time"),
                        rs.getDouble("price")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
