package com.awesomekris.android.newsbox;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.awesomekris.android.newsbox.data.NewsContract;
import com.awesomekris.android.newsbox.library.RecyclerViewCursorAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by kris on 16/10/4.
 */
public class NewsListRecyclerViewAdapter  extends RecyclerViewCursorAdapter<RecyclerView.ViewHolder> {

    private static final String LOG_TAG = NewsListRecyclerViewAdapter.class.getSimpleName();
//    private Cursor mCursor;
    private Context mContext;

    public NewsListRecyclerViewAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
        mContext = context;
        mCursor = c;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, Cursor cursor) {

        ((ViewHolder)holder).titleView.setText(mCursor.getString(NewsContract.ContentEntry.COLUMN_INDEX_HEADLINE));
        ((ViewHolder)holder).dateView.setText(mCursor.getString(NewsContract.ContentEntry.COLUMN_INDEX_WEB_PUBLICATION_DATE));
        ((ViewHolder)holder).trailView.setText(mCursor.getString(NewsContract.ContentEntry.COLUMN_INDEX_TRAIL_TEXT));

        String thumbnailUrl = mCursor.getString(NewsContract.ContentEntry.COLUMN_INDEX_THUMBNAIL);
        Picasso.with(mContext).load(thumbnailUrl).into(((ViewHolder)holder).thumbnailView);


    }

    @Override
    protected void onContentChanged() {

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnailView;
        public TextView titleView;
        public TextView trailView;
        public TextView dateView;

        public ViewHolder(View view) {
            super(view);
            thumbnailView = (ImageView) view.findViewById(R.id.thumbnail);
            titleView = (TextView) view.findViewById(R.id.news_title);
            trailView = (TextView) view.findViewById(R.id.news_trail);
            dateView = (TextView) view.findViewById(R.id.news_date);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        int layoutId = R.layout.list_item_news;
        View view = LayoutInflater.from(parent.getContext()).inflate(layoutId, parent, false);
        final ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: go to detail fragment
//                    view.setTransitionName(getString(R.string.transition_photo));
//                    ActivityOptions options = ActivityOptions
//                            .makeSceneTransitionAnimation(ArticleDetailActivity.class, view, getString(R.string.transition_photo));
//                    startActivity(new Intent(Intent.ACTION_VIEW,
//                            ItemsContract.Items.buildItemUri(getItemId(vh.getAdapterPosition()))));
            }
        });
        return vh;
    }
//
//    @Override
//    public int getItemCount() {
//        return mCursor.getCount();
//    }
//
//    @Override
//    public long getItemId(int position) {
//        mCursor.moveToPosition(position);
//        return mCursor.getInt(NewsContract.ContentEntry.COLUMN_INDEX_ID);
//    }
}
