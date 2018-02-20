package org.anuj.swagger.Swaggerdemo.Controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.anuj.Swaggerdemo.RestTemplate.InvokeWebService;
import org.anuj.swagger.Swaggerdemo.Product;
import org.anuj.swagger.Swaggerdemo.service.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductLogin {

	@Autowired
	ServiceDemo sd;

	@RequestMapping(value = "/productpage", method = RequestMethod.GET)
	public String Productinfo() {
		System.out.println("Inside Controller");
		return "login";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.GET)
	public String addProduct() {
		return "addProduct";
	}

	@RequestMapping(value = "/deleteProduct", method = RequestMethod.GET)
	public String deleteProduct() {
		return "deleteProduct";
	}

	/*
	 * @RequestMapping(value = "/getProduct", method = RequestMethod.GET) public
	 * String getProduct() { return "getProduct"; }
	 */

	@RequestMapping(value = "/processaddproduct", method = RequestMethod.GET)
	public String ProcessAddProduct(@ModelAttribute("ob") Product product) {
		System.out.println(product.getId() + product.getName());
		sd.additem(product);
		return "addSuccessful";
	}

	@RequestMapping(value = "/processdeleteproduct", method = RequestMethod.GET)
	public String ProcessDeleteProduct(@ModelAttribute("ob") Product product) {
		System.out.println(product.getId() + product.getName());
		sd.deleteitem(product);
		return "deleteSuccessful";
	}

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public ModelAndView ProcessGetProduct() {
		Product[] p = InvokeWebService.getProduct();
		List<Product> l = Arrays.asList(p);
		System.out.println(l.get(0).getId());
		ModelAndView mv = new ModelAndView("GetProduct");
		mv.addObject("item", l);
		return mv;
	}
}
