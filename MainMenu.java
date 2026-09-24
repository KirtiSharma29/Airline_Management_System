package mini_project;

import javax.swing.*; import java.awt.*;

public class MainMenu extends JFrame {


public MainMenu() {
setTitle("Airline Management System - Main Menu"); setSize(400, 500);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setLayout(new GridLayout(8, 1, 10, 10));

JButton btnSearch = new JButton("Search Flights");
btnSearch.addActionListener(e -> new SearchFlight(null).setVisible(true));
 
add(btnSearch);


JButton btnAdd = new JButton("Add Flight");
btnAdd.addActionListener(e -> new AddFlight(null).setVisible(true)); add(btnAdd);

JButton btnDetails = new JButton("View All Flights");
btnDetails.addActionListener(e -> new FlightDetails(null).setVisible(true)); add(btnDetails);

JButton btnBook = new JButton("Book Flight");
btnBook.addActionListener(e -> new SelectFlight(null).setVisible(true)); add(btnBook);

JButton btnExit = new JButton("Exit");
btnExit.addActionListener(e -> System.exit(0)); add(btnExit);
}
}

