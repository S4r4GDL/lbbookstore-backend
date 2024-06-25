package br.ueg.progweb1.lbbookstore;

import br.ueg.progweb1.lbbookstore.enums.ProductType;
import br.ueg.progweb1.lbbookstore.enums.UserRole;
import br.ueg.progweb1.lbbookstore.model.book.Book;
import br.ueg.progweb1.lbbookstore.model.cart.Cart;
import br.ueg.progweb1.lbbookstore.model.client.Client;
import br.ueg.progweb1.lbbookstore.model.mug.Mug;
import br.ueg.progweb1.lbbookstore.model.user.Login;
import br.ueg.progweb1.lbbookstore.model.user.User;
import br.ueg.progweb1.lbbookstore.repository.BookRepository;
import br.ueg.progweb1.lbbookstore.repository.ClientRepository;
import br.ueg.progweb1.lbbookstore.repository.MugRepository;
import br.ueg.progweb1.lbbookstore.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class AppStartupRunner implements ApplicationRunner {
    public static final String CREATE_DROP="create-drop";
    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MugRepository mugRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserRepository userRepository;


    public void initializeData(){
        LOG.info("Getting started with initializeData...");
        if(!this.ddlAuto.equalsIgnoreCase(CREATE_DROP)){
            return;
        }
        LOG.info("...Adding Book data...");
        Book newBook = Book.builder()
                .name("The Yellow heart")
                .author("Pablo Neruda")
                .edition("Pocket 2ed")
                .publisher("MoonPub")
                .releaseYear(2002)
                .price(new BigDecimal("15.00"))
                .quantity(10)
                .lastUpdate(LocalDate.now())
                .pages(300)
                .type(ProductType.BOOK)
                .active(true)
                .description(" Poems collection by pablo neruda ").build();

        this.bookRepository.save(newBook);

        newBook = Book.builder()
            .name("Echoes of Andromeda")
            .author("Anya Petrova")
            .edition("1st Edition")
            .publisher("Galactic Press")
            .releaseYear(2015)
            .price(new BigDecimal("18.99"))
            .quantity(0)
            .pages(100)
            .type(ProductType.BOOK)
            .lastUpdate(LocalDate.now())
            .active(true)
            .description("A science fiction novel that explores the mysteries of" +
                    " space travel and contact with alien civilizations.")
                .build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .name("1984")
                .author("George Orwell")
                .edition("1st Edition")
                .publisher("Galactic Press")
                .releaseYear(1949)
                .price(new BigDecimal("25.99"))
                .quantity(12)
                .pages(200)
                .type(ProductType.BOOK)
                .lastUpdate(LocalDate.now())
                .active(true)
                .description("The story follows Winston Smith," +
                        " a man who rebels against the oppressive regime.").build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .name("The Da Vinci code")
                .author("Daw Brown")
                .edition("13st Edition")
                .publisher("Galactic Press")
                .releaseYear(2003)
                .price(new BigDecimal("12.99"))
                .quantity(12)
                .pages(100)
                .type(ProductType.BOOK)
                .lastUpdate(LocalDate.now())
                .active(true).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .name("Love in the Time of Cholera")
                .author("Gabriel Garcia Marques")
                .edition("10st Pocket")
                .publisher("Star Press")
                .releaseYear(1972)
                .price(new BigDecimal("20.99"))
                .quantity(16)
                .pages(300)
                .type(ProductType.BOOK)
                .lastUpdate(LocalDate.now())
                .active(true)
                .description("Follows the enduring love story of Florentino Ariza" +
                        " and Fermina Daza, who experience a passionate romance in their youth.").build();

        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .name("Memories of My Melancholy Whores")
                .author("Gabriel Garcia Marques")
                .edition("10st ")
                .publisher("Record Press")
                .releaseYear(2005)
                .price(new BigDecimal("70.00"))
                .quantity(0)
                .pages(350)
                .type(ProductType.BOOK)
                .lastUpdate(LocalDate.now())
                .active(false).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .name("The Metamorphosis")
                .author("Franz Kafka")
                .edition("1st Edition")
                .publisher("Principis")
                .releaseYear(1915)
                .price(new BigDecimal("14.99"))
                .quantity(60)
                .pages(96)
                .type(ProductType.BOOK)
                .lastUpdate(LocalDate.now())
                .active(true)
                .description("Tells the story of Gregor Samsa, a traveling salesman" +
                        " who wakes up one morning transformed into a giant insect.").build();
        this.bookRepository.save(newBook);

        LOG.info("...Adding Mug data...");

        Mug newMug = Mug.builder().name("Hollow knight")
                        .price(new BigDecimal("47.99"))
                        .quantity(15)
                        .msl(450)
                        .type(ProductType.MUG)
                        .lastUpdate(LocalDate.now())
                        .active(true).build();

        this.mugRepository.save(newMug);

        newMug = Mug.builder().name("Lonely hearts")
                .price(new BigDecimal("39.99"))
                .quantity(10)
                .msl(400)
                .type(ProductType.MUG)
                .lastUpdate(LocalDate.now())
                .active(true).build();

        this.mugRepository.save(newMug);

        newMug = Mug.builder().name("Flowers")
                .price(new BigDecimal("25.00"))
                .quantity(20)
                .msl(400)
                .type(ProductType.MUG)
                .lastUpdate(LocalDate.now())
                .active(true).build();

        this.mugRepository.save(newMug);

        newMug = Mug.builder().name("New wave")
                .price(new BigDecimal("50.00"))
                .quantity(0)
                .msl(400)
                .type(ProductType.MUG)
                .lastUpdate(LocalDate.now())
                .active(false).build();

        this.mugRepository.save(newMug);

        LOG.info("...Adding User data...");

        User newUser = User.builder().
                name("SaraADM").
                userName("saraadm7321@gmail.com").
                lastUpdate(LocalDate.now()).
                role(UserRole.ADMIN).
                login(new Login()).
                dataCreate(LocalDate.now()).build();
        newUser.getLogin().setUser(newUser);
        newUser.getLogin().setPassword(passwordEncoder.encode("123456789"));
        this.userRepository.save(newUser);

        Client newClient = Client.builder().
                name("Sara").
                userName("sara7321@gmail.com").
                cart(new Cart()).
                dataBirth(LocalDate.now()).
                lastUpdate(LocalDate.now()).
                role(UserRole.USER).
                login(new Login()).
                dataCreate(LocalDate.now()).build();
        newClient.getLogin().setUser(newClient);
        newClient.getLogin().setPassword(passwordEncoder.encode("123456789"));
        this.clientRepository.save(newClient);




        LOG.info("...End of initializeData");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            this.initializeData();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}