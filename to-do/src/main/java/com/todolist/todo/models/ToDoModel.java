package com.todolist.todo.models;

// import org.apache.commons.lang3.builder.EqualsBuilder;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
public class ToDoModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @Column(nullable = false)
  private String descricao;
  private boolean realizado;
  private int prioridade;

  public ToDoModel() {

  }

  public ToDoModel(
      Long id, String nome, String descricao, boolean realizado, int prioridade) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
  }

  public ToDoModel(String nome, String descricao, boolean realizado, int prioridade) {
    this.nome = nome;
    this.descricao = descricao;
    this.realizado = realizado;
    this.prioridade = prioridade;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public boolean isRealizado() {
    return realizado;
  }

  public void setRealizado(boolean realizado) {
    this.realizado = realizado;
  }

  public int getPrioridade() {
    return prioridade;
  }

  public void setPrioridade(int prioridade) {
    this.prioridade = prioridade;
  }

  // @Override
  // public boolean equals(Object obj) {
  // return EqualsBuilder.reflectionEquals(obj, this);
  // }

}
