package javaintro;

import java.util.BitSet;
import java.util.Scanner;

/**
 * Created by Dawei on 10/12/2016.
 */
public class BitSetTest {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        for (int i = 0; i< m; i++) {
            String command = scanner.next();
            int op1 = scanner.nextInt();
            int op2 = scanner.nextInt();
            switch (command) {
                case "AND":
                    if (op1 == 1)
                        b1.and(b2);
                    else
                        b2.and(b1);
                    break;
                case "OR":
                    if (op1 == 1)
                        b1.or(b2);
                    else
                        b2.or(b1);
                    break;

                case "XOR":
                    if (op1 == 1)
                        b1.xor(b2);
                    else
                        b2.xor(b1);
                    break;

                case "FLIP":
                    if (op1 == 1)
                        b1.flip(op2);
                    else
                        b2.flip(op2);
                    break;

                case "SET":
                    if (op1 == 1)
                        b1.set(op2);
                    else
                        b2.set(op2);
                    break;

                default:
                    System.err.println("Wrong command!");
            }

            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
    }
}
