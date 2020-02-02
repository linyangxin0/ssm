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

}
