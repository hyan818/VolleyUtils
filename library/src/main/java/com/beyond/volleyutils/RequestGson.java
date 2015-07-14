package com.beyond.volleyutils;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.beyond.volleyutils.extra.GsonRequest;

/**
 * Author: Huang.Yan
 * Time:   2015-07-14 11:52
 */
public class RequestGson<T> extends BaseRequest<T> {

    private Class<T> clazz;

    public RequestGson(Context context) {
        super(context);
    }

    public RequestGson(Context context, RequestInfo requestInfo, Class<T> clazz) {
        super(context, requestInfo);
        this.clazz = clazz;
    }

    @Override
    Request createRequest(int method, final IResponseListener<T> listener) {
        GsonRequest<T> gsonRequest = new GsonRequest<T>(method, mRequestInfo.getRequestUrl(), mRequestInfo.getRequestParams(),
                clazz, new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error);
            }
        });
        BaseVolley.getInstance(mContext).addToRequestQueue(gsonRequest);
        return gsonRequest;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }
}
