package ita.euris.academy.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ita.euris.academy.cinema.data.dto.TicketDto;
import ita.euris.academy.cinema.data.model.Ticket;
import org.springframework.transaction.annotation.Transactional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

  @Query(value = "SELECT t.id FROM Ticket t WHERE t.unit_price is NULL AND t.quantity is NULL AND t.time is NULL AND t.id_film = :id_film", nativeQuery = true)
  Integer getEmptyTicketByIdFilm(@Param("id_film")Long id);
  
  @Transactional
  @Modifying
  @Query(value = "UPDATE Ticket t SET t.time = :time WHERE t.id = :id", nativeQuery = true)
  void updateTime(@Param("id")Long id, @Param("time") String time);
}
