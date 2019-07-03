package com.productOrder.productOrderDetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class represents a business object in a persistent storage mechanism
 * @author 787089
 *
 */
@Entity
@Table(name = "product_order")
public class ProductOrder {
	
	/**
	 * represents product Id
	 */
	@Id
    @GeneratedValue
    @Column(name = "ID")
	 private Long id;
	
	/**
	 * represents product name
	 */
    @Column(name = "Product_Name")
    private String ProductName;
    
    /**
     * represents model name
     */
    @Column(name = "Model_Name")
    private String ModelName;
    
    /**
     * represents product price
     */
    @Column(name = "Price")
    private long price;
    
    public ProductOrder() 
    {		
	}
    
    /**
     * parameterizd constructor for ProductOrder Entity
     * @param id
     * @param productName
     * @param modelName
     * @param price
     */
	public ProductOrder(Long id, String productName, String modelName, long price) {
		this.id = id;
		ProductName = productName;
		ModelName = modelName;
		this.price = price;
	}
	
	/**
	 * 
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return ProductName
	 */
	public String getProductName() {
		return ProductName;
	}
	
	/**
	 * 
	 * @param productName
	 */
	public void setProductName(String productName) {
		ProductName = productName;
	}
	
	/**
	 * 
	 * @return ModelName
	 */
	public String getModelName() {
		return ModelName;
	}
	
	/**
	 * 
	 * @param modelName
	 */
	public void setModelName(String modelName) {
		ModelName = modelName;
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
		return "ProductOrder [id=" + id + ", ProductName=" + ProductName + ", ModelName=" + ModelName + ", price="
				+ price + "]";
	}    

}
