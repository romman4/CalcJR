package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Solution {
    private JButton btnAdd, btnSub, btnMul, btnDiv, btnSqrt;
    private JLabel lblNum1, lblNum2, lblRes;
    private JTextField txtFieldNum1, txtFieldNum2, txtFieldRes;
    private JPanel panel1, panel2, panel21, panel22, panel3;
    private JFrame frame;
    private double a, b;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createButtons();
        solution.addButtonListeners();
        solution.createLabels();
        solution.createTextFields();
        solution.createPanels();
        solution.createFrame();
    }

    private void createButtons() {
        btnAdd = new JButton("+");
        btnSub = new JButton("-");
        btnMul = new JButton("*");
        btnDiv = new JButton("/");
        btnSqrt = new JButton("Корень квадратный");
    }

    private void addButtonListeners() {
        ButtonListener b1 = new ButtonListener();
        btnAdd.addActionListener(b1);
        btnSub.addActionListener(b1);
        btnMul.addActionListener(b1);
        btnDiv.addActionListener(b1);
        btnSqrt.addActionListener(b1);
    }

    private void createLabels() {
        lblNum1 = new JLabel("Число 1:");
        lblNum2 = new JLabel("Число 2:");
        lblRes = new JLabel("Результат:");
    }

    private void createTextFields() {
        txtFieldNum1 = new JTextField(10);
        txtFieldNum2 = new JTextField(10);
        txtFieldRes = new JTextField(10);
        txtFieldRes.setForeground(Color.RED);
        txtFieldRes.setEditable(false);
        }

    private void createPanels() {
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());

        panel21 = new JPanel();
        panel21.setLayout(new FlowLayout());

        panel22 = new JPanel();
        panel22.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());

        panel1.add(lblNum1);
        panel1.add(txtFieldNum1);
        panel1.add(btnSqrt);

        panel21.add(btnAdd);
        panel21.add(btnSub);
        panel21.add(btnMul);
        panel21.add(btnDiv);

        panel22.add(lblNum2);
        panel22.add(txtFieldNum2);

        panel2.add(panel21, BorderLayout.NORTH);
        panel2.add(panel22, BorderLayout.CENTER);

        panel3.add(lblRes);
        panel3.add(txtFieldRes);
    }

    private void createFrame() {
        frame = new JFrame("Калькулятор");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public class ButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            a = Double.parseDouble(txtFieldNum1.getText());
            if (e.getSource() == btnSqrt) {
                txtFieldRes.setText(String.valueOf(Math.sqrt(a)));
            } else b = Double.parseDouble(txtFieldNum2.getText());
            if (e.getSource() == btnAdd) {
                txtFieldRes.setText(String.valueOf(a + b));
            } else if (e.getSource() == btnSub) {
                txtFieldRes.setText(String.valueOf(a - b));
            } else if (e.getSource() == btnMul) {
                txtFieldRes.setText(String.valueOf(a * b));
            } else if (e.getSource() == btnDiv) {
                txtFieldRes.setText(String.valueOf(a / b));
            }
        }
    }
}
