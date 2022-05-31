package br.edu.ifsuldeminas.mch.tarefas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas.db.TaskDAO;
import br.edu.ifsuldeminas.mch.tarefas.domain.Task;

public class MainActivity extends AppCompatActivity {

    private ListView todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openActivityForm = new Intent(getApplicationContext(),
                        FormActivity.class);
                startActivity(openActivityForm);
            }
        });

        todoList = findViewById(R.id.todo_list);

        todoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l) {

                Task task = (Task) todoList.getItemAtPosition(position);
                Intent openActivityForm = new Intent(getApplicationContext(),
                        FormActivity.class);

                openActivityForm.putExtra("task", task);

                startActivity(openActivityForm);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateTasks();
    }

    private void updateTasks() {
        TaskDAO dao = new TaskDAO(this);
        List<Task> tasks = dao.listAll();

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, tasks);

        todoList.setAdapter(adapter);
    }
}