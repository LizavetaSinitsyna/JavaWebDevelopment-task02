/*
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.logic;

import java.math.BigInteger;
import java.util.Map;

import by.epamtc.sinitsyna.bean.Ball;
import by.epamtc.sinitsyna.bean.BallBasket;
import by.epamtc.sinitsyna.exception.NullBasketException;
import by.epamtc.sinitsyna.validation.ValidationHelper;

public class BallBasketLogic {
	public BigInteger retrieveAllBallsWeight(BallBasket basket) throws NullBasketException {
		if (ValidationHelper.isNull(basket)) {
			throw new NullBasketException("Basket can't be equal to null.");
		}
		Ball ball;
		Integer ballAmount;
		long ballWeight;
		long ballGeneralWeight;

		BigInteger allBallsWeight = new BigInteger("0");

		for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
			ball = element.getKey();
			ballAmount = element.getValue();
			if (!ValidationHelper.isNull(ball) && !ValidationHelper.isNull(ballAmount)) {
				ballWeight = ball.getWeight();
				ballGeneralWeight = ballWeight * ballAmount;
				allBallsWeight = allBallsWeight.add(new BigInteger(Long.toString(ballGeneralWeight)));
			}

		}

		return allBallsWeight;
	}

	public BigInteger retrieveBallsAmountByColor(BallBasket basket, String color) throws NullBasketException {
		if (ValidationHelper.isNull(basket)) {
			throw new NullBasketException("Basket can't be equal to null.");
		}
		Ball ball;
		Integer separateBallAmount;
		BigInteger generalAmount = new BigInteger("0");

		for (Map.Entry<Ball, Integer> element : basket.getBalls().entrySet()) {
			ball = element.getKey();
			if (!ValidationHelper.isNull(ball) && ball.getColor().equals(color)) {
				separateBallAmount = element.getValue();
				if (!ValidationHelper.isNull(separateBallAmount)) {
					generalAmount = generalAmount.add(new BigInteger(separateBallAmount.toString()));
				}
			}
		}

		return generalAmount;
	}
}
