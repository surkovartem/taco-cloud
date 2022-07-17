package com.artemsurkov.tacocloud.controller;

import com.artemsurkov.tacocloud.model.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * OrderControllet - класс, перенаправляющий пользователя
 * на форму заказа, откуда он сможет сделать заказ на доставку
 * своего тако.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 18.07.2022
 */
@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {

  /**
   * Обработка GET-запроса, с путем orders/current.
   *
   * @return страница представления формы текущего заказа.
   * @since 18.07.2022
   */
  //TODO: при появлении бд изменить. Заполнение модели Taco в порядке их создания.
  @GetMapping("/current")
  public String orderForm() {
    return "orderForm";
  }

  /**
   * Обработка POST-запроса с путем /orders.
   * После запуска метода, ему будет передан объект TacoOrder
   * со значениями свойст, полученными из полей отправленной формы.
   * На данный момент метод просто регистрирует объект TacoOrder в журнале.
   * Метод setCompleate() гарантирует, что сеанс очищен и готов к приему
   * нового заказа, когда пользователь создаст тако.
   *
   * @since 18.07.2022
   */
  @PostMapping
  public String processOrder(TacoOrder order, SessionStatus sessionStatus) {
    log.info("Заказ создан: {}", order);
    sessionStatus.setComplete();
    return "redirect:/";
  }
}