package KeywordPractice.extends_implements;

public class Main {
    public static void main(String[] args) {
        IB temp = new Aimpl();
        temp.fun();
    }
}

interface IA {
    String name = "诗尧";
    abstract void fun();
}
abstract class C implements IA{
}

interface IB {
//    String name = "刘苗";
    abstract void fun();
}

class Aimpl extends C implements IB{

    @Override
    public void fun() {
        System.out.println("喜欢"+name);
    }
}