package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Owners;
import model.Pets;
import model.Visits;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/12/03/20:22
 * @Description:
 */
@WebServlet("/addPetIllServlet2")
public class AddPetIllServlet2 extends HttpServlet {
    private IPetDao dao=new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");
        //获取添加宠物病例的所有信息
        String pet_id = request.getParameter("pet_id");
        String visit_date = request.getParameter("visit_date");
        String description = request.getParameter("description");
        String state = request.getParameter("state");
        //日期转换
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        java.sql.Date sqlDate=null;
        try {
            date = formatter.parse(visit_date);
            sqlDate=new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //封装结果集
        Visits visits=new Visits();
        visits.setPet_id(Integer.parseInt(pet_id));
        visits.setVisit_date(sqlDate);
        visits.setDescription(description);
        visits.setState(state);
        //添加宠物信息
        int i = dao.addPetIll(visits);
        if(i>0){
            request.setAttribute("msg","宠物病例信息插入成功");
            request.getRequestDispatcher("pet.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
