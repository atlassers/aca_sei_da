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
import ita.euris.academy.cinema.data.dto.PurchaseDto;
import ita.euris.academy.cinema.service.PurchaseService;

@RestController
@RequestMapping("/purchases-cinema")
public class PurchaseCinemaController {

  @Autowired
  PurchaseService purchaseService;
  
  @GetMapping("/v1")
  public List<PurchaseDto> getAll() {
    return purchaseService.getAll();
  }
  
  @GetMapping("/v1/{id}")
  public PurchaseDto getById(@PathVariable("id") Long id) {
    return purchaseService.get(id);
  }
  
  @DeleteMapping("/v1/{id}")
  public Boolean delete(@PathVariable("id") Long id) {
    return purchaseService.delete(id);
  }
  
  @PostMapping("/v1")
  public PurchaseDto insert(@RequestBody PurchaseDto dto) {
    return purchaseService.add(dto);
  }
  
  @PutMapping("/v1")
  public PurchaseDto update(@RequestBody PurchaseDto dto) {
    return purchaseService.update(dto);
  }
}
