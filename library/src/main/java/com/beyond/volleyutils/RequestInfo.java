package com.beyond.volleyutils;

import java.util.Map;

/**
 * Request information class
 *
 * Author: Huang.Yan
 * Time:   2015-07-13 15:16
 */
public class RequestInfo {

    private String requestUrl;
    private Map<String, String> requestParams;

    private RequestInfo(Builder builder) {
        requestUrl = builder.requestUrl;
        requestParams = builder.requestParams;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public Map<String, String> getRequestParams() {
        return requestParams;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public void setRequestParams(Map<String, String> requestParams) {
        this.requestParams = requestParams;
    }

    public static final class Builder {
        private String requestUrl;
        private Map<String, String> requestParams;

        public Builder() {
        }

        public Builder requestUrl(String requestUrl) {
            this.requestUrl = requestUrl;
            return this;
        }

        public Builder requestParams(Map<String, String> requestParams) {
            this.requestParams = requestParams;
            return this;
        }

        public RequestInfo build() {
            return new RequestInfo(this);
        }
    }
}
