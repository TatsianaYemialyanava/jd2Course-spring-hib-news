package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.les04.bean.News;
import by.htp.les04.controller.CheckAuthorisationSession;
import by.htp.les04.controller.command.Command;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.ServiceProvider;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class DeleteNews {

	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=delete_news"})
	public String execute(@ModelAttribute("id") News news, Model theModel) throws ServletException, IOException, ServiceException {

		/*if (CheckAuthorisationSession.redirectIfNotAuthorisated(request, response)) {
			return;
		}*/
		
		newsService.deleteNews(news.getId());
		
		theModel.addAttribute("message","News was deleted");

		return REDIRECT_PREFIX + REDIRECT_FROM_DELETE_NEWS_TO_MAIN_PAGE;


	}
}
