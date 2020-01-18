package www.classSystem;
import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        /**
         * 班级成员管理系统(基于链表)：属性：学号(ID)、姓名(name)、年龄(age)
         * 1.初始化
         * 2.输入 input(从文件中读取)
         * 3.取值 get
         * 4.查找 select
         * 5.插入 insert
         * 6.删除 delete
         * 7.输出 output
         * 0.退出 exit
         */
        boolean choose = true;
        Scanner s = new Scanner(System.in);
        //设置一个ifGet属性进行判断是否已经创建链表
        boolean ifGet = false;
        ManagementSystemList system = null;
        while (choose) {
            menu();
            String temp = s.nextLine();
            switch (temp) {
                case "1" : {
                    //实例化对象
                    system = ManagementSystemList.getInstance();
                    ifGet = true;
                    System.out.println("链表创建成功");
                    break;
                }
                case "2" : {
                    ManagementSystemList.checkIfGet(ifGet);
                    system.input();
                    System.out.println("文件读取成功");
                    break;
                }
                case "3" : {
                    ManagementSystemList.checkIfGet(ifGet);
                    System.out.println("请输入要查询的下标：");
                    int index = Integer.valueOf(s.nextLine());
                    system.get(index);
                    break;
                }

                case "4":{
                    ManagementSystemList.checkIfGet(ifGet);
                    System.out.println("请输入要查询的ID：");
                    int ID = Integer.valueOf(s.nextLine());
                    system.select(ID);
                    break;
                }

                case "5" : {
                    ManagementSystemList.checkIfGet(ifGet);
                    System.out.println("请输入要插入的位置以及内容：'xx(index) xx(ID) xx(name) xx(age)");
                    String[] data = s.nextLine().split(" ");
                    system.insert(Integer.valueOf(data[0]), Integer.valueOf(data[1]), data[2], Integer.valueOf(data[3]));
                    break;
                }
                case "6": {
                    ManagementSystemList.checkIfGet(ifGet);
                    System.out.println("请输入要删除的位置：");
                    system.delate(Integer.valueOf(s.nextLine()));
                    break;
                }
                case "7" : {
                    ManagementSystemList.checkIfGet(ifGet);
                    system.output();
                    break;
                }
                case "0": {
                    ManagementSystemList.checkIfGet(ifGet);
                    choose = false;
                    system.outputFile();
                    break;
                }
                default:{
                    System.out.println("输入有误，请重新输入：");
                    break;
                }
            }
        }
    }
    //菜单方法
    private static void menu() {
        System.out.println("1.初始化");
        System.out.println("2.输入");
        System.out.println("3.取值");
        System.out.println("4.查找");
        System.out.println("5.插入");
        System.out.println("6.删除");
        System.out.println("7.输出");
        System.out.println("0.退出");
        System.out.println("请输入你的选择：");
    }
}

/**
 * 班级成员管理系统(基于链表)：属性：学号(ID)、姓名(name)、年龄(age)
 * 1.初始化
 * 2.输入 input(从文件中读取)
 * 3.取值 get
 * 4.查找 select
 * 5.插入 insert
 * 6.删除 delete
 * 7.输出 output
 * 0.退出 exit
 */
class ManagementSystemList {
    private static class Node {
        private Node next;
        private String name;
        private int age;
        private int ID;
        private Node(){}
        public Node(int ID, String name, int age) {
            this.name = name;
            this.age = age;
            this.ID = ID;
        }
        @Override
        public String toString() {
            return "{ ID = " + ID +
                    ", name= " + name +
                    ", age=" + age +
                    '}';
        }
    }
    public static Node head;
    public static int size;

    //封装ManagementSystemList对象
    private static ManagementSystemList m = new ManagementSystemList();
    //初始化
    private ManagementSystemList() {
        this.head = new Node();
        this.size = 0;
    }
    public static ManagementSystemList getInstance() {
        return m;
    }

    //2.输入
    public void input () throws IOException {
        File file = new File("C:"+File.separator+"Users"+File.separator
            +"孙诗尧"+File.separator+"Desktop"+File.separator+"data.txt");
        InputStream in = new FileInputStream(file);
        byte[] data = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (-1 !=(count = in.read(data))) {
            sb.append(new String(data,0,count));
        }
        String[] temp = sb.toString().split(" ");
        for (int i = 0;i < temp.length/3;i++) {
            if (i == 0) {
                insert(1,Integer.valueOf(temp[0]), temp[1], Integer.valueOf(temp[2]));
            } else {
                insert(i+1, Integer.valueOf(temp[i*3].trim()), temp[i*3+1], Integer.valueOf(temp[i*3+2].trim()));
            }
        }
    }
    //3.取值
    public void get(int index) {
        if (checkIndex(index) == true) {
            Node result = head;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
            System.out.println("取得信息如下：" + result.toString());
        }
        return;
    }

    //4.查找(根据学号查找)
    public void select(int ID) {
        if (size == 0) {
            System.out.println("链表为空，查找失败");
            return;
        }
        Node temp = head;
        for (int i = 0;i < size;i++) {
            temp = temp.next;
            if (temp.ID == ID) {
                System.out.println("找到指定学号同学，名字为:"+temp.name);
                return;
            }
        }
        System.out.println("未找到指定学号同学");
        return;

    }

    //5.插入(根据指定位置插入)
    public void insert(int index,int ID,String name,int age) {
        Node newNode = new Node(ID,name,age);
        if (size == 0) {
            head.next = newNode;
            size++;
            System.out.println("插入成功");
            return;
        } else if (index > 0 && index <= size + 1) {
                Node temp = head;
                for (int i = 0; i < index - 1; i++) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
                size++;
                System.out.println("插入成功");
                return;
        }
        System.out.println("插入失败，坐标超出范围");
    }
    //6.删除
    public void delate(int index) {
        if (checkIndex(index) == true) {
            if (size == 0) {
                System.out.println("删除失败，链表为空");
                return;
            }
            Node targetNode = head;
            for (int i = 0; i < index - 1; i++) {
                targetNode = targetNode.next;
            }
            targetNode.next = targetNode.next.next;
            size--;
            System.out.println("删除成功");
        }
        return;
    }

    //7.输出
    public void output() {
        if (size == 0) {
            System.out.println("当前班级系统信息为空");
            return;
        } else {
            System.out.println("当前班级系统信息如下:");
            Node temp = head;
            for (int i = 0;i < size;i++) {
                temp = temp.next;
                System.out.println(temp.toString());
            }
        }
    }

    //0.输出返回至源文件
    public void outputFile () throws IOException {
        File file = new File("C:"+File.separator+"Users"+File.separator
                +"孙诗尧"+File.separator+"Desktop"+File.separator+"data.txt");
        OutputStream out = new FileOutputStream(file);
        StringBuilder sb = new StringBuilder();
        Node temp = head;
        for (int i = 0;i < size;i++) {
            temp = temp.next;
            sb.append(temp.ID+" ");
            sb.append(temp.name+" ");
            sb.append(temp.age+" \r\n");
        }
        out.write(sb.toString().getBytes());
    }
    //检查坐标
    private boolean checkIndex(int index) {
        if (index < 0 || index > this.size) {
            System.out.println("坐标超出范围");
            return false;
        }
        return true;
    }
    //检查是否已经建立顺序表
    public static void checkIfGet(boolean b) throws ClassNotFoundException {
        if (b == false)
            throw new ClassNotFoundException("还未建立顺序表");
        return;
    }
}