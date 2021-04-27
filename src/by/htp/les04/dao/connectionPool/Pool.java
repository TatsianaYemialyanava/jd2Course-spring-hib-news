package by.htp.les04.dao.connectionPool;

import static by.htp.les04.dao.impl.DAOLevelConstant.PASSWORD;
import static by.htp.les04.dao.impl.DAOLevelConstant.URL;
import static by.htp.les04.dao.impl.DAOLevelConstant.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import by.htp.les04.dao.DAOException;

public class Pool {
	public static final int POOL_MAXIMUM = 5;
	
	private static final  Semaphore available = new Semaphore (POOL_MAXIMUM, true);
	private static List<Connection> connections = new ArrayList<Connection>();
	
	static  {
		MYSQLDriverLoader.getInstance();
		for(int i = 0; i < POOL_MAXIMUM; i++) {
			try {
				connections.add(DriverManager.getConnection(URL, USER, PASSWORD));
			} catch (SQLException e) {  
				throw new RuntimeException("ACHTUNG!", e);
			}
		}
	}
	
	public static synchronized Connection getConnection() throws DAOException { 
		try {
			available.acquire();
		} catch (InterruptedException e) {
			throw new DAOException("Action with connection was interrapted", e);
		}
		return connections.remove(0);
	}
	
	public static synchronized void returnConnection (Connection connection) {
		available.release();
		connections.add(connection);
	}
	
	

}
