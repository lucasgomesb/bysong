package bysong.app.service;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import bysong.app.fragments.CallBackInterface;


/**
 * Created by Lucas on 07/09/2016.
 */
public class JSONServiceManager extends AsyncTask<String, Void, String> {


    private CallBackInterface responseCallBack;
    private Type resultType;

    public void setCallBack(CallBackInterface responseCallBack, Type resultType) {

        this.responseCallBack = responseCallBack;
        this.resultType = resultType;
    }


    @Override
    protected String doInBackground(String... serviceURLArray) {

        String result = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;

        try {
            URL serviceURL = new URL(serviceURLArray[0]);

            httpURLConnection = (HttpURLConnection) serviceURL.openConnection();
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            result = stringBuffer.toString();
            bufferedReader.close();

            if (inputStream != null) inputStream.close();

        } catch (Exception ex) {
            //Log.i("Exception", "FALHA:" + ex.toString());
        } finally {
            if (httpURLConnection != null) httpURLConnection.disconnect();
        }

        return result;
    }


    protected void onPostExecute(String result) {
        responseCallBack.executeCallBack(result, resultType);
    }

}
