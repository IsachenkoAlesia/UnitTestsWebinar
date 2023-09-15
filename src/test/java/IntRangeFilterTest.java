import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntRangeFilterTest {
    private static final int LOWER_BOUND = 2;
    private static final int UPPER_BOUND = 8;
    private IntRangeFilter filter;

    // [2; 8]   filter()
    //2, 1, 8, 9, 6
    @Before
    public void setUp(){
        filter = new IntRangeFilter(LOWER_BOUND, UPPER_BOUND);
    }

    @Test
    public  void filterNumberEqualsLowerBoundTest(){
        boolean actual = filter.filter(2);
       // boolean expected = true;
        assertTrue("Число равно левой границе", actual);
    }

    @Test
    public  void filterNumberLessThanLowerBoundTest(){
        boolean actual = filter.filter(1);
        // boolean expected = false;
        assertFalse("Число меньше чем левая граница", actual);
    }

    @After
    public void clean(){
        //чистка данных
    }


}
