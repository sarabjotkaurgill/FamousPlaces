package com.example.famousplaces;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlacesAdapter extends BaseAdapter {

    ArrayList<FamousPlacesArray> all_places;
    Button viewBtn;
    Context context;

    public PlacesAdapter(ArrayList<FamousPlacesArray> all_places, Context context) {
        this.all_places = all_places;
        this.context = context;
    }

    @Override
    public int getCount() {
        return all_places.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder              = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView             = inflater.inflate(R.layout.activity_show_places,parent, false);
            viewBtn                 = convertView.findViewById(R.id.viewDetail);
            viewHolder.placeImage   = convertView.findViewById(R.id.placeImage);
            viewHolder.placeName    = convertView.findViewById(R.id.placeName);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.placeImage.setImageResource(all_places.get(position).getPlaceImage());
        viewHolder.placeName.setText(all_places.get(position).getPlaceName());

        //View Detail Page
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent viewWindow = new Intent(context, ViewPlaceActivity.class);
                viewWindow.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                viewWindow.putExtra("place",position);
                context.startActivity(viewWindow);

            }
        });
        return convertView;
    }

    private static class ViewHolder{
        ImageView placeImage;
        TextView placeName;
    }
}
