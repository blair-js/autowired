package com.spring.demospring;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Profile("test")
//Profile("!prod & !prid")
public class TestBookRepository implements BookRepository{

}
