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
 * @Date: 2021/12/03/20:22
 * @Description:
 */
@WebServlet("/addPetIllServlet1")
public class AddPetIllServlet1 extends HttpServlet {
    private IPetDao dao=new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取宠物的id
        String id = request.getParameter("id");
        //根据宠物的id查询宠物
        Pets pets = dao.findByPetId(Integer.parseInt(id));
        //根据宠物拥有人的id查询拥有人
        Owners owners = dao.findByOwId(pets.getOwner_id());
        //封装结果集并显示
        request.setAttribute("pets",pets);
        request.setAttribute("owners",owners);
        request.getRequestDispatcher("addpetIll.jsp").forward(request,response);
    }
}
