package by.htp.les04.dao;

import java.util.List;
import by.htp.les04.bean.News;

public interface NewsDAO {

	List<News> all() throws DAOException;

	News getOne(int id) throws DAOException;

	void updateNews(int id, String title, String brief, String content) throws DAOException;

	void deleteNews(int id) throws DAOException;
}
