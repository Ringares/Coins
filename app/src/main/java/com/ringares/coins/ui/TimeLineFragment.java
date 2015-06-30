package com.ringares.coins.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ringares.coins.R;
import com.ringares.coins.application.MyApplication;

public class TimeLineFragment extends Fragment {
    private RecyclerViewAdapter adapter;

    public TimeLineFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RecyclerView rv = (RecyclerView) inflater.inflate(
                R.layout.fragment_list, container, false);
        setupRecyclerView(rv);
        return rv;
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        recyclerView.setLayoutManager(new LinearLayoutManager(MyApplication.context));
        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setVerticalScrollBarEnabled(true);
    }

    public static class RecyclerViewAdapter extends RecyclerView.Adapter {
        public static class RVHolder extends RecyclerView.ViewHolder {
            private ImageView iv;
            private TextView tv;

            public RVHolder(View view) {
                super(view);
                iv = (ImageView) view.findViewById(R.id.iv);
                tv = (TextView) view.findViewById(R.id.tv);
            }
            public void setData(int index){
                tv.setText("      "+index);
            }
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MyApplication.context).inflate(R.layout.list_item,parent,false);

            return new RVHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            RVHolder rvHolder = (RVHolder)holder;
            rvHolder.setData(position);
        }

        @Override
        public int getItemCount() {
            return 20;
        }
    }


}
