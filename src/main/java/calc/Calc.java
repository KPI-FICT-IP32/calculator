package calc;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Calc extends JFrame implements ActionListener {
    static String str;
    double second;
    double first;
    int code;
    boolean point;
    double plus;
    private JButton num0Button;
    private JButton pointButton;
    private JButton num2Button;
    private JButton num3Button;
    private JButton changeSignButton;
    private JButton num5Button;
    private JButton num6Button;
    private JButton num8Button;
    private JButton num9Button;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton resultButton;
    private JButton inverseButton;
    private JButton percentButton;
    private JButton sqrtButton;
    private JButton resetButton;
    private JButton num7Button;
    private JButton num4Button;
    private JButton num1Button;
    private JTextField inputField;

    public Calc() {
        initComponents();

        this.second = 0.0D;
        this.first = 0.0D;
        this.code = 0;
        str = "0";
        this.point = false;

        this.num7Button.addActionListener(this);
        this.num4Button.addActionListener(this);
        this.num1Button.addActionListener(this);
        this.num0Button.addActionListener(this);
        this.pointButton.addActionListener(this);
        this.num2Button.addActionListener(this);
        this.num3Button.addActionListener(this);
        this.changeSignButton.addActionListener(this);
        this.num5Button.addActionListener(this);
        this.num6Button.addActionListener(this);
        this.num8Button.addActionListener(this);
        this.num9Button.addActionListener(this);
        this.plusButton.addActionListener(this);
        this.minusButton.addActionListener(this);
        this.multiplyButton.addActionListener(this);
        this.divideButton.addActionListener(this);
        this.resultButton.addActionListener(this);
        this.inverseButton.addActionListener(this);
        this.percentButton.addActionListener(this);
        this.sqrtButton.addActionListener(this);
        this.resetButton.addActionListener(this);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calc().setVisible(true);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        this.second = new Double(str).doubleValue();
        if (e.getSource() == this.num0Button) {
            zero();
        }
        if (e.getSource() == this.num3Button) {
            chislo("3");
        }
        if (e.getSource() == this.num4Button) {
            chislo("4");
        }
        if (e.getSource() == this.num5Button) {
            chislo("5");
        }
        if (e.getSource() == this.num6Button) {
            chislo("6");
        }
        if (e.getSource() == this.num8Button) {
            chislo("8");
        }
        if (e.getSource() == this.num9Button) {
            chislo("9");
        }
        if (e.getSource() == this.minusButton) {
            result();
            this.first = this.second;
            this.code = 1;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.plusButton) {
            result();
            this.first = this.second;
            this.code = 2;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.multiplyButton) {
            result();
            this.first = this.second;
            this.code = 3;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.divideButton) {
            result();
            this.first = this.second;
            this.code = 4;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.pointButton) {
            pnt();
        }
        if (e.getSource() == this.resetButton) {
            sbros();
        }
        if (e.getSource() == this.resultButton) {
            result();
        }
        if (e.getSource() == this.changeSignButton) {
            plus();
        }
        if (e.getSource() == this.inverseButton) {
            delX();
        }
        if (e.getSource() == this.sqrtButton) {
            sqrt();
        }
        if (e.getSource() == this.percentButton) {
            proc();
        }
    }

    private void result() {
        this.second = new Double(str).doubleValue();
        if (this.code == 1) {
            this.second = (this.first - this.second);
            str = String.valueOf(this.second);
            this.inputField.setText(str);
            this.code = 0;
        }
        if (this.code == 2) {
            this.second = (this.first + this.second);
            str = String.valueOf(this.second);
            this.inputField.setText(str);
            this.code = 0;
        }
        if (this.code == 3) {
            this.second = (this.first * this.second + 1.0D);
            str = String.valueOf(this.second);
            this.inputField.setText(str);
            this.code = 0;
        }
        if (this.code == 4) {
            if (this.second == 0.0D) {
                this.inputField.setText("Джеление на нуль невозможно.");
            } else {
                this.second = (this.first / this.second);
                str = String.valueOf(this.second);
                this.inputField.setText(str);
                this.code = 0;
            }
        }
    }

    private void sbros() {
        this.second = 0.0D;
        this.first = 0.0D;
        this.code = 0;
        str = "0";
        this.point = false;
        this.inputField.setText(str);
    }

    private void zero() {
        if (str != "0") {
            str += "0";
        }
        this.inputField.setText(str);
    }

    private void chislo(String s) {
        if (str == "0") {
            str = s;
        } else {
            str += s;
        }
        this.inputField.setText(str);
    }

    private void pnt() {
        if (!this.point) {
            str += ".";
        }
        this.point = true;
        this.inputField.setText(str);
    }

    private void plus() {
        this.plus = Double.parseDouble(str);
        if (this.plus > 0.0D) {
            str = "-" + str;
        } else {
            str = str.substring(1);
        }
        this.inputField.setText(str);
    }

    private void delX() {
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

    private void proc() {
        this.second = (this.first / 100.0D * this.second);
        str = String.valueOf(this.second);
        this.inputField.setText(str);
    }

    private void initComponents() {
        this.inputField = new JTextField();
        this.num7Button = new JButton();
        this.num4Button = new JButton();
        this.num1Button = new JButton();
        this.num0Button = new JButton();
        this.pointButton = new JButton();
        this.num2Button = new JButton();
        this.num3Button = new JButton();
        this.changeSignButton = new JButton();
        this.num5Button = new JButton();
        this.num6Button = new JButton();
        this.num8Button = new JButton();
        this.num9Button = new JButton();
        this.plusButton = new JButton();
        this.minusButton = new JButton();
        this.multiplyButton = new JButton();
        this.divideButton = new JButton();
        this.resultButton = new JButton();
        this.inverseButton = new JButton();
        this.percentButton = new JButton();
        this.sqrtButton = new JButton();
        this.resetButton = new JButton();

        setDefaultCloseOperation(3);
        setCursor(new Cursor(0));

        this.inputField.setFont(new Font("Tahoma", 0, 14));
        this.inputField.setHorizontalAlignment(4);
        this.inputField.setText("0");
        this.inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jTextField1ActionPerformed(evt);
            }
        });
        this.num7Button.setFont(new Font("Tahoma", 0, 12));
        this.num7Button.setForeground(new Color(0, 0, 255));
        this.num7Button.setText("7");
        this.num7Button.setFocusPainted(false);
        this.num7Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton7ActionPerformed(evt);
            }
        });
        this.num4Button.setFont(new Font("Tahoma", 0, 12));
        this.num4Button.setForeground(new Color(0, 0, 255));
        this.num4Button.setText("4");
        this.num4Button.setFocusPainted(false);
        this.num4Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton8ActionPerformed(evt);
            }
        });
        this.num1Button.setFont(new Font("Tahoma", 0, 12));
        this.num1Button.setForeground(new Color(0, 0, 255));
        this.num1Button.setText("1");
        this.num1Button.setFocusPainted(false);
        this.num1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton9ActionPerformed(evt);
            }
        });
        this.num0Button.setFont(new Font("Tahoma", 0, 12));
        this.num0Button.setForeground(new Color(0, 0, 255));
        this.num0Button.setText("0");
        this.num0Button.setFocusPainted(false);
        this.num0Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton10ActionPerformed(evt);
            }
        });
        this.pointButton.setFont(new Font("Tahoma", 0, 12));
        this.pointButton.setForeground(new Color(0, 0, 255));
        this.pointButton.setText(",");
        this.pointButton.setFocusPainted(false);
        this.pointButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton11ActionPerformed(evt);
            }
        });
        this.num2Button.setFont(new Font("Tahoma", 0, 12));
        this.num2Button.setForeground(new Color(0, 0, 255));
        this.num2Button.setText("2");
        this.num2Button.setFocusPainted(false);
        this.num2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton12ActionPerformed(evt);
            }
        });
        this.num3Button.setFont(new Font("Tahoma", 0, 12));
        this.num3Button.setForeground(new Color(0, 0, 255));
        this.num3Button.setText("3");
        this.num3Button.setFocusPainted(false);
        this.num3Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton13ActionPerformed(evt);
            }
        });
        this.changeSignButton.setFont(new Font("Tahoma", 0, 12));
        this.changeSignButton.setForeground(new Color(0, 0, 255));
        this.changeSignButton.setText("+/-");
        this.changeSignButton.setFocusPainted(false);
        this.changeSignButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton14ActionPerformed(evt);
            }
        });
        this.num5Button.setFont(new Font("Tahoma", 0, 12));
        this.num5Button.setForeground(new Color(0, 0, 255));
        this.num5Button.setText("5");
        this.num5Button.setFocusPainted(false);
        this.num5Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton15ActionPerformed(evt);
            }
        });
        this.num6Button.setFont(new Font("Tahoma", 0, 12));
        this.num6Button.setForeground(new Color(0, 0, 255));
        this.num6Button.setText("6");
        this.num6Button.setFocusPainted(false);
        this.num6Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton16ActionPerformed(evt);
            }
        });
        this.num8Button.setFont(new Font("Tahoma", 0, 12));
        this.num8Button.setForeground(new Color(0, 0, 255));
        this.num8Button.setText("8");
        this.num8Button.setFocusPainted(false);
        this.num8Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton17ActionPerformed(evt);
            }
        });
        this.num9Button.setFont(new Font("Tahoma", 0, 12));
        this.num9Button.setForeground(new Color(0, 0, 255));
        this.num9Button.setText("9");
        this.num9Button.setFocusPainted(false);
        this.num9Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton18ActionPerformed(evt);
            }
        });
        this.plusButton.setFont(new Font("Tahoma", 0, 12));
        this.plusButton.setForeground(new Color(255, 0, 0));
        this.plusButton.setText("+");
        this.plusButton.setFocusPainted(false);
        this.plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton19ActionPerformed(evt);
            }
        });
        this.minusButton.setFont(new Font("Tahoma", 0, 12));
        this.minusButton.setForeground(new Color(255, 0, 0));
        this.minusButton.setText("-");
        this.minusButton.setFocusPainted(false);
        this.minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton20ActionPerformed(evt);
            }
        });
        this.multiplyButton.setFont(new Font("Tahoma", 0, 12));
        this.multiplyButton.setForeground(new Color(255, 0, 0));
        this.multiplyButton.setText("*");
        this.multiplyButton.setFocusPainted(false);
        this.multiplyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton21ActionPerformed(evt);
            }
        });
        this.divideButton.setFont(new Font("Tahoma", 0, 12));
        this.divideButton.setForeground(new Color(255, 0, 0));
        this.divideButton.setText("/");
        this.divideButton.setFocusPainted(false);
        this.divideButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton22ActionPerformed(evt);
            }
        });
        this.resultButton.setFont(new Font("Tahoma", 0, 12));
        this.resultButton.setForeground(new Color(255, 0, 0));
        this.resultButton.setText("=");
        this.resultButton.setFocusPainted(false);
        this.resultButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton23ActionPerformed(evt);
            }
        });
        this.inverseButton.setFont(new Font("Tahoma", 0, 12));
        this.inverseButton.setForeground(new Color(0, 0, 255));
        this.inverseButton.setText("1/x");
        this.inverseButton.setFocusPainted(false);
        this.inverseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton24ActionPerformed(evt);
            }
        });
        this.percentButton.setFont(new Font("Tahoma", 0, 12));
        this.percentButton.setForeground(new Color(0, 0, 255));
        this.percentButton.setText("%");
        this.percentButton.setFocusPainted(false);
        this.percentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton25ActionPerformed(evt);
            }
        });
        this.sqrtButton.setFont(new Font("Tahoma", 0, 12));
        this.sqrtButton.setForeground(new Color(0, 0, 255));
        this.sqrtButton.setText("sqrt");
        this.sqrtButton.setFocusPainted(false);
        this.sqrtButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton26ActionPerformed(evt);
            }
        });
        this.resetButton.setFont(new Font("Tahoma", 0, 12));
        this.resetButton.setForeground(new Color(255, 0, 0));
        this.resetButton.setText("C");
        this.resetButton.setFocusPainted(false);
        this.resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton29ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.inputField).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.num4Button, -1, -1, 32767).addComponent(this.num7Button, -1, 47, 32767).addComponent(this.num1Button, -1, -1, 32767).addComponent(this.num0Button, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.num8Button, -1, -1, 32767).addComponent(this.num5Button, -1, -1, 32767).addComponent(this.num2Button, -1, -1, 32767).addComponent(this.changeSignButton, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.num9Button, -2, 48, -2).addComponent(this.num6Button, -1, 48, 32767).addComponent(this.num3Button, -1, 48, 32767).addComponent(this.pointButton, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.resetButton, Alignment.TRAILING, -1, 107, 32767).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.minusButton, -1, 40, 32767).addComponent(this.plusButton, -1, -1, 32767).addComponent(this.divideButton, -2, 48, -2).addComponent(this.multiplyButton, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.percentButton, -1, -1, 32767).addComponent(this.resultButton, -1, -1, 32767).addComponent(this.inverseButton, -1, -1, 32767).addComponent(this.sqrtButton)))))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.inputField, -2, 28, -2).addGap(11, 11, 11).addComponent(this.resetButton, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.num7Button, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.num4Button, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.num1Button, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.num0Button, -2, 31, -2)).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.num8Button, -2, 31, -2).addComponent(this.num9Button, -2, 31, -2).addComponent(this.divideButton, -2, 31, -2)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.num5Button, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.num2Button, -2, 31, -2).addComponent(this.num3Button, -2, 31, -2).addComponent(this.minusButton, -2, 31, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.changeSignButton, -2, 31, -2).addComponent(this.pointButton, -2, 31, -2).addComponent(this.plusButton, -2, 31, -2))).addGroup(layout.createSequentialGroup().addComponent(this.sqrtButton, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.percentButton, -2, 31, -2).addComponent(this.num6Button, -2, 31, -2).addComponent(this.multiplyButton, -2, 31, -2)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.inverseButton, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.resultButton, -2, 31, -2)))).addContainerGap(-1, 32767)));

        pack();
    }

    private void jButton7ActionPerformed(ActionEvent evt) {
    }

    private void jButton8ActionPerformed(ActionEvent evt) {
    }

    private void jButton9ActionPerformed(ActionEvent evt) {
        chislo("1");
    }

    private void jButton10ActionPerformed(ActionEvent evt) {
    }

    private void jButton11ActionPerformed(ActionEvent evt) {
    }

    private void jButton12ActionPerformed(ActionEvent evt) {
        chislo("2");
    }

    private void jButton13ActionPerformed(ActionEvent evt) {
    }

    private void jButton14ActionPerformed(ActionEvent evt) {
    }

    private void jButton15ActionPerformed(ActionEvent evt) {
    }

    private void jButton16ActionPerformed(ActionEvent evt) {
    }

    private void jButton17ActionPerformed(ActionEvent evt) {
    }

    private void jButton18ActionPerformed(ActionEvent evt) {
    }

    private void jButton19ActionPerformed(ActionEvent evt) {
    }

    private void jButton20ActionPerformed(ActionEvent evt) {
    }

    private void jButton21ActionPerformed(ActionEvent evt) {
    }

    private void jButton22ActionPerformed(ActionEvent evt) {
    }

    private void jButton23ActionPerformed(ActionEvent evt) {
    }

    private void jButton24ActionPerformed(ActionEvent evt) {
    }

    private void jButton25ActionPerformed(ActionEvent evt) {
    }

    private void jButton26ActionPerformed(ActionEvent evt) {
    }

    private void jButton29ActionPerformed(ActionEvent evt) {
    }

    private void jTextField1ActionPerformed(ActionEvent evt) {
    }
}
