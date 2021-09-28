package ita.euris.academy.cinema.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ita.euris.academy.cinema.data.dto.FilmDto;
import ita.euris.academy.cinema.data.dto.FoodDto;
import ita.euris.academy.cinema.service.FilmService;

@RestController
@RequestMapping("/films")
public class FilmController {

  @Autowired
  FilmService filmService;
  
  @GetMapping("/v1")
  public List<FilmDto> getAll() {
    return filmService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public FilmDto getById(@PathVariable("id") Long id) {
    return filmService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return filmService.delete(id);
  }
  
  @PostMapping("/v1")
  public FilmDto insert(@RequestBody FilmDto dto) {
    return filmService.add(dto);
  }
  
  @PutMapping("/v1")
  public FilmDto update(@RequestBody FilmDto dto) {
    return filmService.update(dto);
  }
}
