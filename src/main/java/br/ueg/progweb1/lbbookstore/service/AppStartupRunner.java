package br.ueg.progweb1.lbbookstore.service;

import br.ueg.progweb1.lbbookstore.model.Book;
import br.ueg.progweb1.lbbookstore.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class AppStartupRunner implements ApplicationRunner {
    public static final String CREATE_DROP="create-drop";
    private static final Logger LOG =
            LoggerFactory.getLogger(AppStartupRunner.class);

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddlAuto;

    @Autowired
    private BookRepository bookRepository;

    public void initializeData(){
        LOG.info("Getting started with initializeData...");
        if(!this.ddlAuto.equalsIgnoreCase(CREATE_DROP)){
            return;
        }
        Book newBook = Book.builder()
                .title("The Yellow heart")
                .author("Pablo Neruda")
                .edition("Pocket 2ed")
                .publisher("MoonPub")
                .releaseYear(2002)
                .price(new BigDecimal("15.00"))
                .quantity(10)
                .lastUpdate(LocalDate.now())
                .active(true).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
            .title("Echoes of Andromeda")
            .author("Anya Petrova")
            .edition("1st Edition")
            .publisher("Galactic Press")
            .releaseYear(2015)
            .price(new BigDecimal("18.99"))
            .quantity(10)
            .lastUpdate(LocalDate.now())
            .active(true).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .title("1984")
                .author("George Orwell")
                .edition("1st Edition")
                .publisher("Galactic Press")
                .releaseYear(1949)
                .price(new BigDecimal("25.99"))
                .quantity(12)
                .lastUpdate(LocalDate.now())
                .active(true).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .title("The Da Vinci code")
                .author("Daw Brown")
                .edition("13st Edition")
                .publisher("Galactic Press")
                .releaseYear(2003)
                .price(new BigDecimal("12.99"))
                .quantity(12)
                .lastUpdate(LocalDate.now())
                .active(true).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .title("Love in the Time of Cholera")
                .author("Gabriel Garcia Marques")
                .edition("10st Pocket")
                .publisher("Star Press")
                .releaseYear(1972)
                .price(new BigDecimal("20.99"))
                .quantity(16)
                .lastUpdate(LocalDate.now())
                .active(true).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .title("Memories of My Melancholy Whores")
                .author("Gabriel Garcia Marques")
                .edition("10st ")
                .publisher("Record Press")
                .releaseYear(2005)
                .price(new BigDecimal("70.00"))
                .quantity(0)
                .lastUpdate(LocalDate.now())
                .active(false).build();
        this.bookRepository.save(newBook);

        newBook = Book.builder()
                .title("The Metamorphosis")
                .author("Franz Kafka")
                .edition("1st Edition")
                .publisher("Principis")
                .releaseYear(1915)
                .price(new BigDecimal("14.99"))
                .quantity(60)
                .lastUpdate(LocalDate.now())
                .active(true).build();
        this.bookRepository.save(newBook);

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