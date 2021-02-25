package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

@RestController(value = "newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newService;//
	
	
	@PostMapping("/api/new") //Khai báo: POST(thêm mới), PUT(cập nhật), DELETE(xóa), GET(lấy dữ liệu) 
	public NewDTO createNew(@RequestBody NewDTO newDTO) {		
		return newService.save(newDTO);//Hàm save xử lí đã dc tạo ở bên NewService để tạo mới
	}
	
	@PutMapping("/api/new") 
	public NewDTO updateNew(@RequestBody NewDTO updateNew) {		
		return newService.save(updateNew);//Hàm save xử lí đã dc tạo ở bên NewService để cập nhật 
	}
	
	@DeleteMapping("/api/new") 
	public void deleteNew(@RequestBody long[] ids) {		
		newService.delete(ids);
	}
}
