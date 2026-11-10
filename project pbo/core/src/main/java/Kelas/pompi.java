package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;

public class pompi extends Tumbuhan{
    public pompi()
    {
        super(new Texture(Gdx.files.internal("GameAsset/Pompi1.png")),100,4,20);
    }

    @Override
    public void nembak(ArrayList<proyektil> aktifProyektil,ArrayList<Ikan> activeFish,ArrayList<Orb> activeOrb) {

        boolean ikanAda = false;

        for(int A = 0; A < activeFish.size(); A++)
        {
            float ikanY = activeFish.get(A).getY() + activeFish.get(A).getHeight()/2;

            if (ikanY >= this.getY() && ikanY < this.getY() + this.getHeight()) {
                ikanAda = true;
                break; // Ditemukan ikan di baris ini, tidak perlu cek lebih lanjut
            }
        }


        if (ikanAda) {
            float proyektilX = this.getX() + this.getWidth() / 2; // Geser sedikit ke tengah
            float proyektilY = this.getY() + this.getHeight() / 3; // Di tengah tumbuhan

            float proyektilWidth = 10; // Ukuran peluru
            float proyektilHeight = 10;
            float proyektilSpeedY = 0; // Kecepatan peluru vertikal (ke atas)
            float proyektilSpeedX = 50;

            proyektil itemTembak = new proyektil(proyektilX, proyektilY, proyektilWidth, proyektilHeight, proyektilSpeedX, proyektilSpeedY, 25, new Texture(Gdx.files.internal("GameAsset/PompiAmo.png")));
            aktifProyektil.add(itemTembak);

        }
    }
}
