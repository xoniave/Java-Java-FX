package com.first.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class TampilanMenu implements Screen {

    CoralClash game;
    private Texture background,btnPlay,btnAbout,btnAboutHover,btnPlayHover;
    private Vector3 XYMouse;


    public TampilanMenu(CoralClash game) {
        this.game = game;
    }

    @Override
    public void show() {
        //ini melakukan set Bckground dll dengan menggunakan Texture
        background = new Texture(Gdx.files.internal("MainMenu/Background.png"));
        btnPlay = new Texture(Gdx.files.internal("MainMenu/PlayNormal.png"));
        btnPlayHover = new Texture(Gdx.files.internal("MainMenu/PlayHover.png"));
        btnAbout = new Texture(Gdx.files.internal("MainMenu/AboutNormal.png"));
        btnAboutHover = new Texture(Gdx.files.internal("MainMenu/AboutHover.png"));

        //Buat kordinat xy mouse
        XYMouse = new Vector3();

    }

    @Override
    public void render(float v) {
        //Ketika screen tidak ada isinya
        ScreenUtils.clear(Color.BLACK);

        game.viewport.apply(); // kayak buat canvas sblm mulai gambar
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        game.batch.begin(); //mulai gambar
        game.batch.draw(background,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());


        //Template
        XYMouse.set(Gdx.input.getX(), Gdx.input.getY(),0);

        game.viewport.unproject(XYMouse);
        // untuk konversi X Y ASLI ke dunia game ( mouse) Jadi , misal saya ambil kooridnat 100,100
        //Belum tentu di di dunia game juga 100,100 bisa jadi 10,10

        //ini cek ketika di Hover
        if (isMouseOver(113,56,74,30)) {
            game.batch.draw(btnPlayHover,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }
        else {
            game.batch.draw(btnPlay,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }

        if (isMouseOver(110,17,81,31)) {
            game.batch.draw(btnAboutHover,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }
        else {
            game.batch.draw(btnAbout,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }

        //ini cek ketika di kilik , jadi Gdx.input punya fungsi bawaan isTouched() yaitu ketika click
        if(Gdx.input.isTouched())// hanya dapat info dia click
        {
            if (isMouseOver(113,56,74,30)) { //PLAY
                game.setScreen(new StageMenu(game));
                dispose();
            }

            if (isMouseOver(110,17,81,31)) {

            }

        }

        game.batch.end();


    }

    public boolean isMouseOver(int x,int y,int width,int height)
    {
        return XYMouse.x >= x && XYMouse.x <= x + width && XYMouse.y >= y && XYMouse.y <= y + height;
    }

    @Override
    public void resize(int width, int height) {
        game.viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        background.dispose();
        btnAbout.dispose();
        btnAboutHover.dispose();
        btnPlay.dispose();
        btnPlayHover.dispose();
    }
}
