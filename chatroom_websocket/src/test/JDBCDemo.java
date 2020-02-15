import com.ssy.chatroom.utils.JDBCUtil;
import com.ssy.chatroom.utils.JDBCUtilTwo;
import jdk.nashorn.internal.scripts.JD;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Assert;
import org.junit.Test;

import javax.rmi.CORBA.Util;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBCDemo {
    //查询
    @Test
    public void test() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/jdbc", "root","a5289012");
            //3.执行sql
            String sql = "select * from user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            //遍历结果集
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String useName = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("id="+id+" username="+useName+" password="+password);
            }
            //4.释放资源
            connection.close();
            statement.close();
            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //新增
    @Test
        public void test2() {
            try {
                //1.加载驱动
                Class.forName("com.mysql.jdbc.Driver");
                //2.获取连接
                Connection connection = DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/jdbc", "root","a5289012");
                //3.执行sql
                String sql = "insert into user(userName, password)"+"values ('xm','123')";
                Statement statement = connection.createStatement();
                int result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
                System.out.println(result);
                //4.释放资源
                connection.close();
                statement.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
    @Test
    public void test3() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/jdbc", "root","a5289012");
            //3.执行sql
            String sql = "delete from user where id = 9";
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql,statement.RETURN_GENERATED_KEYS);
            System.out.println(result);
            //4.释放资源
            connection.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/jdbc","root","a5289012");
            String sql = "select * from user " +
                    "where username = ? and password = ?";
            //预编译SQL
            PreparedStatement statement = connection.prepareStatement(sql);
            String username = "ssy";
            String password = "123";
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet result = statement.executeQuery();
            if (result.next())
                System.out.println("登陆成功");
            else
                System.out.println("登陆失败");

            connection.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void Test5() {
        //先创建好，准备后面try-catch
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql = "select * from user";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                System.out.println("id = "+id+",userName = "+userName+",password = "+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //无论如何都要关闭资源
            JDBCUtil.closeResources(connection,statement,resultSet);
        }
    }

    @Test
    public void testQuery() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            //关于preparedStatement的使用
            connection = JDBCUtilTwo.getConnection();
            //在语句中使用占位符
            String sql = "select * from user where id = ? and username = ?" ;
            //使用connection.prepareStatement()方法
            preparedStatement = connection.prepareStatement(sql);
            //这里前面的1表示第一个占位符,后面的则为代替的数据
            preparedStatement.setInt(1,4);
            preparedStatement.setString(2,"test");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("userName");
                String password = resultSet.getString("password");
                System.out.println("id =  "+id+",userName = "+userName+",password = "+password);
            }
        } catch(SQLException e) {

        } finally {
            JDBCUtilTwo.closeResources(connection,preparedStatement,resultSet);
        }
    }

    @Test
    public void testInsert() {
        //关于增加的操作
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtilTwo.getConnection();
            String sql = "insert into user(username, password) values (?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"asd");
            //DigestUtils.madHex():导入Apache依赖进行密码的加密操作
            preparedStatement.setString(2, DigestUtils.md5Hex("123"));
            int n = preparedStatement.executeUpdate();
            Assert.assertEquals(1,n);

        } catch (SQLException e) {

        } finally {
          JDBCUtilTwo.closeResources(connection,preparedStatement);
        }
    }
}
