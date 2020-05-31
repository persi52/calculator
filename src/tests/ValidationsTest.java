package tests;
import com.company.Okienko;
import com.company.Validations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class ValidationsTest {

    @Test
    public void isAbleToQuickCalculate_MinusAtTheEnd_returnsFalse(){
        //given
        Okienko okienko = new Okienko();
        JTextArea textArea1 = okienko.getTextArea1();
        textArea1.setText("15-");
        //when
        boolean result = Validations.isAbleToQuickCalculate(textArea1);

        //then
        Assertions.assertEquals(false,result);
    }


    @Test
    public void isAbleToBeWritten_WithSecondDot_returnsFalse(){
        //given
        Okienko okienko = new Okienko();
        JTextArea textArea1 = okienko.getTextArea1();
        textArea1.setText("1.507");
        //when
        boolean result = Validations.isAbleToBeWritten(textArea1,'.');
        //then
        Assertions.assertEquals(false,result);

    }
    @Test
    public void isAbleToBeWritten_WriteSignWhenTextAreaIsEmpty_returnsFalse(){
        //given
        Okienko okienko = new Okienko();
        JTextArea textArea1 = okienko.getTextArea1();
        //textArea1.setText("1.50");
        //when
        boolean result = Validations.isAbleToBeWritten(textArea1,'.');
        boolean result2 = Validations.isAbleToBeWritten(textArea1,'+');
        //then
        Assertions.assertEquals(false,result);
        Assertions.assertEquals(false,result2);
       // Assertions.assertEquals(false,result3);
    }

}
