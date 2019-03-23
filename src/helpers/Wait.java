package helpers;

public class Wait {

	public Wait() {
		// TODO Auto-generated constructor stub
	}
	public static void sleep(double sec) {
		try {
			Thread.sleep((long)(sec * 1000));
		}catch(InterruptedException e) {
			e.getMessage();
		}
	}
}
