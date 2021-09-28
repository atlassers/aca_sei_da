package ita.euris.academy.cinema.service;

import java.util.List;
import ita.euris.academy.cinema.data.dto.FilmDto;

public interface FilmService {

  public List<FilmDto> getAll();

  public FilmDto get(Long id);

  public FilmDto add(FilmDto dto);

  public FilmDto update(FilmDto dto);

  public Boolean delete(Long id);
}
