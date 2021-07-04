/*
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.runner;

import java.math.BigInteger;

import by.epamtc.sinitsyna.bean.BallBasket;
import by.epamtc.sinitsyna.exception.NonPositiveException;
import by.epamtc.sinitsyna.exception.NullBasketException;
import by.epamtc.sinitsyna.input.UserDataInput;
import by.epamtc.sinitsyna.logic.BallBasketLogic;
import by.epamtc.sinitsyna.presentation.BallBasketView;

public class Main {
	public static void main(String[] args) {
		BigInteger weight;
		BigInteger ballsAmount;
		String color;
		BallBasket basket;
		boolean removeResult;
		UserDataInput input = new UserDataInput();
		BallBasketLogic logic = new BallBasketLogic();
		BallBasketView view = new BallBasketView();

		try {
			basket = input.requestBalls("Пожалуйста, введите количество мячиков для добавления в корзину >>");
			view.printBasketContent(basket);

			removeResult = basket.removeBall(input
					.requestBall("Для удаления мячика из корзины, пожалуйста, введите запрашиваемые ниже данные:"));
			if (removeResult) {
				view.printBasketContent(basket);
			} else {
				System.out.println("Подобного мячика в корзине нет, состав корзины не изменился.");
			}

			weight = logic.retrieveAllBallsWeight(basket);
			System.out.printf("Масса всех мячиков в корзине равна %d г.\n", weight);

			color = input.requestString("Для вывода общего количества, пожалуйста, введите желаемый цвет мячика >>");
			ballsAmount = logic.retrieveBallsAmountByColor(basket, color);
			System.out.printf("Количество мячиков с цветом \"%s\" в корзине равно %d шт.\n", color, ballsAmount);

		} catch (NonPositiveException | NullBasketException e) {
			System.out.println(e.getMessage());
		}

	}
}
