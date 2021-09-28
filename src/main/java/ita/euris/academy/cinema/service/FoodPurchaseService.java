package ita.euris.academy.cinema.service;

import java.util.List;
import ita.euris.academy.cinema.data.dto.FoodPurchaseDto;

public interface FoodPurchaseService {

  public List<FoodPurchaseDto> getAll();

  public FoodPurchaseDto get(Long id);

  public FoodPurchaseDto add(FoodPurchaseDto dto);

  public FoodPurchaseDto update(FoodPurchaseDto dto);

  public Boolean delete(Long id);
}
