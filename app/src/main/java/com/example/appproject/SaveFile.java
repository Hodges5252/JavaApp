package com.example.appproject;

import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Vector;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SaveFile
{

    Vector<Goal> loadVector = new Vector<>();

    public void save(@NonNull Vector<Goal> gl) {
        JSONArray saveFile = new JSONArray();
        for (int i = 0; i < gl.size(); i++) {
            JSONObject saveGoal = new JSONObject();
            JSONObject saveObject = new JSONObject();
            switch (gl.get(i).ID) {
                case 0: {
                    saveObject.put("ID", gl.get(i).ID);
                    saveObject.put("goalName", gl.get(i).goalName);
                    saveObject.put("incDec", gl.get(i).incDec);
                    saveObject.put("endGoal", gl.get(i).endGoal);
                    saveObject.put("current", gl.get(i).current);
                    saveObject.put("progress", gl.get(i).progress);
                    saveObject.put("complete", gl.get(i).complete);
                    saveGoal.put("goal", saveObject);
                    saveFile.add(saveGoal);
                }
                case 1: {
                    saveObject.put("ID", gl.get(i).ID);
                    saveObject.put("goalName", gl.get(i).goalName);
                    saveObject.put("incDec", gl.get(i).incDec);
                    saveObject.put("endGoal", gl.get(i).endGoal);
                    saveObject.put("current", gl.get(i).current);
                    saveObject.put("progress", gl.get(i).progress);
                    saveObject.put("complete", gl.get(i).complete);
                    saveObject.put("uOM", gl.get(i).uOM);
                    saveObject.put("goalWeight", gl.get(i).goalWeight);
                    saveObject.put("weightChange", gl.get(i).weightChange);
                    saveObject.put("difference", gl.get(i).difference);
                    saveObject.put("distance", gl.get(i).distance);
                    saveGoal.put("goal", saveObject);
                    saveFile.add(saveGoal);
                }
                case 2: {
                    saveObject.put("ID", gl.get(i).ID);
                    saveObject.put("goalName", gl.get(i).goalName);
                    saveObject.put("incDec", gl.get(i).incDec);
                    saveObject.put("endGoal", gl.get(i).endGoal);
                    saveObject.put("current", gl.get(i).current);
                    saveObject.put("progress", gl.get(i).progress);
                    saveObject.put("complete", gl.get(i).complete);
                    saveGoal.put("goal", saveObject);
                    saveFile.add(saveGoal);
                }
            }
        }



        try (FileWriter fw = new FileWriter("save.json")) {}
        catch (IOException e) {e.printStackTrace();}

        try (FileWriter file = new FileWriter("save.json"))
        {
            file.write(saveFile.toJSONString());
            file.flush();

        } catch (IOException e) { e.printStackTrace(); }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @SuppressWarnings("unchecked")
    public void load()
    {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("save.json"))
        {
            //Read JSON file
            Object obj = jsonParser.parse(reader);

            JSONArray loadFile = (JSONArray) obj;

            //Iterate over employee array

                loadFile.forEach((emp) -> parseFile( (JSONObject) emp ));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseFile(@NonNull JSONObject loadObject)
    {
        //Get employee object within list
        JSONObject loadFile = (JSONObject) loadObject.get("goal");

        long ID = (long) loadFile.get("ID");
        String goalName = (String) loadFile.get("goalName");
        Boolean incDec = (Boolean) loadFile.get("incDec");
        long endGoal = (long) loadFile.get("endGoal");
        long current = (long) loadFile.get("current");
        double progress = (double) loadFile.get("progress");
        Boolean complete = (Boolean) loadFile.get("complete");
        String uOM = "";
        long goalWeight = 0;
        long weightChange = 0;
        long difference = 0;
        long distance = 0;
        if (ID == 1)
        {
            uOM = (String) loadFile.get("uOM");
            goalWeight = (long) loadFile.get("goalWeight");
            weightChange = (long) loadFile.get("weightChange");
            difference = (long) loadFile.get("difference");
            distance = (long) loadFile.get("distance");
        }

        switch ((int)ID)
        {
            case 0:
            {
                Goal goal = new Goal((String) goalName, (Boolean) incDec, (int) endGoal, (int) current, (float) progress, (Boolean) complete, (int) ID);
                loadVector.add(goal);
                break;
            }
            case 1:
            {
                Goal health = new HealthGoal((String) goalName, (Boolean) incDec, (int) endGoal, (int) current, (float) progress, (Boolean) complete, (int) ID, (String) uOM, (int) goalWeight,  (int) weightChange, (int) difference, (int) distance);
                loadVector.add(health);
                break;
            }
            case 2:
            {
                Goal cash = new MoneyGoals((String) goalName, (Boolean) incDec, (int) endGoal, (int) current, (float) progress, (Boolean) complete, (int) ID);
                loadVector.add(cash);
                break;
            }
        }
    }

}
