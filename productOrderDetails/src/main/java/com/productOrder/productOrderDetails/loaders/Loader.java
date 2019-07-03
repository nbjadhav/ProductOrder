package com.productOrder.productOrderDetails.loaders;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.productOrder.productOrderDetails.ProductOrderRepository.ProductOrderRepository;
import com.productOrder.productOrderDetails.entity.ProductOrder;

/**
 * Loader class for initialization
 * @author 787089
 *
 */
@Component
public class Loader {

	@Autowired
	private ProductOrderRepository productOrderRepository;
	
	/**
	 * It is called after the bean is initialized.
	 */
	@PostConstruct
	public void load() {
		ProductOrder productOrder=new ProductOrder((long) 23, "HP Desktop", "HP", 232);
		productOrderRepository.save(productOrder);
	}	
}
