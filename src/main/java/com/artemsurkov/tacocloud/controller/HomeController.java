package com.artemsurkov.tacocloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * Поскольку HomeController снабжен аннотацией @Controller,
 * механизм сканирования в Spring автоматически обнаружит его
 * и создаст экземпляр HomeController как bean-компонент в
 * контексте приложения Spring.
 */

/**
 * HomeController - класс контроллер домашней страницы.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 16.07.2022
 */
@Controller
public class HomeController {
  @GetMapping("/")
  public String home() {
    return "home";
  }
}