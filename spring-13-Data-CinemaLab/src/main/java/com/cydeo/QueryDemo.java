package com.cydeo;

import com.cydeo.Repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;

public class QueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public QueryDemo(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public void run(String... args) throws Exception {

       // System.out.println(accountRepository.findByCountryOrState("United States"));

        System.out.println("AGE LESS THAN: "+accountRepository.findAllByAgeLessThanEqual(45));

    }
}
