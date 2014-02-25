package bitsandpiecestwo;
import java.text.DecimalFormat;
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
		
		float result = 2.0F + (6/7.0F);
		
		System.out.println(result);
		
		int aVar;
		long bVar;
		
		float cVar = 10.0F;
		double dVar = 10.0;
		
		System.out.println(10/3.0);
		
		double firstDouble = 0.66666/0.43333;
		double secondDouble = 66666.0/43333.0;
		
		if(firstDouble == secondDouble) {
			System.out.println("Doubles are the same");
		}
		
		System.out.println(firstDouble + " " + secondDouble);
		
		double precision = 1.0E-06;
		System.out.println(precision);
		
		DecimalFormat formatter = new DecimalFormat("0.0000000");
		System.out.println("Precision " + formatter.format(precision));
	
		System.out.format("****  %4.2f has some value   %4.2f\n", firstDouble, secondDouble);
		
		double difference = firstDouble - secondDouble;
		
		// which is bigger or smaller???
		
		Double firstBigDouble = firstDouble;
		Double secondBigDouble = secondDouble;
		
		if(firstBigDouble.compareTo(secondBigDouble) > 0) {
			System.out.println("First is bigger than second");
		}
	}
	
	public boolean withinDelta(double first, double second, double plusMinus) {
		if(first + plusMinus > second) {
			return false;
		}
			
		if(first - plusMinus < second) {
			return false;
		}
		
		return true;
	}

}
