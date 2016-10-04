package com.matteo.tonnicchi.appleorange.home;

import static com.matteo.tonnicchi.appleorange.support.web.Message.MESSAGE_ATTRIBUTE;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matteo.tonnicchi.appleorange.support.web.Message;
import com.matteo.tonnicchi.appleorange.support.web.MessageHelper;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Principal principal) {
		if(principal == null){
			return new ModelAndView("home/homeNotSignedIn");
		}

		ProductForm productForm = new ProductForm();
		productForm.setProductEntries(
			productService.getAll().stream()
				.map(this::createEmptyProductEntry)
				.collect(Collectors.toList())
		);
		
		return new ModelAndView("home/homeSignedIn" , "productForm", productForm);
	}
	
	@RequestMapping(value = "/calculateprice", method = RequestMethod.POST)
	public String calculatePrice(
			Principal principal,
			@Valid @ModelAttribute ProductForm productForm,
			Errors errors,
			RedirectAttributes ra) {
		if (errors.hasErrors()) {
			return "redirect:/";
		}
		BigDecimal price = productService.calculatePrice(productForm.getProductEntries());
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
		ra.addFlashAttribute("result", new Message("price.result", Message.Type.INFO, price.doubleValue()));
        return "redirect:/";
	}
	
	private ProductFormEntry createEmptyProductEntry (Product product){
		return new ProductFormEntry(product.getCode(), product.getName(), 0);
	}
}
