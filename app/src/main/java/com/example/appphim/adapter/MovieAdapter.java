package com.example.appphim.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appphim.DetailActivity;
import com.example.appphim.R;
import com.example.appphim.helpers.FavoriteManager;
import com.example.appphim.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> implements Filterable {

    private List<Movie> movieList;
    private List<Movie> movieListFull;  // Danh sách đầy đủ để lọc
    private Context context;
    private FavoriteManager favoriteManager;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.movieListFull = new ArrayList<>(movieList);  // Lưu bản sao đầy đủ
        this.context = context;
        this.favoriteManager = new FavoriteManager(context);
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        holder.tvTitle.setText(movie.getTitle());
        holder.tvYear.setText(movie.getYear());
        holder.ivPoster.setImageResource(movie.getPosterResId());

        // Cập nhật trạng thái icon yêu thích
        updateFavoriteIcon(holder.ivFavorite, movie.getId());

        // Xử lý click vào icon yêu thích
        // Xử lý click vào icon yêu thích
        holder.ivFavorite.setOnClickListener(v -> {
            if (favoriteManager.isFavorite(movie.getId())) {
                // Nếu đang yêu thích -> xóa
                favoriteManager.removeFavorite(movie.getId());
                updateFavoriteIcon(holder.ivFavorite, movie.getId());
                // THÊM DÒNG NÀY: Thông báo xóa
                android.widget.Toast.makeText(context, "Đã xóa khỏi yêu thích", android.widget.Toast.LENGTH_SHORT).show();
            } else {
                // Nếu chưa yêu thích -> thêm
                favoriteManager.addFavorite(movie.getId());
                updateFavoriteIcon(holder.ivFavorite, movie.getId());
                // THÊM DÒNG NÀY: Thông báo thêm
                android.widget.Toast.makeText(context, "Đã thêm vào yêu thích", android.widget.Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý click vào item (xem chi tiết)
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("movie", movie);
            context.startActivity(intent);
        });
    }

    private void updateFavoriteIcon(ImageView ivFavorite, int movieId) {
        if (favoriteManager.isFavorite(movieId)) {
            ivFavorite.setImageResource(android.R.drawable.btn_star_big_on);
        } else {
            ivFavorite.setImageResource(android.R.drawable.btn_star_big_off);
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    // Phương thức cập nhật danh sách (dùng khi refresh favorite)
    public void updateList(List<Movie> newList) {
        this.movieList = newList;
        this.movieListFull = new ArrayList<>(newList);
        notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {
        return movieFilter;
    }

    private Filter movieFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Movie> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(movieListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Movie movie : movieListFull) {
                    if (movie.getTitle().toLowerCase().contains(filterPattern)) {
                        filteredList.add(movie);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            movieList.clear();
            movieList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
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