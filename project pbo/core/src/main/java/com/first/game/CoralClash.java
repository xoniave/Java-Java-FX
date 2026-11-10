package com.first.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class CoralClash extends Game {
    public SpriteBatch batch;
    public BitmapFont font;
    public FitViewport viewport;
    public Preferences Database;

    public void create() {
        batch = new SpriteBatch(); // BUAT DRAW

        font = new BitmapFont(); // FONT
        viewport = new FitViewport(300, 170); //

        font.setUseIntegerPositions(false);
        font.getData().setScale(viewport.getWorldHeight() / Gdx.graphics.getHeight());

        //INI MEMBUAT DATABASE MENGGUNAKAN PREFERNECES
        Database = Gdx.app.getPreferences("CoralClashProgress");

        Database.remove("currentLevel"); //AGAR KETIKA GAME SELESAI DATABASE TIDAK TERSIMPAN


        //INI CHECK APAKAH SUDAH ADA DATA HIGHEST KALAU BELUM DI BIKIN DAN DI SET 1
        if (!Database.contains("currentLevel")) {
            Database.putInteger("currentLevel", 5);
            Database.flush();// INI UNTUK MEMPERBARUI DATA E
        }


        //GANTI KE TAMPILAN MENU
        this.setScreen(new TampilanMenu(this));

    }

    // ini Mendapatkan currentLevel , jika gk ada isinya default nya adalah 1
    public int getCurrentLevel() {
        return Database.getInteger("currentLevel", 1);
    }

    public void StageSelesai(int nomorStageSelesai) {
        int tertinggiSekarang = getCurrentLevel();
        if (nomorStageSelesai == tertinggiSekarang) {
            Database.putInteger("currentLevel", nomorStageSelesai + 1);
            Database.flush();
        }
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
        getScreen().dispose();
    }
}
