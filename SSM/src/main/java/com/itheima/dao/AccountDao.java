package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询用户信息
     * @return
     */
    public List<Account> findAll();

    /**
     * 保存账户信息
     */
    public void saveAccount();
}
