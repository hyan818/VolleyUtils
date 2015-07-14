package com.beyond.volleyutils;

import android.content.Context;
import com.android.volley.Request;

import java.util.Map;

/**
 * Author: Huang.Yan
 * Time:   2015-07-14 11:10
 */
public abstract class BaseRequest<T> implements IRequestType<T> {

    protected Context mContext;
    protected RequestInfo mRequestInfo;

    public BaseRequest(Context context) {
        this.mContext = context;
    }

    public BaseRequest(Context context, RequestInfo requestInfo) {
        this.mContext = context;
        this.mRequestInfo = requestInfo;
    }

    abstract Request createRequest(int method, final IResponseListener<T> listener);

    @Override
    public void post(Object tag, IResponseListener<T> listener) {
        createRequest(Request.Method.POST, listener).setTag(tag);
    }

    @Override
    public void get(Object tag, IResponseListener<T> listener) {
        Map<String, String> paramMap = mRequestInfo.getRequestParams();
        if (paramMap != null && !paramMap.isEmpty()) {
            StringBuilder builder = new StringBuilder(mRequestInfo.getRequestUrl());
            builder.append("?");
            for (String key : paramMap.keySet()) {
                builder.append(key).append("=").append(paramMap.get(key));
            }
            mRequestInfo.setRequestUrl(builder.toString());
        }
        createRequest(Request.Method.GET, listener).setTag(tag);
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public void setRequestInfo(RequestInfo requestInfo) {
        this.mRequestInfo = requestInfo;
    }
}
