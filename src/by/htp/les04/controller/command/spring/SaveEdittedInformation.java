package by.htp.les04.controller.command.spring;

import java.io.IOException;
import java.security.Principal;
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
@RequestMapping("/AdminController")
public class SaveEdittedInformation {

	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=save_new_information"})
	public String execute(@ModelAttribute("singleNews") News news, Model theModel, Principal principal) throws ServletException, IOException, ServiceException {

		int idNews = news.getId();
		String titleNews = news.getTitle();
		String briefNews = news.getBrief();
		String contentNews = news.getContent();

		newsService.updateNews(idNews, titleNews, briefNews, contentNews);
		theModel.addAttribute(MESSAGE, "news has been saved");
		return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_EDDITED_INFORMATION_TO_GO_TO_FULL_NEWS_PAGE + idNews;
	}
}
