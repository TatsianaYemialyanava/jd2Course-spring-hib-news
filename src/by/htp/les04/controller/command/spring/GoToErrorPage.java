package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.service.ServiceException;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class GoToErrorPage {

	@RequestMapping(params = {"command=go_to_error_page"})
	public String execute(Model theModel) throws ServletException, IOException, ServiceException {
		
		// ?theModel.addAttribute("message", e.Throwable);
		
		
		return REQUESTDISPATCHER_FROM_GO_TO_ERROR_PAGE_TO_ERROR_PAGE;
	}
}
