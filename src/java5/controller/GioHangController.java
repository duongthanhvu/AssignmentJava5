package java5.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java5.entity.SanPham;

@Transactional
@Controller 
public class GioHangController {
	@Autowired
	SessionFactory factory;
	
	@RequestMapping(value="/addtocart", method=RequestMethod.POST)
	@ResponseBody
	public String addToCart(@RequestParam("url") String url,
			@RequestParam("soluong") Integer soluong,
			HttpServletResponse response,
			@CookieValue(value="giohang", required=false) String giohang) {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(SanPham.class);
		url = url.substring(0, url.lastIndexOf('.')); //cắt bỏ đuôi html
		cr.add(Restrictions.eq("url", url));
		SanPham sp = (SanPham)cr.uniqueResult();
		if(sp != null) {
			giohang = ghiDataVaoJSON(String.valueOf(sp.getSanpham_id()), soluong, giohang);
			System.out.println(giohang);
			Cookie ck = new Cookie("giohang", giohang);
			response.addCookie(ck);
			session.close();
			return "success";
		}else {
			session.close();
			return "error";
		}
	}
	
	private String ghiDataVaoJSON(String id, Integer soluong, String cookie) {
		try {
			JSONObject jsonObject;
			if(cookie == null || cookie.equals("")) {
				jsonObject = new JSONObject();
			}else {
				jsonObject = new JSONObject(cookie);
			}
			if(jsonObject.has(id)) {
				Integer value = jsonObject.getInt(id);
				soluong = soluong + value;
				System.out.println("soluong="+soluong);
				jsonObject.put(id, soluong);
				return jsonObject.toString();
			}else {
				jsonObject.put(id, soluong);
				return jsonObject.toString();
			}
		}catch(JSONException e) {
			System.out.println(e.getMessage());
			return cookie;
		}
	}
	
	@RequestMapping(value="/cart",method=RequestMethod.GET)
	public String showCart(@CookieValue(value="giohang", required=false) String giohang, ModelMap model) {
		Map<Integer,Integer> thongtingiohang = layDataTuJSON(giohang);
		if(thongtingiohang == null) {
			model.addAttribute("message","empty");
			return "cart";
		}
		Iterator it = thongtingiohang.entrySet().iterator();
		Map<SanPham,Integer> dssp = new HashMap<>();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        Integer key = (Integer) pair.getKey();
	        SanPham sp = layTTSP(key);
	        dssp.put(sp, (Integer)pair.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	    model.addAttribute("message","available");
		model.addAttribute("giohang",dssp);
		return "cart";
	}
	
	private Map<Integer,Integer> layDataTuJSON(String cookie){
		JSONObject jsonObject;
		if(cookie == null || cookie.equals("")) {
			return null;
		}else {
			jsonObject = new JSONObject(cookie);
		}
		Iterator<?> keys = jsonObject.keys();
		Map<Integer,Integer> map = new HashMap<>();
		while( keys.hasNext() ) {
		    String key = (String)keys.next();
		    Integer value = (Integer) jsonObject.get(key);
		    map.put(Integer.parseInt(key), value);
		}
		return map;
	}
	
	private SanPham layTTSP(Integer id) {
		Session session = factory.openSession();
		Criteria cr = session.createCriteria(SanPham.class);
		cr.add(Restrictions.eq("sanpham_id", id));
		SanPham sp = (SanPham)cr.uniqueResult();
		session.close();
		return sp;
	}
}
