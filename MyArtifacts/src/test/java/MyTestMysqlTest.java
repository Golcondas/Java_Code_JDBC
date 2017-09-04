import static org.junit.Assert.*;

public class MyTestMysqlTest {
    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.Test
    public void sayHello() throws Exception {
        MyTestMysql myTestMysql=new MyTestMysql();
        System.out.println( myTestMysql.SayHello());
    }

}