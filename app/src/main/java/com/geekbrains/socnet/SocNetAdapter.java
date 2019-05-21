package com.geekbrains.socnet;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

// адаптер
public class SocNetAdapter extends RecyclerView.Adapter<SocNetAdapter.ViewHolder> {
    private List<Soc> dataSource;                   // Наш источник данных
    private OnItemClickListener itemClickListener;  // Слушатель, будет устанавливаться извне

    // интерфейс для обработки нажатий как в ListView
    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    // сеттер слушателя нажатий
    void SetOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    // Передаем в конструктор источник данных
    // В нашем случае это массив, но может быть и запросом к БД
    SocNetAdapter(List<Soc> dataSource) {
        this.dataSource = dataSource;
    }

    // Создать новый элемент пользовательского интерфейса
    // Запускается менеджером
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Создаём новый элемент пользовательского интерфейса
        // Через Inflater
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        // Здесь можно установить всякие параметры
        ViewHolder vh = new ViewHolder(v);

        // на каком-то этапе будет переиспользование карточки, и в лог эта строка не попадет
        // а строка onBindViewHolder попадет, это будет означать, что старая карточка
        // переоткрыта с новыми данными
        Log.d("SocNetAdapter", "onCreateViewHolder");
        return vh;
    }

    // Заменить данные в пользовательском интерфейсе
    // Вызывается менеджером
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Вынести на экран используя ViewHolder
        holder.description.setText(dataSource.get(position).getDescription());
        holder.picture.setImageResource(dataSource.get(position).getPicture());
        holder.like.setChecked(dataSource.get(position).getLike());

        // отрабатывает при необходимости нарисовать карточку
        Log.d("SocNetAdapter", "onBindViewHolder");

        final int i = position;
        holder.like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                dataSource.get(i).setLike(isChecked);
            }
        });
    }

    // Вернуть размер данных, вызывается менеджером
    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    // этот класс хранит связь между данными и элементами View
    // Сложные данные могут потребовать несколько View на
    // Один пункт списка.
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView description;
        ImageView picture;
        CheckBox like;

        ViewHolder(View v) {
            super(v);
            initViews(v);

            // обработчик нажатий на этом ViewHolder
            picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });

            like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

        private void initViews(@NonNull View v) {
            description = v.findViewById(R.id.description);
            picture = v.findViewById(R.id.picture);
            like = v.findViewById(R.id.like);
        }
    }
}

