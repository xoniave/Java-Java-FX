package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

public class Orb {
    protected float x, y;
    protected float width, height;
    protected float speedY; // Kecepatan jatuh vertikal (ke bawah)
    protected Texture texture;
    protected boolean active; // Status aktif (untuk di-update/gambar)
    protected boolean stop;
    protected float targetStopY;
    protected int uang;

    public Orb(float x, float y, float speedY,float targetStopY,int uang) {
        Random rand = new Random();

        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.speedY = speedY;
        this.active = true; // Orb aktif saat dibuat
        this.stop = false; // Orb belum berhenti saat dibuat
        this.targetStopY = targetStopY;
        this.uang = uang;
        this.texture = new Texture(Gdx.files.internal("GameAsset/Orbs.png"));
    }

    public void draw(SpriteBatch batch) {
        if (active && texture != null) {
            batch.draw(texture, x, y, width, height);
        }
    }

    public void dispose()
    {
        if(texture != null)
        {
            texture.dispose();
        }
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

    public float getSpeedY() {
        return speedY;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public Texture getTexture() {
        return texture;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public float getTargetStopY() {
        return targetStopY;
    }

    public void setTargetStopY(float targetStopY) {
        this.targetStopY = targetStopY;
    }

    public int getUang() {
        return uang;
    }

    public void setUang(int uang) {
        this.uang = uang;
    }
}
