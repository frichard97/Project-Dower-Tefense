package hu.legjava.game.Net;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import hu.legjava.game.VDat;

import java.io.IOException;

public class Server extends Net implements Runnable{
    com.esotericsoftware.kryonet.Server server;
    public Server()
    {
        server = new com.esotericsoftware.kryonet.Server();
        try {
            server.bind(2000,2500);
        } catch (IOException e) {
            e.printStackTrace();
        }
        server.start();
        server.addListener(new Listener(){

            @Override
            public void connected(Connection connection) {
                //TODO Alap szinkronizáció pl. recconectelésnél
                super.connected(connection);
            }

            @Override
            public void disconnected(Connection connection) {
                //TODO disconnectnél a player törlése a memóriából
                super.disconnected(connection);
            }

            @Override
            public void received(Connection connection, Object object) {
                // TODO VDATA Szinkronizációs algoritmus
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
        server.sendToAllUDP(event);
    }
}
