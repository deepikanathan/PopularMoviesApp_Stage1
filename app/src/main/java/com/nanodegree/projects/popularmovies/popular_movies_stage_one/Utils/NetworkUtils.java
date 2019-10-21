package com.nanodegree.projects.popularmovies.popular_movies_stage_one.Utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.nanodegree.projects.popularmovies.popular_movies_stage_one.R;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Utility class that provides network related methods
 */
public class NetworkUtils
{
    
    private static final String API_KEY = "api_key";

    /**
     * Builds URL to retrieve JSON response
     * @param context MainActivity
     * @param sort_by sort method
     * @return URL
     */
    public static URL buildUrl(Context context, String sort_by)
    {
        String uri;
        if (sort_by.equals(String.valueOf(context.getResources().getString(R.string.sort_by_most_popular_api))))
        {
            uri = context.getResources().getString(R.string.popular_tmdb_url);
        }
        else
        {
            uri = context.getResources().getString(R.string.top_rated_tmdb_url);
        }
        Uri builtUri = Uri.parse(uri).buildUpon()
                .appendQueryParameter(API_KEY, context.getString(R.string.tmdb_api_key))
                .build();

        URL url = null;
        try
        {
            url = new URL(builtUri.toString());
        }
        catch (MalformedURLException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return url;
    }

    /**
     * Gets JSON response from TMDB
     * @param url path to TMDB API
     * @return JSON Movie response
     * @throws IOException exception
     */
    public static String getResponseFromHttpUrl(URL url) throws IOException
    {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try
        {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        }
        finally
        {
            urlConnection.disconnect();
        }
    }

    /**
     * Check for network connection.
     * Code taken from "https://stackoverflow.com/questions/9002180/using-context-connectivity-service-to-check-for-internet-connection"
     * @param context MainActivity
     * @return true if connection available, false otherwise
     */
    public static boolean isNetworkAvailable(Context context)
    {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
