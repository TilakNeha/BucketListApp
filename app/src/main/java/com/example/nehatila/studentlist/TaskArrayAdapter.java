package com.example.nehatila.studentlist;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nehatila.studentlist.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nehatila on 6/26/2015.
 */
public class TaskArrayAdapter extends ArrayAdapter<BucketTask> {
    Context context;
    int layoutResourceId;
    ArrayList<BucketTask> bucketTasks = new ArrayList<BucketTask>();

    public TaskArrayAdapter(Context context, int layoutResourceId, ArrayList<BucketTask> bucketTasks ) {
        super(context, layoutResourceId, bucketTasks);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.bucketTasks = bucketTasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        BucketTaskWrapper bucketTaskWrapper = null;
        if (item == null ) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            item = inflater.inflate(layoutResourceId, parent, false);
            bucketTaskWrapper = new BucketTaskWrapper();
            bucketTaskWrapper.taskName = (TextView) item.findViewById(R.id.taskName);
            bucketTaskWrapper.taskLocation = (TextView) item.findViewById(R.id.taskLocation);
            bucketTaskWrapper.taskType = (TextView) item.findViewById(R.id.taskType);
            bucketTaskWrapper.markDone = (Button) item.findViewById(R.id.btnDone);
            bucketTaskWrapper.deleteTask = (Button) item.findViewById(R.id.btnDelete);
            item.setTag(bucketTaskWrapper);
        } else {
            bucketTaskWrapper = (BucketTaskWrapper) item.getTag();
        }

        BucketTask bTask = bucketTasks.get(position);
        bucketTaskWrapper.taskName.setText(bTask.getTaskName());
        bucketTaskWrapper.taskLocation.setText(bTask.getTaskLocation());
        bucketTaskWrapper.taskType.setText(bTask.getTaskType());
        bucketTaskWrapper.deleteTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Deleting task", Toast.LENGTH_SHORT).show();
            }
        });
        bucketTaskWrapper.markDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Task Done", Toast.LENGTH_SHORT).show();
            }
        });
        return item;
    }

    static class BucketTaskWrapper {
        TextView taskName;
        TextView taskLocation;
        TextView taskType;
        Button markDone;
        Button deleteTask;
    }
}

