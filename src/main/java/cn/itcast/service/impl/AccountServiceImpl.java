package cn.itcast.service.impl;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    //    查询所有账户
    public List<Account> findAll(){
        return accountDao.findAll();
    }
    //查询账号密码
    public Account getUserByName(String user_name){
        return accountDao.getUserByName(user_name);
    }


    //保存账户信息
    public void saveAccount(Account account){
        accountDao.saveAccount(account);
    }
}
