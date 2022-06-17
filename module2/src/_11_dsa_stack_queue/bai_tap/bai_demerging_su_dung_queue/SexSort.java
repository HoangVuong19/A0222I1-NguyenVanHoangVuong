package _11_dsa_stack_queue.bai_tap.bai_demerging_su_dung_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SexSort {
    public static void main(String[] args) {
        Person o1 = new Person("a", "nu", "10-2-2000");
        Person o2 = new Person("b", "nam", "10-3-2000");
        Person o3 = new Person("c", "nu", "10-4-2000");
        Person o4 = new Person("d", "nam", "10-5-2000");
        Person o5 = new Person("e", "nam", "10-6-2000");
        Person o6 = new Person("f", "nu", "10-7-2000");
        Queue<Person> male = new LinkedList<>();
        Queue<Person> female = new LinkedList<>();

        ArrayList<Person> people = new ArrayList<>();
        people.add(o1);
        people.add(o2);
        people.add(o3);
        people.add(o4);
        people.add(o5);
        people.add(o6);

        for (Person p : people) {
            if (p.getSex().equals("nu")) {
                female.add(p);
            } else {
                male.add(p);
            }
        }

        people.clear();
        while (!female.isEmpty()) {
            people.add(female.remove());
        }
        while (!male.isEmpty()) {
            people.add(male.remove());
        }

        for (Person p : people) {
            System.out.println(p);
        }

    }
}
