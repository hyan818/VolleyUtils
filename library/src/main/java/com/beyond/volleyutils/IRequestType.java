package com.beyond.volleyutils;

/**
 * Author: Huang.Yan
 * Time:   2015-07-13 14:53
 */
public interface IRequestType<T> {

    /**
     * request put something
     *
     * @param tag      request tag
     * @param listener response listener
     */
    void post(Object tag, final IResponseListener<T> listener);

    /**
     * request get something
     *
     * @param tag      request tag
     * @param listener response listener
     */
    void get(Object tag, final IResponseListener<T> listener);
}
