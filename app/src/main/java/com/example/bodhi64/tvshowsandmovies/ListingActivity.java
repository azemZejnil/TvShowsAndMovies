package com.example.bodhi64.tvshowsandmovies;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bodhi64.tvshowsandmovies.details.DetailsActivity;
import com.example.bodhi64.tvshowsandmovies.model.Movie;
import com.example.bodhi64.tvshowsandmovies.model.TVShow;
import com.example.bodhi64.tvshowsandmovies.movies_listing.MoviesFragment;
import com.example.bodhi64.tvshowsandmovies.searching.SearchTvContentActivity;
import com.example.bodhi64.tvshowsandmovies.tvshows_listing.TVShowsFragment;

public class ListingActivity extends AppCompatActivity implements MoviesFragment.Callback, TVShowsFragment.Callback{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.ic_search2);
        toolbar.setOverflowIcon(drawable);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        String frag="";
        if(mViewPager.getCurrentItem()==0)
            frag+="movies";
        else
            frag+="shows";

            //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(ListingActivity.this, SearchTvContentActivity.class).putExtra("key",frag));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onMoviesLoaded(Movie movie) {
    }

    @Override
    public void onMovieClicked(Movie movie) {
        startMovieActivity(movie);
    }

    private void startMovieActivity(Movie movie) {
        Intent intent = new Intent(this, DetailsActivity.class);
        Bundle extras = new Bundle();
        extras.putParcelable("movie", movie);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onTvShowsLoaded(TVShow tvShow) {

    }

    @Override
    public void onTvShowsClicked(TVShow tvShow) {
        Toast.makeText(this,"Didn't set for TV Shows",Toast.LENGTH_SHORT).show();
    }

    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0:
                    MoviesFragment fragment1= new MoviesFragment();
                    return fragment1;
                case 1:
                    TVShowsFragment fragment2= new TVShowsFragment();
                    return fragment2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }


    }
}
