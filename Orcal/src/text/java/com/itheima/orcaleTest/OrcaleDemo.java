package com.itheima.orcaleTest;

import oracle.jdbc.OracleTypes;
import org.junit.Test;

import java.sql.*;

public class OrcaleDemo {
    @Test
    public void javaCallOracle() throws Exception {
        //加载注册驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到Connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.186.10:1521:orcl",
                "itheima", "itheima");
        //得到预编译的Statement对象
        PreparedStatement ps = connection.prepareStatement("select * from emp where empno = ?");
        //给参数赋值
        ps.setObject(1,7788);
        //执行数据库查询操作
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            System.out.println(rs.getString("ename"));
        }
        //释放资源
        rs.close();
        ps.close();
        connection.close();
    }

    @Test
    public void javaCallFunction() throws Exception{
        //加载注册驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //得到Connection连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.186.10:1521:orcl",
                "itheima", "itheima");
        //得到预编译的Statement对象
        CallableStatement ps = connection.prepareCall("{? = call f_yearsal(?)}");
        //给参数赋值

        ps.setObject(2,7788);
        ps.registerOutParameter(1, OracleTypes.NUMBER);
        //执行数据库查询操作
        ps.execute();
        //输出结果
        System.out.println(ps.getObject(1));
        //释放资源
        ps.close();
        connection.close();
    }
}
