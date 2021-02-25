package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.laptrinhjavaweb.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> { 
	UserEntity findOneByUserNameAndStatus(String name, int status); // Câu lệnh trả về tên người đăng nhập và trang thái của tk còn hoạt động hay ko
}

