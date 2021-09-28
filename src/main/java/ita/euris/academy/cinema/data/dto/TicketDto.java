package ita.euris.academy.cinema.data.dto;

import ita.euris.academy.cinema.data.archetype.Dto;
import ita.euris.academy.cinema.data.model.Film;
import ita.euris.academy.cinema.data.model.Ticket;
import ita.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TicketDto implements Dto {

  private String id;
  
  private String idFilm;
  
  private String unitPrice;
  
  private String quantity;
  
  private String time;
  
  @Override
  public Ticket toModel() {
    return Ticket.builder()
        .id(UT.toLong(id))
        .idFilm(Film.builder().id(UT.toLong(idFilm)).build())
        .unitPrice(UT.toDouble(unitPrice))
        .quantity(UT.toInt(quantity))
        .time(UT.getScreeningTime(time))
        .build();
  }

}
