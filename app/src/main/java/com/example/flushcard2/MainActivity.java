package com.example.flushcard2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Card> mCards;
    CardAdapter mCardAdapter;
    ListView mListView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.listView);
        mCards = new ArrayList<Card>();

        mCards.add(new Card(R.drawable.icon1,getString(R.string.walk_title),
                getString(R.string.walk_content),getString(R.string.walk_meaning)));
        mCards.add(new Card(R.drawable.icon2,getString(R.string.jump_title),
                getString(R.string.jump_content),getString(R.string.jump_meaning)));
        mCards.add(new Card(R.drawable.icon3,getString(R.string.president_title),
                getString(R.string.president_content),getString(R.string.president_meaning)));
        mCards.add(new Card(R.drawable.icon4,getString(R.string.shortcut_title),
                getString(R.string.shortcut_content),getString(R.string.shortcut_meaning)));

        mCardAdapter = new CardAdapter(this,R.layout.card,mCards);
        mListView.setAdapter(mCardAdapter);



    }
}
