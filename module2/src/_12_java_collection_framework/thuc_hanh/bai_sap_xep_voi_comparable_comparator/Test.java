package _12_java_collection_framework.thuc_hanh.bai_sap_xep_voi_comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student student0 = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT");
        Student student3 = new Student("Tung", 38, "HT");

        List<Student> students = new ArrayList<>();
        students.add(student0);
        students.add(student1);
        students.add(student2);
        students.add(student3);

        Collections.sort(students);

        System.out.println("So sanh theo ten:");
        for (Student st : students) {
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
//        Collections.sort(students,ageComparator);
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o, Student o2) {
//                return o.getAge()- o2.getAge();
//            }
//        });

//        Collections.sort(students, (o, o2) -> o.getAge()- o2.getAge());
        students.sort(Comparator.comparing(Student::getAge));

        System.out.println("So sanh theo tuoi:");
        for (Student st : students) {
            System.out.println(st.toString());
        }
    }
}
