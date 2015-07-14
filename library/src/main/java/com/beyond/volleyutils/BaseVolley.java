package com.beyond.volleyutils;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Volley base class. Use to init request queue
 * <p/>
 * Author: Huang.Yan
 * Time:   2015-07-13 14:25
 */
public class BaseVolley {

    private static BaseVolley mVolleyNetwork;
    private Context mContext;
    private RequestQueue mRequestQueue;

    public static synchronized BaseVolley getInstance(Context context) {
        if (mVolleyNetwork == null) {
            mVolleyNetwork = new BaseVolley(context);
        }
        return mVolleyNetwork;
    }

    public BaseVolley(Context context) {
        mContext = context;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    /**
     * Stop request
     *
     * @param tag request tag
     */
    public void stop(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
