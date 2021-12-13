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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/12/02/14:05
 * @Description:
 */
@WebServlet("/addPetServlet2")
public class AddPetServlet2 extends HttpServlet {
    private IPetDao dao=new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取前台内容
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String birth_date=request.getParameter("birth_date");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String oname = request.getParameter("oname");
        //String转成日期类型
        Date date = null;
        java.sql.Date sqlDate=null;
        try {
            date = formatter.parse(birth_date);
            sqlDate=new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //通过名字查询拥有人
        Owners owners = dao.findByName(oname);
        //封装对象
        Pets pets=new Pets();
        pets.setName(name);
        pets.setBirth_date(sqlDate);
        pets.setType(type);
        pets.setOwner_id(owners.getId());
        int pet = dao.addPet(pets);
        //返回宠物页面
        if(pet>0){
            request.setAttribute("msg","宠物信息插入成功");
            request.getRequestDispatcher("pet.jsp").forward(request,response);
        }
    }
}
