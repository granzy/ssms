package service.impl;

import domain.Account;
import mappers.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AccountService;

import java.util.List;

/**
 * Created by gzy on 2016/12/29.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<Account> getEmail() {
        List<Account> accountList = accountMapper.getEmail();
        return accountList;
    }
}
