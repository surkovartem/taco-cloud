package com.artemsurkov.tacocloud.model;

import lombok.Data;

/**
 * Class Ingredient.
 * У каждого ингредиента есть название и тип, позволяющие
 * его визуально классифицировать (белки, жиры, соусы и т.д).
 * У каждого есть идентификатор, по которому на него можно ссылаться.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 16.07.2022
 */

@Data
public class Ingredient {
  private final String id;
  private final String name;
  private final Type type;

  /**
   * Возможные типы ингредиентов.
   *
   * @author artemsurkov
   * @version 1.0
   */
  public enum Type {
   WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
  }
}
