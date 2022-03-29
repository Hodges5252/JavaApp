package com.example.appproject;

import java.util.Scanner;

public class HealthGoal extends Goal
{
    String uOM = "lbs";
    int goalWeight = 0;
    int weightChange = 0;
    int difference;
    int distance;


    public void getIncDec() //figures out if we are counting progress up or down
    {
        Boolean loop = false;

        while (!loop)
        {
            System.out.println("Do you want to gain or lose weight?\n (gain/lose) ");
            Scanner myObj = new Scanner(System.in);

            String input = myObj.nextLine();
            if (input.equals("gain"))
            {
                incDec = true;
                goalName = "gain";
                loop = true;
            }
            else if (input.equals("lose"))
            {
                incDec = false;
                goalName = "lose";
                loop = true;
            }
            else
            {
                System.out.println("ERROR: please enter either GAIN or LOSE");
            }
        }
    }

    public void getEndGoal()
    {
        System.out.println("please enter a unit of measurment");
        Scanner weight = new Scanner(System.in);

        uOM = weight.nextLine();

        System.out.println("In "+ uOM + ", How much weight do you want to " + goalName + "?");
        Scanner myObj = new Scanner(System.in);

        endGoal = Integer.parseInt(myObj.nextLine());
    }

    public void getGoalWeight()
    {
        if (incDec)
        {
            goalWeight = current + endGoal;
        }
        else
        {
            goalWeight = current - endGoal;
        }

        goalName = (goalName + " " + goalWeight + " " + uOM);
        getDifference();
        distance = difference;
    }
    public void getCurrentProgress()
    {
        System.out.println("How much do you weigh now? ");
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
                "% complete with your goal to " + goalName + "!\n" + motivate );
    }

    public void update()
    {
        if(!complete)
        {
            System.out.println("Please enter current weight");

            Scanner myObj = new Scanner(System.in);
            current = Integer.parseInt(myObj.nextLine());

            getDifference();
            weightChange += difference;

            if ((current == endGoal) || (incDec && current > endGoal) || (!incDec && current < endGoal))
            {
                complete();
            }
        }
        else
        {
            calcProgress();
        }


    }

    public void getDifference()
    {
        difference = goalWeight - current;
    }


    public void newGoal()
    {
        getIncDec();
        getEndGoal();
        getCurrentProgress();
        getGoalWeight();
        getDifference();
    }
}
