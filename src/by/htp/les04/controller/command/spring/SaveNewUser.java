package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.User;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;
import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/AnonymousController")
public class SaveNewUser {

	@Autowired
	private UserService userService;

	@RequestMapping(params = {"command=savenewuser"})
	public String execute(@ModelAttribute("User") User user, Model theModel) throws ServletException, IOException, ServiceException {
		try {

			System.out.println(user.toString());

			userService.createUser(user);
			theModel.addAttribute(MESSAGE, "Registration completed successfully");
			return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE;
		} catch (ServiceException e) {
			theModel.addAttribute(MESSAGE, e.getMessage());
			return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE;	
		}
	}
}

