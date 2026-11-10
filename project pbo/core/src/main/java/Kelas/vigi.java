package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class vigi extends Tumbuhan{
    private Texture textureDarahHalf;

    public vigi()
    {
        super(new Texture(Gdx.files.internal("GameAsset/Vigi1.png")),400,0,0);
        textureDarahHalf = new Texture(Gdx.files.internal("GameAsset/VigiHalf.png"));
    }

    @Override
    public void draw(SpriteBatch batch, float x, float y, float width, float height) {
        if (getDarah() <= 200 && textureDarahHalf != null) {
            batch.draw(textureDarahHalf, x, y, width, height);
        } else {
            super.draw(batch, x, y, width, height); // Panggil metode draw dari parent (Tumbuhan)
        }
    }

    @Override
    public void nembak(ArrayList<proyektil> aktifProyektil, ArrayList<Ikan> activeFish, ArrayList<Orb> activeOrb) {

    }
}
