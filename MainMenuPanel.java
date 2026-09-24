package mini_project;
import javax.swing.*; import java.awt.*;

public class MainMenuPanel extends JPanel {


public MainMenuPanel(MainApp app) { setLayout(new GridBagLayout());
setBackground(new Color(230, 235, 255));


GridBagConstraints gbc = new GridBagConstraints(); gbc.insets = new Insets(12, 12, 12, 12);

JLabel title = new JLabel("AIRLINE MANAGEMENT SYSTEM"); title.setFont(new Font("Arial", Font.BOLD, 26));
gbc.gridx = 0;
gbc.gridy = 0; add(title, gbc);

JButton btnRegister = new JButton("Register"); gbc.gridy = 1; add(btnRegister, gbc);

JButton btnLogin = new JButton("Login");
 
gbc.gridy = 2; add(btnLogin, gbc);


JButton btnSearch = new JButton("Search Flights"); gbc.gridy = 3; add(btnSearch, gbc);

JButton btnAddFlight = new JButton("Add Flight"); gbc.gridy = 4; add(btnAddFlight, gbc);

btnRegister.addActionListener(e -> app.showPanel("Register")); btnLogin.addActionListener(e -> app.showPanel("Login")); btnSearch.addActionListener(e -> app.showPanel("SearchFlight")); btnAddFlight.addActionListener(e -> app.showPanel("AddFlight"));
}
}

