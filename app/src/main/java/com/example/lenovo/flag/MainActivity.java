package com.example.lenovo.flag;

import android.content.ClipData;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Item> flagList=new ArrayList<>();
    MyAdapter myAdapter;
    private static final String[] COUNTRIES = {
            "afghanistan",
            "albania",
            "china",
            "chile",
            "aruba",
            "france",
            "germany",
            "finland",
            "costa_rica",
            "denmark","ecuador","japan"
    };
    public void onUserSelect(int index){
            flagList.remove(index);
            myAdapter.notifyDataSetInvalidated();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView) findViewById(R.id.listview_main);
        for(String country : COUNTRIES){
            flagList.add(new Item(country,getResources().getIdentifier(country,"drawable",getPackageName())));
        }
        myAdapter = new MyAdapter(this,R.layout.list_view_items,flagList);
       listView.setAdapter(myAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("country",((TextView)((ViewGroup)view).findViewById(R.id.tv_item)).getText());
                startActivity(intent);
            }
        });

       listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
           @Override
           public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
             //  DialogFragment fragment=new DialogFragment();
             DeleteFragment deleteDialog=DeleteFragment.newInstance();
             FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
             Bundle args=new Bundle();
             args.putInt("index",position);
             deleteDialog.setArguments(args);
             deleteDialog.show(ft,"deleteDialog");
             return true;
           }
       });
}}
