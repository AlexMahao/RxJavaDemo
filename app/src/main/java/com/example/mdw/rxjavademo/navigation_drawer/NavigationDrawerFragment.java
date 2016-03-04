package com.example.mdw.rxjavademo.navigation_drawer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mdw.rxjavademo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mdw on 2016/3/4.
 */
public class NavigationDrawerFragment extends Fragment {

    private static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    private static final String STATE_SELECTED_POSITION = "selected_navigation_drawer_position";

    private static final String PREFERENCES_FILE = "my_app_settings";

    private RecyclerView mDrawerList;

    private View mFragmentContainerView;

    private DrawerLayout mDrawerLayout;

    private ActionBarDrawerToggle mActionBarDrawerToggle;

    private boolean mUserLearnedDrawer;

    private boolean mFromSavedInstanceState;

    private int mCurrentSelectedPosition;
    private List<NavigationItem> menu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);
        mDrawerList = (RecyclerView) view.findViewById(R.id.drawerList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mDrawerList.setLayoutManager(layoutManager);
        mDrawerList.setHasFixedSize(true);

        final List<NavigationItem> navigationItems = getMenu();


        return super.onCreateView(inflater, container, savedInstanceState);


    }

    public List<NavigationItem> getMenu() {
        List<NavigationItem> items = new ArrayList<>();

        items.add(new NavigationItem("Example 1", getResources().getDrawable(R.mipmap.ic_action_android)));
        items.add(new NavigationItem("Example 2", getResources().getDrawable(R.mipmap.ic_action_android)));
        items.add(new NavigationItem("Example 3", getResources().getDrawable(R.mipmap.ic_action_android)));


        items.add(
                new NavigationItem("Filter", getResources().getDrawable(R.mipmap.ic_action_filter)));
        items.add(new NavigationItem("Take and TakeLast",
                getResources().getDrawable(R.mipmap.ic_action_filter)));
        items.add(new NavigationItem("Distinct abd DistinctUntilChanged",
                getResources().getDrawable(R.mipmap.ic_action_filter)));

        items.add(new NavigationItem("Map", getResources().getDrawable(R.mipmap.ic_action_wizard)));
        items.add(new NavigationItem("Scan", getResources().getDrawable(R.mipmap.ic_action_wizard)));
        items.add(
                new NavigationItem("GroupBy", getResources().getDrawable(R.mipmap.ic_action_wizard)));

        items.add(
                new NavigationItem("Merge", getResources().getDrawable(R.mipmap.ic_action_process_save)));
        items.add(
                new NavigationItem("Zip", getResources().getDrawable(R.mipmap.ic_action_process_save)));
        items.add(
                new NavigationItem("Join", getResources().getDrawable(R.mipmap.ic_action_process_save)));
        items.add(new NavigationItem("CombineLatest",
                getResources().getDrawable(R.mipmap.ic_action_process_save)));
        items.add(new NavigationItem("And Then When",
                getResources().getDrawable(R.mipmap.ic_action_process_save)));

        items.add(new NavigationItem("SharedPreferences",
                getResources().getDrawable(R.mipmap.ic_action_playback_schuffle)));
        items.add(new NavigationItem("Long task",
                getResources().getDrawable(R.mipmap.ic_action_playback_schuffle)));
        items.add(new NavigationItem("Network task",
                getResources().getDrawable(R.mipmap.ic_action_playback_schuffle)));

        items.add(new NavigationItem("Stack Overflow",
                getResources().getDrawable(R.mipmap.ic_action_android)));

        return menu;
    }
}
