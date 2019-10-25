import java.awt.dnd.InvalidDnDOperationException;
import java.util.function.Consumer;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    LinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public void addFirst(int elem){
        Node node = new Node(elem);

        if(this.isEmpty()){

            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
        }

        this.head = node;
        this.size++;
    }

    public void addLast(int elem){
        Node node = new Node(elem);

        if (this.isEmpty()){
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
        this.size++;
    }

    public int removeFirst(){
        if (this.isEmpty()){
            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }

        Node deleted = this.head;
        this.head = this.head.next;
        deleted.next = null;

        if (this.size == 1){
            this.tail = null;
        } else {
            this.head.prev = null;
        }

        this.size--;
        return deleted.value;
    }

    public int removeLast(){
        if (this.isEmpty()){
            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }

        Node deleted = this.tail;
        this.tail = this.tail.prev;
        deleted.prev = null;

        if (this.size == 1){
            this.head = null;
        } else {
            this.tail.next = null;
        }

        this.size--;
        return deleted.value;
    }

    public void forEach (Consumer<Integer> consumer){
        Node current = this.head;

        while (current != null){
            consumer.accept(current.value);
            current = current.next;
        }
    }

    public int[] toArray(){
        int[] result = new int[this.size];
        int index = 0;

        Node current = this.head;

        while (current != null){
            result[index] = current.value;
            current = current.next;
            index++;
        }
        return result;
    }

    public void addAfter (int searchedElement, int newElement){
        if (this.isEmpty()){
           throw new InvalidDnDOperationException("The list is empty");
        }

        Node current = this.head;
        while (current != null){
            if (current.value == searchedElement){
                Node node = new Node(newElement);

                node.next = current.next;
                node.prev = current;

                if(current.next != null){
                    node.next.prev = node;
                } else {
                    this.tail = node;
                }

                current.next = node;

                this.size++;
                return;
            }

            current = current.next;
        }
        throw new InvalidDnDOperationException("Searched element not found");
    }

    public int removeAfter(int searchedElement){
        if (this.isEmpty()){
            throw new InvalidDnDOperationException("The list is empty");
        }

        Node current = this.head;
        while (current != null){
            if (current.value == searchedElement){
                Node forDeletion = current.next;

                if (forDeletion == null){
                    throw new InvalidDnDOperationException("No element after searched element");
                }

                current.next = forDeletion.next;

                if (current.next == null){
                    this.tail = current;
                } else {
                    current.next.prev = current;
                }

                forDeletion.next = null;
                forDeletion.prev = null;

                return forDeletion.value;
            }

            current = current.next;
        }

        throw new InvalidDnDOperationException("No element after searched element");
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }
}
