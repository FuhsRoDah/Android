package com.example.carletonf.lab05;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * A fragment that cycles through a list of movies and displays their details
 */
public class Fragment_One extends Fragment {
    MovieData movie = new MovieData();
    List<Map<String,?>> moviesList= new ArrayList<Map<String,?>>();
    Map current;
    int i=0;
    TextView title;
    TextView description;
    TextView url;
    ImageView image;
    RatingBar ratingBar;

    float newrating;

    public Fragment_One() {

    }


    public void loadNext(){
        title = (TextView)getView().findViewById(R.id.title);
        description = (TextView)getView().findViewById(R.id.description);
        url = (TextView)getView().findViewById(R.id.url);
        image = (ImageView)getView().findViewById(R.id.imageView);
        ratingBar = (RatingBar)getView().findViewById(R.id.ratingBar);

        if(i>=movie.getSize())
        {
            i=0;
        }
        moviesList = movie.getMoviesList();
        current = moviesList.get(i);
        String stringtitle = "Title: " +current.get("name").toString()+ "\n" +current.get("year").toString();
        String stringdesc =  "Length: " +current.get("length").toString() +"\n" +current.get("description").toString()
                +"\nStars: " +current.get("stars").toString();
        String stringurl = "URL: " +current.get("url").toString();
        int movieImage = (int) current.get("image");
        double rating = (double) current.get("rating");
        newrating = (float) rating/2;

        title.setText(stringtitle);
        description.setText(stringdesc);
        url.setText(stringurl);
        image.setImageResource(movieImage);
        ratingBar.setRating(newrating);
        i++;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__one, container, false);
        Button loadnext = (Button) view.findViewById(R.id.loadnext);
        loadnext.setOnClickListener(new View.OnClickListener() {
                                        public void onClick(View view) {
                                            loadNext();
                                        }
                                    });

        return view;
    }

}
