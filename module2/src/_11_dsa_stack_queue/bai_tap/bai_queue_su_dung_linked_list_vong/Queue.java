package _11_dsa_stack_queue.bai_tap.bai_queue_su_dung_linked_list_vong;

public class Queue<E> extends Node {
    private Node front;
    private Node rear;

    public Queue() {
    }

    public void enQueue(E element) {
        Node nodeNew = new Node(element);
        if (this.front == null) {
            this.front = nodeNew;
        } else {
            this.rear.next = nodeNew;
        }
        this.rear = nodeNew;
        this.rear.next = this.front;
    }

    public void deQueue() {
        if (this.front == null) {
            return;
        }
        this.front = this.front.next;
        this.rear.next = this.front;
    }

    public void displayQueue() {
        if (this.front == null) {
            System.out.println("Queue rỗng");
        }
        Node element = this.front;
        do {
            System.out.println(element.data);
            element = element.next;
        } while (element != this.front);
    }
}