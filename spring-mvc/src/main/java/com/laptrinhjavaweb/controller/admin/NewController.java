package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.util.MessageUtil;

@Controller(value = "newControllerOfAdmin")
public class NewController {
	
	@Autowired private INewService newService; 
	
	@Autowired private ICategoryService categoryService;
	
	@Autowired private MessageUtil messageUntil;
	
	@RequestMapping(value = "/quan-tri/bai-viet/danh-sach", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page,  //Dùng để lấy giá trị param trên thanh url . Lấy giá trị page hiện tại đang đứng
								 @RequestParam("limit") int limit,  // Lấy giá trị giới hạn item ở mỗi page
								 HttpServletRequest request) {
		/*
		 * NewDTO model = new NewDTO(); model.setPage(page); // Sử dụng các hàm spring
		 * mvc đã cung cấp model.setLimit(limit); // Sử dụng các hàm spring mvc đã cung
		 * cấp ModelAndView mav = new ModelAndView("admin/new/list");
		 * 
		 * Pageable pageable = new PageRequest(page - 1, limit); // Sử dụng các hàm
		 * spring mvc đã cung cấp model.setListResult(newService.findAll(pageable));
		 * 
		 * model.setTotalItem(newService.getTotalItem()); model.setTotalPage((int)
		 * Math.ceil((double) model.getTotalItem()/model.getLimit()));//Đếm tổng số
		 * trang
		 * 
		 * mav.addObject("model", model); return mav;
		 */
		NewDTO model = new NewDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/new/list");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(newService.findAll(pageable));
		model.setTotalItem(newService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		
		if(request.getParameter("message") != null) {
			/*
			 * if(request.getParameter("message").equals("update_success")) {
			 * mav.addObject("message", "Update success"); mav.addObject("alert",
			 * "success"); }else
			 * if(request.getParameter("message").equals("insert_success")) {
			 * mav.addObject("message", "Insert success"); mav.addObject("alert",
			 * "success"); }else if(request.getParameter("message").equals("error_system")){
			 * mav.addObject("message", "Error system"); mav.addObject("alert", "danger"); }
			 */
			Map<String, String> message = messageUntil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		
		return mav;
	}
	
	
	
	//Phương thức url này sẽ sử dụng chung cho cả việc thêm và update
	@RequestMapping(value = "/quan-tri/bai-viet/chinh-sua", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		//Lấy id cho việc cần cập nhật dữ liệu, nếu là thêm mới thì ko cần id, vì vậy ta cần khai báo "required = false" để nếu id là null thì web ko bị lỗi
		ModelAndView mav = new ModelAndView("admin/new/edit");
		NewDTO model = new NewDTO();
		if(id != null) {
			model = newService.findById(id);
		}
		
		//Sử dụng để truyền thông tin dến client thông báo coi cập nhật, thêm mới thành công hay thất bại
		if(request.getParameter("message") != null) {
			/*
			 * if(request.getParameter("message").equals("update_success")) {
			 * mav.addObject("message", "Update success"); mav.addObject("alert",
			 * "success"); }else
			 * if(request.getParameter("message").equals("insert_success")) {
			 * mav.addObject("message", "Insert success"); mav.addObject("alert",
			 * "success"); }else if(request.getParameter("message").equals("error_system")){
			 * mav.addObject("message", "Error system"); mav.addObject("alert", "danger"); }
			 */
			//Rút ngắn
			Map<String, String> message = messageUntil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		
		mav.addObject("categories", categoryService.findAll()); //categories sẽ giúp ben giao diện load lên các thể loại của bài báo
		mav.addObject("model", model); //model này sẽ dc đẩy ra view để bên giao diện sử dụng lấy data
		return mav;
	}
}
