package com.pefi.chess;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    WebsocketConnector connection;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        connection = new WebsocketConnector();
    }
}
