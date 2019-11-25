package com.hcl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.UserOrder;

@Repository
public interface UserOrderRepository extends JpaRepository<UserOrder, Integer> {

	List<UserOrder> findByUserId(Integer userId);

}
