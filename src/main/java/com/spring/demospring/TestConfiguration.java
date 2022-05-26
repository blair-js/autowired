package com.spring.demospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/* 빈 설정파일
단, 프로파일이 test 프로파일 일때만 빈 설정(등록)이 되는 것이다.
즉 test 프로파일로 이 애플리케이션을 실행하기 전까지는 아래의 빈 설정 파일이 적용이 되지 않는다. */
/*@Configuration
public class TestConfiguration {

    @Bean
    @Profile("test")
    public BookRepository bookRepository(){
        return new TestBookRepository();
    }
}*/
