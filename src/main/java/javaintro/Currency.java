package javaintro;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Dawei on 10/10/2016.
 */
public class Currency {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // Write your code here.
        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale.Builder().setLanguage("en").setRegion("IN").build()).format(payment));
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));

        String s = "asdfas";
        System.out.println((char)(s.charAt(0) + 'A' - 'a') + s.substring(1));
    //    System.out.println("India: " + india);
    //    System.out.println("China: " + china);
    //    System.out.println("France: " + france);
    }
}
