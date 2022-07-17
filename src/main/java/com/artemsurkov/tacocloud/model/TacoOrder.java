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

  private String deliverName;
  private String deliverStreet;
  private String deloverCity;
  private String deliverState;
  private String deliverZip;
  private String ccNumber;
  private String ccExpiration;
  private String ccCvv;

  private List<Taco> tacos = new ArrayList<>();

  public void addTaco(Taco taco) {
    this.tacos.add(taco);
  }
}