package com.productOrder.productOrderDetails.ProductOrderRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.productOrder.productOrderDetails.entity.ProductOrder;

/**
 * ProductOrderRepository to perform database related operations
 * @author 787089
 *
 */
@Repository
@Transactional
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>{
}
