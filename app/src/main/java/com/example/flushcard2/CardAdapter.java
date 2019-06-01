package com.example.flushcard2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CardAdapter extends ArrayAdapter<Card> {
    List<Card> mCards;

    public CardAdapter(Context context, int layoutResouceId, List<Card> objects){
        super(context,layoutResouceId,objects);

        mCards = objects;
    }

    @Override
    public int getCount(){
        return mCards.size();
    }

    @Override
    public Card getItem(int position) {
        return mCards.get(position);
    }

    @Override
    public View getView(final  int position, View convertView , ViewGroup parent){
        final ViewHolder viewHolder;

        return convertView;
    }


    public static class ViewHolder{
        ImageView iconImageView;
        TextView titleTextView;
        TextView likeTextView;
        TextView contentTextView;
        ImageView likeButton;

        public ViewHolder(View view){
            iconImageView = (ImageView)view.findViewById(R.id.icon);
            titleTextView = (TextView)view.findViewById(R.id.title_textview);
            likeTextView = (TextView)view.findViewById(R.id.like_textview);
            contentTextView = (TextView)view.findViewById(R.id.content);
            likeButton = (ImageView) view.findViewById(R.id.like_button);



        }
    }

}
