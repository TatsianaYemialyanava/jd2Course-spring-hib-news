package by.htp.les04.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.htp.les04.bean.News;
import by.htp.les04.bean.User;
import by.htp.les04.bean.UserLoginationInfo;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.UserDAO;
import by.htp.les04.dao.connectionPool.MYSQLDriverLoader;
import by.htp.les04.dao.connectionPool.Pool;
import static by.htp.les04.dao.impl.DAOLevelConstant.*;

@Repository
@Transactional()
public class SQLUserDAO implements UserDAO {

	static {
		MYSQLDriverLoader.getInstance();
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User authorization(String login, String password) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("from User where login = '" + login + "' and password = '" + password + "'", User.class);
		User user = new User(); 
		user =(User) theQuery.getSingleResult();
		return user;
	}
		
		/*currentSession
		
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
/*@Override
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
	}*/
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
