package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class QueryClientGUI extends JFrame {
    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField ClientIDField;
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNoField;
    private JTextField dateRegisteredField;
    private GregorianCalendar dateChosen;

    public QueryClientGUI() {
        super("Query Clients");

        JPanel jpanel = new JPanel();
        jpanel.setLayout(new BoxLayout(jpanel, BoxLayout.Y_AXIS));

        jpanel.add(Box.createVerticalStrut(50));
        jpanel.add(createTitlePanel());
        jpanel.add(createDetailsPanel());
        jpanel.add(Box.createVerticalStrut(40));
        jpanel.add(createSubmitPanel());
        jpanel.add(Box.createVerticalStrut(20));

        add(jpanel);

    }

    public static void main(String[] args) {
        QueryClientGUI qc = new QueryClientGUI();
    }

    private JPanel createTitlePanel() {
        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Query Client Details");
        titleLabel.setFont(new Font("serif", Font.PLAIN, 15));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ClientIDLabel = new JLabel("ClientID");
        addComponent(jpanel, ClientIDLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField ClientIDField = new JTextField(1);
        addComponent(jpanel, ClientIDField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel firstNameLabel = new JLabel("First Name: ");
        addComponent(jpanel, firstNameLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        firstNameField = new JTextField(1);
        addComponent(jpanel, firstNameField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        addComponent(jpanel, lastNameLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        lastNameField = new JTextField(1);
        addComponent(jpanel, lastNameField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel phoneNoLabel = new JLabel("Phone No: ");
        addComponent(jpanel, phoneNoLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        phoneNoField = new JTextField(1);
        addComponent(jpanel, phoneNoField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel dateRegisteredLabel = new JLabel("Date Registered: ");
        addComponent(jpanel, dateRegisteredLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        dateRegisteredField = new JTextField("dd-mm-yyyy", 1);
        addComponent(jpanel, dateRegisteredField, 0, gridy, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JButton dateRegisteredButton = new JButton("Date Registered");
        dateRegisteredButton.setPreferredSize(new Dimension(1, 1));
        addComponent(jpanel, dateRegisteredButton, 0, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        return jpanel;
    }

    private void addComponent(Container container, Component component,
                              int gridx, int gridy, int gridwidth, int gridheight,
                              Insets insets, int anchor, int fill) {

        GridBagConstraints gbc = new GridBagConstraints(gridx, gridy,
                gridwidth, gridheight, 0.0, 0.0, anchor, fill, insets, 5, 5);

        container.add(component, gbc);
    }

    public Component createSubmitPanel() {
        JPanel jpanel = new JPanel();

        JButton btnQueryClient = new JButton("Query Client");

        btnQueryClient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client c1 = new Client(1, "Michael", "McGinn", "0871234567", new GregorianCalendar(2006, 9, 15));
                Client c2 = new Client(2, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2007, 03, 17));
                Client c3 = new Client(3, "Tyrone", "Mitchell", "0873456789", new GregorianCalendar(2090, 05, 13));
                Client c4 = new Client(4, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2017, 01, 18));
                Client c5 = new Client(5, "Margaret", "Flaherty", "0872345678", new GregorianCalendar(2015, 12, 2));
                ArrayList<Client> allClients = new ArrayList<Client>(Arrays.asList(c1, c2, c3, c4, c5));

                try {
                    Client at;
                    String allClientData = "";

                    Iterator<Client> iterator = allClients.iterator();

                    while (iterator.hasNext()) {
                        at = iterator.next();
                        if (at != null)
                            allClientData += at + "\n";
                    }
                    JOptionPane.showMessageDialog(null, allClientData, "List of all Clients", JOptionPane.INFORMATION_MESSAGE);


                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid ClientID", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid First Name", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Last Name", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Phone No", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Date Registered", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        jpanel.add(btnQueryClient);

        return jpanel;
    }
}

    //using an iterator here just for practice (could have easily done without it in this case)
   /* Iterator<Product> iterator = allProducts.iterator();

        while(iterator.hasNext()) {
        pr = iterator.next();
        if (pr != null)
            allProductData += pr + "\n";
    }

        JOptionPane.showMessageDialog(null,allProductData,"List of all Products",JOptionPane.INFORMATION_MESSAGE);*/
