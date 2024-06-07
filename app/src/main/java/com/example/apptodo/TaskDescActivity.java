package com.example.apptodo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TaskDescActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_EDIT_TASK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_desc_activity);

        // Récupérer les données de la tâche passées par l'intent
        Task task = (Task) getIntent().getSerializableExtra("task");

        // Afficher les données de la tâche dans les TextView correspondants
        TextView titleTextView = findViewById(R.id.titleTextView);
        titleTextView.setText(task.getTitle());

        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(task.getDescription());

        TextView dueDateTextView = findViewById(R.id.dueDateTextView);
        dueDateTextView.setText(task.getDate());

        TextView durationTextView = findViewById(R.id.durationTextView);
        durationTextView.setText(task.getDuration());

        // Trouver le bouton "Fermer" dans le layout
        Button closeButton = findViewById(R.id.closeButton);

        // Ajouter un écouteur d'événements sur le bouton "Fermer"
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Fermer l'activité en cours
                finish();
            }
        });

        Button editButton = findViewById(R.id.editButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créer un intent pour ouvrir TaskEditActivity
                Intent intent = new Intent(TaskDescActivity.this, TaskEditActivity.class);
                // Passer les détails de la tâche à TaskEditActivity
                intent.putExtra("task", task);
                // Démarrer l'activité
                startActivityForResult(intent, REQUEST_CODE_EDIT_TASK);
            }
        });
    }
}
