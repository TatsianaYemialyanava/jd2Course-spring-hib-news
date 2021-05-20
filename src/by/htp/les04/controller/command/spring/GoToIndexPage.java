package by.htp.les04.controller.command.spring;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.News;
import by.htp.les04.bean.User;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToIndexPage {
	
	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=gotoindexpage"})
	public String execute(Model theModel, Principal principal) throws ServiceException {
		
		List<News> news = newsService.takeAll();

		theModel.addAttribute(NEWS_ATTRIBUTE, news);
		
		User user = new User();
		
		theModel.addAttribute(USER, user);
		
		return REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX;
	}
}
