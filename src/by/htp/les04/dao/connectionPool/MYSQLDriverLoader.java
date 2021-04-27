package by.htp.les04.dao.connectionPool;

import by.htp.les04.dao.DBDriverLoadingException;
import static by.htp.les04.dao.impl.DAOLevelConstant.*;

public class MYSQLDriverLoader {
	
	private static final MYSQLDriverLoader instance = new MYSQLDriverLoader();
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		}catch (ClassNotFoundException e) {
			throw new DBDriverLoadingException("Driver not found", e);
		}
	}
	
	private MYSQLDriverLoader() {}
	
	public static MYSQLDriverLoader getInstance() {
		return instance;
	}
}
