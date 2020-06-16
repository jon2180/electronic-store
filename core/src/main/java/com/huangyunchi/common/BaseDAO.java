package com.huangyunchi.common;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

public class BaseDAO {

    /**
     * 创建一个集合类，用于加载配置文件
     */
    private static final Properties props = new Properties();

    private final static Logger logger = Logger.getLogger(BaseDAO.class.getName());

    protected final Logger log = Logger.getLogger(getClass().getName());

    /**
     * 数据源对象
     */
    private static DataSource dds = null;
    protected static QueryRunner qr;

    static {
        try {
            InputStream is = Thread.currentThread()
                    .getContextClassLoader()
                    .getResourceAsStream("dbconfig.properties");
            props.load(is);
            // 根据配置文件来创建一个Druid连接池
            dds = DruidDataSourceFactory.createDataSource(props);
            qr = new QueryRunner(dds);
        } catch (IOException e) {
            logger.severe("加载数据库配置文件失败！请检查");
            e.printStackTrace();
        } catch (Exception e) {
            logger.severe("创建连接池失败！");
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库的一个连接对象
     *
     * @return Connection 连接对象
     * @throws SQLException 出现连接获取问题
     */
    public static Connection getConnection() throws SQLException {
        return dds.getConnection();
    }

    public static DataSource getDataSource() {
        return dds;
    }

    public static QueryRunner getQr() {
        return qr;
    }
}
