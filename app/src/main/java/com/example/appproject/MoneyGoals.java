package com.example.appproject;

import java.util.Scanner;

public class MoneyGoals extends Goal
{

    public void getGoalName() //gets the name of the goal
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("What do you want to save for?");

        goalName = myObj.nextLine();
    }


    public void getEndGoal()
    {
        System.out.println("How much does a " + goalName + " cost?");
        Scanner myObj = new Scanner(System.in);

        endGoal = Integer.parseInt(myObj.nextLine());
    }

    public void getCurrentProgress()
    {
            System.out.println("How much money do you have now? ");
            Scanner myObj = new Scanner(System.in);

            current = Integer.parseInt(myObj.nextLine());
    }

    public void calcProgress()
    {
        String motivate;
        if(complete)
        {
            progress = 100;
            motivate = "You did it!";
        }
        else
        {
            motivate = "Keep it up!";
            progress = (((float)current / endGoal) * 100);
        }
            System.out.println("You are " + progress +
                    "% closer to buying a " + goalName +"!\n" + motivate);
    }

    public void update()
    {
        if(!complete)
        {
            getCurrentProgress();
            if (current >= endGoal)
            {
                complete();
            }
        }
        else
        {
            calcProgress();
        }
    }


    public void newGoal()
    {
        getGoalName();
        getEndGoal();
        getCurrentProgress();
    }
}
