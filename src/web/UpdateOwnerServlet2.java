package web;

import dao.IPetDao;
import dao.impl.IPetDaoImpl;
import model.Owners;
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
 * @Date: 2021/12/01/17:16
 * @Description:
 */
@WebServlet("/UpdateOwnerServlet2")
public class UpdateOwnerServlet2 extends HttpServlet {
    private IPetDao dao= new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> map = request.getParameterMap();
        Owners owners=new Owners();
        try {
            BeanUtils.populate(owners,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        int owner = dao.updateOwner(owners);
        if(owner>0){
            Owners owners2 = dao.findByOwId(owners.getId());
            if (owners2!=null){
                request.setAttribute("owners",owners2);
                request.setAttribute("msg","修改成功");
                request.getRequestDispatcher("updatesucc.jsp").forward(request,response);
            }
        }
    }
}
