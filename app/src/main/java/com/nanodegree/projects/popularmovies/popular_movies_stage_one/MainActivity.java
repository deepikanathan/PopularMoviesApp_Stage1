package com.nanodegree.projects.popularmovies.popular_movies_stage_one;

import android.content.SharedPreferences;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.nanodegree.projects.popularmovies.popular_movies_stage_one.Utils.NetworkUtils;
import com.nanodegree.projects.popularmovies.popular_movies_stage_one.models.Movie;

/**
 * Launcher class that shows Movie items as a grid
 */
public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    private Menu mainMenu;
    public ProgressBar progressBar;
    private static Movie[] moviesArray;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.pb_loading_indicator);

        gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);

        int spanCount = 3;
        int spacing = 50;
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing));

        setParcelable(savedInstanceState);
    }

    /**
     * Set Movie object in Parcel
     * @param savedInstanceState instance bundle
     */
    private void setParcelable(Bundle savedInstanceState)
    {
        if (savedInstanceState == null)
        {
            String sort_type = getSortType();
            loadMovieData(sort_type);
        }
        else
        {
            Parcelable[] parcelable = savedInstanceState.
                    getParcelableArray(getString(R.string.movie_intent_data));

            if (parcelable != null)
            {
                int numMovieObjects = parcelable.length;
                Movie[] movies = new Movie[numMovieObjects];

                for (int i = 0; i < numMovieObjects; i++)
                {
                    movies[i] = (Movie) parcelable[i];
                }
                moviesArray = movies;
                setMovieAdapter(movies);
            }
        }
    }

    /**
     * Save the instance state
     * @param outState instance state
     */
    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        int numMovieObjects = gridLayoutManager.getItemCount();
        if (numMovieObjects > 0)
        {
            outState.putParcelableArray(getString(R.string.movie_intent_data), moviesArray);
        }
        super.onSaveInstanceState(outState);
    }

    /**
     * Create sort menu options
     * @param menu Menu
     * @return true
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, mainMenu);

        mainMenu = menu;

        mainMenu.add(Menu.NONE,
                R.string.sort_by_most_popular,
                Menu.NONE, getString(R.string.sort_by_most_popular))
                .setVisible(false)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        mainMenu.add(Menu.NONE,
                R.string.sort_by_highest_rating,
                Menu.NONE, getString(R.string.sort_by_highest_rating))
                .setVisible(false)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_WITH_TEXT);

        updateMenu();

        return true;
    }

    /**
     * Update Menu options
     */
    private void updateMenu() {
        String sortMethod = getSortType();

        if (sortMethod.equals(getString(R.string.sort_by_most_popular_api))) {
            mainMenu.findItem(R.string.sort_by_most_popular).setVisible(false);
            mainMenu.findItem(R.string.sort_by_highest_rating).setVisible(true);
        }
        else
        {
            mainMenu.findItem(R.string.sort_by_highest_rating).setVisible(false);
            mainMenu.findItem(R.string.sort_by_most_popular).setVisible(true);
        }
    }

    /**
     * Method called when a sort option is selected from the menu.
     * @param item Sort MenuItem selected
     * @return true
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.string.sort_by_most_popular:
                updateSharedPrefs(getString(R.string.sort_by_most_popular_api));
                updateMenu();
                loadMovieData(getSortType());
                return true;
            case R.string.sort_by_highest_rating:
                updateSharedPrefs(getString(R.string.sort_by_highest_rating_api));
                updateMenu();
                loadMovieData(getSortType());
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Update Shared Preferences
     * @param sortMethod sort type
     */
    private void updateSharedPrefs(String sortMethod) {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(getString(R.string.sort_type_key_shared_pref), sortMethod);
        editor.apply();
    }

    /**
     * Pass Movie array to the adapter
     * @param movies array
     */
    public void setMovieAdapter(Movie[] movies)
    {
        moviesArray = movies;
        MovieAdapter customAdapter = new MovieAdapter(MainActivity.this, movies);
        recyclerView.setAdapter(customAdapter);
    }

    /**
     * Get sort method from preferences
     * @return sort method
     */
    private String getSortType() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        return prefs.getString(getString(R.string.sort_type_key_shared_pref),
                getString(R.string.sort_by_most_popular_api));
    }

    /**
     * Get Movie data from the web by starting an AsyncTask
     * @param sortType Movie data sort method
     */
    private void loadMovieData(String sortType) {

        if (NetworkUtils.isNetworkAvailable(this))
        {
            new FetchMovieTask(this).execute(sortType);
        }
        else
        {
            Toast.makeText(this, R.string.cannot_load_movie_data, Toast.LENGTH_LONG).show();
        }
    }
}
