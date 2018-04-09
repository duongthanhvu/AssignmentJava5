package java5.controller;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java5.entity.SanPham;

@Transactional
@Controller
public class ProductController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping("/product")
	public String product(ModelMap model) {
		Session session = factory.getCurrentSession();
		Criteria cr = session.createCriteria(SanPham.class);
		cr.add(Restrictions.eq("trangthai", true));
		List<SanPham> list = cr.list();
		model.addAttribute("sanpham",list);
		return "product";
	}
	
	@RequestMapping("/{productURL}")
	public String producDetail(ModelMap model, @PathVariable("productURL") String productURL) {
		Session session = factory.getCurrentSession();
		Criteria cr = session.createCriteria(SanPham.class);
		cr.add(Restrictions.eq("url", productURL));
		cr.add(Restrictions.eq("trangthai", true));
		SanPham sp = (SanPham)cr.uniqueResult();
		if(sp != null) {
			model.addAttribute("sanpham",sp);
			return "product-detail";
		}else {
			return "404";
		}
	}

}
