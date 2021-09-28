package ita.euris.academy.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ita.euris.academy.cinema.data.dto.FoodDto;
import ita.euris.academy.cinema.service.FoodService;
import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {

  @Autowired
  FoodService foodService;
  
  @GetMapping("/v1")
  public List<FoodDto> getAll() {
    return foodService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public FoodDto getById(@PathVariable("id") Long id) {
    return foodService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return foodService.delete(id);
  }
  
  @PostMapping("/v1")
  public FoodDto insert(@RequestBody FoodDto dto) {
    return foodService.add(dto);
  }
  
  @PutMapping("/v1")
  public FoodDto update(@RequestBody FoodDto dto) {
    return foodService.update(dto);
  }
}
