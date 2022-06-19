package _12_java_collection_framework.thuc_hanh.bai_sap_xep_voi_comparable_comparator;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o1.getAge() > o2.getAge()) {
            return 1;
        } else if (o1.getAge().equals(o2.getAge())) {
            return 0;
        }

        return -1;
    }
}
