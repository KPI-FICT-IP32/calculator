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
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton13;
    private JButton jButton14;
    private JButton jButton15;
    private JButton jButton16;
    private JButton jButton17;
    private JButton jButton18;
    private JButton jButton19;
    private JButton jButton20;
    private JButton jButton21;
    private JButton jButton22;
    private JButton jButton23;
    private JButton jButton24;
    private JButton jButton25;
    private JButton jButton26;
    private JButton jButton29;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JTextField jTextField1;

    public Calc() {
        initComponents();

        this.second = 0.0D;
        this.first = 0.0D;
        this.code = 0;
        str = "0";
        this.point = false;

        this.jButton7.addActionListener(this);
        this.jButton8.addActionListener(this);
        this.jButton9.addActionListener(this);
        this.jButton10.addActionListener(this);
        this.jButton11.addActionListener(this);
        this.jButton12.addActionListener(this);
        this.jButton13.addActionListener(this);
        this.jButton14.addActionListener(this);
        this.jButton15.addActionListener(this);
        this.jButton16.addActionListener(this);
        this.jButton17.addActionListener(this);
        this.jButton18.addActionListener(this);
        this.jButton19.addActionListener(this);
        this.jButton20.addActionListener(this);
        this.jButton21.addActionListener(this);
        this.jButton22.addActionListener(this);
        this.jButton23.addActionListener(this);
        this.jButton24.addActionListener(this);
        this.jButton25.addActionListener(this);
        this.jButton26.addActionListener(this);
        this.jButton29.addActionListener(this);
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
        if (e.getSource() == this.jButton10) {
            zero();
        }
        if (e.getSource() == this.jButton13) {
            chislo("3");
        }
        if (e.getSource() == this.jButton8) {
            chislo("4");
        }
        if (e.getSource() == this.jButton15) {
            chislo("5");
        }
        if (e.getSource() == this.jButton16) {
            chislo("6");
        }
        if (e.getSource() == this.jButton17) {
            chislo("8");
        }
        if (e.getSource() == this.jButton18) {
            chislo("9");
        }
        if (e.getSource() == this.jButton20) {
            result();
            this.first = this.second;
            this.code = 1;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.jButton19) {
            result();
            this.first = this.second;
            this.code = 2;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.jButton21) {
            result();
            this.first = this.second;
            this.code = 3;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.jButton22) {
            result();
            this.first = this.second;
            this.code = 4;
            str = "0";
            this.point = false;
        }
        if (e.getSource() == this.jButton11) {
            pnt();
        }
        if (e.getSource() == this.jButton29) {
            sbros();
        }
        if (e.getSource() == this.jButton23) {
            result();
        }
        if (e.getSource() == this.jButton14) {
            plus();
        }
        if (e.getSource() == this.jButton24) {
            delX();
        }
        if (e.getSource() == this.jButton26) {
            sqrt();
        }
        if (e.getSource() == this.jButton25) {
            proc();
        }
    }

    private void result() {
        this.second = new Double(str).doubleValue();
        if (this.code == 1) {
            this.second = (this.first - this.second);
            str = String.valueOf(this.second);
            this.jTextField1.setText(str);
            this.code = 0;
        }
        if (this.code == 2) {
            this.second = (this.first + this.second);
            str = String.valueOf(this.second);
            this.jTextField1.setText(str);
            this.code = 0;
        }
        if (this.code == 3) {
            this.second = (this.first * this.second + 1.0D);
            str = String.valueOf(this.second);
            this.jTextField1.setText(str);
            this.code = 0;
        }
        if (this.code == 4) {
            if (this.second == 0.0D) {
                this.jTextField1.setText("Джеление на нуль невозможно.");
            } else {
                this.second = (this.first / this.second);
                str = String.valueOf(this.second);
                this.jTextField1.setText(str);
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
        this.jTextField1.setText(str);
    }

    private void zero() {
        if (str != "0") {
            str += "0";
        }
        this.jTextField1.setText(str);
    }

    private void chislo(String s) {
        if (str == "0") {
            str = s;
        } else {
            str += s;
        }
        this.jTextField1.setText(str);
    }

    private void pnt() {
        if (!this.point) {
            str += ".";
        }
        this.point = true;
        this.jTextField1.setText(str);
    }

    private void plus() {
        this.plus = Double.parseDouble(str);
        if (this.plus > 0.0D) {
            str = "-" + str;
        } else {
            str = str.substring(1);
        }
        this.jTextField1.setText(str);
    }

    private void delX() {
        if (this.second == 0.0D) {
            this.jTextField1.setText("Джеление на нуль невозможно.");
        } else {
            this.second = (1.0D / this.second);
            str = String.valueOf(this.second);
            this.jTextField1.setText(str);
        }
    }

    private void sqrt() {
        if (this.second < 0.0D) {
            this.jTextField1.setText("Недапустимый аргумент функции.");
        } else {
            this.second = Math.sqrt(this.second);
            str = String.valueOf(this.second);
            this.jTextField1.setText(str);
        }
    }

    private void proc() {
        this.second = (this.first / 100.0D * this.second);
        str = String.valueOf(this.second);
        this.jTextField1.setText(str);
    }

    private void initComponents() {
        this.jTextField1 = new JTextField();
        this.jButton7 = new JButton();
        this.jButton8 = new JButton();
        this.jButton9 = new JButton();
        this.jButton10 = new JButton();
        this.jButton11 = new JButton();
        this.jButton12 = new JButton();
        this.jButton13 = new JButton();
        this.jButton14 = new JButton();
        this.jButton15 = new JButton();
        this.jButton16 = new JButton();
        this.jButton17 = new JButton();
        this.jButton18 = new JButton();
        this.jButton19 = new JButton();
        this.jButton20 = new JButton();
        this.jButton21 = new JButton();
        this.jButton22 = new JButton();
        this.jButton23 = new JButton();
        this.jButton24 = new JButton();
        this.jButton25 = new JButton();
        this.jButton26 = new JButton();
        this.jButton29 = new JButton();

        setDefaultCloseOperation(3);
        setCursor(new Cursor(0));

        this.jTextField1.setFont(new Font("Tahoma", 0, 14));
        this.jTextField1.setHorizontalAlignment(4);
        this.jTextField1.setText("0");
        this.jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jTextField1ActionPerformed(evt);
            }
        });
        this.jButton7.setFont(new Font("Tahoma", 0, 12));
        this.jButton7.setForeground(new Color(0, 0, 255));
        this.jButton7.setText("7");
        this.jButton7.setFocusPainted(false);
        this.jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton7ActionPerformed(evt);
            }
        });
        this.jButton8.setFont(new Font("Tahoma", 0, 12));
        this.jButton8.setForeground(new Color(0, 0, 255));
        this.jButton8.setText("4");
        this.jButton8.setFocusPainted(false);
        this.jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton8ActionPerformed(evt);
            }
        });
        this.jButton9.setFont(new Font("Tahoma", 0, 12));
        this.jButton9.setForeground(new Color(0, 0, 255));
        this.jButton9.setText("1");
        this.jButton9.setFocusPainted(false);
        this.jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton9ActionPerformed(evt);
            }
        });
        this.jButton10.setFont(new Font("Tahoma", 0, 12));
        this.jButton10.setForeground(new Color(0, 0, 255));
        this.jButton10.setText("0");
        this.jButton10.setFocusPainted(false);
        this.jButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton10ActionPerformed(evt);
            }
        });
        this.jButton11.setFont(new Font("Tahoma", 0, 12));
        this.jButton11.setForeground(new Color(0, 0, 255));
        this.jButton11.setText(",");
        this.jButton11.setFocusPainted(false);
        this.jButton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton11ActionPerformed(evt);
            }
        });
        this.jButton12.setFont(new Font("Tahoma", 0, 12));
        this.jButton12.setForeground(new Color(0, 0, 255));
        this.jButton12.setText("2");
        this.jButton12.setFocusPainted(false);
        this.jButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton12ActionPerformed(evt);
            }
        });
        this.jButton13.setFont(new Font("Tahoma", 0, 12));
        this.jButton13.setForeground(new Color(0, 0, 255));
        this.jButton13.setText("3");
        this.jButton13.setFocusPainted(false);
        this.jButton13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton13ActionPerformed(evt);
            }
        });
        this.jButton14.setFont(new Font("Tahoma", 0, 12));
        this.jButton14.setForeground(new Color(0, 0, 255));
        this.jButton14.setText("+/-");
        this.jButton14.setFocusPainted(false);
        this.jButton14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton14ActionPerformed(evt);
            }
        });
        this.jButton15.setFont(new Font("Tahoma", 0, 12));
        this.jButton15.setForeground(new Color(0, 0, 255));
        this.jButton15.setText("5");
        this.jButton15.setFocusPainted(false);
        this.jButton15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton15ActionPerformed(evt);
            }
        });
        this.jButton16.setFont(new Font("Tahoma", 0, 12));
        this.jButton16.setForeground(new Color(0, 0, 255));
        this.jButton16.setText("6");
        this.jButton16.setFocusPainted(false);
        this.jButton16.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton16ActionPerformed(evt);
            }
        });
        this.jButton17.setFont(new Font("Tahoma", 0, 12));
        this.jButton17.setForeground(new Color(0, 0, 255));
        this.jButton17.setText("8");
        this.jButton17.setFocusPainted(false);
        this.jButton17.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton17ActionPerformed(evt);
            }
        });
        this.jButton18.setFont(new Font("Tahoma", 0, 12));
        this.jButton18.setForeground(new Color(0, 0, 255));
        this.jButton18.setText("9");
        this.jButton18.setFocusPainted(false);
        this.jButton18.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton18ActionPerformed(evt);
            }
        });
        this.jButton19.setFont(new Font("Tahoma", 0, 12));
        this.jButton19.setForeground(new Color(255, 0, 0));
        this.jButton19.setText("+");
        this.jButton19.setFocusPainted(false);
        this.jButton19.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton19ActionPerformed(evt);
            }
        });
        this.jButton20.setFont(new Font("Tahoma", 0, 12));
        this.jButton20.setForeground(new Color(255, 0, 0));
        this.jButton20.setText("-");
        this.jButton20.setFocusPainted(false);
        this.jButton20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton20ActionPerformed(evt);
            }
        });
        this.jButton21.setFont(new Font("Tahoma", 0, 12));
        this.jButton21.setForeground(new Color(255, 0, 0));
        this.jButton21.setText("*");
        this.jButton21.setFocusPainted(false);
        this.jButton21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton21ActionPerformed(evt);
            }
        });
        this.jButton22.setFont(new Font("Tahoma", 0, 12));
        this.jButton22.setForeground(new Color(255, 0, 0));
        this.jButton22.setText("/");
        this.jButton22.setFocusPainted(false);
        this.jButton22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton22ActionPerformed(evt);
            }
        });
        this.jButton23.setFont(new Font("Tahoma", 0, 12));
        this.jButton23.setForeground(new Color(255, 0, 0));
        this.jButton23.setText("=");
        this.jButton23.setFocusPainted(false);
        this.jButton23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton23ActionPerformed(evt);
            }
        });
        this.jButton24.setFont(new Font("Tahoma", 0, 12));
        this.jButton24.setForeground(new Color(0, 0, 255));
        this.jButton24.setText("1/x");
        this.jButton24.setFocusPainted(false);
        this.jButton24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton24ActionPerformed(evt);
            }
        });
        this.jButton25.setFont(new Font("Tahoma", 0, 12));
        this.jButton25.setForeground(new Color(0, 0, 255));
        this.jButton25.setText("%");
        this.jButton25.setFocusPainted(false);
        this.jButton25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton25ActionPerformed(evt);
            }
        });
        this.jButton26.setFont(new Font("Tahoma", 0, 12));
        this.jButton26.setForeground(new Color(0, 0, 255));
        this.jButton26.setText("sqrt");
        this.jButton26.setFocusPainted(false);
        this.jButton26.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton26ActionPerformed(evt);
            }
        });
        this.jButton29.setFont(new Font("Tahoma", 0, 12));
        this.jButton29.setForeground(new Color(255, 0, 0));
        this.jButton29.setText("C");
        this.jButton29.setFocusPainted(false);
        this.jButton29.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Calc.this.jButton29ActionPerformed(evt);
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.TRAILING, false).addComponent(this.jTextField1).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton8, -1, -1, 32767).addComponent(this.jButton7, -1, 47, 32767).addComponent(this.jButton9, -1, -1, 32767).addComponent(this.jButton10, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton17, -1, -1, 32767).addComponent(this.jButton15, -1, -1, 32767).addComponent(this.jButton12, -1, -1, 32767).addComponent(this.jButton14, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton18, -2, 48, -2).addComponent(this.jButton16, -1, 48, 32767).addComponent(this.jButton13, -1, 48, 32767).addComponent(this.jButton11, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton29, Alignment.TRAILING, -1, 107, 32767).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton20, -1, 40, 32767).addComponent(this.jButton19, -1, -1, 32767).addComponent(this.jButton22, -2, 48, -2).addComponent(this.jButton21, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.jButton25, -1, -1, 32767).addComponent(this.jButton23, -1, -1, 32767).addComponent(this.jButton24, -1, -1, 32767).addComponent(this.jButton26)))))).addContainerGap(-1, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jTextField1, -2, 28, -2).addGap(11, 11, 11).addComponent(this.jButton29, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.jButton7, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton8, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton9, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton10, -2, 31, -2)).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton17, -2, 31, -2).addComponent(this.jButton18, -2, 31, -2).addComponent(this.jButton22, -2, 31, -2)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton15, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton12, -2, 31, -2).addComponent(this.jButton13, -2, 31, -2).addComponent(this.jButton20, -2, 31, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton14, -2, 31, -2).addComponent(this.jButton11, -2, 31, -2).addComponent(this.jButton19, -2, 31, -2))).addGroup(layout.createSequentialGroup().addComponent(this.jButton26, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton25, -2, 31, -2).addComponent(this.jButton16, -2, 31, -2).addComponent(this.jButton21, -2, 31, -2)).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton24, -2, 31, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jButton23, -2, 31, -2)))).addContainerGap(-1, 32767)));

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
