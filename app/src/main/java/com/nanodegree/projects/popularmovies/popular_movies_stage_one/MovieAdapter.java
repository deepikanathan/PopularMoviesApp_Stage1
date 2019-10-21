package com.nanodegree.projects.popularmovies.popular_movies_stage_one;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nanodegree.projects.popularmovies.popular_movies_stage_one.models.Movie;
import com.squareup.picasso.Picasso;

class MovieAdapter extends RecyclerView.Adapter {

    private final Context context;
    private final Movie[] movies;

    public MovieAdapter(Context context, Movie[] movies) {
        this.context = context;
        this.movies = movies;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_list_item, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int position) {

        Picasso.with(context)
                .load(movies[position].getPoster_thumbnail())
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_error)
                .resize(185, 185)
                .into(((MovieViewHolder)viewHolder).image);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                Movie movie = movies[position];
                intent.putExtra(view.getContext().getResources().getString(R.string.movie_intent_data), movie);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }

    class MovieViewHolder extends RecyclerView.ViewHolder
    {
        final ImageView image;

        MovieViewHolder(View itemView)
        {
            super(itemView);
            image = itemView.findViewById(R.id.movie_list_item_image_view);
        }
    }

}


