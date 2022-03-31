package com.example.appproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public static void main (String[] args)
    {
        Boolean quit = false;
        SaveFile saveFile = new SaveFile();
        saveFile.load();
        Vector<Goal> gl = saveFile.loadVector;




        while (!quit)
        {
            System.out.println("Welcome to the App! Please choose an option\n" +
                    "1) Enter New Goal\n" +
                    "2) See Goal Progress\n" +
                    "3) Update Goal\n" +
                    "4) Quit\n");
            Scanner myObj = new Scanner(System.in);
            String option = myObj.nextLine();

            switch(option)
            {
                case "4":
                    System.out.println("See you soon!");
                    saveFile.save(gl);
                    quit = true;
                    break;
                case "1":
                    System.out.println("What Goal would you like to set?\n" +
                            "1) Save Money\n" +
                            "2) Gain/Lose Weight\n" +
                            "3) Back\n");

                    Scanner myObj1 = new Scanner(System.in);
                    String option1 = myObj1.nextLine();

                    switch(option1)
                    {
                        case "3":
                            break;
                        case "1":
                            Goal cash = new MoneyGoals();
                            cash.newGoal();
                            gl.add(cash);


                            break;
                        case "2":
                            Goal weight = new HealthGoal();
                            weight.newGoal();
                            gl.add(weight);
                            break;
                    }
                    break;
                case "2":
                    if (gl.isEmpty())
                    {
                        System.out.println("You currently have no goals, set some!");
                        break;
                    }

                    for (int i = 0; i < gl.size(); i++)
                    {
                        String name = gl.get(i).goalName;
                        System.out.println( "" + (i + 1) + ") " + name + "\n");
                    }
                    System.out.println("Pick a Goal (or choose '0' to go back)");

                    Scanner myObj2 = new Scanner(System.in);
                    int option2 = Integer.parseInt(myObj2.nextLine());

                    if (option2 == 0)
                    {
                        break;
                    }
                    gl.get(option2 - 1).calcProgress();
                    break;
                case "3":
                    if (gl.isEmpty())
                    {
                        System.out.println("You currently have no goals, set some!");
                        break;
                    }

                    for (int i = 0; i < gl.size(); i++)
                    {
                        System.out.println( "" + (i + 1) + ") " + gl.get(i).goalName);
                    }
                    System.out.println("Pick a Goal (or choose '0' to go back)\n");

                    Scanner myObj3 = new Scanner(System.in);
                    int option3 = Integer.parseInt(myObj3.nextLine());

                    if (option3 == 0)
                    {
                        break;
                    }
                    gl.get(option3 - 1).update();
                    saveFile.save(gl);
                    break;
            }
        }
    }
}