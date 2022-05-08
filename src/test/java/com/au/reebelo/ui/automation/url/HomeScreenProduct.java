package com.au.reebelo.ui.automation.url;


import com.au.reebelo.ui.automation.urlcalls.ProductUrl;
import com.au.reebelo.ui.automation.base.BaseTest;
import com.au.reebelo.ui.automation.pageObject.HomeScreenPageObject;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;


public class HomeScreenProduct extends BaseTest {

    HomeScreenPageObject homePage = new HomeScreenPageObject();
    List<String> urls = new ArrayList<>();
    ProductUrl get = new ProductUrl();

    public void getProductUrl() {
        urls = homePage.getProductUrls();
    }

    public boolean statusCodeMatcher(int statusCode) {
        for (String url : urls) {
            Response response = get.getProductUrl(url);
            if (response.getStatusCode() != statusCode) {
                System.err.println("Failed url are: " + url);
                return false;
            }
        }
        return true;
    }

}
