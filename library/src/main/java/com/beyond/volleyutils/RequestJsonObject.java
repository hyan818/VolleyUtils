package com.beyond.volleyutils;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.beyond.volleyutils.extra.CustomJsonObjectRequest;
import org.json.JSONObject;

/**
 * Author: Huang.Yan
 * Time:   2015-07-14 08:47
 */
public class RequestJsonObject extends BaseRequest<JSONObject> {

    public RequestJsonObject(Context context) {
        super(context);
    }

    public RequestJsonObject(Context context, RequestInfo requestInfo) {
        super(context, requestInfo);
    }

    @Override
    Request createRequest(int method, final IResponseListener<JSONObject> listener) {
        CustomJsonObjectRequest jsonObjectRequest;
        jsonObjectRequest = new CustomJsonObjectRequest(method, mRequestInfo.getRequestUrl(), mRequestInfo.getRequestParams(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                listener.onSuccess(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error);
            }
        });
        BaseVolley.getInstance(mContext).addToRequestQueue(jsonObjectRequest);
        return jsonObjectRequest;
    }
}
