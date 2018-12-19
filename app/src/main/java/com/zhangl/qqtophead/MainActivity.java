package com.zhangl.qqtophead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    QQHeaderScrollView qqHeaderScrollView;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qqHeaderScrollView = findViewById(R.id.lv);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, new String[]{
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",
                "星期一 	",
                "星期二	",
                "星期三 	",
                "星期四 	",
                "星期五 ",
                "星期六 ",
                "星期日 ",


        });

        View head = View.inflate(this,R.layout.listview_header,null);
        iv = head.findViewById(R.id.layout_header_image);

        qqHeaderScrollView.setZoomImageView(iv);
        qqHeaderScrollView.addHeaderView(head);
        qqHeaderScrollView.setAdapter(adapter);

        qqHeaderScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,position + "",Toast.LENGTH_SHORT).show();
            }
        });

    }









}
