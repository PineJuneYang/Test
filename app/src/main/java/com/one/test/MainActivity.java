package com.one.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<String> strings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);

        ListAdapter adapter =new ListAdapter();

        for (int i=0;i<10;i++){
            strings.add("我是"+i);
        }

        lv.setAdapter(adapter);
        View inflate = LayoutInflater.from(this).inflate(R.layout.item_title, null);
        lv.addHeaderView(inflate);
    }


    class ListAdapter extends BaseAdapter {


        @Override
        public int getCount() {


            return  strings.size();

        }

        @Override
        public Object getItem(int position) {
            return strings.get(position);
        }

        @Override
        public long getItemId(int postion) {
            return postion;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            if (convertView == null){
                convertView =LayoutInflater.from(MainActivity.this).inflate(R.layout.item,null);
            }
            TextView tv = convertView.findViewById(R.id.tv);
            tv.setText(strings.get(i));

            return convertView;
        }
    }
}
