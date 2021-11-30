package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class AddExerciseActivity extends AppCompatActivity {

    private Button addExerciseBackButton;
    private Button addExerciseToList;
    private ArrayList<String> exerciseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

        addExerciseBackButton = findViewById(R.id.addExerciseBackButton);
        addExerciseBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
        TextView exercise = findViewById(R.id.edtExerciseName);
        addExerciseToList = findViewById(R.id.addExerciseToList);
        addExerciseToList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exerciseList.add(exercise.toString());
            }
        });
    }

    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}