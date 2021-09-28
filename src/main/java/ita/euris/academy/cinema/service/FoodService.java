package ita.euris.academy.cinema.service;

import java.util.List;
import ita.euris.academy.cinema.data.dto.FoodDto;

public interface FoodService {

  public List<FoodDto> getAll();

  public FoodDto get(Long id);

  public FoodDto add(FoodDto dto);

  public FoodDto update(FoodDto dto);

  public Boolean delete(Long id);
}
