package com.example.acer.baitap2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import android.app.AlertDialog;
import android.content.DialogInterface;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<String> arrayWork = new ArrayList<String>();
        //
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,

                android.R.layout.simple_list_item_1, arrayWork);
        //Các EditText để vào nội dung công việc được lấy về từ XML

        final EditText workEnter = (EditText) findViewById(R.id.work_enter);

        final EditText hourEdit = (EditText) findViewById(R.id.hour_edit);

        final EditText minuteEdit = (EditText) findViewById(R.id.minute_edit);



        //Button khi nhấn sẽ thêm công việc vào ListView

        final Button button = (Button) findViewById(R.id.button);
        //ListView chứa danh sách công việc

        final ListView list = (ListView) findViewById(R.id.list);

        //Cần set Adapter cho list để biết sẽ lấy nội dung từ mảng arrayWork

        list.setAdapter(arrayAdapter);
        //Định nghĩa Listener xử lý sự kiện nhấn vào button

        OnClickListener add = new OnClickListener() {
            @Override

            public void onClick(View v) {
                //Nếu 1 trong 3 Edit Text không có nội dung thì hiện lên cảnh báo

                if (workEnter.getText().toString().equals("") ||

                        hourEdit.getText().toString().equals("") ||

                        minuteEdit.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");

                    builder.setMessage("Please enter all information of the work");

                    builder.setPositiveButton("Continue", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {

                            // TODO Auto-generated method stub

                        }

                    });

                    builder.show();

                }
                //Lấy nội dung công việc và thời gian ra từ Edit Text và đưa vào list

                else {

                    String str = workEnter.getText().toString() + " - "

                            + hourEdit.getText().toString() + ":"

                            + minuteEdit.getText().toString();

                    arrayWork.add(0,str);

                    arrayAdapter.notifyDataSetChanged();

                    workEnter.setText("");

                    hourEdit.setText("");

                    minuteEdit.setText("");

                }

            };


        };
        //set Listener cho button

        button.setOnClickListener(add);

    }
}
