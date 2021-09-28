package ita.euris.academy.cinema.data.dto;

import ita.euris.academy.cinema.data.archetype.Dto;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.model.Food;
import ita.euris.academy.cinema.data.model.FoodPurchase;
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
public class FoodPurchaseDto implements Dto {

  private String id;
  
  private String foodId;
  
  private String quantity;
  
  private String ticketId;
  
  @Override
  public FoodPurchase toModel() {
    return FoodPurchase.builder()
        .id(Long.parseLong(id))
        .foodId(new Food())
        .quantity(Integer.parseInt(quantity))
        .ticketId(new Ticket()).build();
  }

}
