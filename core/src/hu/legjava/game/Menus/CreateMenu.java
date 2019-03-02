package hu.legjava.game.Menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import hu.legjava.game.Main;
import javafx.scene.input.ClipboardContent;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;

public class CreateMenu implements Screen {
    private Main main;
    private TextButton create;
    private TextButton back;
    private TextButton ip;
    private Stage stage;
    private Table table;
    private String user_ip;
    public CreateMenu(Main main)
    {
        this.main = main;
    }
    @Override
    public void show() {
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);

        create = new TextButton("Create",main.getSkin());
        back = new TextButton("Back",main.getSkin());
        ip=new TextButton("Copy IP",main.getSkin());
        try {
            ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            for (NetworkInterface intf : interfaces) {
                ArrayList<InetAddress> addrs = Collections.list(intf.getInetAddresses());
                for (InetAddress addr : addrs) {
                    if (!addr.isLoopbackAddress()) {
                        String sAddr = addr.getHostAddress();
                        boolean isIPv4 = sAddr.indexOf(':') < 0;
                        if (isIPv4) {
                            user_ip =sAddr;
                        }
                    }
                }
            }
        } catch (Exception ex){}


        table.add(ip).size(200,90).spaceBottom(5f).row();
        table.add(create).size(200,90).spaceBottom(5f).row();
        table.add(back).size(200,90).spaceBottom(5f).row();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);

        ip.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                StringSelection selection = new StringSelection(user_ip);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection,selection);
                //dispose();
                //super.clicked(event, x, y);
            }
        });

        create.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                //TODO
            }
        });

        back.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new MultiMenu(main));
                dispose();
                super.clicked(event, x, y);
            }
        });


    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
