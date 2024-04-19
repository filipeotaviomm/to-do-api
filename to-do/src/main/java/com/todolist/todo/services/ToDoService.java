package com.todolist.todo.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.todolist.todo.models.ToDoModel;
import com.todolist.todo.exceptions.BadRequestException;
import com.todolist.todo.repositories.ToDoRepository;

@Service
public class ToDoService {
  private ToDoRepository toDoRepository;

  public ToDoService(ToDoRepository toDoRepository) {
    this.toDoRepository = toDoRepository;
  }

  public List<ToDoModel> list() {
    Sort sort = Sort.by(Direction.DESC, "prioridade")
        .and(Sort.by(Direction.ASC, "id"));

    return toDoRepository.findAll(sort);
  }

  public List<ToDoModel> create(ToDoModel payload) {
    toDoRepository.save(payload);
    return list();
  }

  public List<ToDoModel> update(Long id, ToDoModel payload) {
    toDoRepository.findById(id).ifPresentOrElse((existingTodo) -> {
      payload.setId(id);
      toDoRepository.save(payload);
    }, () -> {
      throw new BadRequestException("ToDoModel %d não existe! ".formatted(id));
    });

    return list();

  }

  public List<ToDoModel> delete(Long id) {
    toDoRepository.findById(id).ifPresentOrElse((existingTodo) -> toDoRepository
        .delete(existingTodo), () -> {
          throw new BadRequestException("ToDoModel %d não existe! ".formatted(id));
        });
    return list();
  }
}
