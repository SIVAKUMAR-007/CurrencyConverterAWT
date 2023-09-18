package org.cor;

import java.awt.*;
import java.awt.event.*;

public class CurrencyConverterAWT extends Frame {
    private TextField rupeeTextField, dollarTextField;

    public CurrencyConverterAWT() {
        // Set the frame title
        setTitle("Currency Converter");

        // Create labels
        Label rupeeLabel = new Label("Rupees:");
        Label dollarLabel = new Label("Dollars:");

        // Create text fields
        rupeeTextField = new TextField("0", 10);
        dollarTextField = new TextField("0", 10);

        // Create a button to convert from Rupees to Dollars
        Button rupeeToDollarButton = new Button("Convert to Dollars");
        rupeeToDollarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double rupees = Double.parseDouble(rupeeTextField.getText());
                    double dollars = rupees / 65.25; // Conversion rate
                    dollarTextField.setText(String.valueOf(dollars));
                } catch (NumberFormatException ex) {
                    dollarTextField.setText("Invalid input");
                }
            }
        });

        // Create a button to convert from Dollars to Rupees
        Button dollarToRupeeButton = new Button("Convert to Rupees");
        dollarToRupeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double dollars = Double.parseDouble(dollarTextField.getText());
                    double rupees = dollars * 65.25; // Conversion rate
                    rupeeTextField.setText(String.valueOf(rupees));
                } catch (NumberFormatException ex) {
                    rupeeTextField.setText("Invalid input");
                }
            }
        });

        // Create a button to close the application
        Button closeButton = new Button("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Create a panel to hold the components
        Panel panel = new Panel(new GridLayout(3, 2, 10, 10));
        panel.add(rupeeLabel);
        panel.add(rupeeTextField);
        panel.add(dollarLabel);
        panel.add(dollarTextField);
        panel.add(rupeeToDollarButton);
        panel.add(dollarToRupeeButton);

        // Add the panel to the frame
        add(panel, BorderLayout.CENTER);
        add(closeButton, BorderLayout.SOUTH);

        // Set the frame size and make it visible
        setSize(300, 200);
        setVisible(true);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new CurrencyConverterAWT();
    }
    
}
