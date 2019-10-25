package listiterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListIterator implements Iterable<String> {
    private static final String EXEPTION = "Invalid Operation!";
    private int count;
    private List<String> data;

    public ListIterator(String... elements) {
        this.data = new ArrayList<>();
        this.count = 0;

        if (elements.length != 0) {
            this.data.addAll(Arrays.asList(elements));
        }
    }

    public boolean hasNext() {
        return this.count + 1 < this.data.size();
    }

    public boolean move() {
        if (hasNext()) {
            this.count++;
            return true;
        }
        return false;
    }

    public void print() {
        if (!data.isEmpty()) {
            System.out.println(this.data.get(this.count));
        } else {
            System.out.println(ListIterator.EXEPTION);
        }
    }

    @Override
    public Iterator<String> iterator() {
//        return this.data.iterator();
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public String next() {
                return data.get(this.index++);
            }
        };
    }
}























