package ita.euris.academy.cinema.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.dto.FoodDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "food")
@Entity
public class Food implements Model {
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "unit_price")
  private Double unitPrice;
  
  @Override
  public FoodDto toDto() {
    return FoodDto.builder()
        .id(id.toString())
        .name(name)
        .unitPrice(unitPrice.toString())
        .build();
  }

}
