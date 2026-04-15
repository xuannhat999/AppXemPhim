package com.example.appphim;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Player;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.PlayerView;

public class VideoPlayerActivity extends AppCompatActivity {

    private ExoPlayer player;
    private PlayerView playerView;
    private String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        // Toolbar và nút Back
        Toolbar toolbar = findViewById(R.id.toolbarVideo);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Đang phát");
        }

        // Lấy URL video từ Intent
        videoUrl = getIntent().getStringExtra("video_url");
        if (videoUrl == null || videoUrl.isEmpty()) {
            Toast.makeText(this, "Không có video để phát", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Khởi tạo PlayerView
        playerView = findViewById(R.id.playerView);
        playerView.setFullscreenButtonClickListener(new PlayerView.FullscreenButtonClickListener() {
            @Override
            public void onFullscreenButtonClick(boolean isFullScreen) {
                if (isFullScreen) {
                    // Chuyển sang chế độ màn hình ngang
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                    // Ẩn thanh Action Bar nếu có
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().hide();
                    }

                    WindowInsetsControllerCompat windowInsetsController =
                            ViewCompat.getWindowInsetsController(getWindow().getDecorView());
                    if (windowInsetsController != null) {
                        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
                    }
                } else {
                    // Trở về chế độ màn hình dọc
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                    // Hiện lại Action Bar
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().show();
                    }

                    // Hiện lại thanh hệ thống
                    WindowInsetsControllerCompat windowInsetsController =
                            ViewCompat.getWindowInsetsController(getWindow().getDecorView());
                    if (windowInsetsController != null) {
                        windowInsetsController.show(WindowInsetsCompat.Type.systemBars());
                    }
                }
            }
        });

        // Khởi tạo ExoPlayer
        initializePlayer();
    }

    private void initializePlayer() {
        // Tạo ExoPlayer instance
        player = new ExoPlayer.Builder(this).build();

        // Gắn player vào PlayerView
        playerView.setPlayer(player);

        // Tạo MediaItem từ URL
        Uri videoUri = Uri.parse(videoUrl);
        MediaItem mediaItem = MediaItem.fromUri(videoUri);

        // Set media item và prepare
        player.setMediaItem(mediaItem);
        player.prepare();

        // Tự động phát khi sẵn sàng
        player.setPlayWhenReady(true);

        // Thêm listener để theo dõi lỗi (cú pháp ĐÚNG)
        player.addListener(new Player.Listener() {
            @Override
            public void onPlayerError(androidx.media3.common.PlaybackException error) {
                runOnUiThread(() -> {
                    Toast.makeText(VideoPlayerActivity.this,
                            "Lỗi phát video: " + error.getMessage(),
                            Toast.LENGTH_SHORT).show();
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (player != null) {
            player.setPlayWhenReady(true);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (player != null) {
            player.setPlayWhenReady(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (player != null) {
            player.release();
            player = null;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}