package com.example.appphim;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appphim.adapter.CategoryAdapter;
import com.example.appphim.model.Category;
import com.example.appphim.model.Movie;
import com.example.appphim.utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategories;
    private CategoryAdapter categoryAdapter;
    private List<Category> originalCategories;
    private ImageView ivFavoriteMenu;
    private ImageView ivHistoryMenu;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        originalCategories = DataGenerator.getCategories();
        rvCategories = findViewById(R.id.rvCategories);
        ivFavoriteMenu = findViewById(R.id.ivFavoriteMenu);
        ivHistoryMenu = findViewById(R.id.ivHistoryMenu);
        searchView = findViewById(R.id.searchView);

        // Hiển thị danh sách ban đầu
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
        categoryAdapter = new CategoryAdapter(originalCategories, this);
        rvCategories.setAdapter(categoryAdapter);

        // Xử lý click icon yêu thích
        ivFavoriteMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FavoritesActivity.class);
            startActivity(intent);
        });

        // Xử lý click icon lịch sử
        ivHistoryMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });

        // Xử lý tìm kiếm
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterMovies(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterMovies(newText);
                return false;
            }
        });
    }

    private void filterMovies(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            // Hiện lại tất cả
            categoryAdapter = new CategoryAdapter(originalCategories, this);
            rvCategories.setAdapter(categoryAdapter);
            return;
        }

        // Lọc phim theo từ khóa
        String lowerKeyword = keyword.toLowerCase().trim();
        List<Category> filteredCategories = new ArrayList<>();

        for (Category category : originalCategories) {
            List<Movie> filteredMovies = new ArrayList<>();
            for (Movie movie : category.getMovies()) {
                if (movie.getTitle().toLowerCase().contains(lowerKeyword)) {
                    filteredMovies.add(movie);
                }
            }

            if (!filteredMovies.isEmpty()) {
                filteredCategories.add(new Category(category.getName(), filteredMovies));
            }
        }

        if (filteredCategories.isEmpty()) {
            Toast.makeText(this, "Không tìm thấy phim: " + keyword, Toast.LENGTH_SHORT).show();
        }

        categoryAdapter = new CategoryAdapter(filteredCategories, this);
        rvCategories.setAdapter(categoryAdapter);
    }
}