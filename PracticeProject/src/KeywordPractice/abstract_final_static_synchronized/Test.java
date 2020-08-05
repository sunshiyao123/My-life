package KeywordPractice.abstract_final_static_synchronized;



//class C{
//
//}
//abstract class A {
//    public void fun1(){};
//    //静态内部抽象类
//    static abstract class C {
//        abstract void fun();
//    }
//}
//class B extends A.C {
//
//    public B() {
//        System.out.println("b");
//    }
//
//    @Override
//    void fun() {
//
//    }
//}

//class A {
//    public String name;
//    final int[] data = new int[]{1,2,3};
//}

//
//class A {
//    private static String name;
//    public static void fun() {
//        System.out.println(name);
//    }
//}
//
//class C{
//    public void fun() {
//        A.fun();
//    }
//}
//
//class B {
//    public String fun() {
//        class D {
//            public String name = "诗尧";
//        }
//        return new D().name;
//    }
//}


class A {
    public String name = "诗尧";
    public A() {
        System.out.println("A构造");
    }
    public void fun() {
        System.out.println("A");
    }
}
class B extends A {
    public void fun() {
        System.out.println("B");
    }
}


public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.fun();
    }
}
