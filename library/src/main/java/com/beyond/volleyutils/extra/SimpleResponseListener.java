package com.beyond.volleyutils.extra;

import android.util.Log;
import com.android.volley.VolleyError;
import com.beyond.volleyutils.IResponseListener;

/**
 * Author: Huang.Yan
 * Time:   2015-08-01 13:31
 */
public abstract class SimpleResponseListener<T> implements IResponseListener<T> {

    private static final String TAG = SimpleResponseListener.class.getSimpleName();

    public abstract void onSuccess(T response);

    @Override
    public void onError(VolleyError error) {
        Log.e(TAG, "Volley Error: ", error);
    }
}
