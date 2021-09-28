package ita.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ita.euris.academy.cinema.data.model.PurchaseCinema;

public interface PurchaseRepository extends JpaRepository<PurchaseCinema, Long> {

}
