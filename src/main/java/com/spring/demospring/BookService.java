package com.spring.demospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {

    /*BookRepository bookRepository;*/

    /*생성자 주입 방식*/
    /*생성자 매개변수에서 BookRepository 타입의 빈이 없다고 알려주고 있다.*/
    /*발생 에러 : Parameter 0 of constructor in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.*/
    /*@Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }*/

    /*setter 주입 방식*/
    /*@Autowired(required = false)
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }*/

    /*필드 주입 방식*/
    /*@Autowired(required = false)
    BookRepository bookRepository;*/

    /*BookRepository 인터페이스의 구현체가 여러개인 경우*/
    /*에러 : Field bookRepository in com.spring.demospring.BookService required a single bean, but 2 were found:*/
    //@Autowired @Qualifier("yourBookRepository")
    //BookRepository bookRepository;
    //@Autowired
    //List<BookRepository> bookRepositories;

    /*주입 받을 구현체의 클래스 이름을 카멜케이스로 변경하여 변수명을 설정*/
    @Autowired
    BookRepository myBookRepository;
    public void printBookRepository(){
        /*어떤 구현체가 생성되었는지 해당 클래스를 출력해보는 방법*/
        //System.out.println(bookRepository.getClass());

        /*주입 받은 모든 구현체를 출력하는 코드*/
        //this.bookRepositories.forEach(System.out::println);
        System.out.println(myBookRepository.getClass());
    }
}
