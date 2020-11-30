package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class AddClientDetailsGUI extends JFrame{

    private final Insets normalInsets = new Insets(5,10,0,10);
    private final Insets topInsets = new Insets(5,110,0,0);
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField phoneNoField;
    private JTextField dateRegisteredField;
    private GregorianCalendar dateChosen;

    public AddClientDetailsGUI(){
        super("Client Details");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        panel.add(Box.createVerticalStrut(5));
        panel.add(createTitlePanel());
        panel.add(createDetailsPanel());
        panel.add(Box.createVerticalStrut(40));
        panel.add(createSubmitPanel());
        panel.add(Box.createVerticalStrut(20));

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        AddClientDetailsGUI ac = new AddClientDetailsGUI();}

        private JPanel createTitlePanel() {
        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("Client Details");
        titleLabel.setFont(new Font("serif",Font.PLAIN,15));

        panel.add(titleLabel);

        return panel;
    }

    private JPanel createDetailsPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        int gridy = 0;

        JLabel firstNameLabel = new JLabel("First Name: ");
        addComponent(panel,firstNameLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        firstNameField = new JTextField(1);
        addComponent(panel,firstNameField,0,gridy++,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel lastNameLabel = new JLabel("Last Name: ");
        addComponent(panel,lastNameLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        lastNameField = new JTextField(1);
        addComponent(panel,lastNameField,0,gridy++,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel phoneNoLabel = new JLabel("Phone No: ");
        addComponent(panel,phoneNoLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        phoneNoField = new JTextField(1);
        addComponent(panel,phoneNoField,0,gridy++,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JLabel dateRegisteredLabel = new JLabel("Date Registered: ");
        addComponent(panel,dateRegisteredLabel,0,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        dateRegisteredField = new JTextField("enter in form dd-mm-yyyy or use date-chooser",1);
        addComponent(panel,dateRegisteredField,0,gridy,2,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JButton dateRegisteredButton = new JButton("Date Registered");
        dateRegisteredButton.setPreferredSize(new Dimension(1,1));
        addComponent(panel,dateRegisteredButton,0,gridy++,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        dateRegisteredButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateChooser dateChooser = new DateChooser(AddClientDetailsGUI.this);
                dateChosen = dateChooser.getDateChosen();

                if(dateChosen!=null){
                    System.out.println(dateChosen.get(Calendar.DATE) + "-" +
                            dateChosen.get(Calendar.MONTH) + "-" +
                            dateChosen.get(Calendar.YEAR));

                    String dayString="", monthString="";

                    if (dateChosen.get(Calendar.DATE)<10)
                        dayString = "0" + dateChosen.get(Calendar.DATE);
                    else
                        dayString = "" + dateChosen.get(Calendar.DATE);

                    if(dateChosen.get(Calendar.MONTH)<10)
                        monthString = "0" + dateChosen.get(Calendar.MONTH);
                    else
                        monthString = "" + dateChosen.get(Calendar.MONTH);

                    dateRegisteredField.setText(dayString + "-" +monthString + "-" + dateChosen.get(Calendar.YEAR));
                }
            }
        });

        JLabel ClientIDLabel = new JLabel("ClientID");
        addComponent(panel,ClientIDLabel,1,gridy,1,1,normalInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        JTextField clientIDField = new JTextField(1);
        addComponent(panel, clientIDField,1,gridy,1,1,topInsets,
                GridBagConstraints.LINE_START,GridBagConstraints.HORIZONTAL);

        return panel;
    }

    private void addComponent(Container container, Component component,
                                          int gridx, int gridy, int gridwidth, int gridheight, Insets insets,
                                          int anchor, int fill){

        GridBagConstraints gbc = new GridBagConstraints(gridx,gridy,
                gridwidth,gridheight,0.0,0.0,anchor,fill,insets,5,5);

        container.add(component, gbc);
    }

    private JPanel createSubmitPanel(){
        JPanel panel = new JPanel();

        JButton addButton = new JButton("Add Client");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateRegistered = dateRegisteredField.getText();

                Client client;

                if (dateRegistered.length() >= 7){

                    try{
                        int day = Integer.parseInt(dateRegistered.substring(0,2));
                        int month = Integer.parseInt(dateRegistered.substring(3,5));
                        int year = Integer.parseInt(dateRegistered.substring(6));

                        GregorianCalendar dateRegisteredGC = new GregorianCalendar(year,month-1,day);
                        dateRegisteredGC.setLenient(false);
                        dateRegisteredGC.getTime();

                        System.out.println(dateRegisteredGC.get(Calendar.DATE) + "-" +
                                dateRegisteredGC.get(Calendar.MONTH) + "-" +
                                dateRegisteredGC.get(Calendar.YEAR));

                       int fn =0;
                        String firNam = firstNameField.getText();
                        if(firNam!=""&& firNam.isEmpty())
                        {
                            fn = Integer.parseInt(firNam);
                        }

                        Client c = new Client(fn,lastNameField.getText(),phoneNoField.getText(),dateRegisteredField.getText(),dateRegisteredGC);

                        JOptionPane.showMessageDialog(null,"Client details are added\n\nDetails are -  " + c,"Added Client",JOptionPane.INFORMATION_MESSAGE);
                    }catch (NumberFormatException nfe){
                        JOptionPane.showMessageDialog(null,"Date Registered must be in the form dd-mm-yyyy","Invalid Date Registered",JOptionPane.ERROR_MESSAGE);
                    }catch (IllegalArgumentException iae){
                        if (iae.getMessage().contains("First Name: "))
                            JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid First Name",JOptionPane.ERROR_MESSAGE);
                       else if (iae.getMessage().contains("Last Name: "))
                        JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid Last Name",JOptionPane.ERROR_MESSAGE);
                        else if (iae.getMessage().contains("Phone No: "))
                            JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid Phone No",JOptionPane.ERROR_MESSAGE);
                        else
                            JOptionPane.showMessageDialog(null,iae.getMessage(),"Invalid Date Registered",JOptionPane.ERROR_MESSAGE);
                    }
                } else
                    JOptionPane.showMessageDialog(null,"Date Registered must be at least 7 characters long","Invalid Date Registered",JOptionPane.ERROR_MESSAGE);
            }});
        panel.add(addButton);
        return panel;
    }
}