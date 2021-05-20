package by.htp.les04.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import by.htp.les04.bean.News;
import by.htp.les04.dao.DAOException;
import by.htp.les04.dao.NewsDAO;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDAO newsDAO;

	@Override
	public List<News> takeAll() throws ServiceException {

		List<News> news;

		try {
			news = newsDAO.all();
		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return news;
	}

	@Override
	public News getOne(int id) throws ServiceException {

		News oneNews = null;

		try {
			oneNews = newsDAO.getOne(id);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
		return oneNews;
	}

	@Override
	public void updateNews(int id, String title, String brief, String content) throws ServiceException {

		try {
			newsDAO.updateNews(id, title, brief, content);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}	
	}

	@Override
	public void deleteNews(int id) throws ServiceException {

		try {
			newsDAO.deleteNews(id);

		}catch(DAOException e) {
			throw new ServiceException(e.getMessage(), e);
		}
	}
}
