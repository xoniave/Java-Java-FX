package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import java.util.ArrayList;
import java.util.Iterator;

public class skipi extends Tumbuhan {
    private boolean hasExploded = false;
    private Texture explosionTexture; // Untuk tekstur ledakan
    private float explosionTimer = 0f; // Timer untuk durasi ledakan
    private final float EXPLOSION_DURATION = 0.3f;

    public skipi()
    {
        super(new Texture(Gdx.files.internal("GameAsset/Skipi1.png")),100,0,1000);
        explosionTexture = new Texture(Gdx.files.internal("GameAsset/meledak.png"));
    }

    public void update(float delta) {
        if (hasExploded) {
            explosionTimer += delta;
            if (explosionTimer >= EXPLOSION_DURATION) {
                this.setDarah(0); // supaya kehapus soal e di gamescreen kalau dara < 0 di dispose / null
            }
        }
    }

    public void draw(SpriteBatch batch, float x, float y, float width, float height) {
        if (hasExploded && explosionTimer < EXPLOSION_DURATION && explosionTexture != null) {
            // jadi dapetin dulu titik tengah normal gambar x nya, lalu di kurangi sama panjang kali 3/ 2
            //nanti ketemu titik paling ujung kiri nya setelah with kali 3
            float explosionDrawX = x + width / 2 - (this.width * 3) / 2;
            float explosionDrawY = y + height / 2 - (this.height * 3) / 2;

            // Draw the explosion texture using the calculated scaled width and height
            batch.draw(explosionTexture, explosionDrawX, explosionDrawY, this.width * 3, this.height * 3);
        } else if (!hasExploded && texture != null) {
            batch.draw(texture, x, y, width, height);
        }
    }


    @Override
    public void nembak(ArrayList<proyektil> aktifProyektil, ArrayList<Ikan> activeFish, ArrayList<Orb> activeOrb) {
        if (!hasExploded) { // Ensure explosion only happens once
            Gdx.app.log("Skipi", "Skipi is exploding at X: " + x + ", Y: " + y);

            float explosionWidth = width * 3;
            float explosionHeight = height * 3;
            //kurangi x dan y agar ke kiri bawah paling jauh dengan cara x dikurangi ledakan / 2 soal e ledakan sudah di kasli 2
            Rectangle explosionHitbox = new Rectangle(x - explosionWidth / 2 + width / 2, y - explosionHeight / 2 + height / 2, explosionWidth, explosionHeight);

            Iterator<Ikan> cekIkanKenaLedak = activeFish.iterator();
            while (cekIkanKenaLedak.hasNext()) {
                Ikan fish = cekIkanKenaLedak.next();
                Rectangle fishHitBox = new Rectangle(fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());

                if (explosionHitbox.overlaps(fishHitBox)) {
                    Gdx.app.log("Skipi", "Kena");
                    fish.setDarah(0); // Instantly kill the fish
                    fish.dispose();
                    texture = null;
                    cekIkanKenaLedak.remove();
                }
            }
            this.setDarah(0); // Skipi destroys itself after exploding
            hasExploded = true; // Mark as exploded
        }
    }

    public void dispose() {
        super.dispose();
        if (explosionTexture != null) {
            explosionTexture.dispose();
            explosionTexture = null;
        }
    }

}
