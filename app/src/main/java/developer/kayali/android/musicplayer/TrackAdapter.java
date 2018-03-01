package developer.kayali.android.musicplayer;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TrackAdapter extends ArrayAdapter<Track>{


    public TrackAdapter(Activity context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Track currentTrack = getItem(position);
        // Set album Image
        ImageView trackImage = (ImageView)listItemView.findViewById(R.id.track_image);
        trackImage.setImageResource(currentTrack.getmImagePath());
        // Set track name to textView
        TextView trackName = (TextView) listItemView.findViewById(R.id.track_name);
        trackName.setText(currentTrack.getmName());
        // Set Track length to textView
        TextView trackDuration = (TextView)listItemView.findViewById(R.id.track_duration);
        trackDuration.setText(String.valueOf(currentTrack.getmDuration()));
        // Set artist name to textView
        TextView artistName = (TextView)listItemView.findViewById(R.id.artist_name);
        artistName.setText(String.valueOf(currentTrack.getmArtist()));
        return listItemView;
    }
}