package javaintro;

import java.util.Scanner;

/**
 * Created by Dawei on 10/12/2016.
 */
public class Pqueue {
    class Student{
        private int token;
        private String fname;
        private double cgpa;
        public Student(int id, String fname, double cgpa) {
            super();
            this.token = id;
            this.fname = fname;
            this.cgpa = cgpa;
        }
        public int getToken() {
            return token;
        }
        public String getFname() {
            return fname;
        }
        public double getCgpa() {
            return cgpa;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        while(totalEvents>0){
            String event = in.next();

            //Complete your code

            totalEvents--;
        }
    }

}
