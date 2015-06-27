package com.example.nehatila.studentlist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class TaskDetails extends ActionBarActivity {

    ImageView imageView;
    private EditText taskname, taskloc, tasktype, accesstype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        Bundle extras = getIntent().getExtras();
        taskname = (EditText) findViewById(R.id.taskName);
        taskloc = (EditText) findViewById(R.id.tasklocation);
        tasktype = (EditText) findViewById(R.id.tasktype);
        accesstype = (EditText) findViewById(R.id.accesstype);

        imageView = (ImageView) findViewById(R.id.TaskIcon);
        String str1 = extras.getString("TaskName");
        String str2 = extras.getString("TaskLocation");
        String str3 = extras.getString("TaskType");
        taskname.setText(str1);
        taskloc.setText(str2);
        tasktype.setText(str3);
        if (str3.contains("Adventure")) {
            imageView.setImageResource(R.mipmap.adventure_icon);
        } else if (str3.contains("Tourism")) {
            imageView.setImageResource(R.mipmap.tourism_icon);
        } else if (str3.contains("Food")) {
            imageView.setImageResource(R.mipmap.food_icon);
        } else {
            imageView.setImageResource(R.mipmap.ic_launcher);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_task_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
