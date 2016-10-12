package CrackingInterview;

import java.util.*;

/**
 * 两种方式，一种是直接继承Comparable，实现compareTo方法，
 * 一种是新建一个类实现Comparator。
 */
public class PlayerRank {
    public class Player implements Comparable<Player>{
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Player o) {
            return 0;
        }
    }

    public class Checker implements Comparator<Player>{

        @Override
        public int compare(Player o1, Player o2) {

            if (o1.score != o2.score)
                return o2.score - o1.score;
            return o1.name.compareTo(o2.name);
        }
    }


}
