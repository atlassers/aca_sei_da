package ita.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ita.euris.academy.cinema.data.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
