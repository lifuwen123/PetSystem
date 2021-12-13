package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Owners;
import model.Pets;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/12/02/11:09
 * @Description:
 * 提交更新数据到数据库
 */
@WebServlet( "/updatePetServlet3")
public class UpdatePetServlet3 extends HttpServlet {
    private IPetDao dao= new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Pets pets=new Pets();
        try {
            BeanUtils.populate(pets,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int updatePet = dao.updatePet(pets);
        if (updatePet>0){
            Pets pet = dao.findByPetId(pets.getId());
            Owners owners = dao.findByName(pet.getOname());
            request.setAttribute("owners",owners);
            request.setAttribute("pets",pet);
            request.setAttribute("msg","宠物信息更新成功");
            request.getRequestDispatcher("uppetshow.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
