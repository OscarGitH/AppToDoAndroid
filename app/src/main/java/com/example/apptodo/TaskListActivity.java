package com.example.apptodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskListActivity extends AppCompatActivity implements TaskAdapter.OnItemClickListener {

    private ArrayList<Task> taskList;
    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    private static final int REQUEST_CODE_CREATE_TASK = 1;
    private static final int REQUEST_CODE_EDIT_TASK = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);

        // Initialisation de la liste des tâches
        taskList = new ArrayList<>();
        taskList.add(new Task("Faire les courses", "Acheter des fruits et légumes", "À faire", "2024-05-28", "2h00"));
        taskList.add(new Task("Répondre aux e-mails", "Répondre aux e-mails professionnels", "À faire", "2024-05-29", "1h00"));

        // Initialisation du RecyclerView
        recyclerView = findViewById(R.id.recyclerViewTasks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Création de l'adaptateur pour le RecyclerView
        taskAdapter = new TaskAdapter(taskList, this);
        recyclerView.setAdapter(taskAdapter);

        // Bouton pour ajouter une tâche
        Button addTaskButton = findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ouvrir l'activité de création de tâches
                Intent intent = new Intent(TaskListActivity.this, TaskCreateActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CREATE_TASK);
            }
        });
    }

    // Méthode de l'interface OnItemClickListener
    @Override
    public void onItemClick(Task task) {
        // Créer un intent pour ouvrir TaskDescActivity
        Intent intent = new Intent(TaskListActivity.this, TaskDescActivity.class);
        // Passer les détails de la tâche à TaskDescActivity
        intent.putExtra("task", task);
        // Démarrer l'activité
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_CREATE_TASK && resultCode == RESULT_OK && data != null) {
            Task newTask = (Task) data.getSerializableExtra("newTask");
            taskList.add(newTask);
            taskAdapter.notifyDataSetChanged();
        } else if (requestCode == REQUEST_CODE_EDIT_TASK && resultCode == RESULT_OK && data != null) {
            Task editedTask = (Task) data.getSerializableExtra("editedTask");
            // Trouver l'index de la tâche dans la liste
            int index = taskList.indexOf(editedTask);
            if (index != -1) {
                // Remplacer la tâche dans la liste par la tâche modifiée
                taskList.set(index, editedTask);
                taskAdapter.notifyDataSetChanged();
            }
        }
    }
}