package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class bembi extends Tumbuhan{
    public bembi() {
        super(new Texture(Gdx.files.internal("GameAsset/Bembi1.png")),100,15,0);
    }

    @Override
    public void nembak(ArrayList<proyektil> aktifProyektil,ArrayList<Ikan> activeFish,ArrayList<Orb> activeOrb) {
        float orbX = this.getX() + this.getWidth() / 2;
        float orbY = this.getY();

        Orb o = new Orb(orbX, orbY + this.getHeight()/2, 5, orbY,25);
        activeOrb.add(o);
    }
}
