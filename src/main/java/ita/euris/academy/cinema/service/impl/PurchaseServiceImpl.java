package ita.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ita.euris.academy.cinema.data.dto.PurchaseDto;
import ita.euris.academy.cinema.data.model.FoodPurchase;
import ita.euris.academy.cinema.data.model.PurchaseCinema;
import ita.euris.academy.cinema.exception.IdMustBeNullException;
import ita.euris.academy.cinema.exception.IdMustNotBeNullException;
import ita.euris.academy.cinema.repository.PurchaseRepository;
import ita.euris.academy.cinema.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

  @Autowired
  PurchaseRepository purchaseRepository;

  @Override
  public List<PurchaseDto> getAll() {
    return purchaseRepository.findAll().stream().map(PurchaseCinema::toDto).collect(Collectors.toList());
  }

  @Override
  public PurchaseDto get(Long id) {
    Optional<PurchaseCinema> purchase = purchaseRepository.findById(id);

    if (purchase.isPresent()) {
      return purchase.get().toDto();
    }
    return null;
  }

  @Override
  public PurchaseDto add(PurchaseDto dto) {
    if (dto.getId() != null) {
      throw new IdMustBeNullException();
    }

    return purchaseRepository.save(dto.toModel()).toDto();
  }

  @Override
  public PurchaseDto update(PurchaseDto dto) {
    if (dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }

    return purchaseRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    purchaseRepository.deleteById(id);

    return purchaseRepository.findById(id).isEmpty();
  }

}
