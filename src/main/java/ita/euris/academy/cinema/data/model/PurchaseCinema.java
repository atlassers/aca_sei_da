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
import ita.euris.academy.cinema.data.dto.PurchaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "purchase_cinema")
@Entity
public class PurchaseCinema implements Model {
  
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "email")
  private String email;
  
  @ManyToOne
  @JoinColumn(name = "ticket_id")
  private Ticket ticketId;
  
  @Override
  public PurchaseDto toDto() {
    return PurchaseDto.builder().id(id.toString()).email(email).ticketId(ticketId.getId().toString()).build();
  }

}
