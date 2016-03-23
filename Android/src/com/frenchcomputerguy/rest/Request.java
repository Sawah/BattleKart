package com.frenchcomputerguy.rest;

import android.os.AsyncTask;
import com.frenchcomputerguy.utils.JSONElement;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * This class represents an HTTP request.
 *
 * @author Quentin Brault
 * @since 2016/03/16
 */
public abstract class Request {

    protected static final int GET = 0;

    protected static final int POST = 1;

    protected static final int PUT = 2;

    protected static final int DELETE = 3;

    private HttpClient httpclient = new DefaultHttpClient();

    private HttpUriRequest request;

    private String url;

    private Map<String, String> parameters;

    public Request(String url) {
     this(url, new HashMap<>());
         }

    public Request(String url, Map<String, String> parameters) {
        this.url = url;
        this.parameters = parameters;
    }

    /**
     * Sends an HTTP request and returns the response parsed in JSON, or null if there was a problem.
     * @param method Request method to send.
     * @return Response body parsed to json, or null if there was a problem.
     */
    protected JSONElement fetch(int method) {
        try {
            String response = new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String[] params) {
                    switch (method) {
                        case GET:
                            request = new HttpGet(params[0]);
                            break;
                        case POST:
                            request = new HttpPost(params[0]);
                            break;
                        case PUT:
                            request = new HttpPut(params[0]);
                            break;
                        case DELETE:
                            request = new HttpDelete(params[0]);
                            break;
                        default:
                            request = new HttpGet(params[0]);
                    }
                    for (String parameter : parameters.keySet()) {
                        request.addHeader(parameter, parameters.get(parameter));
                    }
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String result = null;
                    try {
                        result = httpclient.execute(request, handler);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    httpclient.getConnectionManager().shutdown();
                    return result;
                }
            }.execute(url).get();

            if (response == null)
                return null;
            try {
                return new JSONElement(response);
            } catch (JSONException e) {
                return null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public abstract JSONElement getResponse();

    public JSONElement GET(String url, Map<String, String> parameters) {
        try {

            String response = new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String[] params) {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpGet request = new HttpGet(params[0]);
                    for (String parameter : parameters.keySet()) {
                        request.addHeader(parameter, parameters.get(parameter));
                    }
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String result = null;
                    try {
                        result = httpclient.execute(request, handler);
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    httpclient.getConnectionManager().shutdown();
                    return result;
                }
            }.execute(url).get();

            try {
                return new JSONElement(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONElement POST(String url, Map<String, String> parameters) {
        try {

            String response = new AsyncTask<String, Void, String>() {
                @Override
                protected String doInBackground(String[] params) {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost request = new HttpPost(params[0]);
                    for (String parameter : parameters.keySet()) {
                        request.addHeader(parameter, parameters.get(parameter));
                    }
                    ResponseHandler<String> handler = new BasicResponseHandler();
                    String result = null;
                    try {
                        result = httpclient.execute(request, handler);
                    } catch (ClientProtocolException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    httpclient.getConnectionManager().shutdown();
                    return result;
                }
            }.execute(url).get();

            try {
                return new JSONElement(response);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

}
