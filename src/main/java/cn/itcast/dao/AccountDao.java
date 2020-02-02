package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
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
}
