package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
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
 * @Date: 2021/11/30/14:36
 * @Description:
 * 查询兽医信息
 */
@WebServlet("/petDocServlet")
public class PetDocServlet extends HttpServlet {
    private  IPetDao dao= new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取兽医名字
        String vname=request.getParameter("vname");
        //获取兽医专业
        String sname=request.getParameter("sname");
        //满足添加进行封装结果集并显示
        if(!vname.trim().isEmpty()||!sname.trim().isEmpty()){
        List<Vet_Spe> list=dao.findByCom(vname,sname);
        request.setAttribute("list",list);
        request.getRequestDispatcher("petdoctorshow.jsp").forward(request,response);
        }
        //不满足条件时进行跳转
        else {
            request.setAttribute("msg1","不能空值查询哦!");
            request.getRequestDispatcher("petdoctor.jsp").forward(request,response);
        }
    }
}
