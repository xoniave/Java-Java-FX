package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class horsi extends Ikan{
    public horsi()
    {
        super(0,0,0,0,new Texture(Gdx.files.internal("GameAsset/Horsi1.png")),5,25,2,5,400);
    }

    public horsi(float x, float y, float width, float height)
    {
        super(x,y,width,height,new Texture(Gdx.files.internal("GameAsset/Horsi1.png")),5,25,2,5,400);
    }
}
