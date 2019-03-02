package hu.legjava.game.Net;

public class Events {
    //TODO EVENTS NOT COMPLETE
    public static class Login extends Events {public String name;}
    public static class Loginvalasz extends Events  {public boolean accepted = false;public String hostname;}
    public static class NewEnemy extends Events {public float x,y;public short id; public float hp;public float speed;}
    public static class DeleteBody extends Events {public short id;}
    public static class PlayerMove extends Events {public String name;public float x;}
    public static class NewBullet extends Events {public float x,dmg,speed;}
    public static class NewPlayer extends Events {public String name;public float x;}
    public static class DeletePlayer extends Events {public String name;}
    public static class OBJECTDMG extends Events {public int wallid;public float wallhp;}
    public static class Robbanas extends Events {public short id;}
    public static class Defeat extends Events {public int hit;}
    public static class Datas extends Events {public float x;
        public float y;
        public int id;
        public int spriteid;
        public  float hp;
        public boolean local;}
}
