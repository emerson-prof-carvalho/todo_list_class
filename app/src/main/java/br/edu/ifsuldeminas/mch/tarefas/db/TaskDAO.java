package br.edu.ifsuldeminas.mch.tarefas.db;

import android.content.Context;

import java.util.List;

import br.edu.ifsuldeminas.mch.tarefas.domain.Task;

public class TaskDAO extends DAO<Task> {

    public TaskDAO(Context context){
        super(context);
    }

    @Override
    public void save(Task entity) {

    }

    @Override
    public void update(Task entity) {

    }

    @Override
    public void delete(Task entity) {

    }

    @Override
    public List<Task> listAll() {
        return null;
    }
}
