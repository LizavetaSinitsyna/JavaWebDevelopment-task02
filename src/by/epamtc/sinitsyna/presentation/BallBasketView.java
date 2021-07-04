/*
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.presentation;

import java.util.Map;

import by.epamtc.sinitsyna.bean.Ball;
import by.epamtc.sinitsyna.bean.BallBasket;
import by.epamtc.sinitsyna.validation.ValidationHelper;

public class BallBasketView {
	public void printBasketContent(BallBasket basket) {
		if (ValidationHelper.isNull(basket) || basket.isEmpty()) {
			System.out.println("Корзина пуста.");
		} else {
			Ball ball;
			Integer separateBallAmount;
			int pointer = 0;

			System.out.println("В корзине находятся следующие мячи: ");
			for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
				++pointer;
				ball = element.getKey();
				separateBallAmount = element.getValue();
				if (ValidationHelper.isNull(ball)) {
					System.out.printf("%d) Мяч не задан.\n", pointer);
				} else {
					System.out.printf("%d) Мяч массой %d г, цвет \"%s\" в количестве %d шт.\n", pointer,
							ball.getWeight(), ball.getColor(), separateBallAmount == null ? 0 : separateBallAmount);
				}

			}
		}

	}
}
