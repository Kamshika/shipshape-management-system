package views.panels;

import models.Employee;
import services.CS;

import java.awt.*;
import javax.swing.*;

public class HomePanel extends JPanel {
    private Employee employee;
    private ImageIcon imageIcon;
    private int iW=305,iH=0;
    private JLabel welcomeLabel;
    private JLabel titleLabel;
    private JLabel label_1_k;
    private JLabel label_1_v;
    private JLabel label_2_k;
    private JLabel label_2_v;
    private JLabel label_3_k;
    private JLabel label_3_v;
    private JLabel label_4_k;
    private JLabel label_4_v;
    private JLabel label_5_k;
    private JLabel label_5_v;
    private JLabel label_6_k;
    private JLabel label_6_v;
    private JLabel label_7_k;
    private JLabel label_7_v;
    private JLabel label_8_k;
    private JLabel label_8_v;
    private JLabel label_9_k;
    private JLabel label_9_v;
    private JLabel label_10_k;
    private JLabel label_10_v;
    private JButton logoutButton;

    private String teal = "#7faab5";
    private String facebookBlue = "#0075FB";
    private String violet = "#8f00ff";
    private String darkViolet = "#5c05a1";

    private String bgColor = darkViolet;
    private String fgColor = "#FFFFFF";


    public HomePanel(Employee employee) {
        this.employee = employee;
        loadImageFromResource();
        this.createUIComponents();
    }

    private void createUIComponents() {

        this.setLayout(null);
        String name = "Welcome " + employee.getTitle() + " " + employee.getFirstName() + " " + employee.getLastName() + "!";

        welcomeLabel = CS.paintLabels(this, "", name, bgColor, fgColor, 0, true);
        this.add(welcomeLabel);


        titleLabel = CS.paintLabels(this, "", "ACCOUNT DETAILS", bgColor, fgColor, 0, true);

        label_1_k = CS.paintLabels(this, "    ", "Employee ID", bgColor, fgColor, 2, true);
        label_1_v = CS.paintLabels(this, "    ", String.valueOf(employee.getEmployeeId()), bgColor, fgColor, 2, true);

        label_2_k = CS.paintLabels(this, "    ", "Title", bgColor, fgColor, 2, true);
        label_2_v = CS.paintLabels(this, "    ", employee.getTitle(), bgColor, fgColor, 2, true);

        label_3_k = CS.paintLabels(this, "    ", "First Name", bgColor, fgColor, 2, true);
        label_3_v = CS.paintLabels(this, "    ", employee.getFirstName(), bgColor, fgColor, 2, true);

        label_4_k = CS.paintLabels(this, "    ", "Last Name", bgColor, fgColor, 2, true);
        label_4_v = CS.paintLabels(this, "    ", employee.getLastName(), bgColor, fgColor, 2, true);

        label_5_k = CS.paintLabels(this, "    ", "Username", bgColor, fgColor, 2, true);
        label_5_v = CS.paintLabels(this, "    ", employee.getUsername(), bgColor, fgColor, 2, true);

        label_6_k = CS.paintLabels(this, "    ", "Address", bgColor, fgColor, 2, true);
        label_6_v = CS.paintLabels(this, "    ", employee.getAddress(), bgColor, fgColor, 2, true);

        label_7_k = CS.paintLabels(this, "    ", "Mobile", bgColor, fgColor, 2, true);
        label_7_v = CS.paintLabels(this, "    ", employee.getMobile(), bgColor, fgColor, 2, true);

        label_8_k = CS.paintLabels(this, "    ", "Email", bgColor, fgColor, 2, true);
        label_8_v = CS.paintLabels(this, "    ", employee.getEmail(), bgColor, fgColor, 2, true);

        label_9_k = CS.paintLabels(this, "    ", "Schedule", bgColor, fgColor, 2, true);
        label_9_v = CS.paintLabels(this, "    ", employee.getSchedule(), bgColor, fgColor, 2, true);

        label_10_k = CS.paintLabels(this, "    ", "Role", bgColor, fgColor, 2, true);
        label_10_v = CS.paintLabels(this, "    ", employee.getRole().getRoleName(), bgColor, fgColor, 2, true);

        setLogoutButton(new JButton("Logout"));

        this.add(getLogoutButton());
        this.setBounds();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBounds();
//        System.out.println(this.getWidth() + " : " + this.getHeight());
//        //CS.drawDoubleBorder(g,new Rectangle(45, 45, 400,400));
//        //CS.drawDoubleBorder(g,new Rectangle(490, 45, 400,400));
//        if (imageIcon != null) {
//            Image image = imageIcon.getImage();
//            int x = (this.getWidth()-iW)/2 , y= (this.getHeight()-iH)/2;
//            System.out.println(x + " : " + y);
//            //g.drawImage(image, x, y, iW, iH, this); // Draw the resized image
//        }
    }


    private void loadImageFromResource(){
        try {
            imageIcon = new ImageIcon(getClass().getResource("/resources/images/ship_repair_anim_01.gif"));
            if (imageIcon != null) {
                int originalWidth = imageIcon.getIconWidth();
                int originalHeight = imageIcon.getIconHeight();
                iH = originalHeight; iW=originalWidth;
                //System.out.println(originalWidth);
                //iH = (int) (((double) iW / originalWidth) * originalHeight);
            }
        } catch (Exception e) {
            System.out.println("Error Message!");
            System.out.println(e.getLocalizedMessage());
        }

    }
    
    
    public void setBounds(){
        int width= this.getWidth() , height=this.getHeight();
        int x=(width-305)/2, y = ((height-245)/2-25) , w_k=150, w_v=150, h=20, d=5, g=5;
        welcomeLabel.setBounds(x, y,(w_k + g + w_v),30);
        y += (d + h) + 15;
        titleLabel.setBounds(x, y, (w_k + g + w_v), h);
        label_1_k.setBounds(x, y, w_k,h);
        label_1_v.setBounds((x + w_k + g), y, w_v,h);
        y += (d + h);
        label_2_k.setBounds(x, y, w_k,h);
        label_2_v.setBounds((x + w_k + g), y, w_v,h);
        y += (d + h);
        label_3_k.setBounds(x, y, w_k,h);
        label_3_v.setBounds((x + w_k + g), y, w_v,h);
        y += (d + h);
        label_4_k.setBounds(x, y, w_k, h);
        label_4_v.setBounds((x + w_k + g), y, w_v, h);
        y += (d + h);
        label_5_k.setBounds(x, y, w_k, h);
        label_5_v.setBounds((x + w_k + g), y, w_v, h);
        y += (d + h);
        label_6_k.setBounds(x, y, w_k, h);
        label_6_v.setBounds((x + w_k + g), y, w_v, h);
        y += (d + h);
        label_7_k.setBounds(x, y, w_k,h);
        label_7_v.setBounds((x + w_k + g), y, w_v,h);
        y += (d + h);
        label_8_k.setBounds(x, y, w_k,h);
        label_8_v.setBounds((x + w_k + g), y, w_v,h);
        y += (d + h);
        label_9_k.setBounds(x, y, w_k,h);
        label_9_v.setBounds((x + w_k + g), y, w_v,h);
        y += (d + h);
        label_10_k.setBounds(x, y, w_k,h);
        label_10_v.setBounds((x + w_k + g), y, w_v,h);
        y += (d + h);
        y += 20;
        getLogoutButton().setBounds((x + w_k + g), y, w_k,25);
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }
}
