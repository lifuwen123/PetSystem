package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;

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
 * @Date: 2021/12/02/14:05
 * @Description:
 */
@WebServlet("/addPetServlet1")
public class AddPetServlet1 extends HttpServlet {
    private IPetDao dao=new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有拥有人的名字
        List<String> allOwners = dao.findAllOwners();
        if(allOwners!=null){
            //前台显示结果集
            request.setAttribute("lists",allOwners);
            request.getRequestDispatcher("addpet.jsp").forward(request,response);
        }

    }
}
