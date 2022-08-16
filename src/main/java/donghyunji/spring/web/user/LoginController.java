package donghyunji.spring.web.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("login.do")
	public String loginView(UserVO vo) {
		System.out.println("�α��� �������� �̵�");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@PostMapping("login.do")
	public String login(UserVO vo, HttpSession session) {
		System.out.println("�α��� ���� ó��");
		
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalAccessError("���̵�� �ݵ�� �Է��ؾ� �մϴ�.");
		}
		
		UserVO user = userService.getUser(vo);
		if(userService.getUser(vo) != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	
//	@RequestMapping("login.do")
//	public String login(UserVO vo, UserDAO userDAO) {
//		System.out.println("�α��� ó��");
//		
//		if(userDAO.getUser(vo) != null) {
//			return "getBoardList.do";
//		} else {
//			return "login.jsp";
//		}
//		
//	}
	
//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
//		System.out.println("�α��� ó��");
//		// 1. ����� �Է� ���� ����
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		// 2. �����ͺ��̽� ���� ó��
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//		// 3. ȭ�� �׺���̼�
//		ModelAndView mav = new ModelAndView();
//		if(user != null) {
//			mav.setViewName("redirect:getBoardList.do");
//		} else {
//			mav.setViewName("redirect:login.jsp");
//		}
//		return mav;
//
//	}

}
