package com.example.appphim.helpers;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HistoryManager {
    private static final String PREF_NAME = "movie_history";
    private static final String KEY_HISTORY = "history_ids";
    private static final int MAX_HISTORY_SIZE = 10; // Chỉ lưu 10 phim gần nhất

    private SharedPreferences prefs;

    public HistoryManager(Context context) {
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    // Thêm phim vào lịch sử
    public void addToHistory(int movieId) {
        List<String> history = getHistoryList();

        // Xóa nếu đã tồn tại (để đưa lên đầu)
        history.remove(String.valueOf(movieId));

        // Thêm vào đầu danh sách
        history.add(0, String.valueOf(movieId));

        // Giới hạn số lượng
        if (history.size() > MAX_HISTORY_SIZE) {
            history = history.subList(0, MAX_HISTORY_SIZE);
        }

        saveHistoryList(history);
    }

    // Lấy danh sách ID lịch sử
    public List<String> getHistoryIds() {
        return getHistoryList();
    }

    // Xóa toàn bộ lịch sử
    public void clearHistory() {
        saveHistoryList(new ArrayList<>());
    }

    // Lấy danh sách (private)
    private List<String> getHistoryList() {
        Set<String> historySet = prefs.getStringSet(KEY_HISTORY, new HashSet<>());
        return new ArrayList<>(historySet);
    }

    // Lưu danh sách (private)
    private void saveHistoryList(List<String> history) {
        Set<String> historySet = new HashSet<>(history);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putStringSet(KEY_HISTORY, historySet);
        editor.apply();
    }
}