package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1AdditionValid() {
        assertEquals(3, MathQuestionService.q1Addition("1", "2"), 0);
    }

    @Test
    public void testQ1AdditionEmptyInput() {
        assertTrue(Double.isNaN(MathQuestionService.q1Addition("", "2")));
        assertTrue(Double.isNaN(MathQuestionService.q1Addition("1", "")));
    }

    @Test
    public void testQ2SubtractionValid() {
        assertEquals(2, MathQuestionService.q2Subtraction("5", "3"), 0);
    }

    @Test
    public void testQ2SubtractionInvalidInput() {
        assertTrue(Double.isNaN(MathQuestionService.q2Subtraction("a", "3")));
    }

    @Test
    public void testQ3MultiplicationValid() {
        assertEquals(15, MathQuestionService.q3Multiplication("3", "5"), 0);
    }

    @Test
    public void testQ3MultiplicationInvalidInput() {
        assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("", "5")));
        assertTrue(Double.isNaN(MathQuestionService.q3Multiplication("3", "b")));
    }
}
