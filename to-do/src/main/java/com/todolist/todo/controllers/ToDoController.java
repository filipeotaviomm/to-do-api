package com.todolist.todo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.todo.models.ToDoModel;
import com.todolist.todo.services.ToDoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/todos")
public class ToDoController {
  @Autowired
  private ToDoService toDoService;

  @PostMapping
  ResponseEntity<List<ToDoModel>> create(@Valid @RequestBody ToDoModel payload) {
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(toDoService.create(payload));
  }

  @GetMapping
  List<ToDoModel> list() {
    return toDoService.list();
  }

  @PutMapping("{id}")
  List<ToDoModel> update(@PathVariable Long id, @RequestBody ToDoModel payload) {
    return toDoService.update(id, payload);
  }

  @DeleteMapping("{id}")
  List<ToDoModel> delete(@PathVariable Long id) {
    return toDoService.delete(id);
  }
}
