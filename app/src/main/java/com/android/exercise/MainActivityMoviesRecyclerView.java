package com.android.exercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.exercise.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivityMoviesRecyclerView extends AppCompatActivity {
    private List<Movie> mDatabase = new ArrayList<>();
    private RecyclerView myRecyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_movies_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        myRecyclerView = (RecyclerView) findViewById(R.id.my_recyclerView);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.addItemDecoration(new DividerItemDecoration(this, layoutManager.getOrientation()));

        movieAdapter = new MovieAdapter(this, mDatabase);
        myRecyclerView.setAdapter(movieAdapter);
    }

    @Override
    protected void onResume() {
        populateDatabase();
        movieAdapter.swapDatabase(mDatabase);
        super.onResume();
    }

    private void populateDatabase() {
        for (int i = 0; i < 30; i++) {
            mDatabase.add(new Movie.Builder()
                    .setTitle("Kill Bill")
                    .setAuthor("Quentin Tarantino")
                    .create());

            mDatabase.add(new Movie.Builder()
                    .setTitle("Youth")
                    .setAuthor("Paolo Sorrentino")
                    .create());

            mDatabase.add(new Movie.Builder()
                    .setTitle("Melancholia")
                    .setAuthor("Lars Von Trier")
                    .create());
        }
    }


}
