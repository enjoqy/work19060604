package org.junhi.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 1. 声明静态数据源成员变量
 * 2. 创建连接池对象
 * 3. 定义公有的得到数据源的方法
 * 4. 定义得到连接对象的方法
 * 5. 定义关闭资源的方法
 *
 * @Author junhi
 * @Date 2019/5/29 16:47
 */
public class JDBCUtils {

    /**
     * 1. 声明静态数据源成员变量
     */
    private static DataSource dataSource;
    private static PreparedStatement preparedStatement;


    static {
        // 加载配置文件中的数据
        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
            // 创建连接池，使用配置文件中的参数
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 3. 定义公有的得到数据源的方法
     *
     * @return
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 4. 定义得到连接对象的方法
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    /**
     * 5. 定义关闭资源的方法
     */
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 5. 重载定义关闭资源的方法
     *
     * @param connection
     * @param preparedStatement
     */
    public static void close(Connection connection, PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 增删改的公共方法,返回影响的行数
     *
     * @param sql
     * @param obj
     * @return
     */
    public static Integer update(String sql, Object[] obj) {
        Integer i = 0;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);
            //循环赋值
            for (int j = 0; j < obj.length; j++) {
                preparedStatement.setObject(j + 1, obj[j]);
            }
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(connection, preparedStatement);
        }
        return i;
    }

}
