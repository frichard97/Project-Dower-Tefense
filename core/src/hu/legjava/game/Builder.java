package hu.legjava.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import hu.legjava.game.Objects.AttackTower;
import hu.legjava.game.Objects.Enemy;
import hu.legjava.game.Objects.Player;
import hu.legjava.game.Objects.Tower;
import hu.legjava.game.Resources;
import hu.legjava.game.Types.EnemyType;
import hu.legjava.game.VDat;

import java.util.ArrayList;

public class Builder {
    private ArrayList<VDat> dat;
    private Player player;
    private Resources resources;
    private float x,y;
    private InputProcessor listener;
    private Sprite tower;
    private boolean buildable_place = false;
    private World world;
    Vector3 click = new Vector3(0,0,0);
    public Builder(Player player, Resources resources, ArrayList<VDat> dat, World world)
    {
        this.dat = dat;
        this.world = world;
        this.player = player;
        this.resources = resources;
        listener = new InputProcessor(){

            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                if(button==Input.Buttons.RIGHT)
                {
                    if(buildable_place)
                    {
                        Build();
                    }
                }
                if(button==Input.Buttons.LEFT)
                {
                    //TODO TEST ENEMY ADD
                    addenemy();
                }
                return false;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                return false;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                setTile(screenX,screenY);
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }
        };
    }
    private void setTile(float x,float y)
    {
        click.x = x;
        click.y = y;
        player.getCam().unproject(click);
        click.x = (float)Math.floor(click.x);
        click.y = (float)Math.floor(click.y);
        for(VDat dat: dat)
        {
            if(dat.y == click.y && dat.x == click.x){
                buildable_place = false;
                break;
            }
            else
            {
                buildable_place = true;
            }
        }
    }
    private void Build()
    {
        //TODO NETWORKING
        dat.add(new AttackTower(world,true,click.x,click.y));
        buildable_place = false;
        System.out.println("BUILD");
    }
    public void ImgRenderer(SpriteBatch batch)
    {

    }
    public void initInputListener(InputMultiplexer in)
    {
        in.addProcessor(listener);
    }
    //TODO FOR TEST
    private void addenemy()
    {
        dat.add(new Enemy(1, EnemyType.STANDARD,true,click.x,click.y));
    }
}
