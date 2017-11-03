package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Solution {
    private JButton btnAdd, btnSub, btnMul, btnDiv, btnSqrt;
    private JLabel lblNum1, lblNum2, lblRes;
    private JTextField txtFieldNum1, txtFieldNum2, txtFieldRes;     // Объявление полей класса:
    private JPanel panel1, panel2, panel21, panel22, panel3;        // Различных структурных элементов графического интерфейса из пакета javax.swing
    private JFrame frame;
    private double a, b;                                            // Эти две переменные типа long необходимы нам для того,
                                                                    // чтобы в них поместить значения текстовых полей ввода чисел 1 и 2
    public static void main(String[] args) {
        Solution solution = new Solution();                         // Метод main состоит из создания экземпляра класса Solution,
        solution.createButtons();                                   // а также вызова для этого экземпляра поочередно методов создания
        solution.addButtonListeners();                              // различных структурных элементов программы, а именно:
        solution.createLabels();                                    // кнопок, добавления для этих кнопок Слушателей событий,
        solution.createTextFields();                                // подписей текстовых полей(Число 1, число 2, результат),
        solution.createPanels();                                    // самих текстовых полей, панелей для правильного расположения элементов на фрейме,
        solution.createFrame();                                     // и, непосредственно, самого фрейма
    }

    private void createButtons() {
        btnAdd = new JButton("+");                              // данный метод реализует создание различных кнопок
        btnSub = new JButton("-");                              // за счёт создания новых экземпляров класса
        btnMul = new JButton("*");                              // JButton. Конструктор этого класса позволяет нам
        btnDiv = new JButton("/");                              // сразу обозначить, какой текст будет в каждой кнопке
        btnSqrt = new JButton("Корень квадратный");
    }

    private void addButtonListeners() {
        ButtonListener b1 = new ButtonListener();                    // в этом методе сначала создаётся экземпляр класса ButtonListener,
        btnAdd.addActionListener(b1);                                // который является внутренним классом класса Solution(его реализаиция ниже)
        btnSub.addActionListener(b1);                                // далее каждой кнопке присваивается слушатель событий -
        btnMul.addActionListener(b1);                                // - созданный экземпляр класса ButtonListener
        btnDiv.addActionListener(b1);
        btnSqrt.addActionListener(b1);
    }

    private void createLabels() {
        lblNum1 = new JLabel("Число 1:");                      // метод createLabels создаёт компоненты JLabel
        lblNum2 = new JLabel("Число 2:");                      // которые являются подписями к текстовым полям
        lblRes = new JLabel("Результат:");
    }

    private void createTextFields() {
        txtFieldNum1 = new JTextField(10);                  // этот метод создаёт три текстовых поля и с помощью конструктора
        txtFieldNum2 = new JTextField(10);                  // класса JTextField устанавливает ширину тектового поля в 10 символов
        txtFieldRes = new JTextField(10);
        txtFieldRes.setForeground(Color.RED);                        // в этой строке устанавливаем цвет текста в поле результата красным
        txtFieldRes.setEditable(false);                              // тут делаем поле результата неизменяемым
        }

    private void createPanels() {
        panel1 = new JPanel();                                       // этот метод создаёт 5 панелей, но на фрейме будет только 3 панели - panel1, panel2 и panel3
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));           // для каждой панели мы устанавливаем менеджер размещения FlowLayout - он располагает элементы в строку один за другим

        panel2 = new JPanel();                                       // для panel2 устанавливаем менеджер размещения BorderLayout
        panel2.setLayout(new BorderLayout());                        // для того, чтобы разместить на ней панели panel21 и panel22 друг над другом

        panel21 = new JPanel();                                      // панели panel21 и panel22 необходимы для того, чтобы корректно разместить элементы в panel2
        panel21.setLayout(new FlowLayout());

        panel22 = new JPanel();
        panel22.setLayout(new FlowLayout(FlowLayout.LEFT));

        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());

        panel1.add(lblNum1);                                         // на панель panel1 добавляем компоненты подпись числа 1,
        panel1.add(txtFieldNum1);                                    // текстовое поле числа 1, и кнопку извлечения квадратного корня
        panel1.add(btnSqrt);

        panel21.add(btnAdd);                                         // на панель panel21 добавляем четыре кнопки выполнения математических операция
        panel21.add(btnSub);
        panel21.add(btnMul);
        panel21.add(btnDiv);

        panel22.add(lblNum2);                                        // на панель 2 добавляем подпись текстового поля числа 2
        panel22.add(txtFieldNum2);                                   // и само текстовое поле числа 2

        panel2.add(panel21, BorderLayout.NORTH);                     // на панель panel2 добавляем две панели - panel21 и panel22,
        panel2.add(panel22, BorderLayout.CENTER);                    // и с помошью менеджера размещения располагаем их нужным образом

        panel3.add(lblRes);                                          // на panel3 добавляем подпись тектоовго поля результата
        panel3.add(txtFieldRes);                                     // и само тектовое поле
    }

    private void createFrame() {
        frame = new JFrame("Калькулятор");                      // создаем главное окно программы и устанавливаем заголовок Калькулятор
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);// устанавливаем действием закрытия по умолчанию - закрытие фрейма
        frame.setLayout(new BorderLayout());                         // для фрейма устанавливаем менеджер BorderLayout
        frame.add(panel1, BorderLayout.NORTH);                       // чтобы правильно расположить 3 панели по 3 сторонам -
        frame.add(panel2, BorderLayout.CENTER);                      // north, center и south
        frame.add(panel3, BorderLayout.SOUTH);
        frame.setSize(350, 200);                       // устанавливаем размер окна приложения 350 на 200 пикселов
        frame.setLocationRelativeTo(null);                           // этим методом мы размещаем окно приложения по центру экрана
        frame.setResizable(false);                                   // запрещаем пользователю изменять размеры окна для корректного отображения
        frame.setVisible(true);                                      // и наконец делаем фрейм видимым
    }

    public class ButtonListener implements ActionListener{
        @Override                                                     // данный класс реализует интерфейс ActionListener и нужен для
        public void actionPerformed(ActionEvent e) {                  // создания слушателей событий для кнопок
            if (isDouble(txtFieldNum1.getText())) a = Double.parseDouble(txtFieldNum1.getText());           // проверяем, является ли первое число double, если да, то помещаем в a это число
            if (e.getSource() == btnSqrt) {                                                                 // если нажата кнопка извлечения кв.корня, то в текст.поле результата
                txtFieldRes.setText(String.valueOf(Math.sqrt(a)));                                          // помещаем кв.корень числа a, если нажата другая кнопка,
            } else if (isDouble(txtFieldNum2.getText())) b = Double.parseDouble(txtFieldNum2.getText());    // то также проверяем число 2 и помещаем его в b
            if (e.getSource() == btnAdd) {
                txtFieldRes.setText(String.valueOf(a + b));                                                 // далее просто выполняем операцию в соответствие с нажатой кнопкой
            } else if (e.getSource() == btnSub) {
                txtFieldRes.setText(String.valueOf(a - b));
            } else if (e.getSource() == btnMul) {
                txtFieldRes.setText(String.valueOf(a * b));
            } else if (e.getSource() == btnDiv) {
                txtFieldRes.setText(String.valueOf(a / b));
            }
        }
    }

    private static boolean isDouble(String s) {
        try {                                                        // метод проверки принадлежности числа к double
            Double.parseDouble(s);                                   // если число корректно парсится, то вовзращаем true
        } catch(RuntimeException e) {                                // если возникает ошибка, возвращаем fasle
            return false;
        }
        return true;
    }
}