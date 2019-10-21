package com.nanodegree.projects.popularmovies.popular_movies_stage_one.Utils;

import com.nanodegree.projects.popularmovies.popular_movies_stage_one.models.Movie;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Class to parse JSON to Movie objects.
 */
public class JsonUtils
{

    /**
     * Convert JSON to Movie objects
     * @param movieJson JSON from the web
     * @return Movie array
     */
    public static Movie[] getMoviesFromJSON(String movieJson)
    {
        final String RESULTS = "results";
        final String ORIGINAL_TITLE = "original_title";
        final String POSTER_PATH = "poster_path";
        final String OVERVIEW = "overview";
        final String VOTE_AVERAGE = "vote_average";
        final String RELEASE_DATE = "release_date";

        Movie[] movies = null;

        try
        {
            JSONObject moviesJson = new JSONObject(movieJson);
            JSONArray resultsArray = moviesJson.getJSONArray(RESULTS);
            movies = new Movie[resultsArray.length()];

            for (int i = 0; i < resultsArray.length(); i++)
            {
                movies[i] = new Movie();
                JSONObject movieInfo = resultsArray.getJSONObject(i);
                movies[i].setOriginalTitle(movieInfo.getString(ORIGINAL_TITLE));
                movies[i].setPoster_thumbnail(movieInfo.getString(POSTER_PATH));
                movies[i].setSynopsisOverview(movieInfo.getString(OVERVIEW));
                movies[i].setUserRating(movieInfo.getString(VOTE_AVERAGE));
                movies[i].setReleaseDate(movieInfo.getString(RELEASE_DATE));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return movies;
    }

}
