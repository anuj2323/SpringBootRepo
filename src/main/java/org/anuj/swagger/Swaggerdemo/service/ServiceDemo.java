package org.anuj.swagger.Swaggerdemo.service;

import java.util.List;

import org.anuj.swagger.Swaggerdemo.Product;
import org.anuj.swagger.Swaggerdemo.repo.RepoDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceDemo {

	@Autowired
	RepoDemo rd;

	public List<Product> invokedao() {
		return rd.invokedao();
	}

	public void additem(Product p) {
		rd.add(p);
	}

	public void deleteitem(Product p) {
		rd.delete(p);
	}
}
