package Kelas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public abstract class Tumbuhan implements Mahkluk{

    protected Texture texture;
    protected int Darah;
    protected float attackTimer;
    protected float attackCd;
    protected float x,y;
    protected float width, height;
    protected int Damage;

    public Tumbuhan(Texture texture,int Darah,float attackCd,int Damage)
    {
        this.texture = texture;
        this.Darah = Darah;
        this.attackTimer = 0;
        this.attackCd = attackCd;
        this.Damage = Damage;
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public abstract void nembak(ArrayList<proyektil> aktifProyektil, ArrayList<Ikan> activeFish, ArrayList<Orb> activeOrb);

    @Override
    public void Animasi() {

    }

    @Override
    public void KenaDamage() {

    }

    @Override
    public void StatusMati() {

    }

    public void draw(SpriteBatch batch, float x, float y, float width, float height) {
        if (texture != null) { // Pastikan tekstur sudah dimuat
            batch.draw(texture, x, y, width, height); // Gambar tekstur di posisi dan ukuran yang diberikan
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

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setPosition(float x, float y) {
        this.x = x;
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

    public int getDamage() {
        return Damage;
    }

    public void setDamage(int damage) {
        Damage = damage;
    }
}
