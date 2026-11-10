package com.first.game;

import Kelas.normalFish;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Stage1 extends GameScreen{

    public Stage1(CoralClash game) {
        super(game);
    }

    @Override
    protected void loadStageData() {
        this.FISH_SPAWN_INTERVAL = 20.0f;
        this.totalFishSatuStage = 5;
        this.orbMinTime = 5;
        this.orbMaxTime = 12;
        background = new Texture(Gdx.files.internal("GameAsset/stage1_First.png"));
        this.fishSpawnTimer = FISH_SPAWN_INTERVAL/2;
    }

    @Override
    protected void spawnFish(float delta) { // Stage 1 pola adalah 5 ikan jenis normal
        Random rand = new Random();


        fishSpawnTimer -= delta;
        if (fishSpawnTimer <= 0 && totalFishSatuStage >= 0) {
            // Spawn ikan di kolom paling kanan, di baris acak
            int randomBaris = rand.nextInt(0,5);

            // Posisi X awal di paling kanan grid, posisi Y di tengah baris
            float spawnX = mapX + (kolom + 1) * ukuranLebar ; // Sedikit di luar grid kanan
            float spawnY = mapY + randomBaris * ukuranTinggi; // Sesuaikan offset Y ikan


            // CUMAN 1 jenis IKAN
            activeFish.add(new normalFish(spawnX, spawnY, 30, 30)); // Ukuran ikan
            totalFishSatuStage--;

            fishSpawnTimer = FISH_SPAWN_INTERVAL; // Reset timer
            Gdx.app.log("GameScreen", "Spawning fish at row: " + randomBaris);
        }
    }
}
