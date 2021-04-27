package by.htp.les04.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import by.htp.les04.bean.User;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.UserDAO;
import by.htp.les04.dao.connectionPool.MYSQLDriverLoader;
import by.htp.les04.dao.connectionPool.Pool;

import static by.htp.les04.dao.impl.DAOLevelConstant.*;

public class SQLUserDAO implements UserDAO {

	static {
		MYSQLDriverLoader.getInstance();
	}

	@Override
	public User authorization(String login, String password) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		User user = null;
		try {
			con = Pool.getConnection();
			st = con.createStatement();
			String queryAuthorization = String.format(AUTORIZATION_USER_TEMPLATE, login, password);
			rs = st.executeQuery(queryAuthorization);
			while(rs.next()) {
				user = new User();
				user.setName(rs.getString(USER_NAME));
				user.setSurname(rs.getString(USER_SURNAME));
				user.setLogin(rs.getString(USER_LOGIN));
				user.setEmail(rs.getString(USER_EMAIL));
				user.setRole(rs.getString(USER_ROLE));
			}
		}catch (SQLException e) {
			throw new DAOException("Can't authorize user: DB error", e);
		}finally {
			if(con != null) {
				Pool.returnConnection(con);
			}
		}
		return user;
	}

	@Override
	public void createUser(User userInfo) throws DAOException {
		Connection con = null;
		Statement st = null;

		try {
			con = Pool.getConnection();
			st = con.createStatement();
			String queryCreateUser = String.format(CREATE_USER_TEMPLATE, userInfo.getName(), userInfo.getSurname(), userInfo.getEmail(), userInfo.getLogin(),
					userInfo.getPassword());
			st.executeUpdate(queryCreateUser);   

		}catch (SQLException e) {
			throw new DAOException("can't create recording about user", e);
		}finally {
			if(con != null) {
				Pool.returnConnection(con);
			}
		}

	}

}
