public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.addFirst(5);
        System.out.println(list.getHead().value);
        System.out.println(list.getSize());
        System.out.println(list.isEmpty());
        System.out.println("----------");
        list.addFirst(5);
        list.addFirst(5);

//        list.forEach(x -> System.out.println(x));

//        int[] arr = list.toArray();
//        System.out.println(arr[0]);

        list.addAfter(5,7);
        System.out.println("----------");
        list.addAfter(7,9);
        list.forEach(x -> System.out.println(x));
        System.out.println("----------");
        list.addAfter(10,1);
        System.out.println("----------");

    }
}















