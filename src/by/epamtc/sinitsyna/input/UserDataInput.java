/*
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.input;

import java.util.Scanner;

import by.epamtc.sinitsyna.bean.Ball;
import by.epamtc.sinitsyna.bean.BallBasket;
import by.epamtc.sinitsyna.exception.NonPositiveException;

public class UserDataInput {
	private Scanner scanner = new Scanner(System.in);

	public BallBasket requestBalls(String message) throws NonPositiveException {
		Ball ball;
		int requestsAmount;
		int ballsAmount;
		BallBasket balls = new BallBasket();

		requestsAmount = requestInt(message);
		if (requestsAmount < 1) {
			throw new NonPositiveException("The amount of balls to add can't be less than 1.");
		}

		for (int i = 1; i <= requestsAmount; i++) {
			ball = requestBall("Пожалуйста, введите информацию ниже для мячика №" + i);
			ballsAmount = requestInt("Пожалуйста, введите количество мячиков №" + i);
			if (ballsAmount < 1) {
				throw new NonPositiveException("The amount of balls to add can't be less than 1.");
			}
			balls.addBall(ball, ballsAmount);
		}

		return balls;
	}

	public Ball requestBall(String message) throws NonPositiveException {
		int weight;
		String color;
		Ball ball;

		System.out.println(message);

		weight = requestInt("масса мячика в граммах >>");
		if (weight < 1) {
			throw new NonPositiveException("The weight can't be negative or equal to 0.");
		}
		color = requestString("цвет мячика >>");

		ball = new Ball(weight, color);

		return ball;
	}

	public int requestInt(String message) {

		int number;

		System.out.println(message);

		while (!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.println(message);
		}

		number = scanner.nextInt();
		scanner.nextLine();

		return number;
	}

	public String requestString(String message) {

		System.out.println(message);

		return scanner.nextLine();
	}

}
