package org.anuj.swagger.Swaggerdemo.Controller;

import org.anuj.swagger.Swaggerdemo.Product;
import org.anuj.swagger.Swaggerdemo.repo.RepoDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductLogin {

	@Autowired
	RepoDemo repo;

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

	@RequestMapping(value = "/getProduct", method = RequestMethod.GET)
	public String getProduct() {
		return "getProduct";
	}

	@RequestMapping(value = "/processaddproduct", method = RequestMethod.GET)
	public String ProcessAddProduct(@ModelAttribute("ob")Product product) {
		System.out.println(product.getId() + product.getName());
		repo.add(product);
		return "addSuccessful";
	}

	@RequestMapping(value = "/processdeleteproduct", method = RequestMethod.GET)
	public String ProcessDeleteProduct(@ModelAttribute Product product) {
		System.out.println(product.getId() + product.getName());
		repo.delete(product);
		return "deleteSuccessful";
	}

	@RequestMapping(value = "/processgetproduct", method = RequestMethod.GET)
	void ProcessGetProduct(@ModelAttribute Product product) {
		System.out.println(product.getId() + product.getName());
		repo.getItems();
	}
}
