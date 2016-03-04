package com.example.mdw.rxjavademo.navigation_drawer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mdw.rxjavademo.R;

import java.util.List;

/**
 * Created by mdw on 2016/3/4.
 */
public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ViewHolder> {

    private List<NavigationItem> mData;

    private NavigationDrawerCallback mNavigationDrawerCallback;

    private int mSelectedPosition;

    private int mTouchPosition = -1;

    public NavigationDrawerAdapter(List<NavigationItem> data) {
        mData = data;
    }

    public NavigationDrawerCallback getNavigationDrawerCallback() {
        return mNavigationDrawerCallback;
    }

    public void setNavigationDrawerCallback(NavigationDrawerCallback navigationDrawerCallback) {
        this.mNavigationDrawerCallback = navigationDrawerCallback;
    }


    @Override
    public NavigationDrawerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_row, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NavigationDrawerAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.item_name);
        }
    }
}
