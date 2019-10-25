package customlist;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sort<T extends Comparable<T>> {


    public static <T> void sort (CustomList list){
        List<T> collect = (List<T>) list.getList().stream().sorted().collect(Collectors.toList());
        list.setList(collect);
    }
}
