package com.awesomekris.android.newsbox;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.content.LocalBroadcastManager;

import com.awesomekris.android.newsbox.data.NewsContract;

/**
 * Created by kris on 16/10/4.
 */
public class UpdaterService extends IntentService {

    private static final String LOG_TAG = UpdaterService.class.getSimpleName();

    public static final String BROADCAST_ACTION_STATE_CHANGE
            = "com.awesomekris.android.newsbox.STATE_CHANGE";
    public static final String EXTRA_REFRESHING
            = "com.awesomekris.android.newsbox.REFRESHING";

    public UpdaterService() {
        super(LOG_TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
//        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        NetworkInfo ni = cm.getActiveNetworkInfo();
        String mPage = intent.getStringExtra("POSITION");
        String tabTitle = null;
//        String selection = NewsContract.SectionEntry._ID + " = ?";
//        String[] selectionArgs = new String[]{mPage};
        Cursor sectionCursor = getContentResolver().query(NewsContract.SectionEntry.CONTENT_URI,null,null,null,null);
        sectionCursor.moveToPosition(Integer.valueOf(mPage));
        if(sectionCursor.getCount()!=0) {
            tabTitle = sectionCursor.getString(sectionCursor.getColumnIndex(NewsContract.SectionEntry.COLUMN_SECTION_ID));
        }
        sectionCursor.close();
        Intent localIntent = new Intent();
        localIntent.putExtra("TABTITLE", tabTitle);
        LocalBroadcastManager.getInstance(this).sendBroadcast(localIntent);

//        sendStickyBroadcast(
//                new Intent(BROADCAST_ACTION_STATE_CHANGE).putExtra(EXTRA_REFRESHING, true));


    }


}
