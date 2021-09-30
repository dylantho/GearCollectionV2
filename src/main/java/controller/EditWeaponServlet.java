package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Weapon;

/**
 * Servlet implementation class EditWeaponServlet
 */
@WebServlet("/EditWeaponServlet")
public class EditWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditWeaponServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		WeaponHelper dao = new WeaponHelper();
		String name = request.getParameter("name");
		String weaponType = request.getParameter("weaponType");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		Weapon weaponToUpdate = dao.searchForWeaponById(tempId);
		
		weaponToUpdate.setName(name);
		weaponToUpdate.setWeaponType(weaponType);
		
		dao.updateWeapon(weaponToUpdate);
		getServletContext().getRequestDispatcher("/ViewAllWepServlet").forward(request, response);
	}

}
