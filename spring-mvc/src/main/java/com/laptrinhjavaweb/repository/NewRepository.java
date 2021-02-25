package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> { 
	// Ở đây truyền vào 2 tham số: Entity nào sẽ làm việc, Kiểu dữ liệu của khóa chính ở entity đó
	
}
