package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//账户接口
@Repository
public interface AccountDao {
//    查询所有账户
    @Select("select * from account")
    public List<Account> findAll();

//    查询账号密码
    @Select("select * from account where user_name=#{user_name}")
    public Account getUserByName(String user_name);

//保存账户信息
    @Insert("insert into account (user_name,password) values (#{user_name},#{password})")
    public void saveAccount(Account account);

//    添加账户
    @Insert("insert into account (user_name,sex,age,mobile_phone,address,password) values (#{user_name},#{sex},#{age},#{mobile_phone},#{address},#{password})")
    public void addUser(Account account);

//    根据id删除账户
    @Delete("delete from account where id=#{id}")
    public void deleteUserById(int id);

//    根据id更新账户信息
    @Update("update account set user_name=#{user_name} where id=#{id}")
    public void updateUserNameById(Account account);
    @Update("update account set sex=#{sex} where id=#{id}")
    public void updateSexById(Account account);
    @Update("update account set age=#{age} where id=#{id}")
    public void updateAgeById(Account account);
    @Update("update account set mobile_phone=#{mobile_phone} where id=#{id}")
    public void updateMobilePhoneById(Account account);
    @Update("update account set address=#{address} where id=#{id}")
    public void updateAddressById(Account account);

}
