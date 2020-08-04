package com.example.submissionfinalbfaafavoritemovie.view;

import android.database.Cursor;

interface LoadFilmCallback {
    void postExecute(Cursor cursor);
}
