package com.example.weightliftingtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class newWorkoutAct extends AppCompatActivity {

    private TextView date;
    private HashMap<String, ArrayList<String>> workOuts = new HashMap<>();
    private ArrayList<String> exerciseList = new ArrayList<>();
    private Button addToList;
    private TextView exerciseName;
    private TextView weightUsed;
    private TextView reps;
    private TextView sets;
    private Button finishWorkout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_workout);

        date = (TextView) findViewById(R.id.date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String currentDate = sdf.format(new Date());
        date.setText(currentDate);

        workOuts.put(currentDate, exerciseList);

        exerciseName = findViewById(R.id.exerciseName);
        weightUsed = findViewById(R.id.weightUsed);
        reps = findViewById(R.id.repetitionsDone);
        sets = findViewById(R.id.setsDone);

        addToList = (Button) findViewById(R.id.addToList);
        addToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String execName = exerciseName.getText().toString();
                String weight = weightUsed.getText().toString();
                String rep = reps.getText().toString();
                String set = sets.getText().toString();
                String listEntry = execName + " " + weight + " kg " + set + "x" + rep;

                exerciseList.add(listEntry);
            }

        });
        finishWorkout = (Button) findViewById(R.id.finishWorkout);
        finishWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToMap(currentDate, exerciseList);
            }
        });
    }

    public void addToMap(String key, ArrayList<String> list) {
        workOuts.put(key, list);
    }
}