package com.zhx.mypullsunrefreshview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhx.pullsunrefreshview.PullSunRefreshView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView recycleview;
    private PullSunRefreshView mPullToRefreshView;
    private RecyclerviewAdapter adapter;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycleview=findViewById(R.id.recycleview);
        mPullToRefreshView=findViewById(R.id.pullsunrefreshview);
        list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add(i+"");
        }
        adapter=new RecyclerviewAdapter(this,list);
        recycleview.setLayoutManager(new LinearLayoutManager(this));
        recycleview.setAdapter(adapter);
        //监听触发刷新
        mPullToRefreshView.setOnRefreshListener(new PullSunRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 虚拟执行完任务耗时2秒 关闭刷新
                        mPullToRefreshView.setRefreshing(false);
                    }
                },2000);
            }
        });

    }


    public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder> {

        private Context context;
        private List<String> data;

        public RecyclerviewAdapter(Context context, List<String> data) {
            this.context = context;
            this.data = data;

        }

        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview, parent, false);
            return new ViewHolder(view);
        }



        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    Log.e("这里是点击每一行item的响应事件", "" + position + item);
                }
            });

        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private ImageView img;

            public ViewHolder(View itemView) {
                super(itemView);
                img = itemView.findViewById(R.id.img);

            }
        }
    }
}
