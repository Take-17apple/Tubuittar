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
 * Servlet implementation class AccountDeleteServlet
 */
public class AccountDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/accountDelete.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "";
		String deleteId = request.getParameter("delete");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		// Id（はい or いいえ）を判別する。”はい”を選んだ場合、削除処理に進む
		if (deleteId != null && deleteId.equals("はい")) {
			// ユーザーのツイート情報を削除してからユーザー情報を削除する
			boolean isTweetDelete = new AccountService().tweetDelete(user); 
			if (isTweetDelete) {
				// ツイート削除成功
				boolean isUserDelete = new UserService().userDelete(user);
				if (isUserDelete) {
					// アカウント削除成功。セッションスコープを破棄する
					session.invalidate();
					request.setAttribute("accountDelMsg", "アカウント削除しました<br>又のお越しお待ちしております。");
					url = "index.jsp";
				} else {
					// アカウント削除失敗
					response.sendRedirect("LogoutServlet");
					return;
				}
			} else {
				// ツイート情報がない
				request.setAttribute("accountDelMsg", "つぶやかれていないためアカウント削除ができません<br>１件でもつぶやこう");
				url = "WEB-INF/jsp/myPage.jsp";
			}
		} else {
			// アカウント削除ページで”いいえ”を選んだ場合、ユーザーのツイートリストを取得し直してからマイページへ遷移
			request.setAttribute("accountDelCanselMsg", "もう、削除しようとしないでね！！");
			List<Account> myTweetList = new AccountService().selectTweet(user);
			request.setAttribute("myTweetList", myTweetList);
			url = "WEB-INF/jsp/myPage.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
