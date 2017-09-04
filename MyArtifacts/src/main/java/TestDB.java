import java.sql.*;

public class TestDB {
    public static void main(String args[]) {
        String jdbcDriver = "com.mysql.jdbc.Driver";
        String jdbcURLs = "jdbc:mysql://127.0.0.1:3306/test?user=root&password=!QAZ2wsx&useUnicode=true&characterEncoding=utf-8";
        String sql = "";
        Connection conn = null;
        try {
            Class.forName(jdbcDriver);
            System.out.println("JDBC驱动程序加载成功");
            //conn = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassword);
            conn = DriverManager.getConnection(jdbcURLs);
            System.out.println("数据库连接成功");

            Statement stmt = conn.createStatement();
//            sql = "CREATE TABLE user (" +
//                    "    usrID INT PRIMARY KEY auto_increment," +
//                    "    account VARCHAR(20)," +
//                    "    password VARCHAR(20)," +
//                    "    fullname VARCHAR(20)" +
//                    ")engine=Innodb default charset utf8 collate utf8_general_ci;";
//            stmt.execute(sql);
//            System.out.println("数据表创建成功");
            sql = "insert into user (`account`,`password`,`fullname`) values ('zhangs','123','张三');";
            stmt.execute(sql);
            sql = "insert into user (`account`,`password`,`fullname`) values ('lis','123','李四')";
            stmt.execute(sql);
            System.out.println("数据插入成功");
            sql = "select * from user";
            ResultSet rset = stmt.executeQuery(sql);
            System.out.println("数据列表如下：");
            while (rset.next()) {
                System.out.println(rset.getInt("usrID") + ", "
                        + rset.getString("account") + ", "
                        + rset.getString("fullname"));
            }
            System.out.println("数据表查询成功");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC驱动程序加载失败，可能原因之一是找不到有关的库文件。");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL异常，相关语句是" + sql);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();        // 关闭连接的语句必须写在finally语句块中
                } catch (SQLException e) {
                    System.out.println("数据库关闭异常。");
                    e.printStackTrace();
                }
            }
        }
    }
}
