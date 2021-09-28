package ita.euris.academy.cinema.service;

import java.util.List;
import ita.euris.academy.cinema.data.dto.TicketDto;
import ita.euris.academy.cinema.data.model.Ticket;

public interface TicketService {

  public List<TicketDto> getAll();

  public TicketDto get(Long id);

  public TicketDto add(TicketDto dto);

  public TicketDto update(TicketDto dto);

  public Boolean delete(Long id);
  
  public Integer getEmptyTicketByIdFilm(Long id);
  
  public void updateTime(Long id, String time);
}
