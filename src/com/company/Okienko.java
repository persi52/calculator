package com.company;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;

import static com.company.Calculations.*;
import static com.company.Validations.isAbleToQuickCalculate;

public class Okienko {

    private JTextArea textArea1;

    public JTextArea getTextArea1() {
        return textArea1;
    }

    private JButton[] numericButton;
    private JButton a0Button;
    private JButton a1Button;
    private JButton a2Button;
    private JButton a3Button;
    private JButton a4Button;
    private JButton a5Button;
    private JButton a6Button;
    private JButton a7Button;
    private JButton a8Button;
    private JButton a9Button;
    private JButton add;
    private JButton multiply;
    private JButton divide;
    private JButton coma;
    private JButton SignChange;
    private JButton subtract;
    private JButton equals;
    private JPanel Panel;
    private JButton clear;
    private JButton delete;
    private JButton sqrt;
    private JButton pow;

    public JPanel getPanel() {
        return this.Panel;
    }


    public Okienko() {
        initializeListeners();
    }

    void WriteActions(char input) {

        if(!Validations.isAbleToBeWritten(textArea1,input))
        {
                return;
        }
        else{

            if (!textArea1.getText().contains("o"))
                textArea1.append(String.valueOf(input));
            else textArea1.setText(String.valueOf(input));
        }

    }

    void initializeListeners() {

        pow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(isAbleToQuickCalculate(textArea1))
                {
                    calculate(textArea1);
                }
                WriteActions('^');
            }
        });

        sqrt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
               sqrt(textArea1);


            }
        });

        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (!textArea1.getText().isEmpty() && !textArea1.getText().contains("o"))
                {
                    StringBuilder field = new StringBuilder(textArea1.getText());
                    textArea1.setText(field.deleteCharAt(field.length() - 1).toString());
                }


            }
        });

        a0Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('0');
            }
        });
        a1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('1');
            }
        });
        a2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('2');
            }
        });
        a3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('3');
            }
        });
        a4Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('4');
            }
        });
        a5Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('5');
            }
        });
        a6Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('6');
            }
        });
        a7Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('7');
            }
        });
        a8Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('8');
            }
        });
        a9Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                WriteActions('9');
            }
        });

        coma.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                 WriteActions('.');
            }
        });
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(isAbleToQuickCalculate(textArea1))
                {
                    calculate(textArea1);
                }
                WriteActions('+');

            }
        });
        divide.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(isAbleToQuickCalculate(textArea1))
                {
                    calculate(textArea1);
                }
                WriteActions('/');
            }
        });
        subtract.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(isAbleToQuickCalculate(textArea1))
                {
                    calculate(textArea1);
                }
                WriteActions('-');
            }
        });
        multiply.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(isAbleToQuickCalculate(textArea1))
                {
                    calculate(textArea1);
                }
                WriteActions('*');
            }
        });
        clear.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                textArea1.setText("");
            }
        });
        SignChange.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            if(!textArea1.getText().isEmpty() && !textArea1.getText().contains("o")) {
                StringBuilder textToChange = new StringBuilder(textArea1.getText());

                if (textToChange.charAt(0) != '-')
                    textArea1.setText("-" + textArea1.getText());
                else {
                    textToChange.deleteCharAt(0);
                    textArea1.setText(textToChange.toString());
                }
            }
          }
        });
        equals.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(isAbleToQuickCalculate(textArea1))//!textArea1.getText().isEmpty() && !textArea1.getText().equals("Forbidden action"))
                calculate(textArea1);
            }
        });
    }




}

