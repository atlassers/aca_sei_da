package ita.euris.academy.cinema.data.dto;

import ita.euris.academy.cinema.data.archetype.Dto;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.model.PurchaseCinema;
import ita.euris.academy.cinema.data.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PurchaseDto implements Dto {

  private String id;
  
  private String email;
  
  private String ticketId;
  
  @Override
  public PurchaseCinema toModel() {
    return PurchaseCinema.builder().id(Long.parseLong(id)).email(email).ticketId(new Ticket()).build();
  }

}
