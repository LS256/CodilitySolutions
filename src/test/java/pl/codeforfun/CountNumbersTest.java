package pl.codeforfun;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountNumbersTest {
    private CountNumbers cn;

    @Before
    public void init(){
        cn = new CountNumbers();
    }

    @Test
    public void solutionTest(){

        assertEquals(9, cn.solution(100));
        assertEquals(8, cn.solution(24));
        assertEquals(6, cn.solution(12));
        assertEquals(3, cn.solution(9));
        assertEquals(4, cn.solution(8));
        assertEquals(4, cn.solution(6));
        assertEquals(3, cn.solution(4));
        assertEquals(2, cn.solution(2));
        assertEquals(1, cn.solution(1));



    }
}
