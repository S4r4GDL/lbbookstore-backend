package br.ueg.progweb1.lbbookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface BookRepository<Book> extends JpaRepository<Book, Long> {


}
