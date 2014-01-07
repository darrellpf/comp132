package lab1;

public class Something {

	public static void main(String[] args) {

		int result = doMultiply(57, 63);

		System.out.println("Say something " + result);

	}

	public static int doMultiply(int x, int y) {

		System.out.println("Say something " + x);

		int z = x * y;

		return z;

	}

}
