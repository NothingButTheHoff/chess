package com.pefi.chess;

import java.net.URI;

import android.util.Log;
import android.widget.TextView;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.handshake.ServerHandshake;

/**
 * Created by pererikfinstad on 05/07/15.
 */
public class WebsocketConnector {

    URI uri;
    public WebSocketClient client;


    public WebsocketConnector() {
        try {
            uri = new URI("ws://10.0.2.2:8080/ChessWebsocket/moves");
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        client = new WebSocketClient(uri, new Draft_17()) {


            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                Log.i("Websocket", serverHandshake.getHttpStatusMessage());
                try{
                    client.send("Hello");
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onMessage(String s) {
                Log.i("Message", s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                Log.i("Closed:", s);
            }

            @Override
            public void onError(Exception e) {
                Log.e("Error", e.toString());
            }
        };


        client.connect();
    }
}
