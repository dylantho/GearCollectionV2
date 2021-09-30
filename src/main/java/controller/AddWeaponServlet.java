package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Weapon;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddWeaponServlet")
public class AddWeaponServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddWeaponServlet() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String weaponType = request.getParameter("weaponType");
		
		Weapon wep = new Weapon(name, weaponType);
		WeaponHelper dao = new WeaponHelper();
		dao.insertWeapon(wep);
		
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);

	}

}
