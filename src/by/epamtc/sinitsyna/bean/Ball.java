/*
 * Создать класс Мяч. Создать класс Корзина. 
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.bean;

import java.io.Serializable;

public class Ball implements Serializable {

	private static final long serialVersionUID = 1L;

	private int weight;
	private String color;

	public Ball() {
		weight = 1;
	}

	public Ball(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		if (color == null) {
			return "the color is not specified";
		}
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = result * prime + weight;
		result = result * prime + ((color == null) ? 0 : color.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Ball ball = (Ball) obj;
		if (weight != ball.weight) {
			return false;
		}
		if (color == null) {
			if (ball.color != null) {
				return false;
			}
		} else if (!color.equals(ball.color)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [weight=" + weight + ", color=" + color + "]";
	}

}
