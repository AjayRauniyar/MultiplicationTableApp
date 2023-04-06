package com.example.tableapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView myrecyclerview;
    public void dataGenerateInRecyclerView(int tableNum){
        ArrayList<String> tables=new ArrayList<>();
        for(int i=1;i<=10;i++){
            tables.add(tableNum+" * "+i +" = "+Integer.toString(i*tableNum));
        }
        myrecyclerview.setLayoutManager(new LinearLayoutManager(this));
       myrecyclerview.setAdapter(new TableRecyclerViewAdapter(tables,this));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myrecyclerview=findViewById(R.id.recyclerView);
        SeekBar seekmy=findViewById(R.id.seekBar);
        int max=20;
        int min=1;
        int startPosition=10;
        seekmy.setMax(max);
        seekmy.setProgress(startPosition);
        seekmy.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int tableNum;
                if(progress<min){
                    tableNum=min;
                    seekmy.setProgress(tableNum);
                }else{
                    tableNum=progress;
                }
                Log.d("SEEK","Value:"+tableNum);
                dataGenerateInRecyclerView(tableNum);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}