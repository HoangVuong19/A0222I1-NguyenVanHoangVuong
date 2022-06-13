package _11_dsa_stack_queue.thuc_hanh.bai_stack_su_dung_linked_list;

public class GenericStackClient {
    public static void main(String[] args) {
        System.out.println("1. Stack of integers");
        stackOfIntegers();
        System.out.println("\n2. Stack of Strings");
        stackOfIStrings();
    }

    private static void stackOfIStrings() {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("Five");
        stack.push("Four");
        stack.push("Three");
        stack.push("Two");
        stack.push("One");
        System.out.println("Size of stack after push operations: " + stack.size());
        System.out.printf("Pop elements from stack : ");

        while (!stack.isEmpty()) {
            System.out.printf(" %s", stack.pop());
        }

        System.out.println("\nSize of stack after pop operations : " + stack.size());
    }

    private static void stackOfIntegers() {
        MyGenericStack<Integer> stack = new MyGenericStack<>();
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        System.out.println("Size of stack after push operations: " + stack.size());
        System.out.printf("Pop elements from stack: ");

        while (!stack.isEmpty()) {
            System.out.printf(" %d", stack.pop());
        }

        System.out.println("\n Size of stack after pop operations : " + stack.size());
    }
}
