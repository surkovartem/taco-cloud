package com.artemsurkov.tacocloud.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * Class TacoOrder - класс представляющий заказы, которые клиенты
 * будут оставлять на сайте, с информацией о рецепте, оплате и доставке.
 *
 * @author artemsurkov
 * @version 1.0
 * @since 16.07.2022
 */

@Data
public class TacoOrder {

  private String deliveryName;
  private String deliveryStreet;
  private String deliveryCity;
  private String deliveryRegion;
  private String deliveryIndex;
  private String ccNumber;
  private String ccExpiration;
  private String ccCvc;

  private List<Taco> tacos = new ArrayList<>();

  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }
}