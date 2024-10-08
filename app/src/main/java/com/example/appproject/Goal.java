package com.example.appproject;
import java.util.Scanner;

public class Goal
{

        String goalName;
        Boolean incDec;
        int endGoal;
        int current;
        float progress;
        Boolean complete;
        int ID;

    String uOM;
    int goalWeight;
    int weightChange;
    int difference;
    int distance;

    public Goal()
    {
        goalName = "EMPTY";
        incDec = true;
        endGoal = 0;
        current = 0;
        progress = 0;
        complete = false;
    }
    public Goal(String pgoalName, Boolean pincDec, int pendGoal, int pcurrent, float pprogress, Boolean pcomplete, int pID)
    {
        goalName = pgoalName;
        incDec = pincDec;
        endGoal = pendGoal;
        current = pcurrent;
        progress = pprogress;
        complete = pcomplete;
        ID = pID;
    }


    public void getGoalName() //gets the name of the goal
    {
        Scanner myObj = new Scanner(System.in);
        System.out.println("ENTER GOAL:");

        goalName = myObj.nextLine();
    }

    public void getIncDec() //figures out if we are counting progress up or down
    {
        Boolean loop = false;

        while (!loop)
        {
            System.out.println("TO " + goalName + ", WILL YOU GO UP OR DOWN?\n(up/down)");
            Scanner myObj = new Scanner(System.in);

            String input = myObj.nextLine();
            if (input.equals("up"))
            {
                incDec = true;
                loop = true;
            }
            else if (input.equals("down"))
            {
                incDec = false;
                loop = true;
            }
            else
            {
                System.out.println("INCORRECT. PLEASE TRY AGAIN.");
            }
        }
    }

    public void getEndGoal()
    {
        System.out.println("WHAT IS THE END GOAL? ");
        Scanner myObj = new Scanner(System.in);

        endGoal = Integer.parseInt(myObj.nextLine());
    }

    public void getCurrentProgress()
    {
        System.out.println("ENTER CURRENT PROGRESS ");
        Scanner myObj = new Scanner(System.in);

        current = Integer.parseInt(myObj.nextLine());
    }

    public void calcProgress()
    {
        progress = (((float)current / endGoal) * 100);
        System.out.println("YOU ARE " + progress + "% COMPLETE WITH YOUR GOAL OF " + goalName);
    }

    public void update() {}

    public void complete()
    {
        complete = true;
        System.out.println("You completed your goal! Congratulations!!");
        goalName = (goalName + " (complete)");
    }

    public void newGoal()
    {
        ID = 0;
        getGoalName();
        getIncDec();
        getEndGoal();
        getCurrentProgress();
        calcProgress();
    }
}
