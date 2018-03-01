package developer.kayali.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class NowPlayingActivity extends AppCompatActivity {
    // Declaring a boolean Variable to certain if the Track is saved in Favorites
    boolean favorite;
    // Declaring the Button
    ImageButton favoriteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Initializing favorite variable and button
        favorite = false;
        favoriteBtn = (ImageButton)findViewById(R.id.favorite_btn);
        // Set the icon to favorite button according to favorite boolean status
        if (favorite){
            favoriteBtn.setBackgroundResource(R.drawable.ic_favorite_white_24dp);
        } else {
            favoriteBtn.setBackgroundResource(R.drawable.ic_favorite_border_white_24dp);
        }
        // Add / Remove the track from favorites list when button clicked
        favoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (favorite){
                    favorite = false;
                    favoriteBtn.setBackgroundResource(R.drawable.ic_favorite_border_white_24dp);
                    Toast.makeText(NowPlayingActivity.this,getResources().getString(R.string.removed_from_favorites),Toast.LENGTH_SHORT).show();
                } else {
                    favorite = true;
                    favoriteBtn.setBackgroundResource(R.drawable.ic_favorite_white_24dp);
                    Toast.makeText(NowPlayingActivity.this,getResources().getString(R.string.saved_in_favorites),Toast.LENGTH_SHORT).show();
                }
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
            Intent homeIntent = new Intent(NowPlayingActivity.this, AllTracksActivity.class);
            startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}