package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Owners;
import model.Pets;

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
 * @Date: 2021/12/02/11:09
 * @Description:
 * 显示更新的宠物信息
 */
@WebServlet( "/updatePetServlet1")
public class UpdatePetServlet1 extends HttpServlet {
    private IPetDao dao= new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        Pets pet = dao.findPetByNmae(name);
        Owners owners = dao.findByOwId(pet.getOwner_id());
        if(pet!=null){
            request.setAttribute("pets",pet);
            request.setAttribute("owners",owners);
            request.getRequestDispatcher("uppetshow.jsp").forward(request,response);
        }
    }
}
