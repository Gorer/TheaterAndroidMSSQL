package com.example.mymssqlserverdatabaseconnection.Adapters;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymssqlserverdatabaseconnection.Models.Genre;
import com.example.mymssqlserverdatabaseconnection.Models.Item;
import com.example.mymssqlserverdatabaseconnection.Models.TheaterProduction;
import com.example.mymssqlserverdatabaseconnection.R;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private final Context context;
    private List<Item> mainArray;
    private OnItemClickListener listener;

    // Адаптер, отвечающий за заполнение списка recyclerView1
    public MainAdapter(Context context) {
        this.context = context;
        this.mainArray = new ArrayList<Item>();
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
        holder.setData(mainArray.get(position));
    }

    @Override
    public int getItemCount() {
        return mainArray.size();
    }

    public Item getGenre(int position){
        return mainArray.get(position);
    }

    // Класс, отвечающий за отдельный элемент
    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final TextView tvTitle;
        private final Context context;

        public MyViewHolder(@NonNull View itemView, Context context) {
            super(itemView);
            this.context = context;
            tvTitle = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener(this);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    if(listener!=null && position!=RecyclerView.NO_POSITION){
                        listener.onItemClick(mainArray.get(position));
                    }
                }
            });
        }

        @SuppressLint("SetTextI18n")
        public void setData(Item item) {
            // заполнение заголовка для элемента списка
            switch (item.getItemType()) {
                case "TheaterProduction":
                    TheaterProduction theaterProduction = (TheaterProduction) item;
                    Log.d(TAG,theaterProduction.getName() + " | " +
                            theaterProduction.getTheater_name() + " | " +
                            theaterProduction.getRating());
                    tvTitle.setText(theaterProduction.getName() + " | " +
                            theaterProduction.getTheater_name() + " | " +
                            theaterProduction.getRating());
                    break;
                case "Genre":
                    Genre genre = (Genre) item;
                    Log.d(TAG,genre.getId_genre() + " | " + genre.getName_genre());
                    tvTitle.setText(genre.getId_genre() + " | " + genre.getName_genre());
                    break;
                default:
                    Log.d(TAG,"default");
                    tvTitle.setText("default");
                    break;
            }
        }

        @Override
        public void onClick(View view) {
            //Intent intent = new Intent(context, )
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public void updateAdapter(List<Item> newList) { // Обновление списка
        this.mainArray = newList;
    }
}
