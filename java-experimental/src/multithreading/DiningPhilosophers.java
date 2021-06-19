package multithreading;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class DiningPhilosophers {
    Map<Integer, Integer> philStore = new ConcurrentHashMap<>();

    public DiningPhilosophers() {
        reset();
    }

    /*
    Output: [[4,2,1],[4,1,1],[0,1,1],[2,2,1],[2,1,1],[2,0,3],[2,1,2],[2,2,2],[4,0,3],[4,1,2],[0,2,1],[4,2,2],[3,2,1],
    [3,1,1],[0,0,3],[0,1,2],[0,2,2],[1,2,1],[1,1,1],[3,0,3],[3,1,2],[3,2,2],[1,0,3],[1,1,2],[1,2,2]]
Explanation:
n is the number of times each philosopher will call the function.
The output array describes the calls you made to the functions controlling the forks and the eat function, its format is:
output[i] = [a, b, c] (three integers)
- a is the id of a philosopher.
- b specifies the fork: {1 : left, 2 : right}.
- c specifies the operation: {1 : pick, 2 : put, 3 : eat}.
     */
    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        Integer philState = philStore.get(philosopher);

        if (philState != null) {
            switch (philState) {
                case 0:
                    if (pickFork(philosopher, true)) {
                        pickLeftFork.run();
                        philStore.put(philosopher, philState + 1);
                    }
                case 1:
                    // 1 cannot be eating/3 or have left fork/1
                    if (pickFork(philosopher, false)) {
                        pickRightFork.run();
                        philStore.put(philosopher, philState + 1);
                    }
                case 2:
                    // 2 cannot be eating/3 or have right fork/2
                    // 1 cannot be eating/3 or have left fork/1
                    eat.run();
                    philStore.put(philosopher, philState + 1);
                case 3:
                    putLeftFork.run();
                    philStore.put(philosopher, philState + 1);
                case 4:
                    putRightFork.run();
                    philStore.put(philosopher, philState + 1);
                case 5:
                    philStore.remove(philosopher);
            }
        }
    }

    private boolean pickFork(int philosopher, boolean isLeft) {
        Integer phil0State = philStore.get(0);
        Integer phil1State = philStore.get(1);
        Integer phil2State = philStore.get(2);
        Integer phil3State = philStore.get(3);
        Integer phil4State = philStore.get(4);

        switch (philosopher) {
            case 0:
                return isLeft ? phil1State == null || phil1State != 3 && phil1State != 2 :
                        phil4State == null || phil4State != 3 && phil4State != 1;
            case 1:
                return isLeft ? phil2State == null || phil2State != 3 && phil2State != 1 :
                        phil0State == null || phil0State != 3 && phil0State != 2;
            case 2:
                return isLeft ? phil3State == null || phil3State != 3 && phil3State != 1 :
                        phil1State == null || phil1State != 3 && phil1State != 2;
            case 3:
                return isLeft ? phil4State == null || phil4State != 3 && phil4State != 1 :
                        phil2State == null || phil2State != 3 && phil2State != 2;
            case 4:
                return isLeft ? phil0State == null || phil0State != 3 && phil0State != 2 :
                        phil3State == null || phil3State != 3 && phil3State != 1;
        }
        return false;
    }

    private void reset() {
        philStore.put(0, 0);
        philStore.put(1, 0);
        philStore.put(2, 0);
        philStore.put(3, 0);
        philStore.put(4, 0);
    }
}
