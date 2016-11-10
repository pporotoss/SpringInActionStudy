package spittr.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import spittr.Spitter;
import spittr.data.SpitterRepository;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private static final Logger logger = LoggerFactory.getLogger(SpitterController.class);

	
	private SpitterRepository spitterRepository;
	@Autowired
	public SpitterController(SpitterRepository spitterRepository) {
		this.spitterRepository = spitterRepository;
	}
	
	public SpitterController() {
	}


	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new Spitter());
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegistration(HttpServletRequest request, @RequestPart("profilePicture") Part profilePicture, @Valid Spitter spitter, BindingResult errors) throws IOException {
		String path = request.getServletContext().getRealPath("/");
		logger.debug("processRegistration...");
		logger.debug("path : {}",path);
		profilePicture.write("/data/spittr/"+profilePicture.getSubmittedFileName());
		
		if(errors.hasErrors()) {	// Spitter 검증 오류가 나면,
			logger.debug(""+errors.getFieldError());
			return "registerForm";
		}
		logger.debug("username {}", spitter.getUsername());
		spitterRepository.save(spitter);
		return "redirect:/spitter/"+spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(@PathVariable("username") String username, Model model) {
		Spitter spitter = spitterRepository.findByUsername(username);
		model.addAttribute("spitter", spitter);
		return "profile";
	}
}
