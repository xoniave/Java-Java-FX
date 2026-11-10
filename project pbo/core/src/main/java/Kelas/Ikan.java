package Kelas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Ikan implements Mahkluk{

    protected int Darah,Damage;
    protected float x,y;
    protected float width,height;
    protected Texture texture;
    protected int Speed;
    protected float attackTimer;
    protected float attackCd;
    protected int speedAwal;

    public Ikan(float x,float y,float width,float height,Texture texture,int speed,int Damage,float attackCd, int speedAwal,int Darah)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.Speed = speed;
        this.Damage = Damage;
        this.attackTimer = 0;
        this.attackCd = attackCd;
        this.speedAwal = speedAwal;
        this.Darah = Darah;
    }

    @Override
    public void Animasi() {

    }

    @Override
    public void KenaDamage() {

    }

    @Override
    public void StatusMati() {

    }

    public void draw(SpriteBatch batch) {
        if (texture != null) {
            batch.draw(texture, x, y, width, height);
        }
    }

    public void dispose() {
        if (texture != null) {
            texture.dispose();
        }
    }

    public int getDarah() {
        return Darah;
    }

    public void setDarah(int darah) {
        Darah = darah;
    }

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getAttackTimer() {
        return attackTimer;
    }

    public void setAttackTimer(float attackTimer) {
        this.attackTimer = attackTimer;
    }

    public float getAttackCd() {
        return attackCd;
    }

    public void setAttackCd(float attackCd) {
        this.attackCd = attackCd;
    }

    public int getSpeedAwal() {
        return speedAwal;
    }

    public void setSpeedAwal(int speedAwal) {
        this.speedAwal = speedAwal;
    }

    public void setAttackTimer(int attackTimer) {
        this.attackTimer = attackTimer;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public int getSpeed() {
        return Speed;
    }

    public void setSpeed(int speed) {
        Speed = speed;
    }
}
