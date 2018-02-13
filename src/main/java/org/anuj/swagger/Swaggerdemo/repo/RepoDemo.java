package org.anuj.swagger.Swaggerdemo.repo;

import java.util.ArrayList;
import java.util.List;

import org.anuj.swagger.Swaggerdemo.Product;
import org.springframework.stereotype.Repository;

@Repository
public class RepoDemo {
	ArrayList<Product> al = new ArrayList<Product>();

	public List<Product> getItems() {
		return al;
	}

	public void add(Product p) {
		al.add(p);
	}

	public void delete(Product p) {
		String check = p.getName();
		/*for (Product p1 : al) {
			if (p1.getName() == check) {
				al.remove(p1);
			}
		}*/
		al.stream().filter((a)-> a.getName().equals(check)).forEach((a)-> al.remove(a));
	}
}