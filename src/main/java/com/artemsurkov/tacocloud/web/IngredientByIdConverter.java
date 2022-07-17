package com.artemsurkov.tacocloud.web;

import com.artemsurkov.tacocloud.model.Ingredient;
import com.artemsurkov.tacocloud.model.Ingredient.Type;
import java.util.HashMap;
import java.util.Map;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Класс-конвертер, для преобразования String в Ingredient.
 * Необходим, по той причине, что в отображении /design флажки
 * checkBox'ов имеют текстовые значения, а объект Taco представляет
 * список ингредиентов Ingredient. Для перевода текстовых строк
 * ["FLTO", "GRBF", "LETC"] в Ingredient используется метод описанный
 * в данном клссе (convert).
 *
 * @author artemsurkov
 * @version 1.0
 * @since 18.07.2022
 */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

  private Map<String, Ingredient> ingredientMap = new HashMap<>();

  /**
   * Создание экземляра Map с ключами типа String, которые служат
   * идентификаторами ингредиентов, и значениями типа Ingredient,
   * представляющие сами объекты.
   *
   * @since 18.07.2022
   */
  //TODO: заменить конвертер так, чтобы он извлекал ингредиенты из базы данных.
  public IngredientByIdConverter() {
    ingredientMap.put("FLTO", new Ingredient("FLTO", "Пшеничная тортилья", Type.WRAP));
    ingredientMap.put("COTO", new Ingredient("COTO", "Кукурузная тортилья", Type.WRAP));
    ingredientMap.put("GRBF", new Ingredient("GRBF", "Фарш из говядины", Type.PROTEIN));
    ingredientMap.put("CARN", new Ingredient("CARN", "Карнитас", Type.PROTEIN));
    ingredientMap.put("TMTO", new Ingredient("TMTO", "Томаты", Type.VEGGIES));
    ingredientMap.put("LETC", new Ingredient("LETC", "Салат", Type.VEGGIES));
    ingredientMap.put("CHED", new Ingredient("CHED", "Чеддер", Type.CHEESE));
    ingredientMap.put("JACK", new Ingredient("JACK", "Monterrey Jack", Type.SAUCE));
    ingredientMap.put("SLSA", new Ingredient("SLSA", "Сальса", Type.SAUCE));
    ingredientMap.put("SRCR", new Ingredient("SRCR", "Сметана", Type.SAUCE));
  }

  @Override
  public Ingredient convert(String id) {
    return ingredientMap.get(id);
  }
}