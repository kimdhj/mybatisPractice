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
		System.out.println("로그인 페이지로 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login.jsp";
	}
	
	@PostMapping("login.do")
	public String login(UserVO vo, HttpSession session) {
		System.out.println("로그인 인증 처리");
		
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalAccessError("아이디는 반드시 입력해야 합니다.");
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
//		System.out.println("로그인 처리");
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
//		System.out.println("로그인 처리");
//		// 1. 사용자 입력 정보 추출
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		// 2. 데이터베이스 연동 처리
//		UserVO vo = new UserVO();
//		vo.setId(id);
//		vo.setPassword(password);
//		UserDAO userDAO = new UserDAO();
//		UserVO user = userDAO.getUser(vo);
//		// 3. 화면 네비게이션
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
