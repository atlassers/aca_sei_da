package ita.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ita.euris.academy.cinema.data.model.FoodPurchase;

public interface FoodPurchaseRepository extends JpaRepository<FoodPurchase, Long> {

}
