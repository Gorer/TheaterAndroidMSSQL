package com.example.mymssqlserverdatabaseconnection.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymssqlserverdatabaseconnection.Models.Genre;
import com.example.mymssqlserverdatabaseconnection.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private final Context context;
    private List<Genre> mainArray;

    // Адаптер, отвечающий за заполнение списка recyclerView1
    public MainAdapter(Context context) {
        this.context = context;
        mainArray = new ArrayList<>();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Создание
        View view = LayoutInflater.from(context).inflate(
                R.layout.departure_airports_list_layout, parent, false);
        return new MyViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) { // Заполнение
        //holder.tvTitle.setText(this.mainArray.get(position).getId_genre()
        //        + this.mainArray.get(position).getName_genre());
        holder.setData(mainArray.get(position));
    }

    @Override
    public int getItemCount() {
        return mainArray.size();
    }

    public Genre getGenre(int position){
        return mainArray.get(position);
    }

    // Класс, отвечающий за отдельный элемент
    static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvTitle;
        private final Context context;
        private Genre localFlight;


        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            tvTitle = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(this);
        }

        @SuppressLint("SetTextI18n")
        public void setData(Genre flight) {
            localFlight = flight;
            // заполнение заголовка для элемента списка
            tvTitle.setText(flight.getId_genre() + " | " + flight.getName_genre());
        }

        @Override
        public void onClick(View view) {

        }

        /*@Override
        public void onClick(View v) { // при нажатии на элемент передается ID заметки из бд и переходит на экран изменения
            Intent i = new Intent(context, GenreActivity.class);
            i.putExtra("airlineId", localFlight.getId_genre());
            i.putExtra("routeId", localFlight.getId_route_pfk());
            context.startActivity(i);
        }*/
    }

    public void updateAdapter(List<Genre> newList) { // Обновление списка
       this.mainArray = newList;
        //notifyDataSetChanged();
    }
}
