package com.example.appphim.utils;

import com.example.appphim.R;
import com.example.appphim.model.Category;
import com.example.appphim.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    // URL video MP4 (xem trong app)
    private static final String VIDEO_MP4_1 = "https://samplelib.com/lib/preview/mp4/sample-5s.mp4";
    private static final String VIDEO_MP4_2 = "https://samplelib.com/lib/preview/mp4/sample-10s.mp4";
    private static final String VIDEO_MP4_3 = "https://samplelib.com/lib/preview/mp4/sample-15s.mp4";
    private static final String VIDEO_MP4_4 = "https://samplelib.com/lib/preview/mp4/sample-20s.mp4";
    private static final String VIDEO_MP4_5 = "https://samplelib.com/lib/preview/mp4/sample-30s.mp4";
    private static final String VIDEO_MP4_6 = "https://samplelib.com/lib/preview/mp4/sample-5s.mp4";

    // YouTube ID (xem trên YouTube)
    private static final String YOUTUBE_ID_1 = "TcMBFSGVi1c";  // Avengers trailer
    private static final String YOUTUBE_ID_2 = "YoHD9XEInc0";  // Inception trailer
    private static final String YOUTUBE_ID_3 = "EXeTwQWrcwY";  // Dark Knight trailer
    private static final String YOUTUBE_ID_4 = "zSWdZVtXT7E";  // Interstellar trailer
    private static final String YOUTUBE_ID_5 = "vKQi3bBA1y8";  // Matrix trailer
    private static final String YOUTUBE_ID_6 = "owK1qxDrsE";   // Gladiator trailer

    public static List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        // Movie(id, title, year, overview, posterResId, videoUrl/YoutubeId)

        movies.add(new Movie(1, "Avengers: Endgame", "2019",
                "Sau những sự kiện tàn khốc của Infinity War, các Avengers còn sống sót cùng đồng minh quyết tâm đảo ngược hành động của Thanos.",
                R.drawable.poster_placeholder, YOUTUBE_ID_1, VIDEO_MP4_1));

        movies.add(new Movie(2, "Inception", "2010",
                "Một tên trộm chuyên đánh cắp bí mật qua giấc mơ được giao nhiệm vụ đảo ngược: cấy một ý tưởng vào tiềm thức.",
                R.drawable.poster_placeholder, YOUTUBE_ID_2, VIDEO_MP4_2));

        movies.add(new Movie(3, "The Dark Knight", "2008",
                "Batman phải đối đầu với Joker, một tên tội phạm hỗn loạn muốn phá vỡ trật tự xã hội.",
                R.drawable.poster_placeholder, YOUTUBE_ID_3, VIDEO_MP4_3));

        movies.add(new Movie(4, "Interstellar", "2014",
                "Một nhóm nhà thám hiểm du hành qua lỗ sâu để tìm kiếm hành tinh mới cho nhân loại.",
                R.drawable.poster_placeholder, YOUTUBE_ID_4, VIDEO_MP4_4));

        movies.add(new Movie(5, "The Matrix", "1999",
                "Một hacker phát hiện ra rằng thế giới thực chỉ là mô phỏng và anh ta được chọn để giải thoát nhân loại.",
                R.drawable.poster_placeholder, YOUTUBE_ID_5, VIDEO_MP4_5));

        movies.add(new Movie(6, "Gladiator", "2000",
                "Một vị tướng La Mã bị phản bội trở thành nô lệ và trở thành đấu sĩ giác đấu, trả thù cho hoàng đế.",
                R.drawable.poster_placeholder, YOUTUBE_ID_6, VIDEO_MP4_6));

        return movies;
    }

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        List<Movie> allMovies = getAllMovies();

        List<Movie> actionMovies = new ArrayList<>();
        actionMovies.add(allMovies.get(0)); // Avengers
        actionMovies.add(allMovies.get(2)); // Dark Knight
        actionMovies.add(allMovies.get(5)); // Gladiator
        categories.add(new Category("🔥 Hành động", actionMovies));

        List<Movie> scifiMovies = new ArrayList<>();
        scifiMovies.add(allMovies.get(1)); // Inception
        scifiMovies.add(allMovies.get(3)); // Interstellar
        scifiMovies.add(allMovies.get(4)); // Matrix
        categories.add(new Category("🚀 Viễn tưởng", scifiMovies));

        return categories;
    }
}