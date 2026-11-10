package Kelas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class normalFishMutation extends Ikan {
    public normalFishMutation()
    {
        super(0,0,0,0,new Texture(Gdx.files.internal("GameAsset/normalFishMutation1.png")),5,30,2,5,150);
    }

    public normalFishMutation(float x, float y,float width,float height)
    {
        super(x,y,width,height,new Texture(Gdx.files.internal("GameAsset/normalFishMutation1.png")),5,30,2,5,150);
    }
}
