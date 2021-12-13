package dao;
import model.*;
import java.util.List;
/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/11/30/8:25
 * @Description:
 */
public interface IPetDao {
    //用户登录
    Employee login(String name, String password);

    //联合查询
    List<Vet_Spe> findByCom(String sname, String vname);

    //查询宠物以及拥有人
    List<Pet_Own> findByPet_Own(String pname, String oname);

    //添加所有入信息
    int saveowners(Owners owners);

    //根据名字查询拥有人
    Owners findByName(String name);

    //更新宠物所有人信息
    int updateOwner(Owners owners);

    //根据所有人id进行查询
    Owners findByOwId(int id);

    //根据宠物名称查询宠物
    Pets findPetByNmae(String name);

    //查询所有宠物拥有人信息
    List<String> findAllOwners();

    //添加新宠物
    int addPet(Pets pets);

    //修改宠物信息
    int updatePet(Pets pets);

    //根据宠物id查询宠物的信息
    Pets findByPetId(int id);

    //查询宠物的病例访问记录
    List<Visits> findPetRecord(int id);

    //添加宠物病例
    int addPetIll(Visits visits);
}