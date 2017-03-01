package cn.sxt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.sxt.vo.User;

@Controller
@RequestMapping("/user") //խ��-��ģ�鿪������user������list.ע��ҳ����ת
public class UserController {
	private List<User> list = new ArrayList<User>();
	public UserController(){
		list.add(new User(1,"aa","1111"));
		list.add(new User(2,"bb","2222"));
		list.add(new User(3,"cc","3333"));
	}

	//��ѯ�����û�
	@RequestMapping("/list")
	public String list(ModelMap map){
		map.addAttribute("list",list);
		return "/list.jsp"; //����/ ��ת���� /usersys/list.jsp
		
	}
	//�����û�
	@RequestMapping("/add")
	public String add(User user){
		user.setId(list.get(list.size()-1).getId()+1);
		list.add(user);
		//return "/user/list.do"
		//�൱��ˢ��,�Ͳ����й�ʱ��Ϣ
		return "redirect:list.do";
	}
	
	//ɾ���û�
	@RequestMapping("/delete")
	public String delete(int id){
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
				break;
			}
		}
		//�൱��ˢ��,�Ͳ����й�ʱ��Ϣ
		return "redirect:list.do";
	}
	
	//ʹ��restful delete/123
	//url /user/123/delete1
	@RequestMapping(value="/{id}/delete1")
	public String delete1(@PathVariable int id){
		System.out.println("id===="+id);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getId()==id){
				list.remove(i);
				break;
			}
		}
		//�൱��ˢ��,�Ͳ����й�ʱ��Ϣ
		return "redirect:list.do";
	}
}