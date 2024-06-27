package views;

import models.DashboardModel;
import models.Employee;
import views.panels.HomePanel;
import views.panels.SideBar;

import javax.swing.*;

public class DashboardView extends JFrame {


    private JPanel mainPanel;
    private SideBar sideBar;
    private JPanel contentPanel;
    private HomePanel homePanel;
    private DashboardModel dashboardModel;
    private String currentPanelName = "Home";


    public DashboardView(DashboardModel dashboardModel){
        this.dashboardModel = dashboardModel;
        this.createUIComponents();
    }
    public DashboardView() {
        this.createUIComponents();
    }

    private void createUIComponents() {

        this.sideBar = new SideBar(this.dashboardModel.getCurrentUser().getRole().getRoleName());
        this.homePanel = new HomePanel(this.dashboardModel.getCurrentUser());
        this.contentPanel = this.homePanel;

        //this.setResizable(false);

        mainPanel.setLayout(null);


        this.setContentPane(mainPanel);



        this.setTitle("ShipShape Management System");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(40,40,1200,850);
        //this.setResizable(false);
    }


    public Employee getCurrentUser() {
        return this.dashboardModel.getCurrentUser();
    }

    public void setCurrentUser(Employee currentUser) {
        if(this.dashboardModel==null){
            this.dashboardModel = new DashboardModel(currentUser);
        }else {
            this.dashboardModel.setCurrentUser(currentUser);
        }
    }

    public DashboardModel getDashboardModel() {
        return dashboardModel;
    }

    public void setDashboardModel(DashboardModel dashboardModel) {
        this.dashboardModel = dashboardModel;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public SideBar getSideBar() {
        return sideBar;
    }

    public void setSideBar(SideBar sideBar) {
        this.sideBar = sideBar;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public void setContentPanel(JPanel contentPanel) {
        this.contentPanel = contentPanel;
    }

    public HomePanel getHomePanel() {
        return homePanel;
    }

    public void setHomePanel(HomePanel homePanel) {
        this.homePanel = homePanel;
    }

    public String getCurrentPanelName() {
        return currentPanelName;
    }

    public void setCurrentPanelName(String currentPanelName) {
        this.currentPanelName = currentPanelName;
    }
}
