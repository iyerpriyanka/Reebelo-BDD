package com.au.reebelo.ui.automation.urlcalls;


import com.au.reebelo.ui.automation.util.UrlUtil;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class ProductUrl {


    public Response getProductUrl(String url) {
        return RestAssured.get(UrlUtil.cleanUrl(url));

    }

}
