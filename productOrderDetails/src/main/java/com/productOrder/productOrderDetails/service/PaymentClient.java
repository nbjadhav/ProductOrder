package com.productOrder.productOrderDetails.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productOrder.productOrderDetails.Dto.PaymentDto;

/**
 * FeignClient interface to communicate with dependent service
 * @author 787089
 *
 */
@FeignClient(name="payment" )
public interface PaymentClient {
	
	   @RequestMapping("/payment/getPaymentData")
	   List<PaymentDto> getPaymentData();	   

}
