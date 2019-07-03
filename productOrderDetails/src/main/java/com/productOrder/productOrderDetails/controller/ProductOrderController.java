package com.productOrder.productOrderDetails.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productOrder.productOrderDetails.Dto.PaymentDto;
import com.productOrder.productOrderDetails.Dto.ProductOrderDto;
import com.productOrder.productOrderDetails.exception.ResourceNotFoundException;
import com.productOrder.productOrderDetails.service.PaymentClient;
import com.productOrder.productOrderDetails.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This is a rest controller class. An Entry point for an api which holds all
 * the ProductOrder API end point
 * @author 787089
 *
 */
@EnableResourceServer
@RestController
public class ProductOrderController extends ResourceServerConfigurerAdapter
{
	private static final Logger LOG = LoggerFactory.getLogger(ProductOrderController.class);

	@Autowired
	private ProductService productservice;	
	 
	@Autowired
	private PaymentClient paymentClient;
	
	/**
	 * Method to fetch product order details
	 * @return
	 * @throws Exception 
	 */
	@GetMapping(value="/v1/getProductOrderDetails")	
	@ResponseBody
	public Flux<ResponseEntity<List<ProductOrderDto>>> getProductOrderDetails() throws Exception{
		LOG.info("Inside ProductOrderController getProductOrderDetails");
		return Flux.just(
				new ResponseEntity<List<ProductOrderDto>>(productservice.getProductOrder(),HttpStatus.OK));
	}
	
	/**
	 * Method to create product order
	 * @param productOrderDto
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value="/v1/createProductOrderDetails")		
	public Flux<ResponseEntity<ProductOrderDto>> createProductOrderDetails(@RequestBody ProductOrderDto productOrderDto) throws Exception
	{	
		LOG.info("Inside ProductOrderController createProductOrderDetails method");
		return Flux.just(
				new ResponseEntity<ProductOrderDto>(productservice.createProductOrder(productOrderDto),HttpStatus.OK));
	}
	
	/**
	 * Method to update product on the basis of product id.
	 * @param productOrderDto
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PutMapping(value="/v1/putProductOrderDetails/{id}")
	public Flux<ResponseEntity<ProductOrderDto>> updateProductOrderDetails(@Valid @RequestBody ProductOrderDto productOrderDto,@PathVariable(value= "id") Long id) throws ResourceNotFoundException
	{	
		LOG.info("Inside ProductOrderController updateProductOrderDetails method");
		return Flux.just(new ResponseEntity<ProductOrderDto>(productservice.updateProductOrder(productOrderDto,id), HttpStatus.OK) );		
	}
	
	/**
	 * Method to delete product on the basis of product id.
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@DeleteMapping("v1/productOrder/{id}")
	public Mono<ResponseEntity<Void>> deleteProdcutOrder(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {		
		LOG.info("Inside deleteProdcutOrder deleteProdcutOrder method");
		productservice.deleteProductOrder(id);
        return (Mono.just(new ResponseEntity<Void>(HttpStatus.OK)));
                
	}

	/**
	 * get payment details from payment service of giver order
	 * 
	 * @return
	 */
	
	  @GetMapping (value="/v1/getOrderPaymentDetails")
	  public List<PaymentDto> getPaymentDetails() { 
		  List<PaymentDto> response = paymentClient.getPaymentData(); 
		  return response; 
		  }
	 
	 
    
	@Override
	 public void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests().antMatchers("/oauth/token", "/oauth/authorize**",
	  "/v1/createProductOrderDetails") .permitAll(); //.anyRequest().authenticated();
	  http.requestMatchers().antMatchers("/v1/getProductOrderDetails").and().
	  authorizeRequests()
	  .antMatchers("/v1/getProductOrderDetails").access("hasRole('USER')").and().
	  requestMatchers()
	  .antMatchers("/v1/putProductOrderDetails/{id}").and().authorizeRequests()
	  .antMatchers("/v1/putProductOrderDetails/{id}").access("hasRole('ADMIN')"); }
	 

}
