package by.htp.les04.controller.command.impl;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.htp.les04.bean.News;
import by.htp.les04.controller.CheckAuthorisationSession;
import by.htp.les04.controller.command.Command;
import by.htp.les04.service.NewsService;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.ServiceProvider;
import static by.htp.les04.controller.command.impl.ControllerLevelConstant.*;

public class GoToMainPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServiceException {

		if (CheckAuthorisationSession.redirectIfNotAuthorisated(request, response)) {
			return;
		}

		ServiceProvider provider = ServiceProvider.getInstance();
		NewsService newsService = provider.getNewsService();


		List<News> news = newsService.takeAll();

		request.setAttribute(NEWS_ATTRIBUTE, news);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(REQUESTDISPATCHER_FROM_GO_TO_MAIN_PAGE_TO_MAIN);
		requestDispatcher.forward(request, response);

	}
}
