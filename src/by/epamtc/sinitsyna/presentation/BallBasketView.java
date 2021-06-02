/*
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.presentation;

import java.util.Map;

import by.epamtc.sinitsyna.bean.Ball;
import by.epamtc.sinitsyna.bean.BallBasket;

public class BallBasketView {
	public void printBasketContent(BallBasket basket) {
		if (basket == null) {
			System.out.println("Корзина пуста.");
		} else {
			int pointer = 0;
			System.out.println("В корзине находятся следующие мячи: ");
			for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
				++pointer;
				System.out.printf("%d) Мяч массой %d г, цвет \"%s\" в количестве %d шт.\n", pointer,
						element.getKey().getWeight(), element.getKey().getColor(), element.getValue());
			}
		}

	}
}
