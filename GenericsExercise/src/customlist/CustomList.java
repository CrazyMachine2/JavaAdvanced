package customlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add (T element){
        this.list.add(element);
    }

    public T remove (int index){
        return this.list.remove(index);
    }

    public boolean contains(T element){
        return this.list.contains(element);
    }

    public void swap(int index1, int index2){
        if (index1 < 0 || index1 > this.list.size() || index2 < 0 || index2 > this.list.size()){
            throw new IndexOutOfBoundsException();
        }

        T first = this.list.get(index1);
        T second = this.list.get(index2);

        this.list.add(index1,second);
        this.list.remove(index1 + 1);
        this.list.add(index2,first);
        this.list.remove(index2 + 1);

    }

    public  <T extends Comparable<T>> void printGreater (T element){
        int count = 0;

        for (int i = 0; i < this.list.size(); i++) {
            if (element.compareTo((T) this.list.get(i)) < 0){
                count++;
            }
        }

        System.out.println(count);
    }

    public void printMax (){
        System.out.println(Collections.max(this.list));
    }

    public void printMin(){
        System.out.println(Collections.min(this.list));
    }

    public void print(){
        for(T element : this.list){
            System.out.println(element);
        }
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
