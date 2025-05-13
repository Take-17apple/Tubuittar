package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Account;
import service.AccountService;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// データベースに登録されている全ツイート情報を取得する
		List<Account> allTweetList = new AccountService().selectTweet();
		// 返ってきたリストが空か確認する
		if (allTweetList.isEmpty()) {
			request.setAttribute("nullMsg", "誰もつぶやいていません<br>１件つぶやいてみよう");
		} 
		// リクエストスコープに保存(空でも保存しJSPで空チェック(not empty)する)
		request.setAttribute("allTweetList", allTweetList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/homePage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
