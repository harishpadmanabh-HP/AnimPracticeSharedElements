package com.hp.hp.animpracticesharedelements;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       final CircleImageView imageView=findViewById(R.id.profile_image);
       final TextView textView=findViewById(R.id.editText);

       imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent shared=new Intent(MainActivity.this,Shared.class);
               //pairs with widget and transition name
               //multiple pairs can also be added                 Pair[] pairs=new Pair[n];
               Pair[] pairs=new Pair[2];
               pairs[0]=new Pair<View,String>(imageView,"imageshared");
               pairs[1]=new Pair<View,String>(textView,"textshared");
               ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
               //start activity with activity options
               startActivity(shared,options.toBundle());
           }
       });
    }
}
