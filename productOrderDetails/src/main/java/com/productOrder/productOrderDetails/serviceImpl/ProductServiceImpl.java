package com.productOrder.productOrderDetails.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.productOrder.productOrderDetails.Dto.ProductOrderDto;
import com.productOrder.productOrderDetails.ProductOrderRepository.ProductOrderRepository;
import com.productOrder.productOrderDetails.entity.ProductOrder;
import com.productOrder.productOrderDetails.exception.ResourceNotFoundException;
import com.productOrder.productOrderDetails.service.ProductService;
import com.productOrder.productOrderDetails.util.Constants;

/**
 * This is the service layer which holds business logic and configuration with
 * other services
 * @author 787089
 *
 */
@Component
public class ProductServiceImpl implements ProductService {

	private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	private ProductOrderRepository productOrderRepository;

	/**
	 * get list of Product Order
	 * @throws ResourceNotFoundException 
	 */
	@Cacheable(value = "productsCache")
	public List<ProductOrderDto> getProductOrder() throws ResourceNotFoundException {
		LOG.info("ProductServiceImpl getProductOrder");
		List<ProductOrderDto> productOrderDtoList = new ArrayList<ProductOrderDto>();
		List<ProductOrder> orderDetailsList = productOrderRepository.findAll();
		if(CollectionUtils.isEmpty(orderDetailsList)) {
			throw new ResourceNotFoundException(Constants.PRODUCT_NOT_FOUND);
		}else {
			orderDetailsList.forEach(productOrder -> {
				ProductOrderDto productOrderDto = new ProductOrderDto(productOrder.getId(), productOrder.getProductName(),
						productOrder.getModelName(), productOrder.getPrice());
				productOrderDtoList.add(productOrderDto);
			});
		}
		
		LOG.info("List of Prodcut details:{} ", productOrderDtoList);
		return productOrderDtoList;
	}

	/**
	 * get product order by id
	 * 
	 * @param productId
	 * @return
	 * @throws ResourceNotFoundException 
	 * 
	 * @Cacheable annotation adds the caching behaviour. If multiple requests are
	 *            received, then the method won't be repeatedly executed, instead,
	 *            the results are shared from cached storage.
	 */
	@Cacheable(value = "productsCache")
	public ProductOrder getProductById(int productId) throws ResourceNotFoundException {
		ProductOrder orderDetails = 
				productOrderRepository.findById((long) productId)
			                     .orElseThrow(() -> new  ResourceNotFoundException(Constants.PRODUCT_NOT_FOUND));
		return orderDetails;
		
		
	}

	/**
	 * create product order
	 * @throws Exception 
	 */
	public ProductOrderDto createProductOrder(ProductOrderDto productOrderDto) throws Exception {
		LOG.info("ProductServiceImpl createProductOrder");
		ProductOrder productOrder = new ProductOrder(productOrderDto.getId(), productOrderDto.getName(),
				productOrderDto.getModelName(), productOrderDto.getPrice());
		try {
			productOrderRepository.save(productOrder);
		}catch(Exception e) {
			throw new Exception(Constants.PRODUCT_NOT_SAVED+":"+e.getCause());
		}
		
		LOG.info("Product Order created:{} ", productOrder);
		return productOrderDto;
	}

	/**
	 * update product order
	 * 
	 * @CachePut annotation updates the cached value.
	 */
	@CachePut(value = "productsCache")
	public ProductOrderDto updateProductOrder(ProductOrderDto productOrderDto, Long id)
			throws ResourceNotFoundException {		
		LOG.info("ProductServiceImpl updateProductOrder");
		ProductOrderDto updatedProductOrderDto = new ProductOrderDto();	
		Optional<ProductOrder> productOrder = productOrderRepository.findById(id);
		if(productOrder.isPresent()) 
		{
			ProductOrder updatedProductOrder = productOrderRepository.save(new ProductOrder(id, productOrderDto.getName(),
					productOrderDto.getModelName(), productOrderDto.getPrice()));
			
			BeanUtils.copyProperties(updatedProductOrder, updatedProductOrderDto);
			
		}else {
			throw new ResourceNotFoundException(Constants.PRODUCT_NOT_FOUND);
		}	
		LOG.info("Product Order updated successfully:");
		return updatedProductOrderDto;

	}

	/**
	 * delete product order
	 * @return 
	 * @CacheEvict annotation removes one or all entries from cached storage.
	 *  <code>allEntries=true</code> attribute allows developers to purge all entries from the cache.
	 */
	@CacheEvict(value = "productsCache")
	public void deleteProductOrder(Long id) throws ResourceNotFoundException {	
		LOG.info("ProductServiceImpl deleteProductOrder");
		Optional<ProductOrder> productOrder = productOrderRepository.findById(id);
		if(productOrder.isPresent()) 
		{
			ProductOrder existingProductOrder = 	productOrder.get();
			productOrderRepository.delete(existingProductOrder);
			
		}else {
			throw new ResourceNotFoundException(Constants.PRODUCT_NOT_FOUND);
		}
		LOG.info("ProductServiceImpl deleted successfully");
		
	}


}
