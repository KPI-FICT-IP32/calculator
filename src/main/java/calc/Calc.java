package calc;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import static javax.swing.SwingConstants.*;

public class Calc extends JFrame {

    private static String str;
    private double second;
    private double first;
    private Operation operation;
    private boolean point;


    private JButton num0Button;
    private JButton num1Button;
    private JButton num2Button;
    private JButton num3Button;
    private JButton num4Button;
    private JButton num5Button;
    private JButton num6Button;
    private JButton num7Button;
    private JButton num8Button;
    private JButton num9Button;

    private JButton pointButton;
    private JButton changeSignButton;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton resultButton;
    private JButton inverseButton;
    private JButton percentButton;
    private JButton sqrtButton;
    private JButton resetButton;
    private JTextField inputField;

    public Calc() {
        initComponents();

        this.second = 0.0D;
        this.first = 0.0D;
        this.operation = Operation.NOOP;
        str = "0";
        this.point = false;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new Calc().setVisible(true));
    }

    private void result() {
        this.second = Double.parseDouble(str);
        switch (this.operation) {
            case SUBTRACTION:
                this.second = this.first - this.second;
                str = String.valueOf(this.second);
                this.inputField.setText(str);
                this.operation = Operation.NOOP;
                break;
            case ADDITION:
                this.second = this.first + this.second;
                str = String.valueOf(this.second);
                this.inputField.setText(str);
                this.operation = Operation.NOOP;
                break;
            case MULTIPLICATION:
                this.second = this.first * this.second;
                str = String.valueOf(this.second);
                this.inputField.setText(str);
                this.operation = Operation.NOOP;
                break;
            case DIVISION:
                if (this.second == 0.0D) {
                    this.inputField.setText("Джеление на нуль невозможно.");
                } else {
                    this.second = (this.first / this.second);
                    str = String.valueOf(this.second);
                    this.inputField.setText(str);
                    this.operation = Operation.NOOP;
                }
                break;
            default:
                // Do nothing
        }
    }

    private void reset() {
        this.second = 0.0D;
        this.first = 0.0D;
        this.operation = Operation.NOOP;
        str = "0";
        this.point = false;
        this.inputField.setText(str);
    }

    private void zero() {
        if (!"0".equals(str)) {
            str += "0";
        }
        this.inputField.setText(str);
    }

    private void chislo(String s) {
        if ("0".equals(str)) {
            str = s;
        } else {
            str += s;
        }
        this.inputField.setText(str);
    }

    private void decimalPoint() {
        if (!this.point) {
            str += ".";
        }
        this.point = true;
        this.inputField.setText(str);
    }

    private void changeSign() {
        double plus = Double.parseDouble(str);
        if (plus > 0.0D) {
            str = "-" + str;
        } else {
            str = str.substring(1);
        }
        this.inputField.setText(str);
    }

    private void divideByX() {
        if (this.second == 0.0D) {
            this.inputField.setText("Джеление на нуль невозможно.");
        } else {
            this.second = (1.0D / this.second);
            str = String.valueOf(this.second);
            this.inputField.setText(str);
        }
    }

    private void sqrt() {
        if (this.second < 0.0D) {
            this.inputField.setText("Недапустимый аргумент функции.");
        } else {
            this.second = Math.sqrt(this.second);
            str = String.valueOf(this.second);
            this.inputField.setText(str);
        }
    }

    private void percents() {
        this.second = (this.first / 100.0D * this.second);
        str = String.valueOf(this.second);
        this.inputField.setText(str);
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setCursor(Cursor.getDefaultCursor());
        initInputField();
        initButtons();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(
                layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(
                    layout.createParallelGroup(Alignment.TRAILING, false)
                    .addComponent(this.inputField)
                    .addGroup(
                        layout.createSequentialGroup()
                        .addGroup(
                            layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(this.num4Button, -1, -1, 32767)
                            .addComponent(this.num7Button, -1, 47, 32767)
                            .addComponent(this.num1Button, -1, -1, 32767)
                            .addComponent(this.num0Button, -1, -1, 32767)
                        )
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(
                            layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(this.num8Button, -1, -1, 32767)
                            .addComponent(this.num5Button, -1, -1, 32767)
                            .addComponent(this.num2Button, -1, -1, 32767)
                            .addComponent(this.changeSignButton, -1, -1, 32767)
                        )
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(
                            layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(this.num9Button, -2, 48, -2)
                            .addComponent(this.num6Button, -1, 48, 32767)
                            .addComponent(this.num3Button, -1, 48, 32767)
                            .addComponent(this.pointButton, -1, -1, 32767)
                        )
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addGroup(
                            layout.createParallelGroup(Alignment.LEADING)
                            .addComponent(this.resetButton, Alignment.TRAILING, -1, 107, 32767)
                            .addGroup(
                                Alignment.TRAILING,
                                layout.createSequentialGroup().addGroup(
                                    layout.createParallelGroup(Alignment.LEADING)
                                    .addComponent(this.minusButton, -1, 40, 32767)
                                    .addComponent(this.plusButton, -1, -1, 32767)
                                    .addComponent(this.divideButton, -2, 48, -2)
                                    .addComponent(this.multiplyButton, -1, -1, 32767)
                                )
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addGroup(
                                    layout.createParallelGroup(Alignment.LEADING, false)
                                    .addComponent(this.percentButton, -1, -1, 32767)
                                    .addComponent(this.resultButton, -1, -1, 32767)
                                    .addComponent(this.inverseButton, -1, -1, 32767)
                                    .addComponent(this.sqrtButton)
                                )
                            )
                        )
                    )
                )
                .addContainerGap(-1, 32767)
            )
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(
                layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(this.inputField, -2, 28, -2)
                .addGap(11, 11, 11)
                .addComponent(this.resetButton, -2, 31, -2)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(
                    layout.createParallelGroup(Alignment.TRAILING)
                    .addGroup(
                        layout.createSequentialGroup()
                        .addComponent(this.num7Button, -2, 31, -2)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(this.num4Button, -2, 31, -2)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(this.num1Button, -2, 31, -2)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(this.num0Button, -2, 31, -2)
                    )
                    .addGroup(
                        layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(
                            layout.createSequentialGroup()
                            .addGroup(
                                layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(this.num8Button, -2, 31, -2)
                                .addComponent(this.num9Button, -2, 31, -2)
                                .addComponent(this.divideButton, -2, 31, -2)
                            )
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(this.num5Button, -2, 31, -2)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(
                                layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(this.num2Button, -2, 31, -2)
                                .addComponent(this.num3Button, -2, 31, -2)
                                .addComponent(this.minusButton, -2, 31, -2)
                            )
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(
                                layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(this.changeSignButton, -2, 31, -2)
                                .addComponent(this.pointButton, -2, 31, -2)
                                .addComponent(this.plusButton, -2, 31, -2)
                            )
                        )
                        .addGroup(
                            layout.createSequentialGroup()
                            .addComponent(this.sqrtButton, -2, 31, -2)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addGroup(
                                layout.createParallelGroup(Alignment.BASELINE)
                                .addComponent(this.percentButton, -2, 31, -2)
                                .addComponent(this.num6Button, -2, 31, -2)
                                .addComponent(this.multiplyButton, -2, 31, -2)
                            )
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(this.inverseButton, -2, 31, -2)
                            .addPreferredGap(ComponentPlacement.RELATED)
                            .addComponent(this.resultButton, -2, 31, -2)
                        )
                    )
                )
                .addContainerGap(-1, 32767)
            )
        );

        pack();
    }

    private void initButtons() {
        Font buttonFont = new Font("Tahoma", Font.PLAIN, 12);
        this.num1Button = new JButton();
        this.num1Button.setFont(buttonFont);
        this.num1Button.setForeground(Color.BLUE);
        this.num1Button.setText("1");
        this.num1Button.setFocusPainted(false);
        this.num1Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("1");
        });

        this.num2Button = new JButton();
        this.num2Button.setFont(buttonFont);
        this.num2Button.setForeground(Color.BLUE);
        this.num2Button.setText("2");
        this.num2Button.setFocusPainted(false);
        this.num2Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("2");
        });

        this.num3Button = new JButton();
        this.num3Button.setFont(buttonFont);
        this.num3Button.setForeground(Color.BLUE);
        this.num3Button.setText("3");
        this.num3Button.setFocusPainted(false);
        this.num3Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("3");
        });

        this.num4Button = new JButton();
        this.num4Button.setFont(buttonFont);
        this.num4Button.setForeground(Color.BLUE);
        this.num4Button.setText("4");
        this.num4Button.setFocusPainted(false);
        this.num4Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("4");
        });

        this.num5Button = new JButton();
        this.num5Button.setFont(buttonFont);
        this.num5Button.setForeground(Color.BLUE);
        this.num5Button.setText("5");
        this.num5Button.setFocusPainted(false);
        this.num5Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("5");
        });

        this.num6Button = new JButton();
        this.num6Button.setFont(buttonFont);
        this.num6Button.setForeground(Color.BLUE);
        this.num6Button.setText("6");
        this.num6Button.setFocusPainted(false);
        this.num6Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("6");
        });

        this.num7Button = new JButton();
        this.num7Button.setFont(buttonFont);
        this.num7Button.setForeground(Color.BLUE);
        this.num7Button.setText("7");
        this.num7Button.setFocusPainted(false);
        this.num7Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("7");
        });

        this.num8Button = new JButton();
        this.num8Button.setFont(buttonFont);
        this.num8Button.setForeground(Color.BLUE);
        this.num8Button.setText("8");
        this.num8Button.setFocusPainted(false);
        this.num8Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("8");
        });

        this.num9Button = new JButton();
        this.num9Button.setFont(buttonFont);
        this.num9Button.setForeground(Color.BLUE);
        this.num9Button.setText("9");
        this.num9Button.setFocusPainted(false);
        this.num9Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            chislo("9");
        });

        this.num0Button = new JButton();
        this.num0Button.setFont(buttonFont);
        this.num0Button.setForeground(Color.BLUE);
        this.num0Button.setText("0");
        this.num0Button.setFocusPainted(false);
        this.num0Button.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            zero();
        });

        this.pointButton = new JButton();
        this.pointButton.setFont(buttonFont);
        this.pointButton.setForeground(Color.BLUE);
        this.pointButton.setText(",");
        this.pointButton.setFocusPainted(false);
        this.pointButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            decimalPoint();
        });

        this.changeSignButton = new JButton();
        this.changeSignButton.setFont(buttonFont);
        this.changeSignButton.setForeground(Color.BLUE);
        this.changeSignButton.setText("+/-");
        this.changeSignButton.setFocusPainted(false);
        this.changeSignButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            changeSign();
        });

        this.plusButton = new JButton();
        this.plusButton.setFont(buttonFont);
        this.plusButton.setForeground(Color.RED);
        this.plusButton.setText("+");
        this.plusButton.setFocusPainted(false);
        this.plusButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            result();
            this.first = this.second;
            this.operation = Operation.ADDITION;
            str = "0";
            this.point = false;
        });

        this.minusButton = new JButton();
        this.minusButton.setFont(buttonFont);
        this.minusButton.setForeground(Color.RED);
        this.minusButton.setText("-");
        this.minusButton.setFocusPainted(false);
        this.minusButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            result();
            this.first = this.second;
            this.operation = Operation.SUBTRACTION;
            str = "0";
            this.point = false;
        });

        this.multiplyButton = new JButton();
        this.multiplyButton.setFont(buttonFont);
        this.multiplyButton.setForeground(Color.RED);
        this.multiplyButton.setText("*");
        this.multiplyButton.setFocusPainted(false);
        this.multiplyButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            result();
            this.first = this.second;
            this.operation = Operation.MULTIPLICATION;
            str = "0";
            this.point = false;
        });

        this.divideButton = new JButton();
        this.divideButton.setFont(buttonFont);
        this.divideButton.setForeground(Color.RED);
        this.divideButton.setText("/");
        this.divideButton.setFocusPainted(false);
        this.divideButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            result();
            this.first = this.second;
            this.operation = Operation.DIVISION;
            str = "0";
            this.point = false;
        });

        this.resultButton = new JButton();
        this.resultButton.setFont(buttonFont);
        this.resultButton.setForeground(Color.RED);
        this.resultButton.setText("=");
        this.resultButton.setFocusPainted(false);
        this.resultButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            result();
        });

        this.inverseButton = new JButton();
        this.inverseButton.setFont(buttonFont);
        this.inverseButton.setForeground(Color.BLUE);
        this.inverseButton.setText("1/x");
        this.inverseButton.setFocusPainted(false);
        this.inverseButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            divideByX();
        });

        this.percentButton = new JButton();
        this.percentButton.setFont(buttonFont);
        this.percentButton.setForeground(Color.BLUE);
        this.percentButton.setText("%");
        this.percentButton.setFocusPainted(false);
        this.percentButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            percents();
        });

        this.sqrtButton = new JButton();
        this.sqrtButton.setFont(buttonFont);
        this.sqrtButton.setForeground(Color.BLUE);
        this.sqrtButton.setText("sqrt");
        this.sqrtButton.setFocusPainted(false);
        this.sqrtButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            sqrt();
        });

        this.resetButton = new JButton();
        this.resetButton.setFont(buttonFont);
        this.resetButton.setForeground(Color.RED);
        this.resetButton.setText("C");
        this.resetButton.setFocusPainted(false);
        this.resetButton.addActionListener(e -> {
            this.second = Double.parseDouble(str);
            reset();
        });
    }

    private void initInputField() {
        this.inputField = new JTextField();
        Font inputFont = new Font("Tahoma", Font.PLAIN, 14);
        this.inputField.setFont(inputFont);
        this.inputField.setHorizontalAlignment(RIGHT);
        this.inputField.setText("0");
    }

    static enum Operation {
        NOOP,
        ADDITION, SUBTRACTION,
        MULTIPLICATION, DIVISION,
    }
}
