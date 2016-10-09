package CrackingInterview;

import java.util.Comparator;

/**
 * Created by Dawei on 10/7/2016.
 */
public class PlayerRank {
    public class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
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
