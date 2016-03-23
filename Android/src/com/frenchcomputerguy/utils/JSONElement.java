package com.frenchcomputerguy.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * TODO: Description
 *
 * @author Quentin Brault
 * @since 2016/03/16
 */
public class JSONElement {

    private Object element;

    public JSONElement(String json) throws JSONException {
        try {
            this.element = new JSONObject(json);
        } catch (JSONException e) {
            this.element = new JSONArray(json);
        }
    }

    public JSONObject getJSONObject() {
        return (JSONObject) element;
    }

    public JSONArray getJSONArray() {
        return (JSONArray) element;
    }

}
