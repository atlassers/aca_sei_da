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
import ita.euris.academy.cinema.data.dto.FoodPurchaseDto;
import ita.euris.academy.cinema.service.FoodPurchaseService;

@RestController
@RequestMapping("/food-purchases")
public class FoodPurchaseController {
  
  @Autowired
  FoodPurchaseService foodPurchaseService;
  
  @GetMapping("/v1")
  public List<FoodPurchaseDto> getAll() {
    return foodPurchaseService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public FoodPurchaseDto getById(@PathVariable("id") Long id) {
    return foodPurchaseService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return foodPurchaseService.delete(id);
  }
  
  @PostMapping("/v1")
  public FoodPurchaseDto insert(@RequestBody FoodPurchaseDto dto) {
    return foodPurchaseService.add(dto);
  }
  
  @PutMapping("/v1")
  public FoodPurchaseDto update(@RequestBody FoodPurchaseDto dto) {
    return foodPurchaseService.update(dto);
  }

}
