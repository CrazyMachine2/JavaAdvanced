package genericsutil;

import java.util.List;

public class Utils {

    public static <T> void swap (List<T> list, int index1, int index2){

        T first = list.get(index1);
        T second = list.get(index2);

        list.add(index1,second);
        list.remove(index1 + 1);
        list.add(index2,first);
        list.remove(index2 + 1);
        print(list);
    }

    public static <T extends Comparable<T>> int compare (List<T> list, T element){
        int count = 0;

        for (int i = 0; i < list.size(); i++) {
            if (element.compareTo(list.get(i)) < 0){
                count++;
            }
        }

        return count;
    }


    private static <T> void print (List<T> list) {
        for (T value : list){
            System.out.println(value.getClass().getName() + ": " + value);
        }
    }
}
