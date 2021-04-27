package by.htp.les04.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import by.htp.les04.bean.News;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.NewsDAO;
import by.htp.les04.dao.connectionPool.MYSQLDriverLoader;
import by.htp.les04.dao.connectionPool.Pool;

import static by.htp.les04.dao.impl.DAOLevelConstant.*;

@Repository
@Transactional()
public class SQLNewsDAO implements NewsDAO  {
	
	static {
		MYSQLDriverLoader.getInstance();
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<News> all() throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<News> theQuery = currentSession.createQuery("from News where status = 'active'", News.class);

		List<News> news = theQuery.getResultList();
				
		return news;
	}
	
	

	@Override
	public News getOne(int id) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		News result = null;

		try {
			con = Pool.getConnection();
			st = con.createStatement();
			String query = String.format(TAKE_ONE_NEWS_TEMPLATE, id);
			rs = st.executeQuery(query);


			while(rs.next()) {
				int idFromDB = rs.getInt(ID_PARAM);
				String title = rs.getString(TITLE);
				String brief = rs.getString(BRIEF);
				String content = rs.getString(CONTENT);
				Date date = rs.getDate(DATE);
				result = new News(idFromDB, title, brief, content, date.toLocalDate());

			}

		}catch (SQLException e) {
			throw new DAOException("one news not received: DB error", e);
		}finally {
				if(con != null) {
					Pool.returnConnection(con);
				}
		}

		return result;
	}
	
	@Override
	public void updateNews(int id, String title, String brief, String content) throws DAOException {
		Connection con = null;
		Statement st = null;

		try {
			con = Pool.getConnection();
			st = con.createStatement();
			String updateNews = String.format(UPDATE_NEWS_TEMPLATE, title, brief, content, id);
			st.executeUpdate(updateNews);
			
		}catch (SQLException e) {
			throw new DAOException("can't update the news: DB error", e);
		}finally {
				if(con != null) {
					Pool.returnConnection(con);
				}
		}
	}

	@Override
	public void deleteNews(int id) throws DAOException {
		Connection con = null;
		Statement st = null;
				
		try {
			con = Pool.getConnection();
			st = con.createStatement();
			String query = String.format(DELETE_NEWS_TEMPLATE, id);
			st.executeUpdate(query);
			
		}catch (SQLException e) {
			throw new DAOException("can't delete the news: DB error", e);
		}finally {
				if(con != null) {
					Pool.returnConnection(con);
				}
		}
		
	}
}
