package _11_dsa_stack_queue.bai_tap.bai_demerging_su_dung_queue;


public class Person {
    private String name;
    private String sex;
    private String birth;

    public Person(String name, String sex, String birth) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
