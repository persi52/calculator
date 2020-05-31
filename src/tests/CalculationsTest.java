package tests;




import com.company.Calculations;
import com.company.Okienko;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class CalculationsTest {


    @Test
    public void divide_whenDenominatorEqualsZero_throwsArithmeticException(){
        //given

        Calculations calculations = new Calculations();
        //when

        //then
        Assertions.assertThrows(ArithmeticException.class,() -> Calculations.divide(0,5));
    }

}
