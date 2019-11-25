package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="product")
@Getter
@Setter
@SequenceGenerator(name="sequence",initialValue=1)
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
	private Integer productId;
	private String productName;

}
