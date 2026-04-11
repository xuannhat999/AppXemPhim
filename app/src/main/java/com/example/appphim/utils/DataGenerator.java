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
    private static final String VIDEO_MP4_7 = "https://v.ftcdn.net/04/39/38/79/700_F_439387925_cQGkDoffFVtlD9pLqXeIzczvu0lLWkNz_ST.mp4";
    private static final String VIDEO_MP4_8 = "https://v.ftcdn.net/03/16/49/90/700_F_316499041_eMXWlwTbJHkkk4KSbuoOZ593ZJjxVadz_ST.mp4";
    private static final String VIDEO_MP4_9 = "https://v.ftcdn.net/04/35/53/73/700_F_435537318_2vhxGFWaa529Wneb0KyoR3pqfca91o8t_ST.mp4";
    private static final String VIDEO_MP4_10 = "https://v.ftcdn.net/07/84/35/74/700_F_784357415_pgEQLzZJdePIYbgg6MsiWs0jz47aMaJB_ST.mp4";
    private static final String VIDEO_MP4_11 = "https://v.ftcdn.net/08/85/98/88/700_F_885988887_3ldG0Hqv2qV4CsItDFQH4lNJmkLxCE67_ST.mp4";

    // YouTube ID (xem trên YouTube)
    private static final String YOUTUBE_ID_1 = "TcMBFSGVi1c";  // Avengers trailer
    private static final String YOUTUBE_ID_2 = "YoHD9XEInc0";  // Inception trailer
    private static final String YOUTUBE_ID_3 = "EXeTwQWrcwY";  // Dark Knight trailer
    private static final String YOUTUBE_ID_4 = "zSWdZVtXT7E";  // Interstellar trailer
    private static final String YOUTUBE_ID_5 = "vKQi3bBA1y8";  // Matrix trailer
    private static final String YOUTUBE_ID_6 = "owK1qxDrsE";   // Gladiator trailer
    private static final String YOUTUBE_ID_7 = "iKUzhzustok"; // Sherlock Holmes trailer
    private static final String YOUTUBE_ID_8 = "ejMMn0t58Lc"; // The Conjuring trailer
    private static final String YOUTUBE_ID_9 = "xKJmEC5ieOk"; // It (Chú hề ma quái)
    private static final String YOUTUBE_ID_10 = "CwXOrWvPBPk"; // Shrek
    private static final String YOUTUBE_ID_11 = "g4Hbz2jLxvQ"; // Spider-Verse

    public static List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        // Movie(id, title, year, overview, posterResId, videoUrl/YoutubeId)

        movies.add(new Movie(1, "Avengers: Endgame", "2019",
                "Sau những sự kiện tàn khốc của Infinity War, các Avengers còn sống sót cùng đồng minh quyết tâm đảo ngược hành động của Thanos.",
                R.drawable.avengers_poster, YOUTUBE_ID_1, VIDEO_MP4_1));

        movies.add(new Movie(2, "Inception", "2010",
                "Một tên trộm chuyên đánh cắp bí mật qua giấc mơ được giao nhiệm vụ đảo ngược: cấy một ý tưởng vào tiềm thức.",
                R.drawable.inception_poster, YOUTUBE_ID_2, VIDEO_MP4_2));

        movies.add(new Movie(3, "The Dark Knight", "2008",
                "Batman phải đối đầu với Joker, một tên tội phạm hỗn loạn muốn phá vỡ trật tự xã hội.",
                R.drawable.the_dark_knight_poster, YOUTUBE_ID_3, VIDEO_MP4_3));

        movies.add(new Movie(4, "Interstellar", "2014",
                "Một nhóm nhà thám hiểm du hành qua lỗ sâu để tìm kiếm hành tinh mới cho nhân loại.",
                R.drawable.insterstella_poster, YOUTUBE_ID_4, VIDEO_MP4_4));

        movies.add(new Movie(5, "The Matrix", "1999",
                "Một hacker phát hiện ra rằng thế giới thực chỉ là mô phỏng và anh ta được chọn để giải thoát nhân loại.",
                R.drawable.the_matrix_poster, YOUTUBE_ID_5, VIDEO_MP4_5));

        movies.add(new Movie(6, "Gladiator", "2000",
                "Một vị tướng La Mã bị phản bội trở thành nô lệ và trở thành đấu sĩ giác đấu, trả thù cho hoàng đế.",
                R.drawable.gladiator_poster, YOUTUBE_ID_6, VIDEO_MP4_6));
        movies.add(new Movie(7, "Sherlock Holmes", "2009",
                        "Một người đàn ông tin rằng mình là đầu thai của Sherlock Holmes truyền kì, cùng với trợ lý của mình, họ quyết định lên đường giải quyết các vụ án bí ẩn tại London (hay gì đó đại loại thế, em chưa xem)",
                R.drawable.sherlock_holmes_poster, YOUTUBE_ID_7, VIDEO_MP4_7));
        movies.add(new Movie(8, "The Conjuring", "2013",
                "Các nhà điều tra hiện tượng siêu nhiên Ed và Lorraine Warren hợp tác để giúp một gia đình bị một thế lực đen tối khủng bố trong trang trại của họ.",
                R.drawable.the_conjuring_poster, YOUTUBE_ID_8, VIDEO_MP4_8));
        movies.add(new Movie(9, "IT", "2017",
                "Vào mùa hè năm 1989, một nhóm trẻ em bị bắt nạt đã cùng nhau hợp sức để tiêu diệt một con quái vật biến hình, kẻ thường đội lốt chú hề và săn lùng trẻ em ở Derry, thị trấn nhỏ thuộc bang Maine của chúng.",
                R.drawable.it_poster, YOUTUBE_ID_9, VIDEO_MP4_9));
        movies.add(new Movie(10, "Shrek", "2001",
                "Một lãnh chúa độc ác đày các sinh vật trong truyện cổ tích đến đầm lầy của một yêu tinh cáu kỉnh, người phải thực hiện một cuộc phiêu lưu và giải cứu một công chúa cho lãnh chúa để lấy lại đất đai của mình.",
                R.drawable.shrek_poster, YOUTUBE_ID_10, VIDEO_MP4_10));
        movies.add(new Movie(11, "Spider Verse", "2023",
                "Trong chuyến hành trình xuyên đa vũ trụ, Miles Morales gặp gỡ một nhóm Người Nhện mới, gồm các anh hùng đến từ những chiều không gian khác nhau. Nhưng khi các anh hùng bất đồng quan điểm về cách đối phó với một mối đe dọa mới, Miles nhận thấy mình đang đứng trước ngã ba đường.",
                R.drawable.spider_verse_poster, YOUTUBE_ID_11, VIDEO_MP4_11));

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
        scifiMovies.add(allMovies.get(6)); // Sherlock Holmes
        categories.add(new Category("🚀 Viễn tưởng", scifiMovies));

        List<Movie> horrorMovies = new ArrayList<>();
        horrorMovies.add(allMovies.get(7));
        horrorMovies.add(allMovies.get(8));
        categories.add(new Category("\uD83D\uDC80 Kinh dị", horrorMovies));

        List<Movie> animationMovies = new ArrayList<>();
        animationMovies.add(allMovies.get(9));
        animationMovies.add(allMovies.get(10));
        categories.add(new Category("\uD83E\uDDF8 Hoạt hình", animationMovies));

        return categories;
    }
}