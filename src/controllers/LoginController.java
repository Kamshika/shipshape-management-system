package controllers;

import models.DashboardModel;
import models.Role;
import services.EmployeeService;
import models.Employee;
import services.RoleService;
import views.DashboardView;
import views.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private LoginView loginView;
    private EmployeeService employeeService;
    private RoleService roleService;
    private Employee employee;



    public LoginController(Employee employee, LoginView loginView, EmployeeService employeeService, RoleService roleService) {
        this.loginView = loginView;
        this.employeeService = employeeService;
        this.roleService = roleService;

        this.loginView.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        this.loginView.getCancelButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCancel();
            }
        });
    }

    private void handleLogin() {

        String username = loginView.getUsernameText().getText();
        String password = loginView.getPasswordText().getText();


        employee = employeeService.authenticate(new Employee(username, password));

        if (employee.getEmployeeId() > 0) {
            //JOptionPane.showMessageDialog(loginView, "Login successful!");
            employee.setRole(roleService.getRoleById(employee.getRoleId()));
            DashboardModel dashboardModel = new DashboardModel(employee);
            DashboardView dashboardView = new DashboardView(dashboardModel);
            DashboardController dashboardController = new DashboardController(dashboardView, dashboardModel);
            //dashboardController.tmpShowEmployees();
            dashboardView.setVisible(true);
            this.loginView.setVisible(false);
            this.loginView.dispose();
        } else {
            JOptionPane.showMessageDialog(loginView, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void handleCancel() {
        loginView.getUsernameText().setText("");
        loginView.getPasswordText().setText("");
    }
}
