package com.beyond.volleyutils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

/**
 * Author: Huang.Yan
 * Time:   2015-07-14 13:39
 */
public class RequestImage extends BaseRequest<Bitmap> {

    private int maxWidth;
    private int maxHeight;
    private ImageView.ScaleType scaleType;
    private Bitmap.Config decodeConfig;

    public RequestImage(Context context) {
        super(context);
    }

    public RequestImage(Context context, RequestInfo requestInfo) {
        super(context, requestInfo);
    }

    public RequestImage(Context context, RequestInfo requestInfo, int maxWidth, int maxHeight,
                        ImageView.ScaleType scaleType, Bitmap.Config decodeConfig) {
        super(context, requestInfo);
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.scaleType = scaleType;
        this.decodeConfig = decodeConfig;
    }

    @Override
    Request createRequest(int method, final IResponseListener<Bitmap> listener) {
        ImageRequest imageRequest = new ImageRequest(mRequestInfo.getRequestUrl(), new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                listener.onSuccess(response);
            }
        }, maxWidth, maxHeight, scaleType, decodeConfig, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onError(error);
            }
        });
        BaseVolley.getInstance(mContext).addToRequestQueue(imageRequest);
        return imageRequest;
    }

    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public void setDecodeConfig(Bitmap.Config decodeConfig) {
        this.decodeConfig = decodeConfig;
    }
}
