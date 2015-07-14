package com.beyond.volleyutils;

import com.android.volley.VolleyError;

/**
 * Author: Huang.Yan
 * Time:   2015-07-13 14:57
 */
public interface IResponseListener<T> {

    /**
     * response when request success.
     *
     * @param response response value
     */
    void onSuccess(T response);

    /**
     * response when request failed.
     *
     * @param error error info
     */
    void onError(VolleyError error);

}
