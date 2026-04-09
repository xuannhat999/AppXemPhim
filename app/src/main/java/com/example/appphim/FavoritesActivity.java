package com.example.appphim;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appphim.adapter.MovieAdapter;
import com.example.appphim.helpers.FavoriteManager;
import com.example.appphim.model.Movie;
import com.example.appphim.utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class FavoritesActivity extends AppCompatActivity {

    private RecyclerView rvFavorites;
    private MovieAdapter movieAdapter;
    private List<Movie> favoriteMovies;
    private FavoriteManager favoriteManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        // Thêm Toolbar và nút Back
        Toolbar toolbar = findViewById(R.id.toolbarFavorites);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Phim yêu thích");
        }

        favoriteManager = new FavoriteManager(this);

        rvFavorites = findViewById(R.id.rvFavorites);
        rvFavorites.setLayoutManager(new GridLayoutManager(this, 2));

        loadFavorites();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadFavorites();
    }

    private void loadFavorites() {
        favoriteMovies = new ArrayList<>();
        Set<String> favoriteIds = favoriteManager.getFavoriteIds();
        List<Movie> allMovies = DataGenerator.getAllMovies();

        for (Movie movie : allMovies) {
            if (favoriteIds.contains(String.valueOf(movie.getId()))) {
                favoriteMovies.add(movie);
            }
        }

        movieAdapter = new MovieAdapter(favoriteMovies, this);
        rvFavorites.setAdapter(movieAdapter);
    }
}