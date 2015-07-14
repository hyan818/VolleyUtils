package com.beyond.volleyutils;

import android.content.Context;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Author: Huang.Yan
 * Time:   2015-07-13 14:50
 */
public class RequestString extends BaseRequest<String> {

    public RequestString(Context context) {
        super(context);
    }

    public RequestString(Context context, RequestInfo requestInfo) {
        super(context, requestInfo);
    }

    @Override
    Request createRequest(int method, final IResponseListener<String> listener) {
        StringRequest stringRequest = new StringRequest(method, mRequestInfo.getRequestUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                listener.onSuccess(s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                listener.onError(volleyError);
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return mRequestInfo.getRequestParams();
            }
        };
        BaseVolley.getInstance(mContext).addToRequestQueue(stringRequest);
        return stringRequest;
    }
}
