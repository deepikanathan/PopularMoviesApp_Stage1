package com.nanodegree.projects.popularmovies.popular_movies_stage_one;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.nanodegree.projects.popularmovies.popular_movies_stage_one.models.Movie;
import com.squareup.picasso.Picasso;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class that shows Movie details
 */
public class DetailActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        TextView originalTitleTextView = findViewById(R.id.original_title_value);
        ImageView posterImageView = findViewById(R.id.poster_image_view);
        TextView synopsisTextView = findViewById(R.id.synopsis_value);
        TextView userRatingTextView = findViewById(R.id.user_rating_value);
        TextView releaseDateTextView = findViewById(R.id.release_date_value);

        Intent intent = getIntent();
        Movie movie = intent.getParcelableExtra(getString(R.string.movie_intent_data));

        try
        {
            //  set OriginalTitle
            originalTitleTextView.setText(movie.getOriginalTitle());

            //  set Poster thumbnail
            Picasso.with(this)
                    .load(movie.getPoster_thumbnail())
                    .resize(185, 185)
                    .error(R.drawable.ic_error)
                    .placeholder(R.drawable.ic_error)
                    .into(posterImageView);

            //  set Synopsis/Overview
            String overView = movie.getSynopsisOverview();
            if (overView == null || overView.isEmpty())
            {
                overView = getResources().getString(R.string.value_not_found);
            }
            synopsisTextView.setText(overView);

            //  set User Rating
            String userRating = movie.getUserRating();
            if (userRating == null || overView.isEmpty())
            {
                userRating = getResources().getString(R.string.value_not_found);
            }
            else
            {
                userRating = String.valueOf(movie.getUserRating()) + "/10";
            }
            userRatingTextView.setText(userRating);

            //  set Release Date
            String releaseDate = movie.getReleaseDate();
            if (releaseDate != null && !releaseDate.isEmpty())
            {
                try
                {
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(releaseDate);
                    long milliseconds = date.getTime();
                    releaseDate = new SimpleDateFormat("MMM dd, yyyy").format(milliseconds);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                releaseDate = getResources().getString(R.string.value_not_found);
            }
            releaseDateTextView.setText(releaseDate);

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}
