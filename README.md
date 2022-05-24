# @Autowired


필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.

- required: 기본값은 true (따라서 못 찾으면 애플리케이션 구동 실패)

1) BookService 클래스에서 BookRepository를 주입 받는다. 

BookService 클래스는 @Service 어노테이션이 부여된 상태고, BookRepository 클래스는 어떠한 어노테이션도 부여하지 않았다. 

(즉, 스프링은 BookRepository 를 빈으로 등록하지 않은 상태라 의존성 주입이 불가능한 상태 ⇒ 에러코드를 잘 보기 위해 설정한 상황이다)

###생성자 주입 방식
    
    **Description:**
    
    Parameter 0 of constructor in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.
    
    **Action:**
    
    Consider defining a bean of type 'com.spring.demospring.BookRepository' in your configuration.
