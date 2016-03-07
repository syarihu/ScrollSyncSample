package net.syarihu.android.scrollsyncsample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RecylerAdapter extends RecyclerView.Adapter<RecylerAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private ArrayList<String> mData;

    public RecylerAdapter(Context context, ArrayList<String> data) {
        mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(android.R.layout.simple_list_item_1, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // データ表示
        if (mData != null && mData.size() > position && mData.get(position) != null) {
            holder.textView.setText(mData.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(android.R.id.text1);
        }
    }
}
