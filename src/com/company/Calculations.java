package com.company;

import javax.swing.*;
import java.util.Stack;

import static com.company.Validations.isAbleToQuickCalculate;


public class Calculations {
    static double subtract(double subtrahent,double minuend) {
        return minuend- subtrahent;
    }

    static double add(double factor1, double factor2) {
        return factor1 + factor2;
    }

    public static double divide(double denominator, double nominator) {

        if(denominator==0) throw new ArithmeticException();

        return nominator / denominator;

    }

    static double multiply(double factor1, double factor2) {
        return factor1 * factor2;
    }

    static double power(double index, double base) {
        return Math.pow(base, index);
    }

    public static void sqrt(JTextArea textArea1) throws ArithmeticException{
        try {

            if(isAbleToQuickCalculate(textArea1))
                calculate(textArea1);


            if (isAbleToQuickCalculate(textArea1,"sqrt")) {



                if (!textArea1.getText().startsWith("-")) {
                    StringBuilder temp = new StringBuilder(textArea1.getText());
                    double tempDouble = Math.pow(Double.parseDouble(temp.toString()), 1.0 / 2.0);
                    textArea1.setText(String.valueOf(tempDouble));
                } else throw new ArithmeticException();
           }
        } catch (ArithmeticException ex) {
            textArea1.setText("Forbidden action");
        }

    }

    static void calculate(JTextArea textArea1) { // zbyt rozbudowana funkcja, bo w zamyśle chciałem zrobic troche inny kalkulator

        if(textArea1.getText().contains("E"))
        {
            textArea1.setText("Too long number for now");
            return;
        }


        Stack actionStack = new Stack<>();
        int i = 0;
        StringBuilder neededToResolve = new StringBuilder(textArea1.getText());
        StringBuilder extract;// = new StringBuilder();
        char znak = ' ';



        while (i < neededToResolve.length()) {
            extract = new StringBuilder();



            innerloop:
            while ((((int) neededToResolve.charAt(i) >= '0') && ((int) neededToResolve.charAt(i) <= '9')) || neededToResolve.charAt(i) == '.') {

                extract.append(neededToResolve.charAt(i));
                i++;

                if (i == neededToResolve.length()) break innerloop;

            }

            if (extract.length() != 0)
            actionStack.push(extract);


            System.out.println(actionStack);

            try {
                switch (znak) {
                    case '+':
                        actionStack.push(Calculations.add(Double.parseDouble(actionStack.pop().toString()), Double.parseDouble(actionStack.pop().toString())));
                        break;
                    case '-':
                        actionStack.push(Calculations.subtract(Double.parseDouble(actionStack.pop().toString()), Double.parseDouble((actionStack.pop().toString()))));
                        break;
                    case '*':
                        actionStack.push(Calculations.multiply(Double.parseDouble(actionStack.pop().toString()), Double.parseDouble((actionStack.pop().toString()))));
                        break;
                    case '/':
                        actionStack.push(Calculations.divide(Double.parseDouble(actionStack.pop().toString()), Double.parseDouble((actionStack.pop().toString()))));
                        break;
                    case '^':
                        actionStack.push(power(Double.parseDouble(actionStack.pop().toString()), Double.parseDouble(actionStack.pop().toString())));
                        break;

                }



                if (i != neededToResolve.length() && i != 0) {
                    System.out.println(neededToResolve.charAt(i));
                    znak = neededToResolve.charAt(i);

                } else if (i == 0) {
                    actionStack.push("-1");
                    znak = '*';
                }


                i++;


            } catch (NumberFormatException e) {

                textArea1.setText("Forbidden action");
                return;
            } catch (ArithmeticException e) {

                textArea1.setText(("Forbidden action"));
                return;

            }


        }


        textArea1.setText(actionStack.pop().toString());


    }


}
