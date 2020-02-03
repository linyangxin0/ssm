package cn.itcast.service;

import cn.itcast.domain.Account;

import java.util.List;

public interface AccountService {
    //    查询所有账户
    public List<Account> findAll();

    //查询账号密码
    public Account getUserByName(String user_name);

    //保存账户信息
    public void saveAccount(Account account);

//    添加账户
    public void addUser(Account account);

//    根据id删除账户
    public void delUser(int id);

//    根据id更新账户信息
//    public void updateUserMessage(Account account);
    public void updateUserNameById(Account account);
    public void updateSexById(Account account);
    public void updateAgeById(Account account);
    public void updateMobilePhoneById(Account account);
    public void updateAddressById(Account account);

}
