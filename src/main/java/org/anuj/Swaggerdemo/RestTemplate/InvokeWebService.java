package org.anuj.Swaggerdemo.RestTemplate;

import org.anuj.swagger.Swaggerdemo.Product;
import org.springframework.web.client.RestTemplate;

public class InvokeWebService {

	public static Product[] getProduct(){
		final String uri="http://localhost:8080/getitems";
		RestTemplate restTemplate = new RestTemplate();
		Product[]result=restTemplate.getForObject(uri, Product[].class);
		return result;
		
	}
}
