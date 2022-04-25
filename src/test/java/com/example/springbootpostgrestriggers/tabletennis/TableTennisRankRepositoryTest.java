package com.example.springbootpostgrestriggers.tabletennis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TableTennisRankRepositoryTest {

    @Autowired
    TableTennisRankRepository repository;

    @Test
    void insertData(){
//        repository.save(new TableTennisRank(null,"Mike", "URSolutions",100));
        repository.save(new TableTennisRank(null,"Susan", "Acme",120));
//        repository.save(new TableTennisRank(null,"Line", "Smørum",200));
//        repository.save(new TableTennisRank(null,"Janus", "Gundsømagle",10));
    }

}