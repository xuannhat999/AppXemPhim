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
    private static final String VIDEO_MP4_12 = "https://v.ftcdn.net/01/25/20/65/700_F_125206588_ns4Lonw2IT1K2y1IMgdtfl0rKdoWkzGO_ST.mp4";
    private static final String VIDEO_MP4_13 = "https://v.ftcdn.net/11/89/56/45/700_F_1189564522_QQHRaBxmE5XE1P8xGZc2ohe6zEvsdYd1_ST.mp4";
    private static final String VIDEO_MP4_14 = "https://v.ftcdn.net/01/87/69/91/700_F_187699155_llnL30ZA6JqALLj4mPhhVb3QvJZ8Cgun_ST.mp4";
    private static final String VIDEO_MP4_15 = "https://v.ftcdn.net/05/35/62/55/700_F_535625524_RMaiPCdeWlonPPQ2jkiDn6Yx0KdOMRkV_ST.mp4";
    private static final String VIDEO_MP4_16 = "https://v.ftcdn.net/08/85/08/51/700_F_885085152_w6PpT3PyCZWHIyBcpwftbsENqSZxUv9Z_ST.mp4";
    private static final String VIDEO_MP4_17 = "https://v.ftcdn.net/00/14/08/97/700_F_14089778_1xQ1vypJTp0vmIwOf0027JVOdGPDErc6_ST.mp4";
    private static final String VIDEO_MP4_18 = "https://v.ftcdn.net/10/77/10/17/700_F_1077101786_1vGUw9tS7ZjoRTFkpUXRsqeKp79u1GOe_ST.mp4";
    private static final String VIDEO_MP4_19 = "https://v.ftcdn.net/08/82/37/12/700_F_882371225_KBauWdRmVNu6ZKabQow2JgIiqHBn8arO_ST.mp4";
    private static final String VIDEO_MP4_20 = "https://v.ftcdn.net/01/66/61/50/700_F_166615043_bUHDO2VanfKDst6B9xIDKa1C9iqXudmM_ST.mp4";
    private static final String VIDEO_MP4_21 = "https://v.ftcdn.net/15/57/53/94/700_F_1557539413_H5lXDKf72SAsLfnzCrhQGuYLnOS52R3i_ST.mp4";
    private static final String VIDEO_MP4_22 = "https://v.ftcdn.net/19/45/51/20/700_F_1945512090_TNx59pSbvCHorxN8vQhIyderJVYTLed3_ST.mp4";
    private static final String VIDEO_MP4_23 = "https://v.ftcdn.net/19/49/32/80/700_F_1949328001_AmWEsyPi0RVj55Ev5xl572HrzEOi26uI_ST.mp4";
    private static final String VIDEO_MP4_24 = "https://v.ftcdn.net/19/58/17/08/700_F_1958170875_35g4q9WU8zMaCYuWMeuGlqZegwpVqnEP_ST.mp4";
    private static final String VIDEO_MP4_25 = "https://v.ftcdn.net/19/51/88/86/700_F_1951888676_wjhl9AZa0IQmhzlLO2u4NKay6ajDDRTh_ST.mp4";
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
    private static final String YOUTUBE_ID_12 = "qEVUtrk8_B4"; // John Wick 4
    private static final String YOUTUBE_ID_13 = "hEJnMQG9ev8"; // Mad Max: Fury Road
    private static final String YOUTUBE_ID_14 = "qSqVVswa420"; // Top Gun: Maverick
    private static final String YOUTUBE_ID_15 = "gCcx85zbxz4"; // Blade Runner 2049
    private static final String YOUTUBE_ID_16 = "n9xhJrPXop4"; // Dune
    private static final String YOUTUBE_ID_17 = "L3pk_TBkihU"; // Tenet
    private static final String YOUTUBE_ID_18 = "VFsmuRPClr4"; // The Conjuring 2
    private static final String YOUTUBE_ID_19 = "V6wWKNij_1M"; // Hereditary
    private static final String YOUTUBE_ID_20 = "WR7cc5t7tv8"; // A Quiet Place
    private static final String YOUTUBE_ID_21 = "DzfpyUB60YY"; // Get Out
    private static final String YOUTUBE_ID_22 = "wmiIUN-7qhE"; // Toy Story 4
    private static final String YOUTUBE_ID_23 = "SkcucKDrbOI"; // How to Train Your Dragon 3
    private static final String YOUTUBE_ID_24 = "eSLe4HuKuK0"; // Frozen 2
    private static final String YOUTUBE_ID_25 = "sAU6Istwz6c"; // Demon Slayer: Mugen Train

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
        movies.add(new Movie(12, "John Wick 4", "2023",
                "Sát thủ huyền thoại John Wick tìm cách đánh bại Hội Đồng Tối Cao để giành lại tự do cho chính mình.",
                R.drawable.johnwick4_poster, YOUTUBE_ID_12, VIDEO_MP4_12));
        movies.add(new Movie(13, "Mad Max: Fury Road",
                "2015", "Trong một thế giới hậu tận thế, Max cùng chiến binh Furiosa tìm cách thoát khỏi tên trùm độc tài.",
                R.drawable.madmax_poster, YOUTUBE_ID_13, VIDEO_MP4_13));
        movies.add(new Movie(14, "Top Gun: Maverick", "2022",
                "Sau hơn 30 năm, Maverick huấn luyện một nhóm phi công trẻ cho một chiến dịch nguy hiểm chưa từng có.",
                R.drawable.topgun_poster, YOUTUBE_ID_14, VIDEO_MP4_14));
        movies.add(new Movie(15, "Blade Runner 2049", "2017",
                "Một Blade Runner mới khám phá ra một bí mật bị chôn giấu từ lâu có khả năng làm hỗn loạn xã hội.",
                R.drawable.blader_runner_poster, YOUTUBE_ID_15, VIDEO_MP4_15));
        movies.add(new Movie(16, "Dune", "2021",
                "Paul Atreides dấn thân vào hành tinh nguy hiểm nhất vũ trụ để bảo vệ tương lai gia tộc.",
                R.drawable.dune_poster, YOUTUBE_ID_16, VIDEO_MP4_16));
        movies.add(new Movie(17, "Tenet", "2020",
                "Một điệp viên phải sử dụng khả năng nghịch đảo thời gian để ngăn chặn thế chiến thứ ba bùng nổ.",
                R.drawable.tenet_poster, YOUTUBE_ID_17, VIDEO_MP4_17));
        movies.add(new Movie(18, "The Conjuring 2", "2016",
                "Vợ chồng nhà Warren đến London để giúp đỡ một gia đình đang bị quỷ ám bởi các linh hồn tà ác.",
                R.drawable.the_conjuring_2_poster, YOUTUBE_ID_18, VIDEO_MP4_18));
        movies.add(new Movie(19, "Hereditary", "2018",
                "Sau cái chết của người bà, một gia đình bắt đầu khám phá ra những bí mật kinh hoàng về tổ tiên.",
                R.drawable.hereditary_poster, YOUTUBE_ID_19, VIDEO_MP4_19));
        movies.add(new Movie(20, "A Quiet Place", "2018",
                "Một gia đình phải sống trong im lặng tuyệt đối để trốn thoát khỏi những sinh vật săn mồi bằng âm thanh.",
                R.drawable.a_quiet_place_poster, YOUTUBE_ID_20, VIDEO_MP4_20));
        movies.add(new Movie(21, "Get Out", "2017",
                "Một chàng trai trẻ phát hiện ra sự thật kinh tởm phía sau chuyến thăm gia đình bạn gái da trắng.",
                R.drawable.getout_poster, YOUTUBE_ID_21, VIDEO_MP4_21));
        movies.add(new Movie(22, "Toy Story 4", "2019",
                "Woody cùng những người bạn đồng hành trong một chuyến hành trình mới và gặp lại Bo Peep.",
                R.drawable.toy_story_4_poster, YOUTUBE_ID_22, VIDEO_MP4_22));
        movies.add(new Movie(23, "How to Train Your Dragon 3", "2019",
                "Hiccup và Răng Sứt khám phá ra vùng đất bí mật của loài rồng và đối mặt với kẻ thù nguy hiểm.",
                R.drawable.how_to_train_ur_dragon_3_poster, YOUTUBE_ID_23, VIDEO_MP4_23));
        movies.add(new Movie(24, "Frozen 2", "2019",
                "Elsa cùng Anna dấn thân vào khu rừng phép thuật để tìm kiếm nguồn gốc sức mạnh của cô.",
                R.drawable.frozen_2_poster, YOUTUBE_ID_24, VIDEO_MP4_24));
        movies.add(new Movie(25, "Demon Slayer", "2020",
                "Tanjiro và nhóm bạn cùng Viêm Trụ tiêu diệt quỷ trên một chuyến tàu vô tận bí ẩn.",
                R.drawable.demon_slayer_poster, YOUTUBE_ID_25, VIDEO_MP4_25));
        return movies;
    }

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        List<Movie> allMovies = getAllMovies();

        List<Movie> actionMovies = new ArrayList<>();
        actionMovies.add(allMovies.get(0)); // Avengers
        actionMovies.add(allMovies.get(2)); // Dark Knight
        actionMovies.add(allMovies.get(5)); // Gladiator
        actionMovies.add(allMovies.get(11)); // John Wick 4
        actionMovies.add(allMovies.get(12)); // Mad Max
        actionMovies.add(allMovies.get(13)); // Top Gun
        categories.add(new Category("🔥 Hành động", actionMovies));

        List<Movie> scifiMovies = new ArrayList<>();
        scifiMovies.add(allMovies.get(1)); // Inception
        scifiMovies.add(allMovies.get(3)); // Interstellar
        scifiMovies.add(allMovies.get(4)); // Matrix
        scifiMovies.add(allMovies.get(6)); // Sherlock Holmes
        scifiMovies.add(allMovies.get(14)); // Blade Runner
        scifiMovies.add(allMovies.get(15)); // Dune
        scifiMovies.add(allMovies.get(16)); // Tenet
        categories.add(new Category("🚀 Viễn tưởng", scifiMovies));

        List<Movie> horrorMovies = new ArrayList<>();
        horrorMovies.add(allMovies.get(7)); // The Conjuring
        horrorMovies.add(allMovies.get(8)); // IT
        horrorMovies.add(allMovies.get(17)); // The Conjuring 2
        horrorMovies.add(allMovies.get(18)); // Hereditary
        horrorMovies.add(allMovies.get(19)); // A Quiet Place
        horrorMovies.add(allMovies.get(20)); // Get Out
        categories.add(new Category("\uD83D\uDC80 Kinh dị", horrorMovies));

        List<Movie> animationMovies = new ArrayList<>();
        animationMovies.add(allMovies.get(9)); // Shrek
        animationMovies.add(allMovies.get(10)); // Spider Verse
        animationMovies.add(allMovies.get(21)); // Toy Story 4
        animationMovies.add(allMovies.get(22)); // Dragon 3
        animationMovies.add(allMovies.get(23)); // Frozen 2
        animationMovies.add(allMovies.get(24)); // Demon Slayer
        categories.add(new Category("\uD83E\uDDF8 Hoạt hình", animationMovies));

        return categories;
    }
}