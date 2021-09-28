package ita.euris.academy.cinema.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ita.euris.academy.cinema.data.dto.FilmDto;
import ita.euris.academy.cinema.data.model.Film;
import ita.euris.academy.cinema.exception.IdMustBeNullException;
import ita.euris.academy.cinema.exception.IdMustNotBeNullException;
import ita.euris.academy.cinema.repository.FilmRepository;
import ita.euris.academy.cinema.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService {

  @Autowired
  FilmRepository filmRepository;

  @Override
  public List<FilmDto> getAll() {
    return filmRepository.findAll().stream().map(Film::toDto).collect(Collectors.toList());
  }

  @Override
  public FilmDto get(Long id) {
    Optional<Film> film = filmRepository.findById(id);

    if (film.isPresent()) {
      return film.get().toDto();
    }
    return null;
  }

  @Override
  public FilmDto add(FilmDto dto) {
    if (dto.getId() != null) {
      throw new IdMustBeNullException();
    }

    return filmRepository.save(dto.toModel()).toDto();
  }

  @Override
  public FilmDto update(FilmDto dto) {
    if (dto.getId() == null) {
      throw new IdMustNotBeNullException();
    }

    return filmRepository.save(dto.toModel()).toDto();
  }

  @Override
  public Boolean delete(Long id) {
    filmRepository.deleteById(id);

    return filmRepository.findById(id).isEmpty();
  }

}
