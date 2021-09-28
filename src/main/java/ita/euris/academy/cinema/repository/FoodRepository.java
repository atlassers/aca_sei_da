package ita.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ita.euris.academy.cinema.data.model.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {

}
