package Project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class MainMenu extends JFrame implements ActionListener
{
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
            menuBar.setBackground(Color.GRAY);
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

    private void createProductFile() {

        ProductMenu = new JMenu("Products");
        JMenuItem item;

        item = new JMenu("Add Products");
        item.addActionListener(this);
        ProductMenu.add(item);

        item = new JMenu("Update Products");
        item.addActionListener(this);
        ProductMenu.add(item);

        item = new JMenu("Remove Products");
        item.addActionListener(this);
        ProductMenu.add(item);

        item = new JMenuItem("Query Products");
        item.addActionListener(this);
        ProductMenu.add(item);
    }


    private void createClientFile() {
        JMenuItem item;

        item = new JMenu("Add Clients");
        item.addActionListener(this);
        ClientMenu.add(item);

        item = new JMenu("Update Clients");
        item.addActionListener(this);
        ClientMenu.add(item);

        item = new JMenu("Remove Clients");
        item.addActionListener(this);
        ClientMenu.add(item);

        item = new JMenuItem("Query Clients");
        item.addActionListener(this);
        ProductMenu.add(item);


    }
    private void createSalesFile() {
        JMenuItem item;

        ClientMenu = new JMenu("Sales");

        item = new JMenu("Process Sale");
        item.addActionListener(this);
        ClientMenu.add(item);

        item = new JMenu("Refund Sale");
        item.addActionListener(this);
        ClientMenu.add(item);
    }
    public void actionPerformed(ActionEvent event){
        String menuName;
        menuName=event.getActionCommand();//menu name is acting as getActionCommand

        if (menuName.equals("Quit")){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showMessageDialog(null,"Are you sure you want to leave?","Exiting SalesSYS",JOptionPane.YES_NO_OPTION);
            if (dialogButton == JOptionPane.YES_OPTION) {
                System.exit(0);}
            else if (dialogButton==JOptionPane.NO_OPTION)
                JOptionPane.showMessageDialog(null,"Exit Cancelled","Exit Cancelled",JOptionPane.INFORMATION_MESSAGE);

        }
        if (menuName.equals("Add Products")){
            AddProductDetailsGUI ap = new AddProductDetailsGUI();
        }
        if (menuName.equals("Add Clients")){
            AddClientDetailsGUI ac = new AddClientDetailsGUI();
        }

        else
            response.setText("Menu Item" + menuName + "is selected");

        }
    }

