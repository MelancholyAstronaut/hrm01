package cn.itcast.jcalculator;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;

public class JCalculator extends JFrame implements ActionListener {
    /**
     *
     */


    private class WindowCloser extends WindowAdapter {
        public void windowClosing(WindowEvent we) {
            System.exit(0);
        }
    }

    Character op = null;
    List<Double> opNumber = new LinkedList<>();
    String ConnNumber = "";
    int i;
    // Strings for Digit & Operator buttons.
    private final String[] str = {"7", "8", "9", "/", "4", "5", "6", "*", "1",
            "2", "3", "-", ".", "0", "=", "+"};
    // Build buttons.
    JButton[] buttons = new JButton[str.length];
    // For cancel or reset.
    JButton reset = new JButton("CE");
    // Build the text field to show the result.
    /**
     *
     */
    JTextField display = new JTextField("0");

    /**
     * Constructor without parameters.
     */
    public JCalculator() {
        super("计算器");
        // Add a panel.
        //JPanel panel1 = new JPanel(new GridLayout(4, 4));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(4, 4));
        for (i = 0; i < str.length; i++) {
            buttons[i] = new JButton(str[i]);
            panel1.add(buttons[i]);
        }
        //JPanel panel2 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.add("Center", display);
        panel2.add("East", reset);
        // JPanel panel3 = new Panel();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add("North", panel2);
        getContentPane().add("Center", panel1);
        // Add action listener for each digit & operator button.
        for (i = 0; i < str.length; i++)
            buttons[i].addActionListener(this);
        // Add listener for "reset" button.
        reset.addActionListener(this);
        // Add listener for "display" button.
        display.addActionListener(this);
        // The "close" button "X".
        addWindowListener(new WindowCloser());
        // Initialize the window size.
        setSize(800, 800);
        // Show the window.
        // show(); Using show() while JDK version is below 1.5.
        setVisible(true);
        // Fit the certain size.
        pack();
    }

    public void actionPerformed(ActionEvent e) {
        Object target = e.getSource();
        String label = e.getActionCommand();
        if (target == reset)
            handleReset();
        else if ("0123456789.".indexOf(label) >= 0) //?
            handleNumber(label);
        else
            handleOperator(label);
    }

    private void handleOperator(String label) {
        opNumber.add(Double.parseDouble(ConnNumber));
        display.setText(ConnNumber);
        ConnNumber = "";
        if (label.charAt(0) == '+') {
            op = '+';
        } else if (label.charAt(0) == '-') {
            op = '-';
        } else if (label.charAt(0) == '/') {
            op = '/';
        } else if (label.charAt(0) == '*') {
            op = '*';
        }

        if (opNumber.size() >= 2) {
            //计算
            double first = opNumber.get(0);
            double second = opNumber.get(1);
            if (op == '+') {
                display.setText(String.valueOf(first + second));
                opNumber.clear();
                ConnNumber = first + second + ""; //支持连续计算
            } else if (op == '-') {
                display.setText(String.valueOf(first - second));
                opNumber.clear();
                ConnNumber = first - second + "";
            } else if (op == '*') {
                //显示两位小数
                display.setText(String.format("%.2f", (first * second)));
                opNumber.clear();
                ConnNumber = first * second + "";
            } else {

                if (second == 0) {
                    display.setText(String.valueOf("by zero"));
                } else {
                    display.setText(String.format("%.2f", (first*1.0 / second)));
                    opNumber.clear();
                    ConnNumber = first / second + "";
                }
            }
            opNumber.clear();
        }

    }

    private void handleNumber(String label) {
        ConnNumber += label;
        //     System.out.println(ConnNumber);
        display.setText(ConnNumber);
    }

    private void handleReset() {
        opNumber.clear();
        ConnNumber = "";
        display.setText("0");
    }
    // Is the first digit pressed?
//    boolean isFirstDigit = true; //这里使用List储存数据,不需要另作判断!
    /**
     * Number handling.
     * @param key the key of the button.
     */

    /**
     * Reset the calculator.
     */

    /**
     * Handling the operation.
     */
    public static void main(String[] args) {
        new JCalculator();
    }
}