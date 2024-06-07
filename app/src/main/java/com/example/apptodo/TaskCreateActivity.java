package com.example.apptodo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TaskCreateActivity extends AppCompatActivity {

    private EditText titleEditText, descriptionEditText, dueDateEditText, durationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_create);

        titleEditText = findViewById(R.id.titleEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        dueDateEditText = findViewById(R.id.dueDateEditText);
        durationEditText = findViewById(R.id.durationEditText);

        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Récupérer les valeurs saisies dans les champs de texte
                String title = titleEditText.getText().toString();
                String description = descriptionEditText.getText().toString();
                String dueDate = dueDateEditText.getText().toString();
                String duration = durationEditText.getText().toString();

                // Créer un nouvel objet Task
                Task task = new Task(title, description, "À faire", dueDate, duration);

                // Passer l'objet Task à TaskListActivity
                Intent intent = new Intent();
                intent.putExtra("newTask", task);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        Button cancelButton = findViewById(R.id.cancelButton);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Annuler et revenir à l'activité précédente
                finish();
            }
        });
    }
}