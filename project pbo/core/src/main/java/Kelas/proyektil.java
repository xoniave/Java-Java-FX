package Kelas;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class proyektil {
    protected float x, y;
    protected float width, height;
    protected float speedX, speedY; // Kecepatan di sumbu X dan Y
    protected int damage;
    protected Texture texture;
    protected boolean active; // Untuk menandakan apakah proyektil masih aktif

    public proyektil(float x, float y, float width, float height, float speedX, float speedY, int damage, Texture texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speedX = speedX;
        this.speedY = speedY;
        this.damage = damage;
        this.texture = texture;
        this.active = true;
    }

    public void update(float delta) {
        if (active) {
            x += speedX * delta;
            y += speedY * delta;
        }
    }

    public void draw(SpriteBatch batch) {
        if (active && texture != null) {
            batch.draw(texture, x, y, width, height);
        }
    }


    public float getX() { return x; }
    public float getY() { return y; }
    public float getWidth() { return width; }
    public float getHeight() { return height; }
    public int getDamage() { return damage; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
