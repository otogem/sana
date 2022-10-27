package my.Sana.Controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ServiceController {
	@RequestMapping(value="/service/selogin",method = RequestMethod.GET)
	public String login() {
		return "/service/selogin";
	}
}
