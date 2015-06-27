package com.example.nehatila.studentlist;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class BucketListView extends ActionBarActivity {
    ListView listView;
    TaskArrayAdapter taskArrayAdapter;
    ArrayList<BucketTask> bucketTaskArray = new ArrayList<BucketTask>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bucket_list_view);

        bucketTaskArray.add(new BucketTask("Taj Mahal", "Agra", "Tourism"));
        bucketTaskArray.add(new BucketTask("Sky Diving", "Canada", "Adventure"));
        bucketTaskArray.add(new BucketTask("Piramids", "Egypt", "Tourism"));
        bucketTaskArray.add(new BucketTask("Alps", "Switzerland", "Tourism"));
        bucketTaskArray.add(new BucketTask("Caviar", "France", "Food"));
        bucketTaskArray.add(new BucketTask("Kebab", "Turkey", "Food"));
        bucketTaskArray.add(new BucketTask("Vada Pav", "Mumbai", "Food"));

        taskArrayAdapter= new TaskArrayAdapter(BucketListView.this,R.layout.list_item, bucketTaskArray);
        listView = (ListView) findViewById(R.id.listView);
        listView.setItemsCanFocus(false);
        listView.setAdapter(taskArrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(BucketListView.this, "Clicked Task", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(BucketListView.this,TaskDetails.class);
                TextView taskname1 = (TextView) view.findViewById(R.id.taskName);
                TextView taskloc1 = (TextView) view.findViewById(R.id.taskLocation);
                TextView tasktype1 = (TextView) view.findViewById(R.id.taskType);
                intent1.putExtra("TaskName",taskname1.getText());
                intent1.putExtra("TaskLocation",taskloc1.getText());
                intent1.putExtra("TaskType",tasktype1.getText());

                startActivity(intent1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
