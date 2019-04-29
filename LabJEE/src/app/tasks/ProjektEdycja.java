package app.tasks;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.model.Projekt;
import app.util.HibernateUtil;

/**
 * Servlet implementation class ProjektEdycja
 */
@WebServlet("/ProjektEdycja")
public class ProjektEdycja extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static final String CONTENT_TYPE = "text/html;charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProjektEdycja() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btn_usun") != null) {
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager();
			String projektId = request.getParameter("txt_usun");
			Projekt projekt = entityManager.find(Projekt.class, Integer.parseInt(projektId)); 
			entityManager.getTransaction().begin(); 
			entityManager.remove(projekt); 
			entityManager.getTransaction().commit();
		}
		if(request.getParameter("btn_zapisz") != null) {
			EntityManager entityManager = HibernateUtil.getInstance().createEntityManager(); 
			Projekt projekt = new Projekt();
			projekt.setNazwa("Projekt testowy");
			projekt.setOpis("Opis projektu testowego");
			projekt.setDataUtworzenia(LocalDateTime.now());
			entityManager.getTransaction().begin();
			entityManager.persist(projekt);
			entityManager.getTransaction().commit();
			entityManager.close();
			
			request.setAttribute("projekt", projekt);
		}
		ServletContext context = getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/projekt_edycja.jsp"); 
		dispatcher.forward(request, response);

	}
}