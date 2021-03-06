package com.artemsurkov.tacocloud.controller;

import com.artemsurkov.tacocloud.model.Ingredient;
import com.artemsurkov.tacocloud.model.Ingredient.Type;
import com.artemsurkov.tacocloud.model.Taco;
import com.artemsurkov.tacocloud.model.TacoOrder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * DesignTacoController - класс составления рецепта тако.
 * Выполняет следующие действия:
 * принимает и обрабатывает HTTP-запросы GET с путем /design;
 * составляет список ингединетов;
 * передает запрос и ингредиенты в шаблон представления, который
 * будет преобразован в html и отправлен веб-браузеру.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 16.07.2022
 */
@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder") // TacoOrder должен поддерживаться на уровне сеанса.
public class DesignTacoController {

  /**
   * Метод добавления ингредиентов в модель.
   */
  //TODO: заменить получение ингредиентов с жесткого способоса на получение из БД.
  @ModelAttribute
  public void addIngredientsToModel(Model model) {
    List<Ingredient> ingredients = Arrays.asList(
      new Ingredient("FLTO", "Пшеничная тортилья", Type.WRAP),
      new Ingredient("COTO", "Кукурузная тортилья", Type.WRAP),
      new Ingredient("GRBF", "Фарш из говядины", Type.PROTEIN),
      new Ingredient("CARN", "Карнитас", Type.PROTEIN),
      new Ingredient("TMTO", "Томаты", Type.VEGGIES),
      new Ingredient("LETC", "Салат", Type.VEGGIES),
      new Ingredient("CHED", "Чеддер", Type.CHEESE),
      new Ingredient("JACK", "Monterrey Jack", Type.SAUCE),
      new Ingredient("SLSA", "Сальса", Type.SAUCE),
      new Ingredient("SRCR", "Сметана", Type.SAUCE)
    );

    Type[] types = Ingredient.Type.values();
    for (Type type : types) {
      model.addAttribute(
          type.toString().toLowerCase(),
          filterByType(ingredients, type)
      );
    }
  }

  /**
   * Создание объекта TacoOrder для размещения в model.
   * Хранит состояние собираемого заказа, пока клиент
   * выбирает ингредиенты для тако несколькими запросами.
   */
  @ModelAttribute(name = "tacoOrder")
  public TacoOrder order() {
    return new TacoOrder();
  }

  /**
   * Создание объекта Taco для размещения в model,
   * чтобы представление, отображаемое в ответ
   * на запрос GET с путем /design, имело объект отображения.
   */
  @ModelAttribute(name = "taco")
  public Taco taco() {
    return new Taco();
  }

  /**
   * Обработка запроса GET с путем /design.
   */
  @GetMapping
  public String showDesignForm() {
    return "design";
  }

  /**
   * Метод обработки POST-запроса по пути /design.
   * При отправке поля формы присваиваются свойствам объекта Taco,
   * который затем передается в качестве параметра данному методу.
   * Получив этот объект, метод добавляет объект Taco в объект TacoOrder,
   * который также передается в параметре, а затем записывает его в журнал.
   * Аннотация @ModelAttribute перед параметром TacoOrder указывает, что он
   * должен использовать объект TacoOrder, который был помещен в модель
   * методом order() с аннатацией @ModelAttribute.
   *
   * @param taco полученые из формы свойства объекта
   * @param tacoOrder объект, в который кладется полученный Taco
   * @return "redirect", представление с перенаправлением на другую страницу.
   */
  @PostMapping
  public String processTaco(Taco taco, @ModelAttribute TacoOrder tacoOrder) {
    tacoOrder.addTaco(taco);
    log.info("Обработка тако {}", taco);
    return "redirect:/orders/current";
  }


  /**
   * Фильтрация ингредиентов по типам.
   *
   * @param ingredients ингредиенты
   * @param type тип ингредиента
   * @return сортированный List ингредиентов по type.
   */
  private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients
        .stream()
        .filter(x -> x.getType().equals(type))
        .collect(Collectors.toList());
  }
}