package javaintro;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Dawei on 10/11/2016.
 */
public class RegexTest {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases-->0){
            String pattern = in.nextLine();
            try{
                Pattern p = Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Exception e) {
                System.out.println("Invalid");
            }
        }
    }
}
