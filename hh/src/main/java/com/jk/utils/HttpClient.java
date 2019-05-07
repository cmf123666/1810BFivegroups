/** 
 * <pre>项目名称:b_commen 
 * 文件名称:HttpClient.java 
 * 包名:b_commen 
 * 创建日期:2018年12月9日下午5:43:51 
 * Copyright (c) 2018, wzstart@126.com All Rights Reserved.</pre> 
 */
package com.jk.utils;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**   
 * 业精于勤荒于嬉,行成于思毁于随   
 * 创建人：wzstart    
 * 创建时间：2018年12月9日 下午5:43:51  
 */
public class HttpClient {
	// 默认字符集
    private static final String ENCODING = "UTF-8";

    /** 
    * @Title: sendPost 
    * @Description: TODO(发送post请求) 
    * @param url 请求地址
    * @param headers 请求头
    * @param data 请求实体
    * @param encoding 字符集
    */
    public static String sendPost(String url,Map<String, String> headers, JSONObject data, String encoding) {
        System.out.print("进入post请求方法...");
        System.out.print("请求入参：URL= " + url);
        System.out.print("请求入参：headers=" + JSON.toJSONString(headers));
        System.out.print("请求入参：data=" + JSON.toJSONString(data));
        // 请求返回结果
        String resultJson = null;
        // 创建Client
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建HttpPost对象
        HttpPost httpPost = new HttpPost();

        try {
            // 设置请求地址
            httpPost.setURI(new URI(url));
            // 设置请求头
            if (headers != null) {
                Header[] allHeader = new BasicHeader[headers.size()];
                int i = 0;
                for (Map.Entry<String, String> entry: headers.entrySet()){
                    allHeader[i] = new BasicHeader(entry.getKey(), entry.getValue());
                    i++;
                }
                httpPost.setHeaders(allHeader);
            }
            // 设置实体
            httpPost.setEntity(new StringEntity(JSON.toJSONString(data)));
            // 发送请求,返回响应对象
            CloseableHttpResponse response = client.execute(httpPost);
            // 获取响应状态
            int status = response.getStatusLine().getStatusCode();
            if (status == HttpStatus.SC_OK) {
                // 获取响应结果
                resultJson = EntityUtils.toString(response.getEntity(), encoding);
            } else {
                System.out.print("响应失败，状态码：" + status);
            }

        } catch (Exception e) {
            System.out.print("发送post请求失败");
        } finally {
            httpPost.releaseConnection();
        }
        return resultJson;
    }

    /** 
    * @Title: sendPost 
    * @Description: TODO(发送post请求，请求数据默认使用json格式，默认使用UTF-8编码) 
    * @param url 请求地址
    * @param data 请求实体
    */
    public static String sendPost(String url, JSONObject data) {
        // 设置默认请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");

        return sendPost(url, headers, data, ENCODING);
    }

    /** 
    * @Title: sendPost 
    * @Description: TODO(发送post请求，请求数据默认使用json格式，默认使用UTF-8编码) 
    * @param url 请求地址
    * @param params 请求实体
    */
    public static String sendPost(String url,Map<String,Object> params){
        // 设置默认请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        // 将map转成json
        JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
        return sendPost(url,headers,data,ENCODING);
    }

    /** 
    * @Title: sendPost 
    * @Description: TODO(发送post请求，请求数据默认使用UTF-8编码) 
    * @param url 请求地址
    * @param headers 请求头
    * @param data 请求实体
    */
    public static String sendPost(String url, Map<String, String> headers, JSONObject data) {
        return sendPost(url, headers, data, ENCODING);
    }

    /** 
    * @Title: sendPost 
    * @Description:(发送post请求，请求数据默认使用UTF-8编码) 
    * @param url 请求地址
    * @param headers 请求头
    * @param params 请求实体
    */
    public static String sendPost(String url,Map<String,String> headers,Map<String,String> params){
        // 将map转成json
        JSONObject data = JSONObject.parseObject(JSON.toJSONString(params));
        return sendPost(url,headers,data,ENCODING);
    }

    /** 
    * @Title: sendGet 
    * @Description: TODO(发送get请求) 
    * @param url 请求地址
    * @param params 请求参数
    * @param encoding 编码
    */
    public static String sendGet(String url,Map<String,Object> params,String encoding){
        System.out.print("进入get请求方法...");
        System.out.print("请求入参：URL= " + url);
        System.out.print("请求入参：params=" + JSON.toJSONString(params));
        // 请求结果
        String resultJson = null;
        // 创建client
        CloseableHttpClient client = HttpClients.createDefault();
        // 创建HttpGet
        HttpGet httpGet = new HttpGet();
        try {
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            // 封装参数
            if(params != null){
                for (String key : params.keySet()) {
                    builder.addParameter(key, params.get(key).toString());
                }
            }
            URI uri = builder.build();
            System.out.print("请求地址："+ uri);
            // 设置请求地址
            httpGet.setURI(uri);
            // 发送请求，返回响应对象
            CloseableHttpResponse response = client.execute(httpGet);
            // 获取响应状态
            int status = response.getStatusLine().getStatusCode();
            if(status == HttpStatus.SC_OK){
                // 获取响应数据
                resultJson = EntityUtils.toString(response.getEntity(), encoding);
            }else{
                System.out.print("响应失败，状态码：" + status);
            }
        } catch (Exception e) {
            System.out.print("发送get请求失败");
        } finally {
            httpGet.releaseConnection();
        }
        return resultJson;
    }
    /** 
    * @Title: sendGet 
    * @Description: TODO(发送get请求) 
    * @param url 请求地址
    * @param params 请求参数
    */
    public static String sendGet(String url,Map<String,Object> params){
        return sendGet(url,params,ENCODING);
    }
    /** 
    * @Title: sendGet 
    * @Description: TODO(发送get请求) 
    * @param url 请求地址
    */
    public static String sendGet(String url){
        return sendGet(url,null,ENCODING);
    }

}
