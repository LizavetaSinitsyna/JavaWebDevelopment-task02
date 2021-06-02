/*
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.logic;

import java.math.BigInteger;
import java.util.Map;

import by.epamtc.sinitsyna.bean.Ball;
import by.epamtc.sinitsyna.bean.BallBasket;

public class BallBasketLogic {
	public BigInteger retrieveAllBallsWeight(BallBasket basket) {
		BigInteger generalWeight = new BigInteger("0");
		long separateBallWeight;
		if (basket != null) {
			for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
				separateBallWeight = (long) element.getKey().getWeight() * element.getValue();
				generalWeight = generalWeight.add(new BigInteger(Long.toString(separateBallWeight)));
			}
		}
		return generalWeight;
	}

	public BigInteger retrieveBallsAmountByColor(BallBasket basket, String color) {
		BigInteger amount = new BigInteger("0");
		if (basket != null) {
			for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
				if (element.getKey().getColor().equals(color)) {
					amount = amount.add(new BigInteger(element.getValue().toString()));
				}
			}
		}
		return amount;
	}
}
