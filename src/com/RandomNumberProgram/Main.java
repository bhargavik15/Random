package com.RandomNumberProgram;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Main implements GameMethod
{
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);
    int count = 0;
    int count1 = 1;
    int random_number;
    int guess;
    @Override
    public void RandomNumberLogic()
    {
        System.out.println("Enter the number between 1 to 10");
        random_number = ran.nextInt(10) + 1;
        boolean correct = false;
        while (!correct) {
            System.out.println("Guess Attempt " + count1);
            count1++;
            guess = sc.nextInt();
            count++;
            if (random_number == guess)
            {
                correct = true;
                System.out.println("You Guessed The Correct Number :" + guess);
                System.out.println("Numbers of attempts taken : " + count);
            }

            else if (guess < random_number)
            {
                correct = false;
                System.out.println("Too Low , Try Again:");

            }
            else
            {
                correct = false;
                System.out.println("Too High , Try Again");
            }
        }
    }
    @Override
    public void GameResultStore()
    {
        try
        {
            FileWriter GameResult = new FileWriter("C:\\Users\\bhargavi\\Desktop\\RandomFile\\guess.txt");
            if(random_number == guess)
            {
                GameResult.write("You Guessed correct number in  "+count+"  Attempts");
                GameResult.write("Result stored");
            }
            GameResult.close();
        }
        catch (IOException e)
        {
            System.out.println("Error Occured");
            e.printStackTrace();
        }
    }
}






