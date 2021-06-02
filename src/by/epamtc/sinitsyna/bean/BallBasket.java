/*
 * Создать класс Мяч. Создать класс Корзина.
 * Наполнить корзину мячиками. Определить вес мячиков в корзине и количество синих мячиков.
 */

package by.epamtc.sinitsyna.bean;

import java.io.Serializable;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class BallBasket implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<Ball, Integer> balls;

	public BallBasket() {
		balls = new Hashtable<>();
	}

	public BallBasket(Map<Ball, Integer> balls) {
		setBalls(balls);
	}

	public Iterator<Entry<Ball, Integer>> getBallsIterator() {
		return balls.entrySet().iterator();
	}

	public Map<Ball, Integer> getBalls() {
		return Collections.unmodifiableMap(balls);
	}

	public void setBalls(Map<Ball, Integer> balls) {
		for (Map.Entry<Ball, Integer> element : balls.entrySet()) {
			if (element.getValue() == null) {
				element.setValue(0);
			}
		}
		this.balls = balls;
	}

	public void addBall(Ball ball, int ballsAmount) {
		if (balls.containsKey(ball)) {
			balls.put(ball, balls.get(ball) + ballsAmount);
		} else {
			balls.put(ball, ballsAmount);
		}
	}

	public boolean removeBall(Ball ball) {
		if (balls.containsKey(ball)) {
			if (balls.get(ball) == 1) {
				balls.remove(ball);
			} else {
				balls.replace(ball, balls.get(ball) - 1);
			}
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 1;
		result = result * prime + ((balls == null) ? 0 : balls.hashCode());
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
		BallBasket basket = (BallBasket) obj;
		if (balls == null) {
			if (basket.balls != null) {
				return false;
			}
		} else if (!balls.equals(basket.balls)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getClass().getName() + " [balls=" + balls + "]";
	}

}
