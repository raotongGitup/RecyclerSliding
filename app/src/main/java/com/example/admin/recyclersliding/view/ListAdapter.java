package com.example.admin.recyclersliding.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.recyclersliding.R;
import com.example.admin.recyclersliding.adapter.Adapter;


/**
 *
 *
 * @author @author raotong (582057218@qq.com)
 * @version RecyclerCoverFlow
 * @Datetime 2017-08-05 10:57
 * @since RecyclerCoverFlow
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private final int TYPE_COVER_FLOW = 1;
    private final int TYPE_TEXT = 2;

    private int mCoverFlowPosition = 0;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if (viewType == TYPE_COVER_FLOW) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coverflow, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_text, parent, false);
        }
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case TYPE_COVER_FLOW:
                intiCoverFlow(holder);
                break;
            case TYPE_TEXT:
                holder.text.setText(position+"");
                break;
        }
    }

    private void intiCoverFlow(final ViewHolder holder) {
        holder.coverFlow.setAdapter(new Adapter(holder.itemView.getContext()));
        holder.coverFlow.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                mCoverFlowPosition = position;
                holder.text.setText((position+1)+"/"+holder.coverFlow.getLayoutManager().getItemCount());
            }
        });
        holder.coverFlow.scrollToPosition(mCoverFlowPosition);
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_COVER_FLOW;
        } else {
            return TYPE_TEXT;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        RecyclerCoverFlow coverFlow;

        public ViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.text);
            coverFlow = (RecyclerCoverFlow) itemView.findViewById(R.id.cover_flow);
        }
    }
}
