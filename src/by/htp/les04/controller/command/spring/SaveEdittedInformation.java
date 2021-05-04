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
import by.htp.les04.service.UserService;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;


@Controller
@RequestMapping("/Controller")
public class SaveEdittedInformation {
	
	@Autowired
	private NewsService newsService;
	
//@RequestMapping(params = {"action=nuovoprodotto","action=salvaprodotto"})
	
	//@RequestMapping(params = {"command=save_new_information"},{"id=" + news.getId()})
	public String execute(@ModelAttribute("News") News news, Model theModel) throws ServletException, IOException, ServiceException {

		/*if (CheckAuthorisationSession.redirectIfNotAuthorisated(request, response)) {
			return;
		}*/
		//&message=&id=

		//idString idStr = request.getParameter(ID_PARAM);
		int idNews = news.getId();
		String titleNews = news.getTitle();
		String briefNews = news.getBrief();
		String contentNews = news.getContent();
		
		/*News idNews = newsService.getOne(news.getId());
		int idInt = Integer.parseInt(idStr);
		String title = request.getParameter(TITLE_PARAM);
		String brief = request.getParameter(BRIEF_PARAM);
		String content = request.getParameter(CONTENT_PARAM);*/

		newsService.updateNews(idNews, titleNews, briefNews, contentNews);
		theModel.addAttribute("message", "news has been saved");
		return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_NEWS_PAGE + idNews;
	}
}
/*News singleNews = newsService.getOne(news.getId());
		if (singleNews == null) {
			theModel.addAttribute("message", "An error has occurred. Wait a while and try again");
			return REDIRECT_PREFIX + REDIRECT_TO_ERROR_PAGE;
		}
		theModel.addAttribute(SINGLE_NEWS_ATTRIBUTE, singleNews);
		return REQUESTDISPATCHER_FROM_GO_TO_FULL_NEWS_PAGE_TO_FUII_NEWS_PAGE;*/