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
        assertEquals(1, cn.solution(1));
    }
}
