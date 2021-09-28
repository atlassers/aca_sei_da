package ita.euris.academy.cinema.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import ita.euris.academy.cinema.data.archetype.Dto;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.dto.FoodPurchaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "food_purchase")
@Entity
public class FoodPurchase implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "food_id")
  private Food foodId;
  
  @Column(name = "quantity")
  private Integer quantity;
  
  @ManyToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticketId;
  
  @Override
  public FoodPurchaseDto toDto() {
    return FoodPurchaseDto.builder()
        .id(id.toString())
        .foodId(foodId.getId().toString())
        .quantity(quantity.toString())
        .ticketId(ticketId.getId().toString())
        .build();
  }

}
