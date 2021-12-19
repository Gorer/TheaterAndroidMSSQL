package com.example.mymssqlserverdatabaseconnection.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultsAdapter extends RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>{
    private Context context;

    //private List<Quote> quoteList;
    //private OnItemClickListener listener;

    @NonNull
    @Override
    public ResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ResultsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ResultsViewHolder extends RecyclerView.ViewHolder{

        TextView quoteText;
        TextView nameAuthor;
        TextView lastnameAuthor;
        TextView title;
        AdapterView.OnItemClickListener onItemClickListener;
        public ResultsViewHolder(View view){
            super(view);
            //quoteText = view.findViewById(R.id.quoteTextElementView);
            //nameAuthor = view.findViewById(R.id.nameAuthorTextElementView);
            //lastnameAuthor = view.findViewById(R.id.lastnameAuthorTextElementView);
            //title = view.findViewById(R.id.textViewTitleElementView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    //if(listener!=null && position!=RecyclerView.NO_POSITION){
                    //    listener.onItemClick(quoteList.get(position));
                    //}
                }
            });
        }
    }
}
