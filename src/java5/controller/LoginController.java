package java5.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

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

import java5.entity.TaiKhoan;

@Transactional
@Controller
public class LoginController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLogin(ModelMap model) {
		model.addAttribute("taikhoan",new TaiKhoan());
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(ModelMap model, @ModelAttribute("taikhoan") TaiKhoan taiKhoan, HttpServletResponse response) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		try {
			Criteria cr = session.createCriteria(TaiKhoan.class);
			cr.add(Restrictions.or(Restrictions.eq("email", taiKhoan.getUsername()), Restrictions.eq("username", taiKhoan.getUsername())));
			TaiKhoan tk = (TaiKhoan)cr.uniqueResult();
			if(tk == null) {
				model.addAttribute("message", "Email hoặc tên đăng nhập không tồn tại!");
				return "login";
			}
			if(tk.getPassword().equals(taiKhoan.getPassword())) {
				t.commit();
				Cookie c1 = new Cookie("username", tk.getUsername());
				c1.setMaxAge(1000000);
				response.addCookie(c1);
				Cookie c2 = new Cookie("quyen", tk.getQuyen());
				c2.setMaxAge(1000000);
				response.addCookie(c2);
				return "redirect:index.html";
			}else {
				model.addAttribute("message","Mật khẩu không đúng!");
				return "login";
			}
		}catch (Exception e){
			t.rollback();
			System.out.println(e.getMessage());
			model.addAttribute("message", "Lỗi đăng nhập!");
		}finally {
			session.close();
		}
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletResponse response) {
		Cookie c1 = new Cookie("username", "");
		c1.setMaxAge(0);
		response.addCookie(c1);
		Cookie c2 = new Cookie("quyen", "");
		c2.setMaxAge(0);
		response.addCookie(c2);
		return "redirect:index.html";
	}
}
