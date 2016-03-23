package com.frenchcomputerguy.rest;

import com.frenchcomputerguy.utils.JSONElement;

import java.util.Map;

/**
 * This class represents an HTTP POST request.
 *
 * @author Quentin Brault
 * @since 2016/03/16
 */
public class PostRequest extends Request {

    public PostRequest(String url) {
        super(url);
    }

    public PostRequest(String url, Map<String, String> parameters) {
        super(url, parameters);
    }

    @Override
    public JSONElement getResponse() {
        return fetch(POST);
    }

}
