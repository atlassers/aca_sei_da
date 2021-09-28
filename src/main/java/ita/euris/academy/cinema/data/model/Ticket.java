package ita.euris.academy.cinema.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import ita.euris.academy.cinema.data.archetype.Model;
import ita.euris.academy.cinema.data.dto.TicketDto;
import ita.euris.academy.cinema.data.enums.ScreeningTime;
import ita.euris.academy.cinema.utils.UT;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "ticket")
@Entity
public class Ticket implements Model {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne(cascade=CascadeType.ALL)
  @JoinColumn(name = "id_film")
  private Film idFilm;
  
  @Column(name = "unit_price")
  private Double unitPrice;
  
  @Column(name = "quantity")
  private Integer quantity;
  
  @Column(name = "time")
  @Enumerated(EnumType.STRING)
  private ScreeningTime time;
  
  @Override
  public TicketDto toDto() {
    return TicketDto.builder()
        .id(UT.numberToString(id))
        .idFilm(UT.numberToString(idFilm.getId()))
        .unitPrice(UT.numberToString(unitPrice))
        .quantity(UT.numberToString(quantity))
        .time(UT.getScreeningTime(time))
        .build();
  }

}
