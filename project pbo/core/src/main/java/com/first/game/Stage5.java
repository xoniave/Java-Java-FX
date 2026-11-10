package com.first.game;

import Kelas.horsi;
import Kelas.horsiMutation;
import Kelas.normalFish;
import Kelas.normalFishMutation;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

public class Stage5 extends GameScreen{

    public Stage5(CoralClash game)
    {
        super(game);
    }

    @Override
    protected void loadStageData() {
        this.FISH_SPAWN_INTERVAL = 15.0f;
        this.totalFishSatuStage = 15;
        this.orbMinTime = 10;
        this.orbMaxTime = 20;
        background = new Texture(Gdx.files.internal("GameAsset/stage4_First.png"));
        this.fishSpawnTimer = FISH_SPAWN_INTERVAL;
    }

    @Override
    protected void spawnFish(float delta) {//masih sama kek stage 4
        Random rand = new Random();

        fishSpawnTimer -= delta;
        if (fishSpawnTimer <= 0 && totalFishSatuStage >= 0) {
            // Spawn ikan di kolom paling kanan, di baris acak
            int randomBaris = rand.nextInt(0,5);

            // Posisi X awal di paling kanan grid, posisi Y di tengah baris
            float spawnX = mapX + (kolom + 1) * ukuranLebar ; // Sedikit di luar grid kanan
            float spawnY = mapY + randomBaris * ukuranTinggi; // Sesuaikan offset Y ikan

            if(totalFishSatuStage < 10)
            {
                int acak = rand.nextInt(1,3);

                if (acak == 1) {
                    activeFish.add(new horsi(spawnX, spawnY, 30, 30));
                }
                else if (acak == 2)
                {
                    activeFish.add(new horsiMutation(spawnX, spawnY, 30, 30));
                }

            }
            else {
                activeFish.add(new normalFishMutation(spawnX, spawnY, 30, 30));
            }

            totalFishSatuStage--;

            fishSpawnTimer = FISH_SPAWN_INTERVAL; // Reset timer
            Gdx.app.log("GameScreen", "Spawning fish at row: " + randomBaris);
        }
    }
}
