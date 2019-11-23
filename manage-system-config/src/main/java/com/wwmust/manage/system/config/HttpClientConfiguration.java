/**
 * *****************************************************
 * Copyright (C) 2019 wwmust.com. All Rights Reserved
 * This file is part of wwmust project.
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * ****************************************************
 **/
package com.wwmust.manage.system.config;

import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author wangwei<wwfdqc@126.com>
 * @date 11/23/2019 10:35
 */
@Configuration
public class HttpClientConfiguration {
    private  int socketTimeout =10000;
    private  int connectTimeout =10000;
    private int connectionRequestTimeout =3000;
    private int maxTotal =1000;
    private int defaultMaxPerRoute =(int)(maxTotal * 0.8);

    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.TEXT_PLAIN);
        mediaTypes.add(MediaType.TEXT_HTML);
        if(converter.getSupportedMediaTypes()!=null){
            mediaTypes.addAll(converter.getSupportedMediaTypes());
        }
        converter.setSupportedMediaTypes(mediaTypes);
        return converter;
    }

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory httpRequestFactory){
        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
        restTemplate.getMessageConverters().add(getMappingJackson2HttpMessageConverter());
        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
        Iterator<HttpMessageConverter<?>> iterator = messageConverters.iterator();
        while (iterator.hasNext()){
            HttpMessageConverter<?> converter= iterator.next();
            if(converter instanceof StringHttpMessageConverter){
                ((StringHttpMessageConverter) converter).setDefaultCharset(StandardCharsets.UTF_8);
            }
        }
        return  restTemplate;
    }


    @Bean
    public ClientHttpRequestFactory httpRequestFactory(HttpClient httpClient){
       return new HttpComponentsClientHttpRequestFactory(httpClient);

    }
    @Bean
    public HttpClient httpClient(){
        Registry socketFactoryRegistry = RegistryBuilder.create()
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .register("http",PlainConnectionSocketFactory.getSocketFactory()).build();
        PoolingHttpClientConnectionManager connectionManager =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(socketTimeout)
                .setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .build();
        return HttpClientBuilder.create().setDefaultRequestConfig(requestConfig)
                .setConnectionManager(connectionManager)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(2,true)).build();
    }
}
