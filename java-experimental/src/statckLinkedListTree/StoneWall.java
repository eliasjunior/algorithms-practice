package statckLinkedListTree;

import java.util.ArrayList;
import java.util.List;

public class StoneWall {
    private List<Integer> stack = new ArrayList<>();

    public int solution(int[] heights, int N) {
        int count = 0;
        // edge case, empty array, empty element in the array, minimum size or small arrays < 2
        add(heights[0]);
        for (int i = 1; i < heights.length; i++) {
            int cur = heights[i];
            int peek = peek();
            if (peek == -1) {
                add(cur);
            } else {
                if (cur == peek) {
                    pop();
                    count++; // incr
                } else if (cur > peek) {
                    // add
                    add(cur);
                } else {
                    pop();
                    peek = peek();
                    if(peek == cur){
                        pop();
                        count++; // incr
                    } else {
                        add(cur);
                    }
                }
            }
        }

        if(stack.size() > 1) {
            int max = 0;
            for (int i = 0; i < stack.size(); i++) {
                int elem = stack.get(i);
                if(max < elem) {
                    max = elem;
                }
            }
            return max;
        } else {
            return heights.length - count;
        }
    }

    private void add(int cur) {
        stack.add(cur);
    }

    private int peek() {
        if (stack.size() == 0) {
            return -1;
        }
        return stack.get(stack.size() - 1);
    }

    private void pop() {
        stack.remove(stack.size() - 1);
    }
}
