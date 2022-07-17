package com.artemsurkov.tacocloud.model;

import java.util.List;
import lombok.Data;

/**
 * Class Taco - основной класс модели сущности.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 16.07.2022
 */

@Data
public class Taco {

  private String name;
  private List<Ingredient> ingredients;

}