package com.example.listview_alertdialog;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add Data to listView
        ListView listView = new ListView(this);
        //Add data to Array List
        //List<String> data = new ArrayList<>();
        //추가
        ArrayList<String> category = new ArrayList<>();

        category.add("개인정보 침해");
        category.add("부적절한 사진");
        category.add("부적절한 내용");
        category.add("광고 및 스팸");
        category.add("욕설");
        category.add("혐오표현");
        category.add("기타");

        //Create Array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,category);
        listView.setAdapter(adapter);

        //Now we add list View to alert bpx
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setView(listView);
        final AlertDialog dialog = builder.create();

        // do action to Edit text
        EditText txtDate = (EditText) findViewById(R.id.txtDays);
        txtDate.setOnClickListener(new View.OnClickListener() { //클릭이되면
            @Override
            public void onClick(View v) {
                dialog.show();
            } //dialog를 보여준다.
        });

        //add action to listView to select date to Edit text
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtDate.setText(adapter.getItem(position)); //adapter(선택창)에서 클릭위치의 item 얻어서 setText에 전달
                dialog.dismiss(); //사라진다.
            }
        });
    }
}