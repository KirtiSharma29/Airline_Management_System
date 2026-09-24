package mini_project;

import javax.swing.*;
import javax.swing.table.DefaultTableModel; import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement; import java.sql.ResultSet;

public class SearchFlight extends JPanel {


private MainApp app;
private JComboBox<String> cbSource, cbDestination; private JTable table;
 
public SearchFlight(MainApp app) { this.app = app;
setLayout(new BorderLayout());


JPanel topPanel = new JPanel(); topPanel.add(new JLabel("Source:"));
cbSource = new JComboBox<>(new
String[]{"Mumbai","Delhi","Bangalore","Chennai","Kolkata"}); topPanel.add(cbSource);
topPanel.add(new JLabel("Destination:")); cbDestination = new JComboBox<>(new
String[]{"Mumbai","Delhi","Bangalore","Chennai","Kolkata"}); topPanel.add(cbDestination);

JButton btnSearch = new JButton("Search"); btnSearch.addActionListener(e -> searchFlights()); topPanel.add(btnSearch);

add(topPanel, BorderLayout.NORTH);


table = new JTable(new DefaultTableModel(
new Object[]{"ID","Code","Source","Destination","Departure","Arrival","Price"},0
));
add(new JScrollPane(table), BorderLayout.CENTER);
}


private void searchFlights() {
try (Connection conn = DBConnection.getConnection()) {
String sql = "SELECT * FROM flights WHERE source=? AND destination=?"; PreparedStatement ps = conn.prepareStatement(sql);
ps.setString(1, cbSource.getSelectedItem().toString());
 
ps.setString(2, cbDestination.getSelectedItem().toString()); ResultSet rs = ps.executeQuery();

DefaultTableModel model = (DefaultTableModel) table.getModel(); model.setRowCount(0);

while(rs.next()) {
model.addRow(new Object[]{ rs.getInt("id"),
rs.getString("flight_code"), rs.getString("source"), rs.getString("destination"), rs.getString("departure_time"), rs.getString("arrival_time"), rs.getDouble("price")
});
}
} catch(Exception e) { e.printStackTrace();
}
}
}
