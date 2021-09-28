package ita.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ita.euris.academy.cinema.data.dto.FoodPurchaseDto;
import ita.euris.academy.cinema.data.model.FoodPurchase;
import ita.euris.academy.cinema.exception.IdMustBeNullException;
import ita.euris.academy.cinema.exception.IdMustNotBeNullException;
import ita.euris.academy.cinema.repository.FoodPurchaseRepository;
import ita.euris.academy.cinema.service.FoodPurchaseService;

@Service
public class FoodPurchaseServiceImpl implements FoodPurchaseService {

  @Autowired
  FoodPurchaseRepository foodPurchaseRepository;

  @Override
  public List<FoodPurchaseDto> getAll() {
    return foodPurchaseRepository.findAll().stream().map(FoodPurchase::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public FoodPurchaseDto get(Long id) {
    Optional<FoodPurchase> foodPurchase = foodPurchaseRepository.findById(id);

    if (foodPurchase.isPresent()) {
      return foodPurchase.get().toDto();
    }
    return null;
  }

  @Override
  public FoodPurchaseDto add(FoodPurchaseDto dto) {
    if (dto.getId() != null) {
      throw new IdMustBeNullException();
    }

    return foodPurchaseRepository.save(dto.toModel()).toDto();
  }

  @Override
  public FoodPurchaseDto update(FoodPurchaseDto dto) {
    if (dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }

    return foodPurchaseRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    foodPurchaseRepository.deleteById(id);

    return foodPurchaseRepository.findById(id).isEmpty();
  }


}
