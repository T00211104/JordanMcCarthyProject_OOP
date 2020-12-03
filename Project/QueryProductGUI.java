package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QueryProductGUI extends JFrame {
    private final Insets normalInsets = new Insets(10, 10, 0, 10);
    private final Insets topInsets = new Insets(30, 10, 0, 10);
    private JTextField ProductIDField;
    private JTextField NameField;
    private JTextField ManufacturerField;
    private JTextField QuantityField;
    private JTextField DescriptionField;
    private JTextField PriceField;

    public QueryProductGUI() {
        super("Query Products");

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
        QueryProductGUI qp = new QueryProductGUI();
    }

    private JPanel createTitlePanel() {
        JPanel jpanel = new JPanel();

        JLabel titleLabel = new JLabel("Query Product Details");
        titleLabel.setFont(new Font("serif", Font.PLAIN, 15));

        jpanel.add(titleLabel);

        return jpanel;
    }

    private JPanel createDetailsPanel() {
        JPanel jpanel = new JPanel();
        jpanel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel ProductIDLabel = new JLabel("ProductID :");
        addComponent(jpanel, ProductIDLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JTextField ProductIDField = new JTextField(1);
        addComponent(jpanel, ProductIDField, 1, gridy++, 1, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel NameLabel = new JLabel("Product Name: ");
        addComponent(jpanel, NameLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        NameField = new JTextField(1);
        addComponent(jpanel, NameField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel ManufacturerLabel = new JLabel("Manufacturer: ");
        addComponent(jpanel, ManufacturerLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        ManufacturerField = new JTextField(1);
        addComponent(jpanel, ManufacturerField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel QuantityLabel = new JLabel("Quantity: ");
        addComponent(jpanel, QuantityLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        QuantityField = new JTextField(1);
        addComponent(jpanel, QuantityField, 0, gridy++, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel DescriptionLabel = new JLabel("Description: ");
        addComponent(jpanel, DescriptionLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        DescriptionField = new JTextField( 1);
        addComponent(jpanel, DescriptionField, 0, gridy, 2, 1, topInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        JLabel PriceLabel = new JLabel("Description: ");
        addComponent(jpanel, PriceLabel, 0, gridy, 1, 1, normalInsets,
                GridBagConstraints.LINE_START, GridBagConstraints.HORIZONTAL);

        PriceField = new JTextField( 1);
        addComponent(jpanel, PriceField, 0, gridy, 2, 1, topInsets,
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

        JButton btnQueryProduct = new JButton("Query Product");

        btnQueryProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Product p1 = new Product(1,"Maxiflex Gloves","MaxiFlex",15,"A Breathable glove that provides protection and grip",3);
                Product p2 = new Product(2,"DEWALT CHALLENGER 3 SAFETY BOOT","DEWALT",3,"Waterproof Brown Safety Boots",150);
                Product p3 = new Product(3,"MOLDEX 2405 MASK,Manufacturer","MOLDEX",15,"Classic FFP-Mask: perfect fit without nose clip",4);
                Product p4 = new Product(4,"BOLLE TRACKER SAFETY GLASSES","Bolle",6,"The Bolle Tracker Safety Glasses are designed to protect against mechanical and chemical risks",15);
                Product p5 = new Product(5,"BIZWELD NAVY BOILERSUIT","BIZWELD",4," Clever design features include flame resistant reflective tape",45);
                ArrayList<Product> allProducts = new ArrayList<Product>(Arrays.asList(p1, p2, p3, p4, p5));

                try {
                    Product at;
                    String allProductData = "";

                    Iterator<Product> iterator = allProducts.iterator();

                    while (iterator.hasNext()) {
                        at = iterator.next();
                        if (at != null)
                            allProductData += at + "\n";
                    }
                    JOptionPane.showMessageDialog(null, allProductData, "List of all Clients", JOptionPane.INFORMATION_MESSAGE);


                } catch (NumberFormatException nfe) {
                } catch (IllegalArgumentException iae) {
                    if (iae.getMessage().contains("0"))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid ProductID", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Name", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Manufacturer", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Quantity", JOptionPane.ERROR_MESSAGE);
                    else if (iae.getMessage().contains(""))
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Description", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, iae.getMessage(),
                                "Invalid Price", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        jpanel.add(btnQueryProduct);

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
