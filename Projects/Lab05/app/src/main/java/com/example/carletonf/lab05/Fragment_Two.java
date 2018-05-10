package com.example.carletonf.lab05;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * I had no luck in getting the image to load or the seekbar to affect anything so I left the
 * fragment in a state where it at least does not break
 */
public class Fragment_Two extends Fragment {
    ImageView imageView;
    SeekBar seekBar;


    public Fragment_Two() {
        // Required empty public constructor
    }

    public void Frag2(){
        imageView = (ImageView)getView().findViewById(R.id.imageView2);
        seekBar = (SeekBar)getView().findViewById(R.id.seekBar);
        imageView.setImageResource(R.drawable.dark_knight);
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "Seek bar value:" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_fragment__two, container, false);
    }


}
