package web.service;

public class MathQuestionService {

    /**
     * Calculate Q1 addition result 
     */
    public static double q1Addition(String number1, String number2) {
        try {
            double n1 = Double.parseDouble(number1);
            double n2 = Double.parseDouble(number2);
            return n1 + n2;
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }

    /**
     * Calculate Q2 subtraction result 
     */
    public static double q2Subtraction(String number1, String number2) {
        try {
            double n1 = Double.parseDouble(number1);
            double n2 = Double.parseDouble(number2);
            return n1 - n2;
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }

    /**
     * Calculate Q3 multiplication result
     */
    public static double q3Multiplication(String number1, String number2) {
        try {
            double n1 = Double.parseDouble(number1);
            double n2 = Double.parseDouble(number2);
            return n1 * n2;
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }
}
