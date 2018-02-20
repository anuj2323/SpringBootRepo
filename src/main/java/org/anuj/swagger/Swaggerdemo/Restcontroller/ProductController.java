package org.anuj.swagger.Swaggerdemo.Restcontroller;

import java.util.List;

import org.anuj.swagger.Swaggerdemo.Product;
import org.anuj.swagger.Swaggerdemo.service.ServiceDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "onlinestore", description = "Operations pertaining to products in Online Store")
@RestController
public class ProductController {

	@Autowired
	ServiceDemo sd;

	@ApiOperation(value = "View a list of products", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 501, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/getitems", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return sd.invokedao();
	}

	@ApiOperation(value = "Add a list of products")
	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	public void add(@RequestBody Product p) {
		sd.additem(p);
	}

	@ApiOperation(value = "Delete a list of products")
	@RequestMapping(value = "/deleteProducts", method = RequestMethod.POST)
	public void delete(@RequestBody Product p) {
		sd.deleteitem(p);
	}
}
