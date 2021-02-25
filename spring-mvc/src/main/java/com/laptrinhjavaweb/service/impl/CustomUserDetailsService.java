package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.dto.MyUser;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;

// Đây là nơi kiểm tra tài khoản và mật khẩu coi có tồn tại ko
@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);
		if(userEntity == null) {
			 throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for(RoleEntity role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		//Put thông tin vào security duy trì thông tin đó khi user login vào hệ thống 
		MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(), true, true, true, true, authorities);
		//Vì lí do phương thức trên ko thể lấy đc tên đầy đủ trong csdl, chỉ lấy đc username và password.
		//Nên phải tạo một class tên "MyUser" bên package dto và sẽ lưu các giá trị. Sau đó bên này sẽ gọi đến và sử dụng
		//rồi từ đó có thể lấy đc hết các thuộc tính muốn lấy trong csdl đó.
		myUser.setFullName(userEntity.getFullName());; 
		return myUser;
	}

}
