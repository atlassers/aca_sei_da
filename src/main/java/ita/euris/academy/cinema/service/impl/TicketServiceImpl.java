package ita.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Ticker;
import ita.euris.academy.cinema.data.dto.TicketDto;
import ita.euris.academy.cinema.data.model.FoodPurchase;
import ita.euris.academy.cinema.data.model.Ticket;
import ita.euris.academy.cinema.exception.IdMustBeNullException;
import ita.euris.academy.cinema.exception.IdMustNotBeNullException;
import ita.euris.academy.cinema.repository.TicketRepository;
import ita.euris.academy.cinema.service.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  TicketRepository ticketRepository;
  
  @Override
  public List<TicketDto> getAll() {
    return ticketRepository.findAll().stream().map(Ticket::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public TicketDto get(Long id) {
    Optional<Ticket> ticket = ticketRepository.findById(id);

    if (ticket.isPresent()) {
      return ticket.get().toDto();
    }
    return null;
  }

  @Override
  public TicketDto add(TicketDto dto) {
    if (dto.getId() != null) {
      throw new IdMustBeNullException();
    }

    return ticketRepository.save(dto.toModel()).toDto();
  }

  @Override
  public TicketDto update(TicketDto dto) {
    if (dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }

    return ticketRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    ticketRepository.deleteById(id);

    return ticketRepository.findById(id).isEmpty();
  }
  
  @Override
  public Integer getEmptyTicketByIdFilm(Long id) {
    return ticketRepository.getEmptyTicketByIdFilm(id);
  }
  
  @Override
  public void updateTime(Long id, String time) {
    ticketRepository.updateTime(id, time);
  }

}
