package test.app.controller;

import java.security.Principal;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MyController implements ErrorController {
	
	@GetMapping(path="/")
	public ModelAndView home (Principal principal) {
		ModelAndView model = new ModelAndView("index");
		model.addObject("userName", principal.getName());
		return model;
	}
	
	@GetMapping(path="/api/admin", produces={"text/plain"})
	public @ResponseBody String getApplicationFamily () {
		try {
			return "Welcome Admin!!";
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@GetMapping(path="/error")
	public ModelAndView error (Principal principal) {
		ModelAndView model = new ModelAndView("error");
		model.addObject("userName", principal.getName());
		return model;
	}
	
}
