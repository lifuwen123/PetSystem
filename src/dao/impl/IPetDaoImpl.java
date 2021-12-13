package dao.impl;

import dao.IPetDao;
import model.*;
import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 李
 * @Date: 2021/11/30/9:02
 * @Description:
 */
public class IPetDaoImpl implements IPetDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    //用户登录
    @Override
    public Employee login(String name, String password) {
        Employee employee = null;
        try {
            String sql="select * from employee where name=? and password=?";
            employee = template.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class),name,password);
        } catch (DataAccessException e) {

            return null;

        }
        return employee;
    }
    //查询宠物医生以及专业
    @Override
    public List<Vet_Spe> findByCom(String vname, String sname) {
        List<Vet_Spe> list=null;
        String sql="SELECT s.name as sname,v.name as vname from specialties s,vets v where 1=1 and s.vid=v.id";
        if(sname!=null && !sname.trim().isEmpty()){
            sql+=" and s.name like"+ "'"+"%"+sname+"%"+"'";
            list=template.query(sql,new BeanPropertyRowMapper<>(Vet_Spe.class));
            return list;
        }
        if(vname!=null && !vname.trim().isEmpty()){
            sql+=" and v.name like"+ "'"+"%"+vname+"%"+"'";
            list=template.query(sql,new BeanPropertyRowMapper<>(Vet_Spe.class));
            return list;
        }

            list=template.query(sql,new BeanPropertyRowMapper<>(Vet_Spe.class),vname,sname);

        return list;
    }
    //查询宠物以及拥有人
    @Override
    public List<Pet_Own> findByPet_Own(String pname, String oname) {
        List<Pet_Own> list=null;
        String sql="select p.name as pname,o.name as oname from pets p,owners o where 1=1 and p.owner_id=o.id";
        if(pname!=null && !pname.trim().isEmpty()){
            sql+=" and p.name like"+ "'"+"%"+pname+"%"+"'";
            list=template.query(sql,new BeanPropertyRowMapper<>(Pet_Own.class));
            return list;
        }
        if(oname!=null && !oname.trim().isEmpty()){
            sql+=" and o.name =?";
            list=template.query(sql,new BeanPropertyRowMapper<>(Pet_Own.class),oname);
            return list;
        }
        list=template.query(sql,new BeanPropertyRowMapper<>(Pet_Own.class),pname,oname);
        return list;
    }
    //添加宠物拥有人
    @Override
    public int saveowners(Owners owners) {
        String sql="insert into owners (name,address,city,telephone) values(?,?,?,?)";
        int i = template.update(sql, owners.getName(), owners.getAddress(), owners.getCity(), owners.getTelephone());
        return i;
    }
    //根据名字查询拥有人
    @Override
    public Owners findByName(String name) {
        Owners owners;
        try {
            String sql="select * from owners where name=?";
            owners = template.queryForObject(sql, new BeanPropertyRowMapper<>(Owners.class),name);

        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return owners;
    }
    //更新宠物所有人信息
    @Override
    public int updateOwner(Owners owners) {
        String sql="update owners set name=?,address=?,city=?,telephone=? where id=?";
        int update = template.update(sql, owners.getName(), owners.getAddress(), owners.getCity(), owners.getTelephone(),owners.getId());
        return update;
    }
    //根据所有人id进行查询
    @Override
    public Owners findByOwId(int id) {
        String sql="select * from owners where id=?";
        Owners owners = template.queryForObject(sql, new BeanPropertyRowMapper<>(Owners.class), id);
        return owners;
    }
    //根据宠物名称查询宠物
    @Override
    public Pets findPetByNmae(String name) {
        Pets pets;
        try {
            String sql="SELECT * from pets where name=?";
            pets = template.queryForObject(sql, new BeanPropertyRowMapper<>(Pets.class), name);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
        return pets ;
    }
    //查询所有宠物拥有人信息
    @Override
    public List<String> findAllOwners() {
        String sql="select name from owners";
        PreparedStatement pre=null;
        ResultSet rs=null;
        ArrayList<String> arrs=new ArrayList<>();
        try {
            pre=JDBCUtils.getConnection().prepareStatement(sql);
            rs=pre.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                arrs.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(pre!=null){
                try {
                    pre.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrs;
    }
    //添加新宠物
    @Override
    public int addPet(Pets pets) {
        String sql="insert into pets (name,birth_date,type,owner_id) values(?,?,?,?)";
        int add = template.update(sql, pets.getName(), pets.getBirth_date(), pets.getType(), pets.getOwner_id());
        return add;
    }
    //修改宠物信息
    @Override
    public int updatePet(Pets pets) {
        String sql="update pets set name=?,birth_date=?,type=? where id=?";
        int update = template.update(sql, pets.getName(), pets.getBirth_date(), pets.getType(), pets.getId());
        return update;
    }
    //根据宠物id查询宠物的信息
    @Override
    public Pets findByPetId(int id) {
        String sql="select p.id,p.name,p.birth_date,p.type,p.owner_id,o.name as oname from pets p,owners o where p.owner_id=o.id and p.id=?";
        Pets pets = template.queryForObject(sql,new BeanPropertyRowMapper<>(Pets.class),id);
        return pets;
    }
    //查询宠物的病例访问记录
    @Override
    public List<Visits> findPetRecord(int id) {
        String sql="select v.visit_date,v.description,v.state from visits v,pets p where v.pet_id=p.id and p.id=?";
        List<Visits> lists = template.query(sql, new BeanPropertyRowMapper<>(Visits.class), id);
        return lists;
    }
    //添加宠物病例
    @Override
    public int addPetIll(Visits visits) {
        String sql="INSERT into visits (pet_id,visit_date,description,state) VALUES(?,?,?,?)";
        int add = template.update(sql, visits.getPet_id(), visits.getVisit_date(), visits.getDescription(), visits.getState());
        return add;
    }
}
