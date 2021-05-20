package by.htp.les04.dao.impl;

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

@Repository
@Transactional()
public class SQLNewsDAO implements NewsDAO  {

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
		Session currentSession = sessionFactory.getCurrentSession();
		News theNews = currentSession.get(News.class, id);
		return theNews;
	}

	@Override
	public void updateNews(int id, String title, String brief, String content) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		News theNews = new News();
		theNews.setId(id);
		theNews.setTitle(title);
		theNews.setBrief(brief);
		theNews.setContent(content);
		theNews.setDate(java.time.LocalDateTime.now());
		theNews.setStatus("active");
		currentSession.saveOrUpdate(theNews);
	}

	@Override
	public void deleteNews(int id) throws DAOException {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("update News set status = 'not active' where id=:newsId");
		theQuery.setParameter("newsId", id);
		theQuery.executeUpdate();		
	}
}
