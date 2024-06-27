import controllers.DashboardController;
import controllers.LoginController;
import controllers.OrderController;
import models.*;
import services.*;
import services.Impl.*;
import views.DashboardView;
import views.LoginView;
import views.OrderView;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        DatabaseConnectionService databaseConnectionService = new MySQLConnectionService();

        // Create the view
        LoginView loginView = new LoginView();
        loginView.setVisible(true);

        // Create the service
        EmployeeService employeeService = new EmployeeServiceImpl(databaseConnectionService);
        RoleService roleService = new RoleServiceImpl(databaseConnectionService);
        // Create the controller
        LoginController loginController = new LoginController(null, loginView, employeeService, roleService);
    }

}