package mustKnowJava.javastreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ReverseList extends ArrayList<String> {
    @Override
    public Iterator<String> iterator() {
        int endIndex = this.size() - 1;
        List<String> list = this;
        return new Iterator<>() {
            int curIndex = endIndex;
            @Override
            public boolean hasNext() {
                return curIndex >= 0;
            }

            @Override
            public String next() {
                return list.get(curIndex--);
            }
        };

    }

    public static void main(String[] args) {
        List<String> myList = new ReverseList();
        myList.addAll(Arrays.asList("A", "B", "C"));
        //MISLEADING ARTICLE in the Baeldung crap, it need to overwrite the forEach!
        // HERE uses the Iterator
        for (String s : myList) {
            System.out.print(s);
        }
        System.out.println();
       // myList.forEach((ele) -> System.out.print(ele));
        // HERE DOES NOT uses the Iterator
        myList.stream().forEach( ele -> System.out.print(ele));
    }
}
