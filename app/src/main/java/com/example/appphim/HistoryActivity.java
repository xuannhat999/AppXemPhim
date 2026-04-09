package com.example.appphim;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appphim.adapter.MovieAdapter;
import com.example.appphim.helpers.HistoryManager;
import com.example.appphim.model.Movie;
import com.example.appphim.utils.DataGenerator;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView rvHistory;
    private TextView tvClearHistory;
    private TextView tvEmptyHistory;
    private MovieAdapter movieAdapter;
    private List<Movie> historyMovies;
    private HistoryManager historyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        // Thêm Toolbar và nút Back
        Toolbar toolbar = findViewById(R.id.toolbarHistory);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Lịch sử xem");
        }

        historyManager = new HistoryManager(this);

        rvHistory = findViewById(R.id.rvHistory);
        tvClearHistory = findViewById(R.id.tvClearHistory);
        tvEmptyHistory = findViewById(R.id.tvEmptyHistory);

        rvHistory.setLayoutManager(new GridLayoutManager(this, 2));

        tvClearHistory.setOnClickListener(v -> {
            // Tạo AlertDialog xác nhận
            new androidx.appcompat.app.AlertDialog.Builder(this)
                    .setTitle("Xóa lịch sử")
                    .setMessage("Bạn có chắc chắn muốn xóa toàn bộ lịch sử xem phim?")
                    .setPositiveButton("Xóa", (dialog, which) -> {
                        // Xóa lịch sử
                        historyManager.clearHistory();
                        loadHistory();
                        // Thông báo đã xóa
                        android.widget.Toast.makeText(this, "Đã xóa lịch sử", android.widget.Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("Hủy", null)
                    .show();
        });

        loadHistory();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadHistory();
    }

    private void loadHistory() {
        historyMovies = new ArrayList<>();
        List<String> historyIds = historyManager.getHistoryIds();
        List<Movie> allMovies = DataGenerator.getAllMovies();

        for (String id : historyIds) {
            int movieId = Integer.parseInt(id);
            for (Movie movie : allMovies) {
                if (movie.getId() == movieId) {
                    historyMovies.add(movie);
                    break;
                }
            }
        }

        if (historyMovies.isEmpty()) {
            rvHistory.setVisibility(View.GONE);
            tvEmptyHistory.setVisibility(View.VISIBLE);
        } else {
            rvHistory.setVisibility(View.VISIBLE);
            tvEmptyHistory.setVisibility(View.GONE);
            movieAdapter = new MovieAdapter(historyMovies, this);
            rvHistory.setAdapter(movieAdapter);
        }
    }
}