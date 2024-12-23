package se.liu.denjo163.lab1;

import javax.swing.*;

public class Exercise7
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
	String input = JOptionPane.showInputDialog("Choose for or while function");
	String func;
	int resultSumFor = sumFor(min, max);
	int resultSumWhile = sumWhile(min, max);
	switch (input) {
	    case "for": System.out.println(resultSumFor);
		break;
	    case "while": System.out.println(resultSumWhile);
		break;
	    default: System.out.print("Invalid input");
	}
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