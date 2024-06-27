package views.panels;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class SideBar extends JPanel {



    /*
    1   ADMIN
    2   MANAGER
    3   OFFICER
    4   CLERK
    5   TECHNICIAN
    */
    private final String roleName;

    private ArrayList<JButton> buttons = new ArrayList<>();

    public ArrayList<JButton> getButtons() {
        return buttons;
    }
    private ImageIcon imageIcon;
    private int iW=200,iH=0;


    public SideBar(String roleName) {

        this.roleName = roleName;
        this.loadImageFromResource();
        this.createUIComponents();

    }


    private void createUIComponents() {

        this.setLayout(null);

        final int d = 10;
        final int sideBarWidth = 220;
        final int btnH = 30; //Button Height
        final int btnW = sideBarWidth - 2*d; //Button Width

        int x=d,y=20;


        JLabel titleLabel = new JLabel("ShipShape Management System");
        titleLabel.setBounds(new Rectangle(x,y,btnW, btnH));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(titleLabel);
        titleLabel.setBackground(Color.decode("#071f38"));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setOpaque(true);


        //y += (btnH + d);
        y+= iH + 20;


        JLabel dateLabel = new JLabel(getDateString());
        dateLabel.setBounds(new Rectangle(x,y,btnW, btnH));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(dateLabel);
        dateLabel.setBackground(Color.decode("#071f38"));
        dateLabel.setForeground(Color.WHITE);
        dateLabel.setOpaque(true);


        y += (btnH + d);


        JLabel timeLabel = new JLabel(getTimeString());
        timeLabel.setBounds(new Rectangle(x,y,btnW, btnH));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(timeLabel);
        timeLabel.setBackground(Color.decode("#071f38"));
        timeLabel.setForeground(Color.WHITE);
        timeLabel.setOpaque(true);


        y += (btnH + d);

        new Thread(() -> {
            while (true){
                try {Thread.sleep(1000);}catch (Exception e){}
                timeLabel.setText(getTimeString());
                //System.out.println("RUN");
            }
        }).start();



        JButton homeBtn = new JButton("Home");
        homeBtn.setBounds(new Rectangle(x,y,btnW, btnH));
        this.add(homeBtn);
        buttons.add(homeBtn);
        y += (btnH + d);



        JButton myJobsBtn = new JButton("My Jobs");
        myJobsBtn.setBounds(new Rectangle(x,y,btnW, btnH));
        this.add(myJobsBtn);
        buttons.add(myJobsBtn);
        y += (btnH + d);

        if(roleName.toLowerCase().contains("admin") || roleName.toLowerCase().contains("manager")){
            JButton employeesBtn = new JButton("Manage Employees");
            employeesBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(employeesBtn);
            buttons.add(employeesBtn);
            y += (btnH + d);
        }


        if(roleName.toLowerCase().contains("admin") || roleName.toLowerCase().contains("manager")){
            JButton rolesBtn = new JButton("Manage Roles");
            rolesBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(rolesBtn);
            buttons.add(rolesBtn);
            y += (btnH + d);
        }



        if(roleName.toLowerCase().contains("admin") || roleName.toLowerCase().contains("manager")|| roleName.toLowerCase().contains("clerk")  || roleName.toLowerCase().contains("officer")){
            JButton customersBtn = new JButton("Manage Customers");
            customersBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(customersBtn);
            buttons.add(customersBtn);
            y += (btnH + d);

            JButton suppliersBtn = new JButton("Manage Suppliers");
            suppliersBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(suppliersBtn);
            buttons.add(suppliersBtn);
            y += (btnH + d);

            JButton partsBtn = new JButton("Manage Parts");
            partsBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(partsBtn);
            buttons.add(partsBtn);
            y += (btnH + d);

            JButton inventoryBtn = new JButton("Manage Inventory");
            inventoryBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(inventoryBtn);
            buttons.add(inventoryBtn);
            y += (btnH + d);

            JButton ordersBtn = new JButton("Manage Orders");
            ordersBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(ordersBtn);
            buttons.add(ordersBtn);
            y += (btnH + d);

            JButton jobsBtn = new JButton("Manage Jobs");
            jobsBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(jobsBtn);
            buttons.add(jobsBtn);
            y += (btnH + d);

            JButton notificationBtn = new JButton("Manage Notifications");
            notificationBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(notificationBtn);
            buttons.add(notificationBtn);
            y += (btnH + d);

            JButton salesReportBtn = new JButton("Sales Report");
            salesReportBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(salesReportBtn);
            buttons.add(salesReportBtn);
            y += (btnH + d);

            JButton emailSettingsBtn = new JButton("Email Settings");
            emailSettingsBtn.setBounds(new Rectangle(x,y,btnW, btnH));
            this.add(emailSettingsBtn);
            buttons.add(emailSettingsBtn);
            y += (btnH + d);


        }

        JButton LogoutBtn = new JButton("Logout");
        LogoutBtn.setBounds(new Rectangle(x,y,btnW, btnH));
        this.add(LogoutBtn);
        buttons.add(LogoutBtn);


    }

    public String getTimeString() {
        LocalDateTime now = LocalDateTime.now();
        String pattern = "hh:mm:ss a";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        String formattedDate = now.format(formatter);
        return formattedDate;
    }

    public String getDateString() {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Define the custom pattern
        String pattern = "@1, MMM d@2 yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH);
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MMM d' 'HH:mm:ss a", Locale.ENGLISH);

        String formattedDate = now.format(formatter);
        String dayOfWeek = now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        int dayOfMonth = now.getDayOfMonth();
        String dayOfMonthSuffix = getDayOfMonthSuffix(dayOfMonth);

        formattedDate = formattedDate.replace("@1", dayOfWeek);
        formattedDate = formattedDate.replace("@2", dayOfMonthSuffix);

        return formattedDate;
    }

    private String getDayOfMonthSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }

    private void loadImageFromResource(){
        try {
            imageIcon = new ImageIcon(getClass().getResource("/resources/images/ship_sea_02.gif"));
            if (imageIcon != null) {
                int originalWidth = imageIcon.getIconWidth();
                int originalHeight = imageIcon.getIconHeight();
                iH = (int) (((double) iW / originalWidth) * originalHeight);
            }
        } catch (Exception e) {
            System.out.println("Error Message!");
            System.out.println(e.getLocalizedMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imageIcon != null) {
            Image image = imageIcon.getImage();
            g.drawImage(image, 10, 45, iW, iH, this); // Draw the resized image
        }
    }
}

