package com.example.flushcard2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.card,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        final Card item = getItem(position);

        if (item != null){
            //setdata
            viewHolder.iconImageView.setBackgroundResource(item.imageId);
            viewHolder.titleTextView.setText(item.title);
            viewHolder.contentTextView.setText(item.content);
            viewHolder.likeButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    item.likeNum++;
                    viewHolder.likeTextView.setText(item.likeNum + "Likes");

                    Animation animation = AnimationUtils.loadAnimation(getContext(),R.anim.like_touch);
                    viewHolder.likeButton.startAnimation(animation);
                }
            });
            viewHolder.iconImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),item.meaning, Toast.LENGTH_SHORT).show();
                }
            });
        }

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
