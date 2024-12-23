package se.liu.denjo163.lab1;

public class Exercise2
{
    public static int sumFor(int min, int max) {
	int sum = 0;
	for (int i = min; i <= max; i++) {
	    sum += i;
	}
	return  sum;
    }


    public static void main(String[] args) {
	final int min = 10;
	final int max = 20;
	int resultSumFor = sumFor(min, max);
	int resultSumWhile = sumWhile(min, max);
	System.out.println(resultSumFor);
	System.out.println(resultSumWhile);
    }

    public static int sumWhile(int min, int max) {
	int i = min;
	int sum = 0;
	do {
	    sum += i;
	    i++;
	}
	while ( i <= max);
	return sum;
    }
}