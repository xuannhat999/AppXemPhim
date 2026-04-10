package com.example.appphim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.appphim.helpers.HistoryManager;
import com.example.appphim.model.Movie;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class DetailActivity extends AppCompatActivity {

    private YouTubePlayerView viewTrailer;
    private ImageView ivPosterLarge;
    private TextView tvTitleDetail;
    private TextView tvYearDetail;
    private TextView tvOverview;
    private Button btnWatchTrailer;  // Nút xem trailer (YouTube)
    private Button btnWatchVideo;     // Nút xem video full (MP4)
    private Button btnShare;
    private RatingBar ratingBar;
    private HistoryManager historyManager;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Toolbar và nút Back
        Toolbar toolbar = findViewById(R.id.toolbarDetail);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Chi tiết phim");
        }

        // Khởi tạo HistoryManager
        historyManager = new HistoryManager(this);

        // Ánh xạ view
//        ivPosterLarge = findViewById(R.id.ivPosterLarge);
        viewTrailer = findViewById(R.id.viewTrailer);
        getLifecycle().addObserver(viewTrailer);

        tvTitleDetail = findViewById(R.id.tvTitleDetail);
        tvYearDetail = findViewById(R.id.tvYearDetail);
        tvOverview = findViewById(R.id.tvOverview);
//        btnWatchTrailer = findViewById(R.id.btnWatchTrailer);
        btnWatchVideo = findViewById(R.id.btnWatchVideo);
        btnShare = findViewById(R.id.btnShare);
        ratingBar = findViewById(R.id.ratingBar);

        // Lấy dữ liệu phim từ Intent
        movie = (Movie) getIntent().getSerializableExtra("movie");


        if (movie != null) {
            // Lưu vào lịch sử
            historyManager.addToHistory(movie.getId());

            // Hiển thị thông tin phim
//            ivPosterLarge.setImageResource(movie.getPosterResId());
            tvTitleDetail.setText(movie.getTitle());
            tvYearDetail.setText(movie.getYear());
            tvOverview.setText(movie.getOverview());
            loadTrailer();

            // ===== NÚT XEM TRAILER (YouTube) =====
//            btnWatchTrailer.setOnClickListener(v -> {
//                String youtubeId = movie.getYoutubeTrailerId();
//                if (youtubeId != null && !youtubeId.isEmpty()) {
//                    // Mở YouTube bằng Intent
//                    Intent intent = new Intent(Intent.ACTION_VIEW,
//                            Uri.parse("https://www.youtube.com/watch?v=" + youtubeId));
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(this, "Không có trailer cho phim này", Toast.LENGTH_SHORT).show();
//                }
//            });

            // ===== NÚT XEM VIDEO FULL (MP4) =====
            btnWatchVideo.setOnClickListener(v -> {
                String videoUrl = movie.getVideoUrl();
                if (videoUrl != null && !videoUrl.isEmpty()) {
                    Intent intent = new Intent(DetailActivity.this, VideoPlayerActivity.class);
                    intent.putExtra("video_url", videoUrl);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Video full đang được cập nhật", Toast.LENGTH_SHORT).show();
                }
            });


            // ===== NÚT CHIA SẺ =====
            btnShare.setOnClickListener(v -> {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, movie.getTitle());
                shareIntent.putExtra(Intent.EXTRA_TEXT,
                        "🎬 Đang xem phim: " + movie.getTitle() + " (" + movie.getYear() + ")\n" +
                                "📝 " + movie.getOverview() + "\n\n" +
                                "▶ Xem trailer: https://www.youtube.com/watch?v=" + movie.getYoutubeTrailerId());
                startActivity(Intent.createChooser(shareIntent, "Chia sẻ qua"));
            });

            // ===== ĐÁNH GIÁ SAO =====
            SharedPreferences prefs = getSharedPreferences("ratings", MODE_PRIVATE);
            float savedRating = prefs.getFloat("rating_" + movie.getId(), 0);
            ratingBar.setRating(savedRating);

            ratingBar.setOnRatingBarChangeListener((ratingBar1, rating, fromUser) -> {
                if (fromUser) {
                    getSharedPreferences("ratings", MODE_PRIVATE)
                            .edit()
                            .putFloat("rating_" + movie.getId(), rating)
                            .apply();
                    Toast.makeText(this, "Cảm ơn bạn đã đánh giá " + rating + " sao!", Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(this, "Không thể tải thông tin phim", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    public void loadTrailer() {
        String youtubeId = movie.getYoutubeTrailerId();
        if (youtubeId == null || youtubeId.isEmpty()) return;
        Log.d("Trailer id",youtubeId);
        viewTrailer.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(youtubeId, 0f);
            }

            @Override
            public void onError(@NonNull YouTubePlayer youTubePlayer, @NonNull PlayerConstants.PlayerError error) {
                super.onError(youTubePlayer, error);
                Log.e("YoutubeError", "Lỗi: " + error.name());
            }
        });
    }
}