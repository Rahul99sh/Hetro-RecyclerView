package com.example.hetrorecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import com.example.hetrorecyclerview.adapter.HetroAdapter;
import com.example.hetrorecyclerview.Modal.Horizontal;
import com.example.hetrorecyclerview.Modal.Vertical;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Object> movies = new ArrayList<>();
    private ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shimmerFrameLayout = findViewById(R.id.shimmer_dash);
        shimmerFrameLayout.startShimmer();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
        HetroAdapter adapter = new HetroAdapter(this, getMovies());
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            shimmerFrameLayout.stopShimmer();
            shimmerFrameLayout.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            }
        }, 2000);

    }

    private ArrayList<Object> getMovies() {
        movies.add(getVerticalData().get(0));
        movies.add(getHorizontalData().get(0));
        movies.add(getVerticalData().get(0));
        movies.add(getHorizontalData().get(0));
        movies.add(getVerticalData().get(0));
        movies.add(getHorizontalData().get(0));
        movies.add(getVerticalData().get(0));
        movies.add(getHorizontalData().get(0));
        movies.add(getVerticalData().get(0));
        movies.add(getHorizontalData().get(0));
        Collections.shuffle(movies);
        return movies;
    }



    public static ArrayList<Horizontal> getHorizontalData() {
        ArrayList<Horizontal> horizontalMovies = new ArrayList<>();
        horizontalMovies.add(new Horizontal(R.drawable.img1, "Bhramastra", "the film follows Shiva, an orphan with pyrokinetic powers who discovers that he is an astra, a weapon of enormous energy.", "2022/8/1"));
        horizontalMovies.add(new Horizontal(R.drawable.img2, "KGF 2", "It follows the assassin Rocky, who after establishing himself as the kingpin of the Kolar Gold Fields, must retain his supremacy over adversaries and government officials, while also coming to terms with his past.", "2021/4/1"));
        horizontalMovies.add(new Horizontal(R.drawable.img3, "Intesteller", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", "2008/2/1"));
        Collections.shuffle(horizontalMovies);
        return horizontalMovies;
    }

    public static ArrayList<Vertical> getVerticalData() {
        ArrayList<Vertical> verticalMovies = new ArrayList<>();
        verticalMovies.add(new Vertical("Bhramastra", "the film follows Shiva, an orphan with pyrokinetic powers who discovers that he is an astra, a weapon of enormous energy.", R.drawable.img1));
        verticalMovies.add(new Vertical("KGF 2", "It follows the assassin Rocky, who after establishing himself as the kingpin of the Kolar Gold Fields, must retain his supremacy over adversaries and government officials, while also coming to terms with his past.", R.drawable.img2));
        verticalMovies.add(new Vertical("Intesteller", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", R.drawable.img3));
        verticalMovies.add(new Vertical("Bhramastra", "the film follows Shiva, an orphan with pyrokinetic powers who discovers that he is an astra, a weapon of enormous energy.", R.drawable.img1));
        verticalMovies.add(new Vertical("KGF 2", "It follows the assassin Rocky, who after establishing himself as the kingpin of the Kolar Gold Fields, must retain his supremacy over adversaries and government officials, while also coming to terms with his past.", R.drawable.img2));
        verticalMovies.add(new Vertical("KGF 2", "It follows the assassin Rocky, who after establishing himself as the kingpin of the Kolar Gold Fields, must retain his supremacy over adversaries and government officials, while also coming to terms with his past.", R.drawable.img2));
        verticalMovies.add(new Vertical("Intesteller", "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.", R.drawable.img3));
        Collections.shuffle(verticalMovies);
        return verticalMovies;
    }


}
