package com.productOrder.productOrderDetails.Dto;

import javax.validation.constraints.NotNull;

/**
 * ProductOrder DTO class used by the Services layer in an N-Tier application to
 * transfer data between itself and the UI layer
 * @author 787089
 *
 */
public class ProductOrderDto {
	
	@NotNull(message = "product Id may not be null")
	private long id;
	
	@NotNull(message = "name may not be null")
	private String name;
	
	@NotNull(message = "modelName may not be null")
	private String modelName;
	
	@NotNull(message = "price may not be null")
	private long  price;
	
	public ProductOrderDto() {		
	}
	
	public ProductOrderDto(long id, String name, String modelName, long price) {
		this.id = id;
		this.name = name;
		this.modelName = modelName;
		this.price = price;
	}

	/**
	 * 
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return modelName
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * 
	 * @return price
	 */
	public long getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductOrderDto [id=" + id + ", name=" + name + ", modelName=" + modelName + ", price=" + price + "]";
	}		

}
