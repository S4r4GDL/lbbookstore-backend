package br.ueg.progweb1.lbbookstore.repository;

import br.ueg.progweb1.lbbookstore.model.mug.Mug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface MugRepository extends JpaRepository<Mug, Long> {
    Mug findMugByActive(boolean active);
    Mug findAllByThemeContainingIgnoreCase(String theme);
    Mug findAllByPriceLessThan(BigDecimal price);
}
