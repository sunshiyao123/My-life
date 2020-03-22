package Day40;
class Person {
    public String name = null;
    public int age = 0;
    public int gender = 0;

    public Person(String n, int a, int g) {
        this.name = n;
        this.age = a;
        this.gender = g;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        Person p = new Person("孙诗尧",20,2);
        System.out.println(p.toString());
        System.out.println(p.name);
        System.out.println(p.age);

    }
}
