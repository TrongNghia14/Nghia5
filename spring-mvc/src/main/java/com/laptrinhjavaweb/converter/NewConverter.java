package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component // Khai báo khái niệm để các class khác có thể nhúng và sử dụng class này
public class NewConverter {
	public NewDTO toDTO(NewEntity entity) {//Sừ dụng để convert data từ entity qua DTO
		NewDTO result = new NewDTO();
		result.setId(entity.getId());
		result.setTitle(entity.getTitle());
		result.setShortDescription(entity.getShortDesription());
		result.setContent(entity.getContent());
		result.setThumbnail(entity.getThumbnail());
		result.setCategoryCode(entity.getCategory().getCode());
		return result;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity result = new NewEntity();
		result.setTitle(dto.getTitle());
		result.setShortDesription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
	
	//Sử dụng để update
	public NewEntity toEntity(NewEntity result, NewDTO dto) {
		result.setTitle(dto.getTitle());
		result.setShortDesription(dto.getShortDescription());
		result.setContent(dto.getContent());
		result.setThumbnail(dto.getThumbnail());
		return result;
	}
}
