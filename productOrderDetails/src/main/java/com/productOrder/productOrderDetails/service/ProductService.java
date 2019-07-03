package com.productOrder.productOrderDetails.service;

import java.util.List;

import com.productOrder.productOrderDetails.Dto.ProductOrderDto;
import com.productOrder.productOrderDetails.exception.ResourceNotFoundException;

/**
 * This is the service layer which holds business logic and configuration with
 * other services
 * @author 787089
 *
 */
public interface ProductService {
	public List<ProductOrderDto> getProductOrder() throws ResourceNotFoundException;
	public ProductOrderDto createProductOrder(ProductOrderDto productOrderDto) throws Exception;
	public ProductOrderDto updateProductOrder(ProductOrderDto productOrderDto, Long id) throws ResourceNotFoundException;
	public void deleteProductOrder(Long id) throws ResourceNotFoundException;
	
}
