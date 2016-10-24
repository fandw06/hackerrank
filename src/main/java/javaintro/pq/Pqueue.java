package javaintro.pq;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Dawei on 10/12/2016.
 */
public class Pqueue {
    static class Student{
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

        PriorityQueue<Student> queue = new PriorityQueue<Student>(100, new Comparator<Student>() {

            @Override
            public int compare(Student s1, Student s2) {
                if (s1.getCgpa() != s2.getCgpa()) {
                    double d = s1.getCgpa() - s2.getCgpa();
                    return (d > 0)? -1:1;
                }
                else if (!s1.getFname().equals(s2.getFname())) {
                    return s1.getFname().compareTo(s2.getFname());
                }
                else
                    return s1.getToken() - s2.getToken();
            }
        });

        Scanner in = new Scanner(System.in);
        int totalEvents = Integer.parseInt(in.nextLine());
        while(totalEvents>0){
            String event = in.next();
            switch (event) {
                case "ENTER":
                    String name = in.next();
                    double gpa = in.nextDouble();
                    int token = in.nextInt();
                    queue.add(new Student(token, name, gpa));
                    break;
                case "SERVED":
                    if (!queue.isEmpty())
                        queue.remove();
                    break;
            }
            totalEvents--;
        }

        if (queue.size() == 0)
            System.out.println("EMPTY");
        while (queue.size() >0) {
            Student s = queue.remove();
            System.out.println(s.getFname());
        }
    }

}
