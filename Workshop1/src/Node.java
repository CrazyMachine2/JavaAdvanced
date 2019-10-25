public class Node {
    int value;
    Node prev;
    Node next;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    Node(int value){
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
