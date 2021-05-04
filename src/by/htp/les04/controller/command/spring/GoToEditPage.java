package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.News;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;


import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class GoToEditPage {

	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=go_to_edit_page"})
	public String execute(@ModelAttribute("News") News news, Model theModel) throws ServletException, IOException, ServiceException {

		/*if (CheckAuthorisationSession.redirectIfNotAuthorisated(request, response)) {
			return;
		}*/
		
		//News singleNews = newsService.getOne(news.getId());

		//String idStr = request.getParameter(ID_PARAM);
		//int idInt = Integer.parseInt(idStr);
		News singleNews = newsService.getOne(news.getId());
		if (singleNews == null) {
			theModel.addAttribute("message", "An error has occurred. Wait a while and try again");
			return REDIRECT_PREFIX + REDIRECT_TO_ERROR_PAGE;
		}
		
		
		
		
		theModel.addAttribute(SINGLE_NEWS_ATTRIBUTE, singleNews);
		return REQUESTDISPATCHER_FROM_GO_TO_EDIT_PAGE_TO_EDIT_PAGE;
		
	}
}
/*News singleNews = newsService.getOne(news.getId());
		if (singleNews == null) {
			theModel.addAttribute("message", "An error has occurred. Wait a while and try again");
			return REDIRECT_PREFIX + REDIRECT_TO_ERROR_PAGE;
		}
		theModel.addAttribute(SINGLE_NEWS_ATTRIBUTE, singleNews);
		return REQUESTDISPATCHER_FROM_GO_TO_FULL_NEWS_PAGE_TO_FUII_NEWS_PAGE;*/
