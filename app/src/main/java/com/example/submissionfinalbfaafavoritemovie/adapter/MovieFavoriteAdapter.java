package com.example.submissionfinalbfaafavoritemovie.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.submissionfinalbfaafavoritemovie.R;
import com.example.submissionfinalbfaafavoritemovie.model.MovieModel;

import java.util.ArrayList;

public class MovieFavoriteAdapter extends RecyclerView.Adapter<MovieFavoriteAdapter.CardViewViewHolder> {
    private ArrayList<MovieModel> listMovie = new ArrayList<>();
    private Context context;

    public void setData(ArrayList<MovieModel> list, Context context) {
        this.context = context;
        listMovie.clear();
        listMovie.addAll(list);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_movie, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int i) {
        holder.mvTitle.setText(listMovie.get(i).getTitle());
        holder.mvOverview.setText(listMovie.get(i).getOverview());
        holder.mvRelease.setText(listMovie.get(i).getRelease_date());
        holder.mvScore.setText(Double.toString(listMovie.get(i).getVote_average()));
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w154" + listMovie.get(i).getPoster_path())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.mvPoster);
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView mvPoster;
        TextView mvTitle, mvRelease, mvScore, mvOverview;
        CardView cvMain;

        CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            mvPoster = itemView.findViewById(R.id.img_mv_poster);
            mvTitle = itemView.findViewById(R.id.title_mv);
            mvRelease = itemView.findViewById(R.id.release_mv);
            mvScore = itemView.findViewById(R.id.score_mv);
            mvOverview = itemView.findViewById(R.id.overview_mv);
            cvMain = itemView.findViewById(R.id.card_view_mv);
        }
    }
}
