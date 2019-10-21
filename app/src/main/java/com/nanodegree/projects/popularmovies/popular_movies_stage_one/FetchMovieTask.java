package com.nanodegree.projects.popularmovies.popular_movies_stage_one;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import com.nanodegree.projects.popularmovies.popular_movies_stage_one.Utils.JsonUtils;
import com.nanodegree.projects.popularmovies.popular_movies_stage_one.Utils.NetworkUtils;
import com.nanodegree.projects.popularmovies.popular_movies_stage_one.models.Movie;
import java.net.URL;

/**
 *  AsyncTask to fetch Movie JSON
 */
class FetchMovieTask extends AsyncTask<String, Void, Movie[]>
{

    private final ProgressBar progressBar;
    private final MainActivity context;

    public FetchMovieTask(MainActivity ctx)
    {
        context = ctx;
        progressBar = ctx.progressBar;
    }

    @Override
    protected void onPreExecute()
    {
        progressBar.setVisibility(View.VISIBLE);
        super.onPreExecute();
    }

    @Override
    protected Movie[] doInBackground(String... strings)
    {
        Movie[] movies = null;
        try
        {
            String sortBy = strings[0];

            URL tmdb_url = NetworkUtils.buildUrl(context, sortBy);
            //Log.d("******AsyncTask", tmdb_url.toString());
            String jsonMovieResponse = NetworkUtils.getResponseFromHttpUrl(tmdb_url);
            //Log.d("AsyncTask", jsonMovieResponse);
            movies = JsonUtils.getMoviesFromJSON(jsonMovieResponse);
            //Log.d("AsyncTask", String.valueOf(movies.length));
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return movies;
    }

    @Override
    protected void onPostExecute(Movie[] movies)
    {
        super.onPostExecute(movies);

        progressBar.setVisibility(View.INVISIBLE);
        context.setMovieAdapter(movies);
    }
}