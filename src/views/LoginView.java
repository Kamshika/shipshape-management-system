package views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginView extends JFrame{
    private JPanel mainPanel;


    public JTextField getUsernameText() {
        return usernameText;
    }

    public JTextField getPasswordText() {
        return passwordText;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    private JTextField usernameText;
    private JTextField passwordText;

    private JButton loginButton;
    private JButton cancelButton;



    public LoginView(){
        this.createUIComponents();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        final Image image = new ImageIcon(getClass().getResource("/resources/images/sea_03.png")).getImage();

        this.mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };

        this.setResizable(false);

        mainPanel.setLayout(null);

        Font font1 = new Font("Bookman Old Style", Font.PLAIN, 70);
        Color color1 = Color.decode("#0000FF");

        JLabel titleLabel1 = new JLabel("SHIPSHAPE");
        titleLabel1.setFont(font1);
        titleLabel1.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel1.setForeground(color1);
        titleLabel1.setLocation(130,160);
        titleLabel1.setSize(500,70);
        mainPanel.add(titleLabel1);


        JLabel titleLabel2 = new JLabel("MANAGEMENT");
        titleLabel2.setFont(font1);
        titleLabel2.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel2.setForeground(color1);
        titleLabel2.setLocation(72,244);
        titleLabel2.setSize(700,70);
        mainPanel.add(titleLabel2);


        JLabel titleLabel3 = new JLabel("SYSTEM");
        titleLabel3.setFont(font1);
        titleLabel3.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel3.setForeground(color1);
        titleLabel3.setLocation(187,336);
        titleLabel3.setSize(500,50);
        mainPanel.add(titleLabel3);

        JPanel whitePanel = new JPanel();
        whitePanel.setLayout(null);
        String htmlColor = "#4bb7f7"; // HTML color for blue
        Color color = Color.decode(htmlColor); // Decode the HTML color
        Color transparentColor = new Color(color.getRed(), color.getGreen(), color.getBlue(), 80); // Set alpha for transparency
        whitePanel.setBackground(transparentColor);
        mainPanel.add(whitePanel);

        whitePanel.setLocation(700,100);
        whitePanel.setSize(400,400);




        Font font5 = new Font("Segoe UI", Font.BOLD, 14);
        Color color5 = Color.decode("#0000FF");

        JLabel usernameLabel = new JLabel();
        usernameLabel.setFont(font5);
        usernameLabel.setText("Username");
        usernameLabel.setForeground(color5);
        whitePanel.add(usernameLabel);


        whitePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        usernameText = new JTextField();
        usernameText.setFont(font5);
        usernameText.setForeground(color5);
        usernameText.setAlignmentX(Component.LEFT_ALIGNMENT);
        whitePanel.add(usernameText);


        whitePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel passwordLabel = new JLabel();
        passwordLabel.setFont(font5);
        passwordLabel.setText("Password");
        passwordLabel.setForeground(color5);
        passwordLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        whitePanel.add(passwordLabel);


        whitePanel.add(Box.createRigidArea(new Dimension(0, 10)));

        passwordText = new JTextField();
        passwordText.setFont(font5);
        passwordText.setForeground(color5);
        passwordText.setAlignmentX(Component.LEFT_ALIGNMENT);
        whitePanel.add(passwordText);

        loginButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        whitePanel.add(loginButton);
        whitePanel.add(cancelButton);


        usernameLabel.setLocation(75,150);
        usernameLabel.setSize(100,20);
        usernameText.setLocation(175,150);
        usernameText.setSize(150,20);

        passwordLabel.setLocation(75,180);
        passwordLabel.setSize(100,20);
        passwordText.setLocation(175,180);
        passwordText.setSize(150,20);

        loginButton.setLocation(115, 220);
        loginButton.setSize(100,25);
        cancelButton.setLocation(225, 220);
        cancelButton.setSize(100,25);

        this.setContentPane(mainPanel);
        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(50,50,1200,600);
    }
}
