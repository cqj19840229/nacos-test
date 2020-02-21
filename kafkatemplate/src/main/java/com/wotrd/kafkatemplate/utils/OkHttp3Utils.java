package com.wotrd.kafkatemplate.utils;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Map;

/**
 * Okhttp3网络连接工具类
 */
@Slf4j
public class OkHttp3Utils {

    //不允许创建对象
    private OkHttp3Utils() {
    }

    private static OkHttpClient client;

    static {
        client = new OkHttpClient.Builder().build();
    }

    /**
     * 使用get方式请求
     *
     * @param url
     */
    public static String getBase64ImgWithOkHttp3(String url) {
        //调用ok的get请求
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        return dealResponseToBase64(request);
    }


    /**
     * 使用get方式请求
     *
     * @param url
     */
    public static String getWithOkHttp3(String url) {
        //调用ok的get请求
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        return dealResponse(request);
    }

    /**
     * 使用post方式请求
     *
     * @param url
     * @param params 请求参数
     */
    public static String postWithOkHttp3(String url, Map<String, String> params) {
        //调用ok的post请求
        FormBody.Builder formbody = new FormBody.Builder();
        if (params != null && !params.isEmpty()) {
            //上传参数
            for (String key : params.keySet()) {
                formbody.add(key, params.get(key));
            }
        }
        //创建请求体
        FormBody body = formbody.build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)//请求体
                .build();
        return dealResponse(request);
    }

    /**
     * 使用json格式请求http
     *
     * @param url
     * @param jsonParam
     * @return
     */
    public static String postWithJsonParamasByOkHttp3(String url, String jsonParam) {
        //创建请求体
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , jsonParam);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)//请求体
                .build();
        return dealResponse(request);
    }

    /**
     * 处理请求返回值
     *
     * @param request
     */
    private static String dealResponse(Request request) {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (IOException e) {
            log.error("异常", e);
        } finally {
            if (null != response)
                response.close();
        }
        return null;
    }

    /**
     * 将图片传承base64
     *
     * @param request
     */
    private static String dealResponseToBase64(Request request) {
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                byte[] bytes = response.body().bytes();
                BASE64Encoder encoder = new BASE64Encoder();
                return encoder.encode(bytes);
            }
        } catch (IOException e) {
            log.error("异常", e);
        } finally {
            if (null != response)
                response.close();
        }
        return null;
    }
}
