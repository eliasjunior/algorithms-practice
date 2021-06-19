import java.util.*;

class MergeIntervals {
    public static void main(String[] args) {
        //[[1,3],[2,6],[8,10],[15,18]]
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new int [][]{{1,3}, {2,6}, {8, 10}, {15, 18}});
    }

    public int[][] merge(int[][] intervals) {
        // check many intersection
        if(intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        LinkedList<int[]> stack = new LinkedList<>();

        stack.push(intervals[0]);
        for(int j = 1; j < intervals.length; j++) {
            int [] int1 = intervals[j];

            int [] mergeResult = intersect(stack.peek(), int1);

            if(mergeResult.length > 0) {
                stack.pop();
                stack.push(mergeResult);
            } else {
                stack.push(int1);
            }
        }
        return stack.toArray(new int[stack.size()][]);
    }

    private int [] intersect(int [] int1, int [] int2) {
        // as its sorted, I'd need just check the end,
        // below still taking care when its not sorted
        int startA = int1[0];
        int endA = int1[1];

        int startB = int2[0];
        int endB = int2[1];

        if(startB <= endA && endB >= startA) {
            int min = Math.min(startA, startB);
            int max = Math.max(endA, endB);
            return new int[]{min, max};
        }
        return new int [0];
    }
}