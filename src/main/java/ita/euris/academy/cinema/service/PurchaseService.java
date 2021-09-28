package ita.euris.academy.cinema.service;

import java.util.List;
import ita.euris.academy.cinema.data.dto.PurchaseDto;

public interface PurchaseService {

  public List<PurchaseDto> getAll();

  public PurchaseDto get(Long id);

  public PurchaseDto add(PurchaseDto dto);

  public PurchaseDto update(PurchaseDto dto);

  public Boolean delete(Long id);
}
