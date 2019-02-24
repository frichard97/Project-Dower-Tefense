package hu.legjava.game.Net;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import hu.legjava.game.VDat;

import java.util.ArrayList;
import java.util.List;

public class Client extends Net implements Runnable
{
    private com.esotericsoftware.kryonet.Client client;
    List<VDat> dat;
    public Client()
    {
        client = new com.esotericsoftware.kryonet.Client();
        client.addListener(new Listener(){

            @Override
            public void connected(Connection connection) {
                super.connected(connection);
            }

            @Override
            public void disconnected(Connection connection) {
                super.disconnected(connection);
            }

            @Override
            public void received(Connection connection, Object object) {
                super.received(connection, object);
            }

            @Override
            public void idle(Connection connection) {
                super.idle(connection);
            }
        });

    }
    @Override
    public void run() {

    }

    @Override
    public void Send(Events event) {
        client.sendUDP(event);
    }
}
