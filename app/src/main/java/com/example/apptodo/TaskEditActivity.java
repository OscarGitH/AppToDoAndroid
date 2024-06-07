package com.example.apptodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TaskEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_edit);

        // Récupérer les données de la tâche passées par l'intent
        Task task = (Task) getIntent().getSerializableExtra("task");

        // Préremplir les champs avec les détails de la tâche
        EditText titleEditText = findViewById(R.id.titleEditText);
        titleEditText.setText(task.getTitle());

        EditText descriptionEditText = findViewById(R.id.descriptionEditText);
        descriptionEditText.setText(task.getDescription());

        EditText dueDateEditText = findViewById(R.id.dueDateEditText);
        dueDateEditText.setText(task.getDate());

        EditText durationEditText = findViewById(R.id.durationEditText);
        durationEditText.setText(task.getDuration());

        // Bouton pour sauvegarder les modifications
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mettre à jour les détails de la tâche
                task.setTitle(titleEditText.getText().toString());
                task.setDescription(descriptionEditText.getText().toString());
                task.setDate(dueDateEditText.getText().toString());
                task.setDuration(durationEditText.getText().toString());

                // Créer un nouvel Intent
                Intent resultIntent = new Intent();
                // Mettre la tâche modifiée en tant qu'extra
                resultIntent.putExtra("editedTask", task);
                // Définir le résultat de l'activité avec l'Intent
                setResult(RESULT_OK, resultIntent);
                // Terminer l'activité
                finish();
            }
        });

        // Bouton pour annuler les modifications
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