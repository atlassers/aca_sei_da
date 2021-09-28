package ita.euris.academy.cinema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ita.euris.academy.cinema.data.dto.TicketDto;
import ita.euris.academy.cinema.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {

  @Autowired
  TicketService ticketService;
  
  @GetMapping("/v1")
  public List<TicketDto> getAll() {
    return ticketService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public TicketDto getById(@PathVariable("id") Long id) {
    return ticketService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return ticketService.delete(id);
  }
  
  @PostMapping("/v1")
  public TicketDto insert(@RequestBody TicketDto dto) {
    return ticketService.add(dto);
  }
  
  @PutMapping("/update/v1")
  public TicketDto update(@RequestBody TicketDto dto) {
    return ticketService.update(dto);
  }
  
  @PutMapping("/update-time/v1")
  public void updateTime(Long id, String time) {
    ticketService.updateTime(id, time);
  }
  
  @PatchMapping("/patch/v1")
  public TicketDto patch(@RequestBody TicketDto dto) {
    return ticketService.update(dto);
  }
  
  @GetMapping("/empty-ticket")
  public Integer getEmptyTicketByIdFilm(Long id) {
    return ticketService.getEmptyTicketByIdFilm(id);
  }
}
