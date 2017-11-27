package com.android.exercise;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.exercise.model.Movie;

import java.util.List;

/**
 * Created by antlap on 19/10/2017.
 */

class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private final Context mContext;
    private List<Movie> mDatabase;

    public MovieAdapter(Context context, List<Movie> database) {
        mContext = context;
        mDatabase = database;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.movie_list_item, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = mDatabase.get(position);
        holder.bind(movie);
    }

    @Override
    public int getItemCount(){
        return mDatabase.size();
    }

    public void swapDatabase(List<Movie> database) {
        mDatabase = database;
        notifyDataSetChanged();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleView;
        TextView authorView;

        public MovieViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.tv_title);
            authorView = (TextView) itemView.findViewById(R.id.tv_author);
            itemView.setOnClickListener(this);
        }

        public void bind(Movie movie) {
            titleView.setText(movie.getTitle());
            authorView.setText(movie.getAuthor());
        }

        @Override
        public void onClick(View view) {
            final String message = mContext.getString(R.string.you_choose, titleView.getText(), authorView.getText());
            AlertDialog alert = new AlertDialog.Builder(mContext)
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                        }
                    })
                    .create();
            alert.show();

        }

    }
}
