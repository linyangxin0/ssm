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

//    添加账户
    public void addUser(Account account){
        accountDao.addUser(account);
    }

    //    根据id删除账户
    public void delUser(int id){
        accountDao.deleteUserById(id);
    }

//    根据id更新账户信息
//    public void updateUserMessage(Account account){
//        accountDao.updateUserNameById(account.getUser_name(),account.getId());
//        accountDao.updateSexById(account.getSex(),account.getId());
//        accountDao.updateAgeById(account.getAge(),account.getId());
//        accountDao.updateMobilePhoneById(account.getMobile_phone(),account.getId());
//        accountDao.updateAddressById(account.getAddress(),account.getId());
//    }
    public void updateUserNameById(Account account){
        accountDao.updateUserNameById(account);
    }
    public void updateSexById(Account account){
        accountDao.updateSexById(account);
    }
    public void updateAgeById(Account account){
        accountDao.updateAgeById(account);
    }
    public void updateMobilePhoneById(Account account){
        accountDao.updateMobilePhoneById(account);
    }
    public void updateAddressById(Account account){
        accountDao.updateAddressById(account);
    }
}
