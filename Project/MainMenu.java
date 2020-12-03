package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MainMenu extends JFrame implements ActionListener {
        JMenu ProductMenu,ClientMenu,SalesMenu;
        JLabel response;

        public MainMenu() {
            super("Main Menu");

            setLayout(new GridBagLayout());

            createProductFile();
            createClientFile();
            createSalesFile();

            JMenuBar menuBar = new JMenuBar();
            setJMenuBar(menuBar);
            menuBar.setBackground(Color.CYAN);
            menuBar.add(ProductMenu);
            menuBar.add(ClientMenu);
            menuBar.add(SalesMenu);

            response = new JLabel("Welcome to SalesSYS");
            add(response);

            setSize(400,400);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(250,200);
            setVisible(true);
        }

    public static void main(String[] args) { MainMenu frame = new MainMenu(); }

    /*Mnemonic Sean Courtney*/
    private void createProductFile() {

        ProductMenu = new JMenu("Products");
        ProductMenu.setMnemonic(KeyEvent.VK_P);
        JMenuItem productItem;

        productItem = new JMenu("Add Products");
        productItem.setMnemonic(KeyEvent.VK_A);
        productItem.addActionListener(this);
        ProductMenu.add(productItem);

        productItem = new JMenu("Update Products");
        productItem.setMnemonic(KeyEvent.VK_U);
        productItem.addActionListener(this);
        ProductMenu.add(productItem);

        productItem = new JMenu("Remove Products");
        productItem.setMnemonic(KeyEvent.VK_R);
        productItem.addActionListener(this);
        ProductMenu.add(productItem);

        productItem = new JMenuItem("Query Products");
        productItem.setMnemonic(KeyEvent.VK_Q);
        productItem.addActionListener(this);
        ProductMenu.add(productItem);
    }

    /*Mnemonic Sean Courtney*/
    private void createClientFile() {
        ClientMenu = new JMenu("Clients");
        ClientMenu.setMnemonic(KeyEvent.VK_P);
        JMenuItem ClientItem;

        ClientItem = new JMenu("Add Clients");
        ClientItem.setMnemonic(KeyEvent.VK_A);
        ClientItem.addActionListener(this);
        ClientMenu.add(ClientItem);

        ClientItem = new JMenu("Update Clients");
        ClientItem.setMnemonic(KeyEvent.VK_U);
        ClientItem.addActionListener(this);
        ClientMenu.add(ClientItem);

        ClientItem = new JMenu("Remove Clients");
        ClientItem.setMnemonic(KeyEvent.VK_R);
        ClientItem.addActionListener(this);
        ClientMenu.add(ClientItem);

        ClientItem = new JMenuItem("Query Clients");
        ClientItem.setMnemonic(KeyEvent.VK_Q);
        ClientItem.addActionListener(this);
        ClientMenu.add(ClientItem);
    }
    /*Mnemonic Sean Courtney*/
    private void createSalesFile() {
        SalesMenu = new JMenu("Sales");
        SalesMenu.setMnemonic(KeyEvent.VK_S);
        JMenuItem salesItem;

        salesItem = new JMenu("Process Sale");
        salesItem.addActionListener(this);
        SalesMenu.add(salesItem);

        salesItem = new JMenu("Refund Sale");
        salesItem.addActionListener(this);
        SalesMenu.add(salesItem);
    }
    public void actionPerformed(ActionEvent e){
        String menuName;
        menuName=e.getActionCommand();//menu name is acting as getActionCommand

        if (menuName.equals("Quit")){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showMessageDialog(null,"Are you sure you want to leave?","Exiting SalesSYS",JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION)
                System.exit(0);
            else if (dialogButton==JOptionPane.NO_OPTION)
                JOptionPane.showMessageDialog(null,"Exit Cancelled","Exit Cancelled",JOptionPane.INFORMATION_MESSAGE);

        }
        if (menuName.equals("Add Products")){
            AddProductGUI Ap = new AddProductGUI();
        }
        if(menuName.equals("Update Products")){
            UpdateProductGUI up = new UpdateProductGUI();
        }
        if (menuName.equals("Remove Products")){
            RemoveProductGUI rp = new RemoveProductGUI();
        }
        if (menuName.equals("Query Products")){
            QueryProductGUI qp = new QueryProductGUI();
        }
        if (menuName.equals("Add Clients")){
            AddClientGUI ac = new AddClientGUI();
        }
        if (menuName.equals("Update Clients")){
            UpdateClientGUI2 uc = new UpdateClientGUI2();
        }
        if (menuName.equals("Remove Clients")){
            RemoveProductGUI rp = new RemoveProductGUI();
        }
        if (menuName.equals("Query Clients")){
            QueryProductGUI qp = new QueryProductGUI();
        }
        else{
            response.setText("Menu Item" + menuName + "is selected");
            }
        }
    }

