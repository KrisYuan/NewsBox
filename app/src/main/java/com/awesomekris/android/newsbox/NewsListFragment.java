package com.awesomekris.android.newsbox;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class NewsListFragment extends Fragment {

    public static final String NEWS_LIST_PAGE = "NEWS_LIST_PAGE";
    private int mPage;

    public static NewsListFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(NEWS_LIST_PAGE, page);
        NewsListFragment newsListFragment = new NewsListFragment();
        newsListFragment.setArguments(args);
        return newsListFragment;
    }

    public NewsListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mPage = getArguments().getInt(NEWS_LIST_PAGE);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.news_title);
        textView.setText("Fragment #" + mPage);
        return rootView;
    }
}
