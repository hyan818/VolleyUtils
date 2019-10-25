# VolleyUtils

Make volley easy to use. Support JsonObjectRequest, GsonObjectRequest, ImageObjectRequest StringObjectRequest.

# How to use

## 1. Import aar package

Download [Volleyutils-library.aar](https://github.com/hyan818/VolleyUtils/blob/master/download/volleyutils-library.aar?raw=true) and import into your project.

## 2. Add this to gradle

```gradle
repositories {
  maven {
    url "https://jitpack.io"
  }
}
	
dependencies {
  compile 'com.github.hyan818:VolleyUtils:v1.0.0'
  compile 'com.mcxiaoke.volley:library:1.0.17'
  compile 'com.google.code.gson:gson:2.3'
}
```

## Code

```java
// Create request parameters map.
Map<String, String> params = new HashMap<>();
params.put("key","value");

//Create url
String url = ...;

//Create request information
RequestInfo requestInfo = new RequestInfo.Builder().requestUrl(url).requestParams(params).build();
```

```java
//Create a requset with response string
RequestString requestString = new RequestString(this, requestInfo);
//Post or Get
requestString.post(TAG, new IResponseListener<String>() {
    @Override
    public void onSuccess(String s) {
        Log.d(TAG, "response = " + s);
    }

    @Override
    public void onError(VolleyError volleyError) {
        Log.e(TAG, "error", volleyError);
    }
});
```

## Other request

```java
RequestJsonObject
RequestGson
RequestImage
```

## Stop request

```java
BaseVolley.getInstance(this).stop(TAG);
```


