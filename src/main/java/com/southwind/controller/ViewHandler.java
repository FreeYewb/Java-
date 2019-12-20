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
 * ���� ViewHandler �е�����ҵ�񷽷���ֻҪ�� request ������� key = "user"��key = "address" �Ķ���ʱ��
 * Spring MVC ���Զ�����������ӵ� session �У����� key ���䡣
 * ���� ViewHandler �е�����ҵ�񷽷���ֻҪ�� request ����������������� User ��Address �Ķ���ʱ��
 * Spring MVC ���Զ�����������ӵ� session �У����� key ���䡣
 */
@Controller
@RequestMapping("/view")
//@SessionAttributes(value = {"user","address"})
//@SessionAttributes(types = {User.class,Adress.class})//ͨ������ȥ���
public class ViewHandler {
	@RequestMapping("/map")
		public String map(Map<String, User> map) {
		User user = new User();
		user.setId(1L);
		user.setName("����");
		map.put("user", user);
			return "view";
		}
	
	@RequestMapping("/model")
	public String model(Model model) {
	User user = new User();
	user.setId(1L);
	user.setName("����");
	Adress adress = new Adress();
	adress.setValue("sn����ʮ����");
	model.addAttribute("user", user);
	model.addAttribute("adress", adress);
		return "view";
	}
	
	@RequestMapping("/application")
	public String application(HttpServletRequest request) {
		ServletContext application = request.getServletContext();
		User user = new User();
		user.setId(1L);
		user.setName("����");
		application.setAttribute("user", user);
		return "view";
	}
	@RequestMapping("/request")
	public String Request(HttpServletRequest request) {
		User user = new User();
		user.setId(1L);
		user.setName("����");
		request.setAttribute("user", user);
		return "view";
	}
	//����ʲô����֮ǰ���������������������һ���������÷���ר����������Ҫ��䵽ûϷ�����еĶ���
//	@ModelAttribute
	public User getUser() {
		User user = new User();
		user.setId(1L);
		user.setName("����");
		return user;
	}
	
	@RequestMapping("/session")
	public String Session(HttpServletRequest request) {
		HttpSession session= request.getSession();
		User user = new User();
		user.setId(1L);
		user.setName("����");
		session.setAttribute("user", user);
		return "view";
	}
	
	@RequestMapping("/session2")
	public String Session(HttpSession session) {
		
		User user = new User();
		user.setId(1L);
		user.setName("����");
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
		user.setName("����");
		
		modelAndView.setViewName("view");
		modelAndView.addObject(user);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/modelandview2")
	public ModelAndView modelAndView2(ModelAndView modelAndView) {
		User user = new User();
		user.setId(1L);
		user.setName("����");
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
		user.setName("����");
		ModelAndView modelAndView = new ModelAndView("view");
		modelAndView.addObject(user);
		System.out.println(modelAndView);
		return modelAndView;
	}
	@RequestMapping("/modelandview4")
	public ModelAndView modelAndView4() {
		User user = new User();
		user.setId(1L);
		user.setName("����");
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
		user.setName("����");
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
		user.setName("����");
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
		user.setName("����");
		ModelAndView modelAndView = new ModelAndView("view","user",user);
		System.out.println(modelAndView);
		return modelAndView;
	}
	
	@RequestMapping("/modelandview8")
	public ModelAndView modelAndView8() {
		User user = new User();
		user.setId(1L);
		user.setName("����");
		View view = new InternalResourceView("/view.jsp");
		ModelAndView modelAndView = new ModelAndView(view,"user",user);
		System.out.println(modelAndView);
		return modelAndView;
	}
}
