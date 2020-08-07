package KeywordPractice.new_this_super_instanceOf;
//
//public class Main {
//    public static void main(String[] args) {
//        A a = new A("ssy");
//    }
//}

//class A {
//    private String name = "诗尧";
//    public A() {
//        this.name = "刘苗";
//        System.out.println("经过了");
//    }
//    public A(String name) {
//        this();
//        System.out.println(this.name+"喜欢"+name );
//    }
//}









//class A {
//    public A() {
//        System.out.println("A无参");
//    }
//    public A(String name) {
//        System.out.println("A有参");
//    }
////    public A(String name,int i){
////        System.out.println("A两参");
////    }
//}

//class B extends A {
////
//    public B(){
//        System.out.println("B的无参构造");
//    }
//    public B(String name) {
//        this();
//        System.out.println("B有参");
//    }
//}


class A {
    public A(String name){
        System.out.println("父类构造");
    }

}
class B extends A {
    public String name;
    public int age;
    public int classData;
    public B (){
        super("诗尧");
        System.out.println("B的无参构造");
    }
    public B(String name) {
        //调用了B的无参构造
        this();
        this.name = name;
        System.out.println("B构造1");
    }
    public B(String name,int age) {
        this(name);
        this.age = age;
        System.out.println("B构造2");

    }
    public B(String name,int age,int classData) {
        this(name,age);
        this.classData = classData;
        System.out.println("B构造3");

    }

}

public class Main {
    public static void main(String[] args) {
        B b = new B("诗尧",22,2017);
    }
}