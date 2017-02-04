package cn.sxt.controller;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import cn.sxt.vo.User;

@Controller
public class UserController {
	@RequestMapping("/add.do")
	public ModelAndView add(User user){
		System.out.println("birthday="+user.getBirthday());
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("msg", "添加成功");
		return mv;
	}
	@RequestMapping(value="/add1.do",method=RequestMethod.GET)
	public ModelAndView add1(String name,int age) throws UnsupportedEncodingException{
		System.out.println("name="+new String(name.getBytes("iso-8859-1"),"utf-8")+"  age="+age);
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("msg", "添加成功");
		return mv;
	}
	@RequestMapping("/save.do")
	public ModelAndView save(User user){
		System.out.println("------------------");
		System.out.println("name="+user.getName()+"  age="+user.getAge());
		System.out.println("------------------");
		ModelAndView mv = new ModelAndView("success");
		mv.addObject("msg", "添加成功");
		return mv;
	}
	//直接在处理方法上声明ModelMap对象 springmvc会将ModelMap中的数据携带到前台
	@RequestMapping("/show.do")
	public ModelAndView show(ModelMap map){
		map.addAttribute("msg", "modelMap携带参数");
		return new ModelAndView("success");
	}
	//直接在处理方法上声明ModelMap对象 springmvc会将ModelMap中的数据携带到前台
	@RequestMapping("/show1.do")
	public ModelAndView show1(Model map){
		map.addAttribute("msg", "modelMap携带参数");
		return new ModelAndView("success");
	}
	@RequestMapping("/show2.do")
	public ModelAndView show2(HttpServletRequest req){
		req.setAttribute("msg", "req携带参数");
		return new ModelAndView("success");
	}
}
