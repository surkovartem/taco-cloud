package com.artemsurkov.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Программа Taco-cloud реализует приложение в рамках
 * изучения Spring FrameWork.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 16.07.2022
 */

/*
 * SpringBootApplication - объединяет в себе три аннотации:
 * 1. SpringBootConfiguration - определяет класс как как класс конфигурацию.
 *    Является специализированной формой аннотации @Configuration.
 *
 * 2. EnabledAutoConfiguration - включает конфигурацию Spring Boot.
 *    Сообщает Spring Boot о необходимости автоматически настраивать
 *    любые компоненты, которые могут понадобиться.
 *
 * 3. ComponentScan - сканирование компонентов.
 *    Позволяет объявлять другие классы с аннотациями, такие как
 *    @Component, @Controller, @Service.
 */
@SpringBootApplication
public class TacoCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}

}
