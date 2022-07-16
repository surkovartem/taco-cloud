package com.artemsurkov.tacocloud.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * testHomePage - метод проверки домашней страницы.
 * В числе результатов выполнения запроса ожидается:
 * 1. Ответ должен иметь статус HTTP 200(OK).
 * 2. Представление должно иметь логическое имя home.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 16.07.2022
 */

/*
 * @WebMvcTest - аннотация из Spring Boot, которая организует запуск теста
 * в контексте приложения Spring MVC. В данном примере она обеспечивает
 * регистрацию класса HomeController в SpringMVC, чтобы дать возможность
 * отправлять ему запросы.
 * Также настраивает поддержку тестрирования Spring MVC в Spring.
 */

@WebMvcTest(HomeController.class) // Тест для HomeController
public class HomeControllerTest {

    // Объект MockMvc для управления фиктивным объектом
    @Autowired
    private MockMvc mockMvc; // Внедрить MockMvc

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform(get("/")) //Выполнить запрос GET
                .andExpect(status().isOk()) //Ожидается код ответа HTTP 200
                .andExpect(view().name("home")); //Ожидается имя представления home
    }
}
