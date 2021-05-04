package by.htp.les04.controller.command.spring;

import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import by.htp.les04.bean.User;
import by.htp.les04.service.ServiceException;
import by.htp.les04.service.UserService;

import static by.htp.les04.controller.command.spring.ControllerLevelConstant.*;

@Controller
@RequestMapping("/Controller")
public class SaveNewUser {

	@Autowired
	private UserService userService;

	@RequestMapping(params = {"command=savenewuser"})
	public String execute(@ModelAttribute("User") User user, Model theModel) throws ServletException, IOException, ServiceException {
		try {

			/*User userInfo = new User();
			userInfo.setName(formData.getName());
			userInfo.setSurname(formData.getSurname());
			userInfo.setEmail(formData.getEmail());
			userInfo.setLogin(formData.getLogin());
			userInfo.setPassword(formData.getPassword());*/

			System.out.println(user.toString());

			userService.createUser(user);
			//theModel.addAttribute("user", new User());
			theModel.addAttribute("message", "Registration completed successfully");
			return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_NEW_USER_TO_GO_TO_INDEX_PAGE;
		} catch (ServiceException e) {
			theModel.addAttribute("message", e.getMessage());
			return REDIRECT_PREFIX + REDIRECT_FROM_SAVE_NEW_USER_TO_REGISTRATION_PAGE;	
		}
	}
}

/*@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		// save the customer using our service
		customerService.saveCustomer(theCustomer);	
		
		return "redirect:/customer/list";
	}*/
