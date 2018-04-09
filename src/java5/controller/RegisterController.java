package java5.controller;



import java.util.Date;

import org.hibernate.Criteria;
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

import java5.entity.KhachHang;
import java5.entity.TaiKhoan;

@Transactional
@Controller
public class RegisterController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String showRegister(ModelMap model) {
		model.addAttribute("khachhang",new KhachHang());
		return "register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(ModelMap model, @ModelAttribute("khachhang") KhachHang khachHang) {
		khachHang.setTrangthai(true);
		khachHang.getTaikhoan().setQuyen("khachhang");
		khachHang.getTaikhoan().setTrangthai("dakichhoat");
		khachHang.getTaikhoan().setNgaytao(new Date());
		khachHang.setNgaytao(new Date());
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(khachHang.getTaikhoan());
			Criteria cr = session.createCriteria(TaiKhoan.class);
			cr.add(Restrictions.eq("username", khachHang.getTaikhoan().getUsername()));
			TaiKhoan tk = (TaiKhoan)cr.uniqueResult();
			khachHang.setTaikhoan(tk);
			session.save(khachHang);
			t.commit();
			return "registerSuccess";
		}catch (Exception e){
			t.rollback();
			System.out.println(e.getMessage());
			model.addAttribute("message", "Đăng ký tài khoản thất bại!");
		}finally {
			session.close();
		}
		return "register";
	}
}
