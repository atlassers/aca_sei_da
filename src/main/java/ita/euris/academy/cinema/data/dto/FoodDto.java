package ita.euris.academy.cinema.data.dto;

import ita.euris.academy.cinema.data.archetype.Dto;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.model.Food;
import ita.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FoodDto implements Dto {

  private String id;
  
  private String name;
  
  private String unitPrice;
  
  @Override
  public Food toModel() {
    return Food.builder()
        .id(UT.toLong(id))
        .name(name)
        .unitPrice(Double.parseDouble(unitPrice))
        .build();
  }

}
