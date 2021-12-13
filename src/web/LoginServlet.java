package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/11/30/8:27
 * @Description:
 * 登录
 */
@WebServlet( "/loginServlet")
public class LoginServlet extends HttpServlet {
    private IPetDao dao=new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String checkbox = request.getParameter("checkbox");
        Employee employee = dao.login(name, password);
        //登录成功
        if(employee!=null){
            //保存用户名到cook中
            if("1".equals(checkbox)){
                Cookie cookie=new Cookie("name",name);
                cookie.setMaxAge(60 * 60 * 24 * 7);//当前 Cookie 一周内有效
                response.addCookie(cookie);
            }
            request.getSession().setAttribute("name",employee.getName());
            request.getRequestDispatcher("petdoctor.jsp").forward(request,response);
        }
        request.setAttribute("msg","用户名或者密码错误");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
