package developer.kayali.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class FavoritesActivity extends AppCompatActivity {
    // Declaring Buttons
    Button tracks, recent, favorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Views Initialization
        tracks = (Button)findViewById(R.id.tracks_btn);
        recent = (Button)findViewById(R.id.recent_btn);
        favorites = (Button)findViewById(R.id.favorites_btn);
        // Set OnClickListeners to Navigation Buttons using explicit intents
        tracks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tracksIntent = new Intent(FavoritesActivity.this, AllTracksActivity.class);
                startActivity(tracksIntent);
            }
        });
        recent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recentIntent = new Intent(FavoritesActivity.this, RecentActivity.class);
                startActivity(recentIntent);
            }
        });
        favorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent favoritesIntent = new Intent(FavoritesActivity.this, FavoritesActivity.class);
                startActivity(favoritesIntent);
            }
        });
        // Declaring ArrayList to save Tracks information inside
        final ArrayList<Track> tracks = new ArrayList<Track>();
        // Adding Favorites Tracks Information to ArrayList
        tracks.add(new Track("Stir Fry", "Album 3", "Migos", R.drawable.stir_fry, 4.05, false));
        tracks.add(new Track("God's Plan", "Album 1", "Drake", R.drawable.gods_plan, 4.05, false));
        tracks.add(new Track("Meant To Be", "Album 2", "Bebe Rexha & Florida Georgia Line", R.drawable.meant_to_be, 1.05, false));
        tracks.add(new Track("Perfect", "Album 1", "Ed Sheeran", R.drawable.perfect, 3.05, false));
        tracks.add(new Track("Finesse", "Album 2", "Bruno Mars & Cardi B", R.drawable.finesse, 2.05, false));
        tracks.add(new Track("Havana", "Album 2", "Camila Cabello Featuring Young Thug", R.drawable.havana, 3.05, false));
        tracks.add(new Track("Look Alive", "Album 2", "BlocBoy JB Featuring Drake", R.drawable.look_alive, 2.05, false));
        // Making a new Object from TrackAdapter
        TrackAdapter adapter = new TrackAdapter(this, tracks);
        // Set an Adapter to ListView
        final ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        // Go to NowPlayingActivity when an Item from ListView clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent trackIntent = new Intent(FavoritesActivity.this, NowPlayingActivity.class);
                startActivity(trackIntent);
            }
        });
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
        // Setting Buttons in Actionbar
        if(id == R.id.homeIcon){
            Intent homeIntent = new Intent(FavoritesActivity.this, AllTracksActivity.class);
            startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}
