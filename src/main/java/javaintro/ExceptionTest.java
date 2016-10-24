package javaintro;

import java.util.Scanner;

/**
 * Created by Dawei on 10/12/2016.
 */
public class ExceptionTest {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String op1 = scanner.next();
        String op2 = scanner.next();
        int i1 = 0;
        int i2 = 0;
        try {
            i1 = Integer.valueOf(op1);
            i2 = Integer.valueOf(op2);
            if (i2 == 0)
                throw new java.lang.ArithmeticException("/ by zero");
            System.out.println(i1/i2);
        } catch (Exception e) {
            throw new java.util.InputMismatchException();
        }
    }
}
