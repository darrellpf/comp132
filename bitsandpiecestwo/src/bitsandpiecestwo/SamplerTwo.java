package bitsandpiecestwo;
import java.util.ArrayList;
import java.util.List;

import static bitsandpiecestwo.BallPurchase.*;

public class SamplerTwo {

	public static void main(String[] args) {
		
		BallPurchase aPurchase = FIVE_FOR_FIFTEEN;

		int balls = aPurchase.getBalls();
		System.out.println(balls);
		
		List<Fish> allFish = new ArrayList<>();
		
		List<Integer> intList = new ArrayList<>();
		
		intList.add(new Integer(66));
		
		Integer anIntegerObject = intList.get(0);
		int value = anIntegerObject.intValue();
		
		intList.add(new Integer(77));
		
		Integer anIntegerObjectTwo = intList.get(1);
		int valueTwo = anIntegerObject.intValue();
		
		int sum = value + valueTwo;
		Integer sumInteger = new Integer(sum);
		intList.set(0, sumInteger);
		
		// -----------
		
		Integer first = 66;
		// Integer first = new Integer(66);
		
		int valueSomething = first;
		// Integer valueSomething = first.intValue();
	}

}
