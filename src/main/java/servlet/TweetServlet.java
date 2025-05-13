package servlet;

import java.io.IOException;
import java.util.ArrayList;
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

/**
 * Servlet implementation class TweetServlet
 */
public class TweetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TweetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		// ユーザーのツイート情報を取得してリクエストスコープに保存する
		List<Account> myTweetList = new AccountService().selectTweet(user);
		request.setAttribute("myTweetList", myTweetList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String tweet = request.getParameter("tweet");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		List<Account> myTweetList = new ArrayList<>();
		AccountService service = new AccountService();
		// 送られてきたツイートが入力されているか判定
		if (tweet != null && !tweet.isBlank()) {
			// ツイートが入力されていたので、データベースに登録し、ツイートリストを取得し直す
			myTweetList = service.userTweet(user, tweet);
			System.out.println("つぶやきリスト取得成功");
		} else {
			// ツイートが入力されていなかったので、ツイートリストのみ取得する
			myTweetList = service.selectTweet(user);
			if (!myTweetList.isEmpty()) {
				// データベースにツイートが１件でも登録されていた場合・・・
				request.setAttribute("nullEntryMsg", "つぶやきが入力されていません");
			} else {
				// データベースにツイートが登録されていない場合・・・
				request.setAttribute("nullMsg", "つぶやきが足りません<br>１件つぶやいてみよう");
				System.out.println("つぶやきリスト取得失敗");
			}
		}
		// リクエストスコープにユーザーのツイートを保存
		request.setAttribute("myTweetList", myTweetList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/myPage.jsp");
		dispatcher.forward(request, response);
	}

}
