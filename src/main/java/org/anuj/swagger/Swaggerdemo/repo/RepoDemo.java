package org.anuj.swagger.Swaggerdemo.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.anuj.Swaggerdemo.RestTemplate.InvokeWebService;
import org.anuj.swagger.Swaggerdemo.Product;
import org.springframework.stereotype.Repository;

@Repository
public class RepoDemo {

	ArrayList<Product> al = new ArrayList<Product>();

	public List<Product> invokedao() {
		return al;
	}

	public void add(Product p) {
		al.add(p);
	}

	public void delete(Product p) {
		String check = p.getName();
		al = (ArrayList<Product>) al.stream().filter((a) -> !a.getName().equals(check)).collect(Collectors.toList());
		al.forEach((a) -> System.out.println(a));
	}
}