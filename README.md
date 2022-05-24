### 💡 “스프링 입문(백기선) - 스프링 프레임워크 핵심 기술 강의”**를 바탕으로 정리한 내용**

> **@Autowired**
> 

필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.

- required: 기본값은 true (따라서 못 찾으면 애플리케이션 구동 실패)

1) BookService 클래스에서 BookRepository를 주입 받는다. 

BookService 클래스는 @Service 어노테이션이 부여된 상태고, BookRepository 클래스는 어떠한 어노테이션도 부여하지 않았다. 

(즉, 스프링은 BookRepository 를 빈으로 등록하지 않은 상태라 의존성 주입이 불가능한 상태 ⇒ 에러코드를 잘 보기 위해 설정한 상황이다)

- **생성자 주입 방식**
    
    **Description:**
    
    Parameter 0 of constructor in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.
    
    **Action:**
    
    Consider defining a bean of type 'com.spring.demospring.BookRepository' in your configuration.
    
    ```java
    @Service
    public class BookService {
    
       BookRepository bookRepository;
    		
    		**/*생성자 주입 방식*/**
        **/*생성자 매개변수에서 BookRepository 타입의 빈이 없다고 알려주고 있다.*/**
        **/*발생 에러 : Parameter 0 of constructor in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.*/**
        @Autowired
        public BookService(BookRepository bookRepository){
            this.bookRepository = bookRepository;
        }
    }
    ```
    
- **setter 주입 방식**
    
    **Description:**
    
    Parameter 0 of method setBookRepository in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.
    
    **Action:**
    
    Consider defining a bean of type 'com.spring.demospring.BookRepository' in your configuration.
    
    ```java
    @Service
    public class BookService {
    
       BookRepository bookRepository;
    		
    		**/*setter 주입 방식*/
    		/*@Autowired(required = false)*/**
        @Autowired
        public void **setBookRepository**(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }
    }
    ```
    

📌 **생성자 주입 방식과 setter 주입 방식의 차이점**

두 방식 모두 BookRepository 가 빈으로 등록되어 있지 않을 경우 아래에 나타나는 에러 코드가 동일하다. 

하지만, 생성자 주입 방식의 경우 BookService 의 인스턴스를 생성하기 위해 BookRepository 가 반드시 필요한 것이고, 

setter 주입 방식의 경우 BookService의 인스턴스는 BookRepository 없이도 생성이 되어야 하는데, 

해당 클래스(BookService)에서 @Autowired 어노테이션을 보고 의존성 주입을 하려고 하고 있기 때문에 위와 같이 에러 코드가 동일했던 것이다. 

그래서 setter 주입 방식의 경우BookService의 인스턴스만 생성하여 사용 하려면 아래와 같은 속성을 추가해주면 된다. 

**@Autowired(required = false)**

그럼 위와 같이 발생했던 에러는 발생하지 않는다. (BookService는 정상적으로 빈으로 등록된 것이고, BookRepository는 아직 빈으로 등록되지 않음.)

- **필드 주입 방식**
    
    setter 주입 방식과 동일하게 BookService 의 인스턴스는 생성이 될 수 있고, BookRepository 에 대한 빈 등록은 Optional 이다. 
    
    ```java
    @Service
    public class BookService {
    
        **/*필드 주입 방식*/**
        @Autowired(required = false)
        BookRepository bookRepository;
    
    }
    ```
    

> **의존성 주입을 위한 빈이 여러 개인 경우**
> 

1) BookRepository를 인터페이스로 만들고, 해당 인터페이스의 구현체를 두 개 만든다. `MyBookRepository`, `YourBookRepository`

이 때, 두 구현체에 모두 @Repository 어노테이션 부여 

2) BookService에서 BookRepository를 의존성 주입 받으려고 하면 어떤 구현체를 주입 받는지 확인한다.

결과는 아래와 같은 에러가 발생한다. 

스프링에서 의존성 주입을 하려고 하는데 해당 **구현체가 2개라 무엇을 주입해야 하는지 모르겠다**고  알려주고 있다. 

또한, **해결 방안을 제시**하고 있다. **⇒ @Primary 사용 or @Qualifier 사용 or 모든 구현체를 다 주입 받기** 

**Description:**

Field bookRepository in com.spring.demospring.BookService required a single bean, **but 2 were found**:
- myBookRepository: defined in file [C:\SpringBootStudy\demoSpring\target\classes\com\spring\demospring\MyBookRepository.class]
- yourBookRepository: defined in file [C:\SpringBootStudy\demoSpring\target\classes\com\spring\demospring\YourBookRepository.class]

**Action:**

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

💡 **해결하기**

**1) @Primary**

내가 우선순위를 부여할 해당 구현체에 @Primary 어노테이션을 부여한다. (여러 구현체 중 해당 클래스가 1순위가 되는 것이다.)

```java
@Repository 
**@Primary**
public class MyBookRepository implements BookRepository{

}
```

**아래는 주입된 빈이 어떤 구현체인지 확인 하는 코드이다.** 

**결과 : class com.spring.demospring.MyBookRepository**

1. BookService 에서 bookRepository의 클래스를 출력하는 메소드 작성
    
    ```java
    public void printBookRepository(){
        **/*어떤 구현체가 생성되었는지 해당 클래스를 출력해보는 방법*/**
        System.out.println(bookRepository.getClass());
    }
    ```
    
2. ApplicationRunner 인터페이스를 구현한 BookServiceRunner 클래스 생성
    
    bookService 의존성 주입을 받아서 bookService의 메소드 printBookRepository()를 호출한다. 
    
    ```java
    @Component
    public class BookServiceRunner implements ApplicationRunner {
    
        @Autowired
        BookService bookService;
    
        @Override
        public void run(ApplicationArguments args) throws Exception {
            bookService.printBookRepository();
        }
    }
    ```
    

**2) @Qualifier**

의존성 주입을 받는 코드에서 **@Qualifier 어노테이션의 괄호 안에 주입받고자 하는 구현체의 이름(카멜케이스)을 적어준다.** 

(ex. MyBookRepository 를 주입 받고자 하면 myBookRepository, YourBookRepository의 경우 yourBookRepository 라고 기재해준다)

```java
@Service
public class BookService {

    BookRepository bookRepository;*/

    @Autowired **@Qualifier("yourBookRepository")**
    BookRepository bookRepository;

    public void printBookRepository(){
        **/*어떤 구현체가 생성되었는지 해당 클래스를 출력해보는 방법*/**
        System.out.println(bookRepository.getClass());
    }
}
```

**결과 : class com.spring.demospring.YourBookRepository**

**3) 모든 구현체를 주입 받는 방식**

주입 받고자 하는 인터페이스를 제네릭에 넣어주고, List 타입으로 받아준다. 

```java
@Service
public class BookService {

    @Autowired
    **List<BookRepository>** bookRepositories;

    public void printBookRepository(){
        
        **/*주입 받은 모든 구현체를 출력하는 코드*/**
        this.bookRepositories.forEach(System.out::println);
    }
}
```

**결과 : com.spring.demospring.MyBookRepository@36bf84e, com.spring.demospring.YourBookRepository@1a0b5323**

**4) 변수 명으로 주입 받을 구현체의 이름(카멜케이스)을 적어준다.** 

```java
@Service
public class BookService {

    **/*주입 받을 구현체의 클래스 이름을 카멜케이스로 변경하여 변수명을 설정*/**
    @Autowired
    BookRepository **myBookRepository**;

    public void printBookRepository(){
        System.out.println(myBookRepository.getClass());
    }
}
```

**결과 : class com.spring.demospring.MyBookRepository**
