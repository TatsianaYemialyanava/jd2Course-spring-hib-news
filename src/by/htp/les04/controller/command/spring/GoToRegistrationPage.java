package by.htp.les04.controller.command.spring;

import java.io.IOException;
import java.security.Principal;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.User;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class GoToRegistrationPage {

	@RequestMapping(params = {"command=registration"})
	public String execute(Model theModel, Principal principal) throws ServletException, IOException {
		User user = new User();
		theModel.addAttribute(USER, user);

		return REQUESTDISPATCHER_FROM_GO_TO_REGISTRATION_PAGE_TO_REGISTRATION;
	}
}
