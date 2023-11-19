package com.example.listview_alertdialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add Data to listView
        ListView listView = new ListView(this);
        //Add data to Array List
        //List<String> data = new ArrayList<>();
        List<String> data = new ArrayList<>();

        data.add("개인정보 침해");
        data.add("부적절한 사진");
        data.add("부적절한 내용");
        data.add("광고 및 스팸");
        data.add("욕설");
        data.add("혐오표현");
        data.add("기타");

        //Create Array adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

        //Now we add list View to alert bpx
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(true);
        builder.setView(listView);
        final AlertDialog dialog = builder.create();

        // do action to Edit text
        EditText txtDate = (EditText) findViewById(R.id.txtDays);
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        //add action to listView to select date to Edit text

        listView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                txtDate.setText(adapter.getItem(position));
                dialog.dismiss();
            }
        });
    }
}