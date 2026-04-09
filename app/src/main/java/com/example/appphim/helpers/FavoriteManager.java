package com.example.appphim.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class FavoriteManager {
    private static final String PREF_NAME = "movie_favorites";
    private static final String KEY_FAVORITES = "favorite_ids";

    private SharedPreferences prefs;

    public FavoriteManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // Thêm vào yêu thích
    public void addFavorite(int movieId) {
        Set<String> favorites = getFavoriteSet();
        favorites.add(String.valueOf(movieId));
        saveFavoriteSet(favorites);
    }

    // Xóa khỏi yêu thích
    public void removeFavorite(int movieId) {
        Set<String> favorites = getFavoriteSet();
        favorites.remove(String.valueOf(movieId));
        saveFavoriteSet(favorites);
    }

    // Kiểm tra có phải yêu thích không
    public boolean isFavorite(int movieId) {
        return getFavoriteSet().contains(String.valueOf(movieId));
    }

    // Lấy danh sách ID yêu thích
    public Set<String> getFavoriteIds() {
        return getFavoriteSet();
    }

    // Lấy Set các ID (private)
    private Set<String> getFavoriteSet() {
        return new HashSet<>(prefs.getStringSet(KEY_FAVORITES, new HashSet<>()));
    }

    // Lưu Set các ID (private)
    private void saveFavoriteSet(Set<String> favorites) {
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet(KEY_FAVORITES, favorites);
        editor.apply();
    }
}