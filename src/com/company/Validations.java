package com.company;

import javax.swing.*;

public class Validations {


    public static boolean isAbleToQuickCalculate(JTextArea textArea1,String... mode){



            if (textArea1.getText().contains("+") || textArea1.getText().contains("*") || textArea1.getText().contains("/")
                || textArea1.getText().contains("^") || (textArea1.getText().contains("-") && !textArea1.getText().startsWith("-"))) {



                    if (!textArea1.getText().endsWith("+") && !textArea1.getText().endsWith("*") && !textArea1.getText().endsWith("/")
                            && !textArea1.getText().endsWith("^") && !textArea1.getText().endsWith("-")) {
                        return true;
                    }
                    return false;
                }

         else if(mode.length!=0 && !textArea1.getText().isEmpty() && !textArea1.getText().contains("o")){
             return true;
         }
         else if (!textArea1.getText().endsWith(".") && !textArea1.getText().contains("o") && !textArea1.getText().matches(".*\\d.*")){

             return true;

         }

        else return false;





    }

    public static boolean isAbleToBeWritten(JTextArea textArea1, char input){

        if ((input < '0' || input > '9'))
            if (!textArea1.getText().isEmpty()) {
                if ((textArea1.getText().charAt(textArea1.getText().length() - 1) < '0' || textArea1.getText().charAt(textArea1.getText().length() - 1) > '9'))
                    return false;
                else {
                    if (input == '.') {


                        int occurs = 0;

                        for (int i = 0; i < textArea1.getText().length(); i++) {
                            if (textArea1.getText().charAt(i) == '.') {
                                occurs++;

                            }
                        }

                        if (occurs == 1) {
                            if ((textArea1.getText().contains("+") || textArea1.getText().contains("*") || textArea1.getText().contains("/")
                                    || textArea1.getText().contains("^") || (textArea1.getText().contains("-") && !textArea1.getText().startsWith("-"))))
                                return true;
                            else return false;
                        } else if (occurs == 0) return true;
                        else return false;
//

                    } else if (textArea1.getText().isEmpty() || textArea1.getText().contains("o"))
                        return false;
                    else if (textArea1.getText().charAt(textArea1.getText().length() - 1) < '0' || textArea1.getText().charAt(textArea1.getText().length() - 1) > '9')
                        return false;

                }

            } else return false;

        return true;
    }

}
