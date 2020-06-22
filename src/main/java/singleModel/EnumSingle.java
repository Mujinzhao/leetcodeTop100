package singleModel;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @ClassName EnumSingle
 * @Author zhangxinkun
 * @Date 2020/3/18  3:03 PM
 * @Version 1.0
 */
public enum  EnumSingle {
    INSTANCE;

    private DataSource dataSource;
    private EnumSingle(){

        //初始化单例的内容，添加dataSource的配置内容
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
