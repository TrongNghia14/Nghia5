package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import com.laptrinhjavaweb.dto.NewDTO;



public interface INewService {
	List<NewDTO> findAll(Pageable pageable);
	int getTotalItem(); 
	NewDTO findById(long id);

	/*
	 * NewDTO insert(NewDTO dto);//Thêm mới bài viết NewDTO unpdate(NewDTO
	 * updateNew);//Cập nhật bài viết
	 */	
	NewDTO save(NewDTO dto);//Cái này dùng chung cho cả 2 cái cập nhật và thêm mới
	void delete(long[] ids);
}
