package by.htp.les04.service;

import java.util.List;
import by.htp.les04.bean.News;

public interface NewsService {

	List <News> takeAll() throws ServiceException;

	News getOne(int id) throws ServiceException;

	void updateNews(int id, String title, String brief, String content) throws ServiceException;

	void deleteNews(int id) throws ServiceException;
}