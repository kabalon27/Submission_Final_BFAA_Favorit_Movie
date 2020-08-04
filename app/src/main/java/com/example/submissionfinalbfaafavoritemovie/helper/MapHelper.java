package com.example.submissionfinalbfaafavoritemovie.helper;

import android.database.Cursor;

import com.example.submissionfinalbfaafavoritemovie.model.MovieModel;

import java.util.ArrayList;

public class MapHelper {
    public static ArrayList<MovieModel> mapCursorToArrayList(Cursor movieCursor){
        ArrayList<MovieModel> movieList = new ArrayList<>();
        while(movieCursor.moveToNext()){
            int id = movieCursor.getInt(movieCursor.getColumnIndexOrThrow("id"));
            int vote_count = movieCursor.getInt(movieCursor.getColumnIndexOrThrow("vote_count"));
            String title = movieCursor.getString(movieCursor.getColumnIndexOrThrow("title"));
            String overview = movieCursor.getString(movieCursor.getColumnIndexOrThrow("overview"));
            String release_date = movieCursor.getString(movieCursor.getColumnIndexOrThrow("release_date"));
            String poster_path = movieCursor.getString(movieCursor.getColumnIndexOrThrow("poster_path"));
            String original_language = movieCursor.getString(movieCursor.getColumnIndexOrThrow("original_language"));
            String category = movieCursor.getString(movieCursor.getColumnIndexOrThrow("category"));
            double vote_average = movieCursor.getDouble(movieCursor.getColumnIndexOrThrow("vote_average"));

            if (category.equals("movie")){
                MovieModel movies = new MovieModel();
                movies.setId(id);
                movies.setVote_count(vote_count);
                movies.setTitle(title);
                movies.setOverview(overview);
                movies.setRelease_date(release_date);
                movies.setPoster_path(poster_path);
                movies.setOriginal_language(original_language);
                movies.setVote_average(vote_average);
                movieList.add(movies);
            }
        }
        return movieList;
    }
}
