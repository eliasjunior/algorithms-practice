import java.util.*;

public class GreedyLuck {

    public static int luckBalance(int k, List<List<Integer>> contests) {
        List<Contest> list = new ArrayList<>();

        for (int i = 0; i < contests.size(); i++) {
            int luckBalance = contests.get(i).get(0);
            int importance = contests.get(i).get(1);
            list.add(new Contest(luckBalance, importance));
        }

        Collections.sort(list);
      //  Collections.sort(list, new ByBalance());

        int countImp = 0;
        //sorted
        int first = list.get(0).importance;
        if (first > 0) {
            countImp++;
            for (int j = 1; j < list.size(); j++) {
                int currentImp = list.get(j).importance;
                if (currentImp < first) {
                    break;
                }
                countImp++;
            }
        }
        int maxBalance = 0;
        for (Contest contest : list) {
            if(countImp > k) {
                maxBalance = maxBalance - contest.balance;
            } else {
                maxBalance = maxBalance + contest.balance;
            }
            countImp--;
        }

        return maxBalance;
    }

    static class Contest implements Comparable<Contest> {
        final int balance;
        final int importance;

        Contest(int balance, int importance) {
            this.balance = balance;
            this.importance = importance;
        }

        @Override
        public int compareTo(Contest o) {
            if(this.importance > o.importance) {
                return -1;
            } else if (this.importance < o.importance) {
                return 1;
            } else {
                if (this.balance > o.balance) {
                    return 1;
                } else if (this.balance < o.balance) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> contests = new ArrayList<>(6);
        contests.add(Arrays.asList(5,1));
        contests.add(Arrays.asList(2,1));
        contests.add(Arrays.asList(1,1));
        contests.add(Arrays.asList(8, 1));
        contests.add(Arrays.asList(10,0));
        contests.add(Arrays.asList(5,0));

        luckBalance(3, contests);
    }
}
