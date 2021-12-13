package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Pet_Own;
import model.Vet_Spe;

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
 * @Date: 2021/12/01/9:14
 * @Description:
 *              查询宠物或者拥有人信息
 */

@WebServlet("/petServlet")
public class petServlet extends HttpServlet {
    private IPetDao dao= new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取宠物名字以及拥有人名字
        String pname=request.getParameter("pname");
        String oname=request.getParameter("oname");
        //2.满足条件时进行封装结果集
        if(!pname.trim().isEmpty() || !oname.trim().isEmpty()){
        List<Pet_Own> list=dao.findByPet_Own(pname,oname);
            request.setAttribute("list",list);
        request.getRequestDispatcher("pet_own_show.jsp").forward(request,response);
        }
        //3.不满足条件时返回页面给出提示
        else {
            request.setAttribute("msg1","不能空值查询哦!");
            request.getRequestDispatcher("pet.jsp").forward(request,response);
        }
    }
}
