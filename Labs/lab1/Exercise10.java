package se.liu.denjo163.lab1;

public class Exercise10
{
    public static void main(String[] args) {
	int number = 16777217;
	double decimal = number;
	int interAgain = (int)decimal;
	int big = 2147483647;
	long bigger = (long)big+1L;
	System.out.println(number);
	System.out.println(decimal);
	System.out.println(interAgain);
	System.out.println(big);
	System.out.println(bigger);
    }
}
