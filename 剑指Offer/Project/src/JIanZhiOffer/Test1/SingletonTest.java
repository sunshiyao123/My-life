package JIanZhiOffer.Test1;

public class SingletonTest {
    public static void main(String[] args) {

    }
}

/**
 * 解法一：在多线程中无法正常运行
 */
//class Singleton {
//    private static Singleton person = null;
//    //封装构造方法
//    private Singleton() {
//
//    }
//    public static Singleton getInstance () {
//        if (person == null)
//            person = new Singleton();
//        return person;
//    }
//}

/**
 * 解法二：加上同步锁，但是每次都要加锁会很麻烦
 */
class Singleton {
    private static Singleton instance = null;
    private Singleton(){}

}