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
		Ball ball;
		Integer ballAmount;
		long separateBallWeight;
		BigInteger generalWeight = new BigInteger("0");

		if (basket != null) {
			for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
				ball = element.getKey();
				ballAmount = element.getValue();
				separateBallWeight = (long) ((ball == null) ? 0 : ball.getWeight())
						* (ballAmount == null ? 0 : ballAmount);
				generalWeight = generalWeight.add(new BigInteger(Long.toString(separateBallWeight)));
			}
		}
		return generalWeight;
	}

	public BigInteger retrieveBallsAmountByColor(BallBasket basket, String color) {
		Ball ball;
		Integer separateBallAmount;
		BigInteger generalAmount = new BigInteger("0");

		if (basket != null) {
			for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
				ball = element.getKey();
				if (ball != null && ball.getColor().equals(color)) {
					separateBallAmount = element.getValue();
					generalAmount = generalAmount
							.add(new BigInteger(separateBallAmount == null ? "0" : separateBallAmount.toString()));
				}
			}
		}
		return generalAmount;
	}
}
