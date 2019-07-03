package com.productOrder.productOrderDetails.controller;


import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.productOrder.productOrderDetails.Dto.ProductOrderDto;
import com.productOrder.productOrderDetails.serviceImpl.ProductServiceImpl;

import reactor.core.publisher.Flux;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductOrderControllerTest {

	@InjectMocks
	private ProductOrderController productOrderController;
	@Mock
	private ProductServiceImpl productService;
	
	private ProductOrderDto productOrderDto;
	
	@Before
	public void setup() {
		productOrderDto=new ProductOrderDto();
		productOrderDto.setId(1);
		productOrderDto.setModelName("HP Laptop");
		productOrderDto.setName("Pavillon");
		productOrderDto.setPrice(1000);
		
	}
	
	@Test
	public void testGetProductOrderDetails() throws Exception{
		List<ProductOrderDto> list = new ArrayList<ProductOrderDto>();		
		Mockito.when(productService.getProductOrder()).thenReturn(list);
		Flux<ResponseEntity<List<ProductOrderDto>>>productOrderDto = productOrderController.getProductOrderDetails();
		assertNotNull(productOrderDto);
	}
}
