### π‘ βμ€νλ§ μλ¬Έ(λ°±κΈ°μ ) - μ€νλ§ νλ μμν¬ ν΅μ¬ κΈ°μ  κ°μβ**λ₯Ό λ°νμΌλ‘ μ λ¦¬ν λ΄μ©**

> **@Autowired**
> 

νμν μμ‘΄ κ°μ²΄μ βνμ"μ ν΄λΉνλ λΉμ μ°Ύμ μ£Όμνλ€.

- required: κΈ°λ³Έκ°μ true (λ°λΌμ λͺ» μ°ΎμΌλ©΄ μ νλ¦¬μΌμ΄μ κ΅¬λ μ€ν¨)

1) BookService ν΄λμ€μμ BookRepositoryλ₯Ό μ£Όμ λ°λλ€. 

BookService ν΄λμ€λ @Service μ΄λΈνμ΄μμ΄ λΆμ¬λ μνκ³ , BookRepository ν΄λμ€λ μ΄λ ν μ΄λΈνμ΄μλ λΆμ¬νμ§ μμλ€. 

(μ¦, μ€νλ§μ BookRepository λ₯Ό λΉμΌλ‘ λ±λ‘νμ§ μμ μνλΌ μμ‘΄μ± μ£Όμμ΄ λΆκ°λ₯ν μν β μλ¬μ½λλ₯Ό μ λ³΄κΈ° μν΄ μ€μ ν μν©μ΄λ€)

- **μμ±μ μ£Όμ λ°©μ**
    
    **Description:**
    
    Parameter 0 of constructor in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.
    
    **Action:**
    
    Consider defining a bean of type 'com.spring.demospring.BookRepository' in your configuration.
    
    ```java
    @Service
    public class BookService {
    
       BookRepository bookRepository;
    		
    		**/*μμ±μ μ£Όμ λ°©μ*/**
        **/*μμ±μ λ§€κ°λ³μμμ BookRepository νμμ λΉμ΄ μλ€κ³  μλ €μ£Όκ³  μλ€.*/**
        **/*λ°μ μλ¬ : Parameter 0 of constructor in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.*/**
        @Autowired
        public BookService(BookRepository bookRepository){
            this.bookRepository = bookRepository;
        }
    }
    ```
    
- **setter μ£Όμ λ°©μ**
    
    **Description:**
    
    Parameter 0 of method setBookRepository in com.spring.demospring.BookService required a bean of type 'com.spring.demospring.BookRepository' that could not be found.
    
    **Action:**
    
    Consider defining a bean of type 'com.spring.demospring.BookRepository' in your configuration.
    
    ```java
    @Service
    public class BookService {
    
       BookRepository bookRepository;
    		
    		**/*setter μ£Όμ λ°©μ*/
    		/*@Autowired(required = false)*/**
        @Autowired
        public void **setBookRepository**(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }
    }
    ```
    

π **μμ±μ μ£Όμ λ°©μκ³Ό setter μ£Όμ λ°©μμ μ°¨μ΄μ **

λ λ°©μ λͺ¨λ BookRepository κ° λΉμΌλ‘ λ±λ‘λμ΄ μμ§ μμ κ²½μ° μλμ λνλλ μλ¬ μ½λκ° λμΌνλ€. 

νμ§λ§, μμ±μ μ£Όμ λ°©μμ κ²½μ° BookService μ μΈμ€ν΄μ€λ₯Ό μμ±νκΈ° μν΄ BookRepository κ° λ°λμ νμν κ²μ΄κ³ , 

setter μ£Όμ λ°©μμ κ²½μ° BookServiceμ μΈμ€ν΄μ€λ BookRepository μμ΄λ μμ±μ΄ λμ΄μΌ νλλ°, 

ν΄λΉ ν΄λμ€(BookService)μμ @Autowired μ΄λΈνμ΄μμ λ³΄κ³  μμ‘΄μ± μ£Όμμ νλ €κ³  νκ³  μκΈ° λλ¬Έμ μμ κ°μ΄ μλ¬ μ½λκ° λμΌνλ κ²μ΄λ€. 

κ·Έλμ setter μ£Όμ λ°©μμ κ²½μ°BookServiceμ μΈμ€ν΄μ€λ§ μμ±νμ¬ μ¬μ© νλ €λ©΄ μλμ κ°μ μμ±μ μΆκ°ν΄μ£Όλ©΄ λλ€. 

**@Autowired(required = false)**

κ·ΈλΌ μμ κ°μ΄ λ°μνλ μλ¬λ λ°μνμ§ μλλ€. (BookServiceλ μ μμ μΌλ‘ λΉμΌλ‘ λ±λ‘λ κ²μ΄κ³ , BookRepositoryλ μμ§ λΉμΌλ‘ λ±λ‘λμ§ μμ.)

- **νλ μ£Όμ λ°©μ**
    
    setter μ£Όμ λ°©μκ³Ό λμΌνκ² BookService μ μΈμ€ν΄μ€λ μμ±μ΄ λ  μ μκ³ , BookRepository μ λν λΉ λ±λ‘μ Optional μ΄λ€. 
    
    ```java
    @Service
    public class BookService {
    
        **/*νλ μ£Όμ λ°©μ*/**
        @Autowired(required = false)
        BookRepository bookRepository;
    
    }
    ```
    

> **μμ‘΄μ± μ£Όμμ μν λΉμ΄ μ¬λ¬ κ°μΈ κ²½μ°**
> 

1) BookRepositoryλ₯Ό μΈν°νμ΄μ€λ‘ λ§λ€κ³ , ν΄λΉ μΈν°νμ΄μ€μ κ΅¬νμ²΄λ₯Ό λ κ° λ§λ λ€. `MyBookRepository`, `YourBookRepository`

μ΄ λ, λ κ΅¬νμ²΄μ λͺ¨λ @Repository μ΄λΈνμ΄μ λΆμ¬ 

2) BookServiceμμ BookRepositoryλ₯Ό μμ‘΄μ± μ£Όμ λ°μΌλ €κ³  νλ©΄ μ΄λ€ κ΅¬νμ²΄λ₯Ό μ£Όμ λ°λμ§ νμΈνλ€.

κ²°κ³Όλ μλμ κ°μ μλ¬κ° λ°μνλ€. 

μ€νλ§μμ μμ‘΄μ± μ£Όμμ νλ €κ³  νλλ° ν΄λΉ **κ΅¬νμ²΄κ° 2κ°λΌ λ¬΄μμ μ£Όμν΄μΌ νλμ§ λͺ¨λ₯΄κ² λ€**κ³   μλ €μ£Όκ³  μλ€. 

λν, **ν΄κ²° λ°©μμ μ μ**νκ³  μλ€. **β @Primary μ¬μ© or @Qualifier μ¬μ© or λͺ¨λ  κ΅¬νμ²΄λ₯Ό λ€ μ£Όμ λ°κΈ°** 

**Description:**

Field bookRepository in com.spring.demospring.BookService required a single bean, **but 2 were found**:
- myBookRepository: defined in file [C:\SpringBootStudy\demoSpring\target\classes\com\spring\demospring\MyBookRepository.class]
- yourBookRepository: defined in file [C:\SpringBootStudy\demoSpring\target\classes\com\spring\demospring\YourBookRepository.class]

**Action:**

Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

π‘ **ν΄κ²°νκΈ°**

**1) @Primary**

λ΄κ° μ°μ μμλ₯Ό λΆμ¬ν  ν΄λΉ κ΅¬νμ²΄μ @Primary μ΄λΈνμ΄μμ λΆμ¬νλ€. (μ¬λ¬ κ΅¬νμ²΄ μ€ ν΄λΉ ν΄λμ€κ° 1μμκ° λλ κ²μ΄λ€.)

```java
@Repository 
**@Primary**
public class MyBookRepository implements BookRepository{

}
```

**μλλ μ£Όμλ λΉμ΄ μ΄λ€ κ΅¬νμ²΄μΈμ§ νμΈ νλ μ½λμ΄λ€.** 

**κ²°κ³Ό : class com.spring.demospring.MyBookRepository**

1. BookService μμ bookRepositoryμ ν΄λμ€λ₯Ό μΆλ ₯νλ λ©μλ μμ±
    
    ```java
    public void printBookRepository(){
        **/*μ΄λ€ κ΅¬νμ²΄κ° μμ±λμλμ§ ν΄λΉ ν΄λμ€λ₯Ό μΆλ ₯ν΄λ³΄λ λ°©λ²*/**
        System.out.println(bookRepository.getClass());
    }
    ```
    
2. ApplicationRunner μΈν°νμ΄μ€λ₯Ό κ΅¬νν BookServiceRunner ν΄λμ€ μμ±
    
    bookService μμ‘΄μ± μ£Όμμ λ°μμ bookServiceμ λ©μλ printBookRepository()λ₯Ό νΈμΆνλ€. 
    
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

μμ‘΄μ± μ£Όμμ λ°λ μ½λμμ **@Qualifier μ΄λΈνμ΄μμ κ΄νΈ μμ μ£Όμλ°κ³ μ νλ κ΅¬νμ²΄μ μ΄λ¦(μΉ΄λ©μΌμ΄μ€)μ μ μ΄μ€λ€.** 

(ex. MyBookRepository λ₯Ό μ£Όμ λ°κ³ μ νλ©΄ myBookRepository, YourBookRepositoryμ κ²½μ° yourBookRepository λΌκ³  κΈ°μ¬ν΄μ€λ€)

```java
@Service
public class BookService {

    BookRepository bookRepository;*/

    @Autowired **@Qualifier("yourBookRepository")**
    BookRepository bookRepository;

    public void printBookRepository(){
        **/*μ΄λ€ κ΅¬νμ²΄κ° μμ±λμλμ§ ν΄λΉ ν΄λμ€λ₯Ό μΆλ ₯ν΄λ³΄λ λ°©λ²*/**
        System.out.println(bookRepository.getClass());
    }
}
```

**κ²°κ³Ό : class com.spring.demospring.YourBookRepository**

**3) λͺ¨λ  κ΅¬νμ²΄λ₯Ό μ£Όμ λ°λ λ°©μ**

μ£Όμ λ°κ³ μ νλ μΈν°νμ΄μ€λ₯Ό μ λ€λ¦­μ λ£μ΄μ£Όκ³ , List νμμΌλ‘ λ°μμ€λ€. 

```java
@Service
public class BookService {

    @Autowired
    **List<BookRepository>** bookRepositories;

    public void printBookRepository(){
        
        **/*μ£Όμ λ°μ λͺ¨λ  κ΅¬νμ²΄λ₯Ό μΆλ ₯νλ μ½λ*/**
        this.bookRepositories.forEach(System.out::println);
    }
}
```

**κ²°κ³Ό : com.spring.demospring.MyBookRepository@36bf84e, com.spring.demospring.YourBookRepository@1a0b5323**

**4) λ³μ λͺμΌλ‘ μ£Όμ λ°μ κ΅¬νμ²΄μ μ΄λ¦(μΉ΄λ©μΌμ΄μ€)μ μ μ΄μ€λ€.** 

```java
@Service
public class BookService {

    **/*μ£Όμ λ°μ κ΅¬νμ²΄μ ν΄λμ€ μ΄λ¦μ μΉ΄λ©μΌμ΄μ€λ‘ λ³κ²½νμ¬ λ³μλͺμ μ€μ */**
    @Autowired
    BookRepository **myBookRepository**;

    public void printBookRepository(){
        System.out.println(myBookRepository.getClass());
    }
}
```

**κ²°κ³Ό : class com.spring.demospring.MyBookRepository**
