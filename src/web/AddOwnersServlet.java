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
 * @Date: 2021/12/01/14:56
 * @Description:
 * 添加所有入
 */
@WebServlet("/addOwnersServlet")
public class AddOwnersServlet extends HttpServlet {
    private IPetDao dao=new IPetDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        //获取前台数据封装到map里面
        Map<String, String[]> map = request.getParameterMap();
        Owners owners=new Owners();
        try {
            //将数据封装到Owners对象里面
            BeanUtils.populate(owners,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //查询名字是否重复
        Owners ow = dao.findByName(owners.getName());
        if(ow==null){
        int i=dao.saveowners(owners);
        //插入成功,受影响的行数大于0
        if(i>0){
                request.setAttribute("msg","所有人信息插入成功");
                request.getRequestDispatcher("pet.jsp").forward(request,response);
            }
        }
        //名字重复
        else {
            request.setAttribute("msg","插入失败,名字重复");
            request.getRequestDispatcher("addowner.jsp").forward(request,response);
        }
    }
}
