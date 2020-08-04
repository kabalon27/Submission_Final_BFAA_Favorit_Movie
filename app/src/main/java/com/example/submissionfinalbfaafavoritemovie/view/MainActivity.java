package com.example.submissionfinalbfaafavoritemovie.view;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submissionfinalbfaafavoritemovie.R;
import com.example.submissionfinalbfaafavoritemovie.adapter.MovieFavoriteAdapter;
import com.example.submissionfinalbfaafavoritemovie.model.MovieModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.example.submissionfinalbfaafavoritemovie.database.DatabaseContract.MovieColumn.CONTENT_URI;
import static com.example.submissionfinalbfaafavoritemovie.helper.MapHelper.mapCursorToArrayList;

public class MainActivity extends AppCompatActivity implements LoadFilmCallback {

    private MovieFavoriteAdapter favoriteAdapter;
    private DataObserver dataObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvMovieFav = findViewById(R.id.rv_movie);
        favoriteAdapter = new MovieFavoriteAdapter();

        rvMovieFav.setLayoutManager(new LinearLayoutManager(this));
        rvMovieFav.setHasFixedSize(true);
        rvMovieFav.setAdapter(favoriteAdapter);

        HandlerThread handlerThread = new HandlerThread("DataObserver");
        handlerThread.start();

        Handler handler = new Handler(handlerThread.getLooper());
        dataObserver = new DataObserver(handler, this);
        getContentResolver().registerContentObserver(CONTENT_URI, true, dataObserver);
        new getData(this, this).execute();
    }

    @Override
    public void postExecute(Cursor cursor){
        ArrayList<MovieModel> listMovie = mapCursorToArrayList(cursor);
        if (listMovie.size() > 0){
            favoriteAdapter.setData(listMovie, getApplicationContext());
        } else {
            Toast.makeText(this, "Tidak Ada data saat ini", Toast.LENGTH_SHORT).show();
            favoriteAdapter.setData(new ArrayList<MovieModel>(), getApplicationContext());
        }
    }

    static class DataObserver extends ContentObserver{
        final Context context;

        DataObserver(Handler handler, Context context) {
            super(handler);
            this.context = context;
        }

        @Override
        public void onChange(boolean selfChange){
            super.onChange(selfChange);
            new getData(context, (MainActivity)context).execute();
        }
    }

    private static class getData extends AsyncTask<Void, Void, Cursor>{
        private final WeakReference<Context> weakContext;
        private final WeakReference<LoadFilmCallback> weakCallback;

        private getData(Context context, LoadFilmCallback callback) {
            weakContext = new WeakReference<>(context);
            weakCallback = new WeakReference<>(callback);
        }

        @Override
        protected Cursor doInBackground(Void... voids) {
            return weakContext.get().getContentResolver().query(CONTENT_URI, null, null, null, null);
        }

        @Override
        protected void onPostExecute(Cursor data){
            super.onPostExecute(data);
            weakCallback.get().postExecute(data);
        }
    }
}
