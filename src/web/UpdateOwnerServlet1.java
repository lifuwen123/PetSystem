package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Owners;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/12/01/16:49
 * @Description:
 */
@WebServlet("/updateOwnerServlet1")
public class UpdateOwnerServlet1 extends HttpServlet {
    private IPetDao dao= new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Owners owners = dao.findByName(name);
        System.out.println(owners);
        if (owners!=null){
            request.setAttribute("owners",owners);
            request.getRequestDispatcher("upownershow.jsp").forward(request,response);
        }
    }
}
