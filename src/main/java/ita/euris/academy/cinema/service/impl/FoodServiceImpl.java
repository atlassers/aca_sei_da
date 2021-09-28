package ita.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ita.euris.academy.cinema.data.dto.FoodDto;
import ita.euris.academy.cinema.data.model.Food;
import ita.euris.academy.cinema.exception.IdMustBeNullException;
import ita.euris.academy.cinema.exception.IdMustNotBeNullException;
import ita.euris.academy.cinema.repository.FoodRepository;
import ita.euris.academy.cinema.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

  @Autowired
  FoodRepository foodRepository;

  @Override
  public List<FoodDto> getAll() {
    return foodRepository.findAll()
        .stream().map(Food::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public FoodDto get(Long id) {
    Optional<Food> food = foodRepository.findById(id);
    
    if(food.isPresent()) {
      return food.get().toDto();
    }
    return null;
  }

  @Override
  public FoodDto add(FoodDto dto) {
    if(dto.getId() != null) {
      throw new IdMustBeNullException();
    }
    
    return foodRepository.save(dto.toModel()).toDto();
  }

  @Override
  public FoodDto update(FoodDto dto) {
    if(dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }
    return foodRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    foodRepository.deleteById(id);
    
    return foodRepository.findById(id).isEmpty();
  }
  
  
}
