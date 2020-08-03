package KeywordPractice.Private_Protacted_Public;



class Father{
    private String name;
    private int age;
    private String sex;
    protected String property;
    public int ClassNumber = 1;

    public Father(int age, String sex) {
        this.age = age;
        this.sex = sex;
        protectey();
    }

    private void protectey() {
        property = "一百万";
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", property='" + property + '\'' +
                ", ClassNumber=" + ClassNumber +
                '}';
    }
}

class Student extends Father{
    public Student(int age, String sex) {
        super(age, sex);
    }

}

class Mother {


}

public class Main {
    public static void main(String[] args) {
        Student student = new Student(10,"男");
        Father father = new Father(40,"男");
        System.out.println(student.toString());
        System.out.println(father.toString());
    }
}




