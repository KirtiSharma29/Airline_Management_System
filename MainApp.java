package mini_project;

import javax.swing.*;
import java.awt.*;

public class MainApp extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    public MainApp() {
        setTitle("Airline Management System");
        setSize(950, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Panels inside mainPanel
        mainPanel.add(new Register(this), "Register");
        mainPanel.add(new Login(this), "Login");
        mainPanel.add(new AddFlight(this), "AddFlight");
        mainPanel.add(new FlightDetails(this), "FlightDetails");
        mainPanel.add(new SearchFlight(this), "SearchFlight");
        mainPanel.add(new SelectFlight(this), "SelectFlight");

        add(mainPanel, BorderLayout.CENTER);

        // Side menu with buttons
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(8, 1, 5, 5));

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(e -> showPanel("Register"));
        menuPanel.add(btnRegister);

        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> showPanel("Login"));
        menuPanel.add(btnLogin);

        JButton btnAddFlight = new JButton("Add Flight");
        btnAddFlight.addActionListener(e -> showPanel("AddFlight"));
        menuPanel.add(btnAddFlight);

        JButton btnFlightDetails = new JButton("Flight Details");
        btnFlightDetails.addActionListener(e -> showPanel("FlightDetails"));
        menuPanel.add(btnFlightDetails);

        JButton btnSearchFlight = new JButton("Search Flight");
        btnSearchFlight.addActionListener(e -> showPanel("SearchFlight"));
        menuPanel.add(btnSearchFlight);

        JButton btnSelectFlight = new JButton("Select Flight");
        btnSelectFlight.addActionListener(e -> showPanel("SelectFlight"));
        menuPanel.add(btnSelectFlight);

        // Payment button (opens JFrame manually)
        JButton btnPayment = new JButton("Payment");
        btnPayment.addActionListener(e -> {
            String email = JOptionPane.showInputDialog("Enter your email:");
            int flightId = Integer.parseInt(JOptionPane.showInputDialog("Enter Flight ID:"));
            new PaymentPage(this, email, flightId);
        });
        menuPanel.add(btnPayment);

        add(menuPanel, BorderLayout.WEST);
    }

    // Switch panels in mainPanel
    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().setVisible(true));
    }
}
