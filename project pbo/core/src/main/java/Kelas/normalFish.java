package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class normalFish extends Ikan{

    public normalFish()
    {
        super(0,0,0,0,new Texture(Gdx.files.internal("GameAsset/normalFish1.png")),5,25,3,5,100);
    }

    public normalFish(float x, float y,float width,float height)
    {
        super(x,y,width,height,new Texture(Gdx.files.internal("GameAsset/normalFish1.png")),5,25,3,5,100);
    }
}

