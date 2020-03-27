//Name: Katie King
//Matriculation No.: S1827986
//getting the google maps through a Http get request
//made 26/03/2020

package org.me.gcu.trafficfinder.apis.tasks;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.textfield.TextInputEditText;

import org.me.gcu.trafficfinder.apis.pullparsers.PullParser;
import org.me.gcu.trafficfinder.models.apimodels.APIModel;
import org.me.gcu.trafficfinder.models.apimodels.Channel;
import org.me.gcu.trafficfinder.models.interfaces.AsyncResponse;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class HttpGetRequest extends AsyncTask<APIModel, Void, APIModel> {

    public AsyncResponse delegate = null;

    ProgressDialog progressDialog;
    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 15000;
    public static final int CONNECTION_TIMEOUT = 15000;
    private XmlPullParserFactory xmlFactoryObject;
    private Channel channel = new Channel();
    private TextInputEditText dateInput;
    private EditText editTxt;
    private Button btn;
    private ListView list;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> arrayList;


    @Override
    protected APIModel doInBackground(APIModel... params) {
        String urlString = params[0].getInput().getUrl().toString();
        String result;
        String inputLine;

        try {

            URL url = new URL(urlString.trim());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setDoInput(true);
            connection.connect();
            InputStream stream = connection.getInputStream();


            PullParser pullParser = new PullParser();
            pullParser.setStream(stream);
            channel = pullParser.execute();

            stream.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        APIModel model = new APIModel(
                channel,
                params[0].getInput()
        );

        return model;
    }

    @Override
    protected void onPostExecute(APIModel result) {
        delegate.processFinish(result);
    }
}
