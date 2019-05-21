package com.geekbrains.weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherHistoryAdapter  extends RecyclerView.Adapter<WeatherHistoryAdapter.ViewHolder> {
    private String[] tempHistory;

    WeatherHistoryAdapter(String[] tempHistory) {
        this.tempHistory = tempHistory;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.element_layout, viewGroup,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Вынести на экран используя ViewHolder
        holder.textView.setText(tempHistory[position]);
    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return tempHistory.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        ViewHolder(View v) {
            super(v);
            initView(v);
        }

        private void initView(@NonNull View v) {
            textView = v.findViewById(R.id.textView);
        }
    }
}
