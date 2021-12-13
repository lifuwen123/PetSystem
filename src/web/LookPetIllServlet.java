package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Pets;
import model.Visits;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/12/03/14:53
 * @Description:
 */
@WebServlet("/lookPetIllServlet")
public class LookPetIllServlet extends HttpServlet {
    private IPetDao dao= new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Pets pet = dao.findByPetId(Integer.parseInt(id));
        List<Visits> lists = dao.findPetRecord(Integer.parseInt(id));
        request.setAttribute("pets",pet);
        request.setAttribute("lists",lists);
        request.getRequestDispatcher("pet-illnesss-show.jsp").forward(request,response);
    }
}
