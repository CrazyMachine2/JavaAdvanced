package froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer> stones;

    public Lake(List<Integer> numbers) {
        this.stones = numbers;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;
            private int lastEvenIndex = (stones.size() - 1) % 2 == 0 ? stones.size() - 1 : stones.size() -2;
            @Override
            public boolean hasNext() {
                return this.index < stones.size();
            }

            @Override
            public Integer next() {
                int stone = stones.get(this.index);

                if (index == lastEvenIndex){
                    index = 1;
                    return stone;
                }

                this.index += 2;
                return stone;
            }
        };
    }
}

