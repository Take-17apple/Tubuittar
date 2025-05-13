package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.User;
import service.AccountService;
import service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "";
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		// 入力が適切か確認する
		UserService service = new UserService();
		boolean isEntryCheck = service.check(name, pass);
		if (isEntryCheck) {
			// データベースに登録されているか確認する
			User user = new User(name, pass);
			boolean isSelect = service.userCheck(user);
			if (isSelect) {
				// ユーザーのツイートリストを取得する
				request.setAttribute("loginMsg", "ログインしました");
				List<Account> myTweetList = new AccountService().selectTweet(user);
				// ユーザーはセッションスコープ、ツイートリストはリクエストスコープに保存
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				request.setAttribute("myTweetList", myTweetList);
				url = "WEB-INF/jsp/myPage.jsp";
			} else {
				// 登録されていなかったので登録させる
				request.setAttribute("loginMsg", "登録されていません<br>登録してください");
				url = "WEB-INF/jsp/entry.jsp";
			}
		}  else {
			// 入力が不適切だった場合・・・
			request.setAttribute("loginMsg", "ログインに失敗しました");
			url = "index.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
