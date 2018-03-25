package com.example.dell.myapplication22;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button add,search;
    String s,s1,s2,s3,s4,s5,s6,s7;
    //TextView tv, tv1, tv2, tv3, tv4, tv5, tv6, tv7;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (Button)findViewById(R.id.ButtonAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(i,007);
            }
        });

        search = (Button)findViewById(R.id.buttonSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");
                Intent intent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lv = (ListView)findViewById(R.id.ListView);
        s = data.getStringExtra("item1");
        s1 = data.getStringExtra("item2");
        s2 = data.getStringExtra("item3");
        s3 = data.getStringExtra("item4");
        s4 = data.getStringExtra("item5");
        s5 = data.getStringExtra("item6");
        s6 = data.getStringExtra("item7");
        s7 = data.getStringExtra("item8");
        String [] Items_list = new String[]{
                s,s1,s2,s3,s4,s5,s6,s7

        };
        final List<String> shopping_list = new ArrayList<String>();
        for(String item: Items_list){
            if(item != null){
                shopping_list.add(item);
            }
        }
        //final List<String> shopping_list = new ArrayList<String>(Arrays.asList(Items_list));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, shopping_list);
        lv.setAdapter(arrayAdapter);

       /* tv = (TextView) findViewById(R.id.textView9);
        tv1 = (TextView) findViewById(R.id.textView2);
        tv2 = (TextView) findViewById(R.id.textView3);
        tv3 = (TextView) findViewById(R.id.textView4);
        tv4 = (TextView) findViewById(R.id.textView5);
        tv5 = (TextView) findViewById(R.id.textView6);
        tv6 = (TextView) findViewById(R.id.textView7);
        tv7 = (TextView) findViewById(R.id.textView8);
        tv.setText(s);
        tv1.setText(s1);
        tv2.setText(s2);
        tv3.setText(s3);
        tv4.setText(s4);
        tv5.setText(s5);
        tv6.setText(s6);
        tv7.setText(s7);*/

    }
}
