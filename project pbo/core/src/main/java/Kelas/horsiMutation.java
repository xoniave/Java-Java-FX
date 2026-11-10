package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class horsiMutation extends Ikan{
    public horsiMutation()
    {
        super(0,0,0,0,new Texture(Gdx.files.internal("GameAsset/KingHosi.png")),3,35,2,3,600);
    }

    public horsiMutation(float x, float y, float width, float height)
    {
        super(x,y,width,height,new Texture(Gdx.files.internal("GameAsset/KingHosi.png")),3,35,2,3,600);
    }
}
