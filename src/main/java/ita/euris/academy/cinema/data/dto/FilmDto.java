package ita.euris.academy.cinema.data.dto;

import ita.euris.academy.cinema.data.archetype.Dto;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.model.Film;
import ita.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class FilmDto implements Dto {

  private String id;
  private String title;
  
  @Override
  public Film toModel() {
    return Film.builder()
        .id(UT.toLong(id))
        .title(title)
        .build();
  }

}
