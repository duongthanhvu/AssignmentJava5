package java5.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java5.entity.SanPham;

@Transactional
@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	SessionFactory factory;
	@Autowired
	ServletContext context;
	
	@RequestMapping(value="/addproduct",method=RequestMethod.GET)
	public String addProduct(ModelMap model) {
		model.addAttribute("sanpham", new SanPham());
		return "admin/addproduct";
	}
	
	@RequestMapping(value="/addproduct",method=RequestMethod.POST)
	public String addProduct(ModelMap model,
			@ModelAttribute("sanpham") SanPham sanPham,
			@RequestParam("photo") MultipartFile photo) {
		if(photo.isEmpty()) {
			model.addAttribute("message","Vui lòng chọn ảnh của sản phẩm!");
			return "admin/addproduct";
		}
		//Lưu ảnh vào thư mục web
		try {
			String photoPath = context.getRealPath("/images/products/"+photo.getOriginalFilename());
			photo.transferTo(new File(photoPath));
		}catch(Exception e) {
			System.out.println(e.getMessage());
			model.addAttribute("message","Lỗi lưu file !");
			return "admin/addproduct";
		}
		//Lưu thông tin sanpham vào CSDL
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		sanPham.setAnh(photo.getOriginalFilename());
		sanPham.setChietkhau(0);
		sanPham.setTrangthai(true);
		sanPham.setUrl("dia-chi-cua-san-pham");
		try {
			session.save(sanPham);
			t.commit();
		}catch (Exception e){
			t.rollback();
			System.out.println(e.getMessage());
			model.addAttribute("message","Lỗi thêm dữ liệu!");
			return "admin/addproduct";
		}finally {
			session.close();
		}
		return "admin/product";
	}
	
	@RequestMapping("/product")
	public String showProductList(ModelMap model) {
		Session session = factory.getCurrentSession();
		Criteria cr = session.createCriteria(SanPham.class);
		cr.add(Restrictions.eq("trangthai", true));
		List<SanPham> list = cr.list();
		model.addAttribute("sanpham",list);
		return "admin/productlist";
	}
	
	@RequestMapping("/delete")
	public String deleteProduct(@RequestParam("id") Integer id) {
		Session session = factory.getCurrentSession();
		Criteria cr = session.createCriteria(SanPham.class);
		cr.add(Restrictions.eq("sanpham_id", id));
		SanPham sp = (SanPham) cr.uniqueResult();
		sp.setTrangthai(false);
		session.update(sp);
		return "redirect:product.html";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String updateProduct(ModelMap model, @RequestParam("id") Integer id) {
		Session session = factory.getCurrentSession();
		Criteria cr = session.createCriteria(SanPham.class);
		cr.add(Restrictions.eq("sanpham_id", id));
		SanPham sp = (SanPham) cr.uniqueResult();
		model.addAttribute("sanpham",sp);
		model.addAttribute("anhGoc",sp.getAnh());
		return "admin/updateproduct";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String updateProduct(ModelMap model,
			@ModelAttribute("sanpham") SanPham sanpham,
			@RequestParam("photo") MultipartFile photo,
			@ModelAttribute("anhGoc") String anhGoc) {
		if(photo.isEmpty()) {
			sanpham.setAnh(anhGoc);
		}else {
			//Lưu ảnh vào thư mục web
			try {
				String photoPath = context.getRealPath("/images/products/"+photo.getOriginalFilename());
				photo.transferTo(new File(photoPath));
				sanpham.setAnh(photo.getOriginalFilename());
			}catch(Exception e) {
				System.out.println(e.getMessage());
				model.addAttribute("message","Lỗi lưu file !");
				return "admin/updateproduct";
			}
		}
		//Lưu thông tin sanpham vào CSDL
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.update(sanpham);
			t.commit();
		}catch (Exception e){
			t.rollback();
			System.out.println(e.getMessage());
			model.addAttribute("message","Lỗi sửa dữ liệu!");
			return "admin/updateproduct";
		}finally {
			session.close();
		}
		return "redirect:product.html";
	}

}
