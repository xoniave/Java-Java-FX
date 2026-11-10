package com.first.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class StageMenu implements Screen {

    CoralClash game;
    private Texture btn1, btn2, btn3, btn4, btn5, stagebackground;
    private Texture btn1_hover, btn2_hover, btn3_hover, btn4_hover, btn5_hover;
    private Vector3 XYMouse = new Vector3();

    public StageMenu(CoralClash game)
    {
        this.game = game;
    }


    @Override
    public void show() {
        btn1 = new Texture(Gdx.files.internal("StageMenu/stage1btn.png"));
        btn2 = new Texture(Gdx.files.internal("StageMenu/stage2btn.png"));
        btn3 = new Texture(Gdx.files.internal("StageMenu/stage3btn.png"));
        btn4 = new Texture(Gdx.files.internal("StageMenu/stage4btn.png"));
        btn5 = new Texture(Gdx.files.internal("StageMenu/stage5btn.png"));
        btn1_hover = new Texture(Gdx.files.internal("StageMenu/stage1btn_Hover.png"));
        btn2_hover = new Texture(Gdx.files.internal("StageMenu/stage2btn_Hover.png"));
        btn3_hover = new Texture(Gdx.files.internal("StageMenu/stage3btn_Hover.png"));
        btn4_hover = new Texture(Gdx.files.internal("StageMenu/stage4btn_Hover.png"));
        btn5_hover = new Texture(Gdx.files.internal("StageMenu/stage5btn_Hover.png"));
        stagebackground = new Texture(Gdx.files.internal("StageMenu/stageBackground.png"));
    }

    @Override
    public void render(float v) {
        //Ketika screen tidak ada isinya
        ScreenUtils.clear(Color.BLACK);
        //layar
        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        game.batch.begin();
        game.batch.draw( stagebackground,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());

        XYMouse.set(Gdx.input.getX(), Gdx.input.getY(),0);
        game.viewport.unproject(XYMouse);

        int currentLevel = game.getCurrentLevel();

        System.out.println(currentLevel);

        if (isMouseOver(174,13,24,11)){
            game.batch.draw(btn1_hover,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        } else {
            game.batch.draw(btn1,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }

        if (currentLevel >= 2) {
            if (isMouseOver(113,42,25,10)){
                game.batch.draw(btn2_hover,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            } else { // diperlukan ini supaya kalau levelnya = 2 atau lbh, tidak stuck di hover dan bisa mbalek normal
                game.batch.draw(btn2,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            }
        } else {// else ini akan terjadi kalo current level di bawah 2, kalo udh 2 atau lebih ini gk bisa di akses lagi
            game.batch.draw(btn2,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }

        if (currentLevel >= 3) {
            if (isMouseOver(123,84,26,10)){
                game.batch.draw(btn3_hover,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            } else {
                game.batch.draw(btn3,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            }
        } else {
            game.batch.draw(btn3,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }

        if (currentLevel >= 4) {
            if (isMouseOver(185,108,26,11)){
                game.batch.draw(btn4_hover,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            } else {
                game.batch.draw(btn4,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            }
        } else {
            game.batch.draw(btn4,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }

        if (currentLevel >= 5) { //
            if (isMouseOver(173,147,26,12)){ //
                game.batch.draw(btn5_hover,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            } else {
                game.batch.draw(btn5,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            }
        } else {
            game.batch.draw(btn5,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
        }

        if(Gdx.input.isTouched())
        {
            if (isMouseOver(174,13,24,11)) {
                game.setScreen(new Stage1(game));
                dispose();
            }
            if (currentLevel >= 2 && isMouseOver(113,42,25,10)) {
                game.setScreen(new Stage2(game));
                dispose();
            }
            if (currentLevel >= 3 && isMouseOver(123,84,26,10)) {
                game.setScreen(new Stage3(game));
                dispose();
            }
            if (currentLevel >= 4 && isMouseOver(185,108,26,11)) {
                game.setScreen(new Stage4(game));
                dispose();
            }
            if (currentLevel >= 5 && isMouseOver(173,147,26,12)) {
                game.setScreen(new Stage5(game));
                dispose();
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
        stagebackground.dispose();
        btn1.dispose();
        btn2.dispose();
        btn3.dispose();
        btn4.dispose();
        btn5.dispose();
        btn1_hover.dispose();
        btn2_hover.dispose();
        btn3_hover.dispose();
        btn4_hover.dispose();
        btn5_hover.dispose();
    }

}
