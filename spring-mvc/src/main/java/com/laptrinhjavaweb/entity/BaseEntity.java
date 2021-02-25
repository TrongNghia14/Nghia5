package com.laptrinhjavaweb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass // Định nghĩa cái này để khi các entity khác kế thừa thì có thể sử dụng đc
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity { // Phải là lớp trừu tượng để các class con kế thừa

	@Id // đây là cột id và có giá trị not null khi dc tạo bên database
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Tự động tăng giá trị cho id
	private Long id;
	
	@Column(name = "createddate" )
	@CreatedDate // Phương  thức này đc JPA cung cấp sẵn
	private Date createdDate;
	
	@Column(name = "modifieddate" )
	@LastModifiedDate // Phương  thức này đc JPA cung cấp sẵn
	private Date modifiedDate;
	
	@Column(name = "createdby")
	@CreatedBy // Phương  thức này đc JPA cung cấp sẵn
	private String createdBy;
	
	@Column(name = "modifiedby")
	@LastModifiedBy // Phương  thức này đc JPA cung cấp sẵn
	private String modifiedBy;

	
	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public Long getId() {
		return id;
	}
	
	
}
