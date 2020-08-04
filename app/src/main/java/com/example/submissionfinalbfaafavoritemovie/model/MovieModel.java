package com.example.submissionfinalbfaafavoritemovie.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class MovieModel implements Parcelable {
    @NonNull
    @ColumnInfo(name = "id")
    @PrimaryKey
    private int id;

    @ColumnInfo(name = "vote_count")
    private int vote_count;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "overview")
    private String overview;

    @ColumnInfo(name = "release_date")
    private String release_date;

    @ColumnInfo(name = "poster_path")
    private String poster_path;

    @ColumnInfo(name = "original_language")
    private String original_language;

    @ColumnInfo(name = "vote_average")
    private double vote_average;

    @ColumnInfo(name = "category")
    private String category;

    public MovieModel(){

    }

    protected MovieModel(Parcel in) {
        id = in.readInt();
        vote_count = in.readInt();
        title = in.readString();
        overview = in.readString();
        release_date = in.readString();
        poster_path = in.readString();
        original_language = in.readString();
        vote_average = in.readDouble();
        category = in.readString();
    }

    public static final Creator<MovieModel> CREATOR = new Creator<MovieModel>() {
        @Override
        public MovieModel createFromParcel(Parcel in) {
            return new MovieModel(in);
        }

        @Override
        public MovieModel[] newArray(int size) {
            return new MovieModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(vote_count);
        dest.writeString(title);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeString(poster_path);
        dest.writeString(original_language);
        dest.writeDouble(vote_average);
        dest.writeString(category);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public static Creator<MovieModel> getCREATOR() {
        return CREATOR;
    }
}
