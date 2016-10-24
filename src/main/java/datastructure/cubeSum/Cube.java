package datastructure.cubeSum;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Dawei on 10/13/2016.
 */
public class Cube {

    static class Pos implements Comparable<Pos>{
        int x;
        int y;
        int z;
        Pos(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Pos o) {
            if ((this.x == o.x) && (this.y == o.y) && (this.z == o.z))
                return 0;
            if (this.x <= o.x && this.y <= o.y && this.z <= o.z)
                return -1;
            if (this.x >= o.x && this.y >= o.y && this.z >= o.z)
                return 1;
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            Pos c = (Pos)o;
            return (this.x == c.x) && (this.y == c.y) && (this.z == c.z);
        }

        @Override
        public int hashCode() {
            return 39*x + 7*y + 11*z;
        }

        @Override
        public String toString() {
            return "{" + x + ", " + y + ", " + z + "}";
        }
    }

    public static long getSum(Map<Pos, Integer> cube, Pos p1, Pos p2) {
        if (p1.equals(p2)) {
            if (cube.containsKey(p1))
                return cube.get(p1);
            return 0;
        }

        long sum = 0;
        if (cube.containsKey(p1))
            sum += cube.get(p1);
        if (cube.containsKey(p2))
            sum += cube.get(p2);
        Pos min = p1.compareTo(p2)<0? p1:p2;
        Pos max = p1.compareTo(p2)>0? p1:p2;
        for (Map.Entry<Pos, Integer> e : cube.entrySet()) {
            Pos curr = e.getKey();
            int v = e.getValue();
            if (min.compareTo(curr)<0 && max.compareTo(curr) >0)
                sum += v;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("cube2.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int num = scanner.nextInt();
        for (int i = 0; i<num; i++) {
            Map<Pos, Integer> cube = new HashMap<>();
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            for (int j = 0; j< q; j++) {
                String cmd = scanner.next();
                if (cmd.equals("UPDATE"))
                    cube.put(new Pos(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()), scanner.nextInt());
                else if (cmd.equals("QUERY")) {
                    System.out.println(getSum(cube, new Pos(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()), new Pos(scanner.nextInt(), scanner.nextInt(), scanner.nextInt())));
                }
            }
        }


    }
}
