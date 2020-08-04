package com.example.submissionfinalbfaafavoritemovie.database;

import android.net.Uri;
import android.provider.BaseColumns;

public class DatabaseContract {
    private static final String AUTHORITY = "com.example.submissionfinalbfaa";
    private static final String SCHEME = "content";
    public static final class MovieColumn implements BaseColumns{
        private static final String TABLE_NAME = "favorite_mv_tv";
        public static final Uri CONTENT_URI = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .appendPath(TABLE_NAME)
                .build();
    }
}
