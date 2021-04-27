package by.htp.les04.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.les04.controller.command.impl.DeleteNews;
import by.htp.les04.controller.command.impl.GoToEditPage;
import by.htp.les04.controller.command.impl.GoToErrorPage;
import by.htp.les04.controller.command.impl.GoToFullNewsPage;
import by.htp.les04.controller.command.impl.GoToIndexPage;
import by.htp.les04.controller.command.impl.GoToMainPage;
import by.htp.les04.controller.command.impl.GoToRegistrationPage;
import by.htp.les04.controller.command.impl.Localization;
import by.htp.les04.controller.command.impl.Logination;
import by.htp.les04.controller.command.impl.Logout;
import by.htp.les04.controller.command.impl.SaveEdittedInformation;
import by.htp.les04.controller.command.impl.SaveNewUser;

public class CommandProvider {
	private Map <CommandName, Command> commands = new HashMap<>();
	
	public CommandProvider() {
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new GoToRegistrationPage());
		commands.put(CommandName.SAVENEWUSER, new SaveNewUser());
		commands.put(CommandName.GOTOINDEXPAGE, new GoToIndexPage());
		commands.put(CommandName.GOTOMAINPAGE, new GoToMainPage());
		commands.put(CommandName.LOGOUT, new Logout());
		commands.put(CommandName.GO_TO_FULL_NEWS_PAGE, new GoToFullNewsPage());
		commands.put(CommandName.GO_TO_EDIT_PAGE, new GoToEditPage());
		commands.put(CommandName.SAVE_NEW_INFORMATION, new SaveEdittedInformation());
		commands.put(CommandName.LOCALIZATION, new Localization());
		commands.put(CommandName.DELETE_NEWS, new DeleteNews());
		commands.put(CommandName.GO_TO_ERROR_PAGE, new GoToErrorPage());
	}
	
	public Command takeCommand(String name) {
		CommandName commandName;
		
		commandName = CommandName.valueOf(name.toUpperCase());
		return commands.get(commandName);
	}
	

}
