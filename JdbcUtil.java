package in.ineuron.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.catalina.startup.HostConfig;
import org.apache.tomcat.dbcp.dbcp2.datasources.SharedPoolDataSource;



public class JdbcUtil {

	private JdbcUtil() {
	}

	static {
		// Step1: loading and register the Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	public static Connection getJdbcConnection() throws SQLException, IOException {

		String fileLoc = "C:\\Users\\AJAY YADAV\\Desktop\\krishna\\projectClasses\\MVCCRUDAPP\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		HostConfig config = new HostConfig();
		SharedPoolDataSource dataSource = new SharedPoolDataSource();

		return dataSource.getConnection();
	}

	@SuppressWarnings("unused")
	private static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		String fileLoc = "D:\\octbatchservletpgms\\JDBCCRUDAPP\\src\\main\\java\\in\\ineuron\\properties\\application.properties";
		FileInputStream fis = new FileInputStream(fileLoc);
		Properties properties = new Properties();
		properties.load(fis);

		String url = properties.getProperty("jdbcUrl");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");

		return DriverManager.getConnection(url, username, password);
	}

}
