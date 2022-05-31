package br.edu.ifsuldeminas.mch.tarefas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;

import br.edu.ifsuldeminas.mch.tarefas.db.TaskDAO;
import br.edu.ifsuldeminas.mch.tarefas.domain.Task;

public class FormActivity extends AppCompatActivity {

    private Task task = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        task = (Task) intent.getSerializableExtra("task");
        if (task != null){
            TextInputEditText descriptionTIET =
                    findViewById(R.id.task_description);

            descriptionTIET.setText(task.getDescription());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save_task:
                TextInputEditText descriptionTIET =
                        findViewById(R.id.task_description);

                String description = descriptionTIET.getText().toString();
                description = description != null ? description : "";

                if(description.equals("")){
                    Toast.makeText(this, R.string.task_description_empty,
                            Toast.LENGTH_SHORT).show();

                } else {
                    if(task == null) {
                        Task task = new Task(0, description);

                        TaskDAO dao = new TaskDAO(this);
                        dao.save(task);

                        Toast.makeText(getBaseContext(), R.string.task_saved,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        task.setDescription(description);

                        TaskDAO dao = new TaskDAO(this);
                        dao.update(task);

                        Toast.makeText(getBaseContext(), R.string.task_updated,
                                Toast.LENGTH_SHORT).show();
                    }
                }

                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
