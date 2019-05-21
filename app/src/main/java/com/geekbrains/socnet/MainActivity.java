package com.geekbrains.socnet;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        // установим аниматор по умолчанию
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        // эта установка служит для повышения производительности системы.
        recyclerView.setHasFixedSize(true);

        // будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        // строим источник данных
        DataSourceBuilder builder = new DataSourceBuilder(getResources());
        List<Soc> dataSource = builder.build();

        // установим адаптер
        SocNetAdapter adapter = new SocNetAdapter(dataSource);
        recyclerView.setAdapter(adapter);

        // установить слушатели
        setOnItemClickAdapter(adapter);
        setOnClickAddBtn(dataSource,adapter);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recycler_view);
        add = findViewById(R.id.add);
    }

    private void setOnItemClickAdapter(SocNetAdapter adapter) {
        adapter.SetOnItemClickListener(new SocNetAdapter.OnItemClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getApplicationContext(), String.format("Позиция - %d", position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setOnClickAddBtn(final List<Soc> dataSource, final SocNetAdapter adapter) {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Добавим элемент в 0-ю позицию
                dataSource.add(0, new Soc("Еще одна осень", R.drawable.nature7, true));
                // Дадим инструкцию адаптеру, что данные изменились
                adapter.notifyDataSetChanged();
            }
        });
    }
}
