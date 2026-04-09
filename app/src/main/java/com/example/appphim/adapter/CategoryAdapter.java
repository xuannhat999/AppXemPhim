package com.example.appphim.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appphim.DetailActivity;
import com.example.appphim.R;
import com.example.appphim.helpers.FavoriteManager;
import com.example.appphim.model.Category;
import com.example.appphim.model.Movie;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<Category> categoryList;
    private Context context;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.tvCategoryTitle.setText(category.getName());

        // Tạo adapter cho danh sách phim ngang
        MovieHorizontalAdapter movieAdapter = new MovieHorizontalAdapter(category.getMovies(), context);
        holder.rvCategoryMovies.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        holder.rvCategoryMovies.setAdapter(movieAdapter);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvCategoryTitle;
        RecyclerView rvCategoryMovies;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryTitle = itemView.findViewById(R.id.tvCategoryTitle);
            rvCategoryMovies = itemView.findViewById(R.id.rvCategoryMovies);
        }
    }

    // Adapter bên trong cho danh sách phim ngang
    static class MovieHorizontalAdapter extends RecyclerView.Adapter<MovieHorizontalAdapter.MovieViewHolder> {
        private List<Movie> movies;
        private Context context;
        private FavoriteManager favoriteManager;

        public MovieHorizontalAdapter(List<Movie> movies, Context context) {
            this.movies = movies;
            this.context = context;
            this.favoriteManager = new FavoriteManager(context);
        }

        @NonNull
        @Override
        public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_movie_horizontal, parent, false);
            return new MovieViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
            Movie movie = movies.get(position);
            holder.tvTitle.setText(movie.getTitle());
            holder.tvYear.setText(movie.getYear());
            holder.ivPoster.setImageResource(movie.getPosterResId());

            // Cập nhật icon yêu thích
            if (favoriteManager.isFavorite(movie.getId())) {
                holder.ivFavorite.setImageResource(android.R.drawable.btn_star_big_on);
            } else {
                holder.ivFavorite.setImageResource(android.R.drawable.btn_star_big_off);
            }

            // Xử lý click yêu thích
            holder.ivFavorite.setOnClickListener(v -> {
                if (favoriteManager.isFavorite(movie.getId())) {
                    favoriteManager.removeFavorite(movie.getId());
                    holder.ivFavorite.setImageResource(android.R.drawable.btn_star_big_off);
                } else {
                    favoriteManager.addFavorite(movie.getId());
                    holder.ivFavorite.setImageResource(android.R.drawable.btn_star_big_on);
                }
            });

            // Xử lý click xem chi tiết
            holder.itemView.setOnClickListener(v -> {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("movie", movie);
                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return movies.size();
        }

        static class MovieViewHolder extends RecyclerView.ViewHolder {
            ImageView ivPoster;
            TextView tvTitle;
            TextView tvYear;
            ImageView ivFavorite;

            public MovieViewHolder(@NonNull View itemView) {
                super(itemView);
                ivPoster = itemView.findViewById(R.id.ivPoster);
                tvTitle = itemView.findViewById(R.id.tvTitle);
                tvYear = itemView.findViewById(R.id.tvYear);
                ivFavorite = itemView.findViewById(R.id.ivFavorite);
            }
        }
    }
}