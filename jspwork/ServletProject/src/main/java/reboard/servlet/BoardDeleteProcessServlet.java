package reboard.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import reboard.data.BoardDao;

import java.io.IOException;

/**
 * Servlet implementation class BoardDeleteProcessServlet
 */
@WebServlet("/board/delete")
public class BoardDeleteProcessServlet extends HttpServlet {
	BoardDao dao = new BoardDao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//num
		int num = Integer.parseInt(request.getParameter("num"));
		//pageNum
		String pageNum = request.getParameter("pageNum");
		//passwd
		String passwd = request.getParameter("passwd");
		//비번이 맞는지 boolean 으로 얻ㄱ기
		//true면 삭제 후 목록으로 이동(페이지번호 전달)
		//false면 fail.jsp 로 포워드
		boolean b = dao.isCheckPass(num, passwd);
		if(b) {
			//해당 글 삭제
			dao.deleteBoard(num);;
			//보던 페이지로 이동
			response.sendRedirect("./list?pageNum="+pageNum);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("./fail.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
