package com.spring.springdemo.DAO;

import com.spring.springdemo.Entity.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    public void addAccount(int i, String value) {
        System.out.println(getClass() + " --> DB work in addAccount()");
    }


    public List<Account> findAllAccounts(){

        Account account1 = new Account("Sok", 24);
        Account account2 = new Account("John", 25);
        Account account3 = new Account("Mike", 31);

        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        accountList.add(account3);

        return accountList;

    }

    public void printAccounts(List<Account> list){
        int i =1;
        for (Account account: list) {
            System.out.println("Account No. "+ i +": "+ account.getName() + ", "+ account.getAge());
            i++;
        }
    }


}
