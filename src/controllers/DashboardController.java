package controllers;

import models.*;
import services.*;
import services.Impl.*;
import views.DashboardView;
import views.LoginView;
import views.OrderView;
import views.panels.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import java.util.List;

public class DashboardController {

    private DashboardView dashboardView;
    private DashboardModel dashboardModel;
    private DatabaseConnectionService databaseConnectionService;
    private EmployeeService employeeService;
    private RoleService roleService;
    private CustomerService customerService;
    private SupplierService supplierService;
    private PartService partService;
    private InventoryService inventoryService;
    private OrderService orderService;
    private JobsService jobsService;
    private JobTypeService jobTypeService;
    private OrderPartService orderPartService;
    private OrderTypeService orderTypeService;
    private NotificationService notificationService;
    private PropertyService propertyService;
    private EmailService emailService;
    private SalesService salesService;


    public DashboardController(DashboardView dashboardView, DashboardModel dashboardModel) {

        this.dashboardView = dashboardView;
        this.dashboardModel = dashboardModel;

        this.databaseConnectionService = new MySQLConnectionService();

        this.employeeService = new EmployeeServiceImpl(databaseConnectionService);
        this.roleService = new RoleServiceImpl(databaseConnectionService);
        this.customerService = new CustomerServiceImpl(databaseConnectionService);
        this.supplierService = new SupplierServiceImpl(databaseConnectionService);
        this.partService = new PartServiceImpl(databaseConnectionService);
        this.inventoryService = new InventoryServiceImpl(databaseConnectionService);
        this.orderService = new OrderServiceImpl(databaseConnectionService);
        this.jobsService = new JobsServiceImpl(databaseConnectionService);
        this.orderService = new OrderServiceImpl(databaseConnectionService);
        this.partService = new PartServiceImpl(databaseConnectionService);
        this.supplierService = new SupplierServiceImpl(databaseConnectionService);
        this.customerService = new CustomerServiceImpl(databaseConnectionService);
        this.orderPartService = new OrderPartServiceImpl(databaseConnectionService);
        this.orderTypeService = new OrderTypeServiceImpl(databaseConnectionService);
        this.jobTypeService = new JobTypeServiceImpl(databaseConnectionService);
        this.notificationService = new NotificationServiceImpl(databaseConnectionService);
        this.propertyService = new PropertyServiceImpl(databaseConnectionService);
        this.emailService = new EmailServiceImpl(propertyService);
        this.salesService = new SalesServiceImpl(databaseConnectionService);

        this.dashboardView.getHomePanel().getLogoutButton().addActionListener(e -> {

            // Create the view
            LoginView loginView = new LoginView();
            loginView.setVisible(true);

            // Create the controller
            LoginController loginController = new LoginController(null, loginView, employeeService, roleService);
            this.dashboardView.setVisible(false);
            this.dashboardView.dispose();
        });


        this.dashboardView.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                paintPanels(dashboardView);
                super.componentResized(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                super.componentMoved(e);
            }

            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                super.componentHidden(e);
            }

        });

        dashboardView.getSideBar().getButtons().forEach(jButton -> {

            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    String btn = jButton.getText();

                    if (!dashboardView.getCurrentPanelName().equals(btn)) {
                        switch (btn) {
                            case "Home":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new HomePanel(dashboardView.getCurrentUser()));
                                break;
                            case "Manage Employees":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                List<Employee> employees = employeeService.getAllEmployees();
                                List<Role> roles = roleService.getAllRoles();
                                dashboardView.setContentPanel(new EmployeesPanel(DashboardController.this, employees, roles));
                                break;
                            case "Manage Roles":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new RolesPanel(DashboardController.this, roleService.getAllRoles()));
                                break;
                            case "Manage Customers":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new CustomersPanel(DashboardController.this, customerService.getAllCustomers()));
                                break;
                            case "Manage Suppliers":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new SuppliersPanel(DashboardController.this, supplierService.getAllSuppliers()));
                                break;
                            case "Manage Parts":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new PartsPanel(DashboardController.this, partService.getAllParts()));
                                break;
                            case "Manage Inventory":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new InventoryPanel(DashboardController.this, inventoryService.getAllInventories()));
                                break;
                            case "Manage Orders":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new OrderPanel(DashboardController.this, orderService.getAllOrders()));
                                break;
                            case "Manage Jobs":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new JobsPanel(DashboardController.this, jobsService.getAllJobs()));
                                break;
                            case "Manage Notifications":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new NotificationsPanel(DashboardController.this, notificationService.getAllNotifications(), propertyService.getAllPropertiesByType("email")));
                                break;
                            case "Sales Report":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new SalesReportPanel(DashboardController.this));
                                break;
                            case "Email Settings":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new EmailSettingsPanel(DashboardController.this, propertyService.getAllPropertiesByType("email")));
                                break;
                            case "My Jobs":
                                dashboardView.getContentPanel().setBounds(0, 0, 0, 0);
                                dashboardView.setContentPanel(null);
                                dashboardView.setContentPanel(new MyJobsPanel(DashboardController.this, jobsService.getAllJobsByEmployeeID(dashboardView.getCurrentUser().getEmployeeId())));
                                break;
                            default:
                                System.out.println("N/A");
                                break;
                        }
                        paintPanels(dashboardView);
                        dashboardView.setCurrentPanelName(btn);
                    }


                    paintPanels(dashboardView);
                }
            });

        });

        paintPanels(dashboardView);
    }


    public void showOrderView(Order order, String title, OrderPanel orderPanel){

        List<Customer> customers = customerService.getAllCustomers();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        List<Part> parts = partService.getAllParts();
        List<OrderType> orderTypes = orderTypeService.getAllOrderTypes();

        OrderModel orderModel = new OrderModel(order, customers, suppliers, parts, orderTypes);
        OrderView orderView = new OrderView(orderModel, title);

        OrderController orderController = new OrderController(databaseConnectionService, orderView, orderModel, orderService, partService, customerService, supplierService, inventoryService, orderPartService, jobsService, jobTypeService, orderTypeService, orderPanel);
        orderView.setOrderController(orderController);
        if(order.getOrderId() > 0) orderController.setOrderToView(order);
        orderView.setVisible(true);

        
    }

    public void paintPanels(DashboardView dashboardView) {

        JPanel mainPanel = dashboardView.getMainPanel();
        JPanel sideBar = dashboardView.getSideBar();
        JPanel contentPanel = dashboardView.getContentPanel();

        final int d = 10;
        final int sideBarWidth = 220;
        final LineBorder lineBorder = new LineBorder(Color.decode("#AAAAAA"), 1, false);


        Dimension wh = mainPanel.getSize();

        Rectangle sideBarBounds = new Rectangle(d, d, sideBarWidth, wh.height - 2 * d);
        sideBar.setBounds(sideBarBounds);
        sideBar.setBorder(lineBorder);
        mainPanel.add(sideBar);

        Rectangle contentPanelBounds = new Rectangle(2 * d + sideBarWidth, d, wh.width - sideBarWidth - 3 * d, wh.height - 2 * d);
        contentPanel.setBounds(contentPanelBounds);
        contentPanel.setBorder(lineBorder);
        mainPanel.add(contentPanel);
    }


    public boolean crudEmployee(Employee employee, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.employeeService.addEmployee(employee);
                case 'r':
                    Employee employee_ = this.employeeService.getEmployeeById(employee.getEmployeeId());
                    if(employee_!=null){
                        employee.clone_(employee_);
                        employee.setRole(roleService.getRoleById(employee.getRoleId()));
                    }
                    return employee_ != null;
                case 'u':
                    return this.employeeService.updateEmployee(employee);
                case 'd':
                    return this.employeeService.deleteEmployee(employee.getEmployeeId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }


    public boolean crudRole(Role role, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.roleService.addRole(role);
                case 'r':
                    break;
                case 'u':
                    return this.roleService.updateRole(role);
                case 'd':
                    return this.roleService.deleteRole(role.getRoleId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    public boolean crudCustomer(Customer customer, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.customerService.addCustomer(customer);
                case 'r':
                    break;
                case 'u':
                    return this.customerService.updateCustomer(customer);
                case 'd':
                    return this.customerService.deleteCustomer(customer.getCustomerId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Customer> getAllCustomers() {
        return this.customerService.getAllCustomers();
    }

    public boolean crudSupplier(Supplier supplier, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.supplierService.addSupplier(supplier);
                case 'r':
                    Supplier supplier_ = this.supplierService.getSupplierById(supplier.getSupplierId());
                    if(supplier_ != null){
                        supplier.clone(supplier_);
                    }
                    return supplier_ != null;
                case 'u':
                    return this.supplierService.updateSupplier(supplier);
                case 'd':
                    return this.supplierService.deleteSupplier(supplier.getSupplierId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Supplier> getAllSuppliers() {
        return this.supplierService.getAllSuppliers();
    }


    public boolean crudPart(Part part, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.partService.addPart(part);
                case 'r':
                    Part part_ = this.partService.getPartWithRemainingQuantityById(part.getPartId());
                    if(part_!=null){
                        part.clone_(part_);
                    }
                    return part_ != null;
                case 'u':
                    return this.partService.updatePart(part);
                case 'd':
                    return this.partService.deletePart(part.getPartId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Part> getAllParts() {
        return this.partService.getAllParts();
    }

    public boolean crudInventory(Inventory inventory, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.inventoryService.addInventory(inventory);
                case 'r':
                    break;
                case 'u':
                    return this.inventoryService.updateInventory(inventory);
                case 'd':
                    return this.inventoryService.deleteInventory(inventory.getInventoryId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Inventory> getAllInventories() {
        return this.inventoryService.getAllInventories();
    }


    public boolean crudJob(Jobs job, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.jobsService.addJob(job);
                case 'r':
                    break;
                case 'u':
                    return this.jobsService.updateJob(job);
                case 'd':
                    return this.jobsService.deleteJob(job.getJobId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<Jobs> getAllJobs() {
        return this.jobsService.getAllJobs();
    }

    public boolean crudOrder(Order order, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.orderService.addOrder(order);
                case 'r':
                    break;
                case 'u':
                    return this.orderService.updateOrder(order);
                case 'd':
                    return this.orderService.deleteOrder(order.getOrderId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }


    public boolean crudNotification(Notification notification, char crudType) {
        try {
            switch (crudType) {
                case 'c':
                    return this.notificationService.addNotification(notification);
                case 'r':
                    break;
                case 'u':
                    return this.notificationService.updateNotification(notification);
                case 'd':
                    return this.notificationService.deleteNotification(notification.getNotificationId());
                default:
                    break;
            }
        } catch (Exception e) {
        }
        return false;
    }


    public List<Notification> getAllNotifications() {
        return this.notificationService.getAllNotifications();
    }

    public void sendOrderRequestEmail(int partId) {
        Part part = partService.getPartById(partId);
        if(part==null){
            JOptionPane.showMessageDialog(null, "Part not found with id : " + partId, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Supplier supplier = supplierService.getSupplierById(part.getSupplierId());
        if(supplier==null){
            JOptionPane.showMessageDialog(null, "Supplier not found with id : " + part.getSupplierId(), "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(supplier.getContactEmail()==null){
            JOptionPane.showMessageDialog(null, "Supplier don't have an email.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String subject = "Order request : " + part.getName();
            String message = "Please contact our purchase department regarding order of " + part.getName();
            emailService.sendEmail(supplier.getContactEmail(), subject, message);
            JOptionPane.showMessageDialog(null, "Order request email sent.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Unable to send order request email.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sendJobAssignmentEmail(int employeeId, int jobId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(employee==null){
            JOptionPane.showMessageDialog(null, "Employee not found with id : " + employeeId, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            String subject = "New Job Assigned ID : " + jobId;
            String message = "Dear " + employee.getTitle() + " " + employee.getFirstName() + ", You have assigned to a new job. JOB ID : " + jobId + ".";
            if(employee.getEmail()==null){
                JOptionPane.showMessageDialog(null, "Employee don't have an email.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            emailService.sendEmail(employee.getEmail(), subject, message);
            JOptionPane.showMessageDialog(null, "Job assignment email sent.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Unable to send job assignment email.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void sendJobCompletionEmail(int orderId) {
        Order order = orderService.getOrder(orderId);
        Customer customer = customerService.getCustomerById(order.getCustomerId());
        try {
            String subject = "Job Completed - Order ID : " + orderId;
            String message = "Dear " + customer.getName() + " your repair/repaint job has been completed. - Order ID : " + orderId ;
            if(customer.getEmail()==null){
                JOptionPane.showMessageDialog(null, "Customer don't have an email.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            emailService.sendEmail(customer.getEmail(), subject, message);
            JOptionPane.showMessageDialog(null, "Job completion email sent.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Unable to send job completion email.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    public List<Sale> getSalesByRange(String fromDateString, String toDateString) {


        java.sql.Date fromDate = CS.parseSQLDateFromString(fromDateString);
        java.sql.Date toDate = CS.parseSQLDateFromString(toDateString);

        if(fromDate==null || toDate==null){
            return null;
        }
        return salesService.getSalesByRange(fromDate, toDate);
    }

    public List<Property> getAllEmailProperties(){
        return  this.propertyService.getAllPropertiesByType("email");
    }

    public Property getPropertyByKeyAndType(String key, String type) {
        return  this.propertyService.getPropertyByKeyAndType(key, type);
    }

    public boolean addOrUpdateProperties(List<Property> properties) {
        boolean success = this.propertyService.addOrUpdateProperties(properties);
        if(success){
            JOptionPane.showMessageDialog(null, "Settings updates successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null, "Error while updating settings successfully.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return success;
    }
}
