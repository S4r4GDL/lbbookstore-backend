package br.ueg.progweb1.lbbookstore.repository;

import br.ueg.progweb1.lbbookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByActive(Boolean active);

    List<Book> findAllByAuthorContainsIgnoreCase(String author);

    List<Book> findAllByTitleContainsIgnoreCase(String title);

    List<Book> findAllByPublisherContainsIgnoreCase(String publisher);

    List<Book> findAllByReleaseYear(Integer year);

    List<Book> findAllByPriceLessThan(BigDecimal price);

}
