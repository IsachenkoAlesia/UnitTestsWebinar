import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class IntRangeFilerParameterizedTest {

    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 8;
    private IntRangeFilter filter;


    private int lowerBound;
    private int upperBound;
    private int value;
    private boolean expectedResult;
    private String message;

    @Parameterized.Parameters(name = "{0} - значение {3}")
    public static Object[][] getData(){
        return new Object[][]{
                {"Число = нижней границе ", 2, 8, 2, true},
                {"Число < нижней границе ", LOWER_BOUND, UPPER_BOUND, /* value = */ 1, /*expected = */ false},
                {"Число = верхней границе ", LOWER_BOUND, UPPER_BOUND, 8, true},
                {"Число > верхней границе ", LOWER_BOUND, UPPER_BOUND, 9, false},
                {"Число в середине ", LOWER_BOUND, UPPER_BOUND, 5, true}
        };
    }

    public IntRangeFilerParameterizedTest(String message, int lowerBound, int upperBound, int value, boolean expectedResult) {
        this.message = message;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.value = value;
        this.expectedResult = expectedResult;
    }

    // [2; 8]   filter()
    //2, 1, 8, 9, 6
    @Test
    public  void filterTest(){
        filter = new IntRangeFilter(lowerBound, upperBound);
        //boolean actual = filter.filter(value);
        assertEquals(message, filter.filter(value), expectedResult);
    }
}
