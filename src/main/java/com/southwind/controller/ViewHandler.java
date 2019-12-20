package com.southwind.controller;



import java.util.HashMap;
import java.util.Map;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.tomcat.util.net.ApplicationBufferHandler;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;

import com.southwind.entity.Adress;
import com.southwind.entity.User;
/**
 * 
 * @author FreeLeaf
 *
 */

/**
 * 对于 ViewHandler 中的所有业务方法，只要向 request 中添加了 key = "user"、key = "address" 的对象时，
 * Spring MVC 会自动将该数据添加到 session 中，保存 key 不变。
 * 对于 ViewHandler 中的所有业务方法，只要向 request 中添加了数据类型是 User 、Address 的对象时，
 * Spring MVC 会自动将该数据添加到 session 中，保存 key 不变。
 */
@Controller
@RequestMapping("/view")
//@SessionAttributes(value = {"user","address"})
//@SessionAttributes(types = {User.class,Adress.class})//通过类型去添加
public class ViewHandler {
	@RequestMapping("/map")
		public String map(Map<String, User> map) {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		map.put("user", user);
			return "view";
		}
	
	@RequestMapping("/model")
	public String model(Model model) {
	User user = new User();
	user.setId(1L);
	user.setName("撒是");
	Adress adress = new Adress();
	adress.setValue("sn西安十三点");
	model.addAttribute("user", user);
	model.addAttribute("adress", adress);
		return "view";
	}
	
	@RequestMapping("/application")
	public String application(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		application.setAttribute("user", user);
		return "view";
	}
	@RequestMapping("/request")
	public String Request(HttpServletRequest request) {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		request.setAttribute("user", user);
		return "view";
	}
	//无论什么方法之前，会先走这个方法，定义一个方法，该方法专门用来返回要填充到没戏数据中的对象
//	@ModelAttribute
	public User getUser() {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		return user;
	}
	
	@RequestMapping("/session")
	public String Session(HttpServletRequest request) {
		HttpSession session= request.getSession();
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		session.setAttribute("user", user);
		return "view";
	}
	
	@RequestMapping("/session2")
	public String Session(HttpSession session) {
		
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		return "view";
	}
	
	@RequestMapping("/modelAttribute")
	public String modelAttribute() {
		return "view";
	}
	@RequestMapping("/modelandview")
	public ModelAndView modelAndView(ModelAndView modelAndView) {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		
		modelAndView.setViewName("view");
		modelAndView.addObject(user);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/modelandview2")
	public ModelAndView modelAndView2(ModelAndView modelAndView) {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		View view = new InternalResourceView("/view.jsp");
		modelAndView.setView(view);
		modelAndView.addObject(user);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/modelandview3")
	public ModelAndView modelAndView3() {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		ModelAndView modelAndView = new ModelAndView("view");
		modelAndView.addObject(user);
		System.out.println(modelAndView);
		return modelAndView;
	}
	@RequestMapping("/modelandview4")
	public ModelAndView modelAndView4() {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		View view = new InternalResourceView("/view.jsp");
		ModelAndView andView = new ModelAndView(view);
		andView.addObject("user", user);
		System.out.println(andView);
		return andView;
	}
	@RequestMapping("/modelandview5")
	public ModelAndView modelAndView5() {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		Map<String, User> map = new HashMap<>();
		map.put("user",user);
		ModelAndView modelAndView = new ModelAndView("view",map);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/modelandview6")
	public ModelAndView modelAndView6() {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		View view = new InternalResourceView("/view.jsp");
		
		Map<String, User> map = new HashMap<>();
		map.put("user",user);
		ModelAndView modelAndView = new ModelAndView(view,map);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/modelandview7")
	public ModelAndView modelAndView7() {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		ModelAndView modelAndView = new ModelAndView("view","user",user);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/modelandview8")
	public ModelAndView modelAndView8() {
		User user = new User();
		user.setId(1L);
		user.setName("撒是");
		View view = new InternalResourceView("/view.jsp");
		ModelAndView modelAndView = new ModelAndView(view,"user",user);
		System.out.println(modelAndView);
		return modelAndView;
	}
}
