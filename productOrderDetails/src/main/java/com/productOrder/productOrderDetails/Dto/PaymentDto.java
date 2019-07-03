package com.productOrder.productOrderDetails.Dto;

import javax.validation.constraints.NotNull;

/**
 * Payment DTO class used by the Services layer in an N-Tier application to
 * transfer data between itself and the UI layer
 * 
 * @author 787089
 *
 */
public class PaymentDto {

	@NotNull(message = "Payment Id may not be null")
	public long paymentId;

	@NotNull(message = "Payment Type may not be null")
	public String paymentType;

	@NotNull(message = "Payment Amount may not be null")
	public long paymentAmt;

	public PaymentDto() {
	}

	public PaymentDto(long id, String paymentType, long paymentAmt) {
		this.setPaymentId(id);
		this.setPaymentType(paymentType);
		this.setPaymentAmt(paymentAmt);
	}

	/**
	 * 
	 * @return paymentId
	 */
	public long getPaymentId() {
		return paymentId;
	}

	/**
	 * 
	 * @param paymentId
	 */
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * 
	 * @return paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * 
	 * @param paymentType
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * 
	 * @return paymentAmt
	 */
	public long getPaymentAmt() {
		return paymentAmt;
	}

	/**
	 * 
	 * @param paymentAmt
	 */
	public void setPaymentAmt(long paymentAmt) {
		this.paymentAmt = paymentAmt;
	}

	@Override
	public String toString() {
		return "PaymentDto [paymentId=" + paymentId + ", paymentType=" + paymentType + ", paymentAmt=" + paymentAmt
				+ "]";
	}

}
