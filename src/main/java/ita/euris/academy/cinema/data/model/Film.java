package ita.euris.academy.cinema.data.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import ita.euris.academy.cinema.data.archetype.Dto;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.dto.FilmDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "film")
@Entity
public class Film implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "title")
  private String title;

  @Override
  public FilmDto toDto() {
    return FilmDto.builder()
        .id(id.toString())
        .title(title)
        .build();
  }
  
}
