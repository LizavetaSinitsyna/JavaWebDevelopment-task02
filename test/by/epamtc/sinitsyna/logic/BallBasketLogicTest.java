package by.epamtc.sinitsyna.logic;

import java.math.BigInteger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import by.epamtc.sinitsyna.bean.Ball;
import by.epamtc.sinitsyna.bean.BallBasket;
import by.epamtc.sinitsyna.exception.NonPositiveException;
import by.epamtc.sinitsyna.exception.NullBasketException;

public class BallBasketLogicTest {
	private BallBasketLogic logic;

	@Before
	public void initLogic() {
		logic = new BallBasketLogic();
	}

	@Test
	public void testRetrieveAllBallsWeight() throws NonPositiveException, NullBasketException {
		BallBasket basket = new BallBasket();
		basket.addBall(new Ball(2, "black"), 3);
		basket.addBall(new Ball(3, "black"), 2);
		basket.addBall(new Ball());
		BigInteger expected = new BigInteger("13");
		BigInteger actual = logic.retrieveAllBallsWeight(basket);
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = NullBasketException.class)
	public void testRetrieveAllBallsWeightWhenPassedNullBasket() throws NonPositiveException, NullBasketException {
		BallBasket basket = null;
		logic.retrieveAllBallsWeight(basket);
	}

	@Test
	public void testRetrieveBallsAmountByColor() throws NullBasketException, NonPositiveException {
		BallBasket basket = new BallBasket();
		basket.addBall(new Ball(2, "black"), 3);
		basket.addBall(new Ball(3, "black"), 2);
		basket.addBall(new Ball(3, "red"), 2);
		basket.addBall(new Ball());
		BigInteger expected = new BigInteger("5");
		BigInteger actual = logic.retrieveBallsAmountByColor(basket, "black");
		Assert.assertEquals(expected, actual);
	}

	@Test(expected = NullBasketException.class)
	public void testRetrieveBallsAmountByColorWhenPassedNullBasket() throws NullBasketException, NonPositiveException {
		BallBasket basket = null;
		logic.retrieveBallsAmountByColor(basket, "black");
	}

}
