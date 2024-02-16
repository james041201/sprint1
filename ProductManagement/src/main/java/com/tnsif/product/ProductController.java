package com.tnsif.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	ProductRepository repo;
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product)
	{
		return repo.save(product);
	}
	
	@GetMapping("/product")
	public List<Product> getProduct ()
	{
		return  (List<Product>) repo.findAll();
	}
	@DeleteMapping("/product/{id}")
	public void deletePoduct(@PathVariable Integer id)
	{
		repo.deleteById(id);
	}
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable Integer id, @RequestBody Product product)
	{
		product.setId(id);
		return repo.save(product);
	}
}
