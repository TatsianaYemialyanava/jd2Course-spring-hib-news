package by.htp.les04.controller.command.spring;



import static by.htp.les04.controller.command.spring.ControllerLevelConstant.NEWS_ATTRIBUTE;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import by.htp.les04.bean.News;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.ServiceProvider;



@Controller
@RequestMapping("/Controller")
public class GoToIndexPage {
	
	@Autowired
	private NewsService newsService;

	@RequestMapping(params = {"command=gotoindexpage"})
	public String execute(Model theModel) throws ServiceException {
		
		List<News> news = newsService.takeAll();

		theModel.addAttribute("news", news);

		return REQUESTDISPATCHER_FROM_GO_TO_INDEX_PAGE_TO_MAIN_INDEX;

	}
}
