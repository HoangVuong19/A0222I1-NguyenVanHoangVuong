package _11_dsa_stack_queue.bai_tap.bai_queue_su_dung_linked_list_vong;

public class Test {
    public static void main(String[] args) {
        Queue<Integer> circular = new Queue<>();
        circular.enQueue(1);
        circular.enQueue(3);
        circular.enQueue(5);
        circular.enQueue(8);
        circular.enQueue(15);
        circular.displayQueue();

        circular.deQueue();
        circular.displayQueue();
    }
}
