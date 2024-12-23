package se.liu.denjo163.lab1;

public class Exercise6
{
    public static boolean isPrime(int number) {
	int k = number - 1;
	for (int i = 2; i <= k; i++) {
	    int rest = number % i;
	    if (rest == 0) {
		return false;
		// number är en jämn multipel av i
	    }
	}
	return true;
    }


    public static void main(String[] args) {
	for (int i = 2; i <= 100; i++) {
	    int sum = i;
	    boolean resultIsPrime = isPrime(sum);
	    System.out.println(resultIsPrime);
	}
    }

}
