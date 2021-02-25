package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

//bên DTO sẽ đổ dữ liệu lấy từ database vô entity
@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewConverter newConverter;

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> models = new ArrayList<>();
		// Khai báo một danh sách bên dto để đổ dữ liệu được lấy bên entities vô.

		List<NewEntity> entities = newRepository.findAll(pageable).getContent();//
		// Lấy dữ liệu vào danh sách entities. Hàm findAll dc springMVC cung cấp sẵn nên
		// ko cần viết tay giống bên JBDC

		for (NewEntity item : entities) {// Sử dụng vòng lặp để đưa dữ liệu vô DTO
			NewDTO newDTO = newConverter.toDTO(item);
			models.add(newDTO);
		}
		return models;
	}

	@Override
	public int getTotalItem() {
		return (int) newRepository.count();// Đếm tổng số item dc lấy từ database.
	}

	@Override
	public NewDTO findById(long id) {
		NewEntity entity = newRepository.findOne(id);
		return newConverter.toDTO(entity);
	}

	/*
	 * Vì lí do khi ta thực hiện các thao tác xuống csdl thì nó sẽ dc đưa vào 1
	 * transaction để xử lí. Nếu như ko bị lỗi thì sẽ là commit Còn nếu bị lỗi thì
	 * sẽ là rollback. Để sử dụng dc các tính năng này một cách tự động và ko cần
	 * viết hàm như bên JDBC thì phải khai báo dòng "@Transactional" trước các
	 * phương thức thao tác với csdl
	 */
	/*
	 * @Override
	 * 
	 * @Transactional public NewDTO insert(NewDTO newDTO) { CategoryEntity category
	 * = categoryRepository.findOneByCode(newDTO.getCategoryCode()); NewEntity
	 * newEntity = newConverter.toEntity(newDTO); newEntity.setCategory(category);
	 * 
	 * Hàm save này dc JpaRepository cung cấp sẵn. Nó sẽ tự tìm xem coi có id hay
	 * ko. Nếu ko có id nó tự động hiểu là thêm mới còn nếu có id nó tự động hiểu là
	 * cập nhật
	 * 
	 * return newConverter.toDTO(newRepository.save(newEntity)); }
	 * 
	 * @Override
	 * 
	 * @Transactional public NewDTO unpdate(NewDTO dto) { NewEntity oldNew =
	 * newRepository.findOne(dto.getId()); CategoryEntity category =
	 * categoryRepository.findOneByCode(dto.getCategoryCode());
	 * oldNew.setCategory(category); NewEntity updateNew =
	 * newConverter.toEntity(oldNew, dto); return
	 * newConverter.toDTO(newRepository.save(updateNew)); }
	 */
	
	//Dùng chung cho cả cập nhật và thêm mới
	@Override
	@Transactional
	public NewDTO save(NewDTO dto) {
		CategoryEntity category = categoryRepository.findOneByCode(dto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if (dto.getId() != null) {
			NewEntity oldNew = newRepository.findOne(dto.getId());//Cập nhật tin tức
			oldNew.setCategory(category);
			newEntity = newConverter.toEntity(oldNew, dto);
		} else {
			newEntity = newConverter.toEntity(dto); //Thêm mới tin tức
			newEntity.setCategory(category);
		}
		return newConverter.toDTO(newRepository.save(newEntity));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id:ids) {
			newRepository.delete(id); //Xóa
		}	
	}
}
