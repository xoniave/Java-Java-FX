package com.first.game;

import Kelas.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.Currency;
import java.util.Iterator;
import java.util.Random;

public abstract class GameScreen implements Screen {

    //DEKLARASI VARIABLE
    protected CoralClash game; // INI YANG DARI CORAL CLASH BERISI VIEWPORT SPRITE BATCH DLL
    protected Texture background;
    protected Vector3 XYMouse =  new Vector3();
    protected int currency;
    protected int levelSkrg;

    //MAP
    protected int baris = 5; // Jumlah baris pada MAP YG KOTAK TENGAH (sesuai gambar)
    protected int kolom = 9; // Jumlah kolom pada MAP YG KOTAK TENGAH (sesuai gambar)
    protected float mapX = 68.8f;  // Posisi X awal map (kiri bawah kotak pertama)
    protected float mapY = 24.8f;  // Posisi Y awal map (kiri bawah kotak pertama)
    protected float ukuranLebar = 21.4f;   // Lebar setiap kotak
    protected float ukuranTinggi = 21.4f;  // Tinggi setiap kotak

    // TUMBUHAN
    protected Tumbuhan[][] mapPlants; // UNTUK SIMPEN OBJECT TUMBUHAN
    protected int ikonTumbuhanDipilih = -1; // DATA INDEX TUMBUHAN YANG DIPILIH UI SEBELAH KIRI
    protected ArrayList<proyektil> activeProyektil;

    // ORB
    protected ArrayList<Orb> activeOrb;
    protected float orbTimer;
    protected int orbMinTime;
    protected int orbMaxTime;
    Random rand = new Random();


    // IKAN
    protected ArrayList<Ikan> activeFish; // DATA ikan yang LAGI HIDUP ada di layar
    protected float fishSpawnTimer; // CD UNTUK IKAN SPAWN YANG GERAK DI MIN-1 TERUS
    protected float FISH_SPAWN_INTERVAL; // SIMMPEN DATA UNTUK DETIK KARENA fishSpawnerTImer kan yang gerak supaya data tidak hilang
    protected int totalFishSatuStage; // DATA IKAN PER STAGE

    protected boolean gameOver = false;
    protected boolean stageComplete = false;
    protected boolean gameEnd = false;

    //LAYAR AKHIR
    protected Texture winScreenTexture;
    protected Texture loseScreenTexture;
    protected float endScreenTimer = 0f;
    protected final float END_SCREEN_DURATION = 3f;


    public GameScreen(CoralClash game) {
        this.game = game;
    }


    @Override
    public void show() {

        //SETTING ARRAY 2D UNTUK NAMPUNG TUMBUHAN OBJECT BERDASARKAN BARIS DAN KOLOM
        mapPlants = new Tumbuhan[baris][kolom];

        //DEKLARASI
        activeFish = new ArrayList<>();
        activeProyektil = new ArrayList<>();
        activeOrb = new ArrayList<>();
        currency = 0;
        levelSkrg = game.getCurrentLevel();


        winScreenTexture = new Texture(Gdx.files.internal("GameAsset/Win.png")); // Pastikan ada file ini
        loseScreenTexture = new Texture(Gdx.files.internal("GameAsset/Lose.png")); // Pastikan ada file ini

        loadStageData(); // LOAD DATA STAGE , TERUTMA CD FISH DAN TOTAL FISH
    }

    protected abstract void loadStageData();

    protected void spawnFish(float delta)
    {
        // INI FUNGSI DEFAULT SPAWN FISH DIGUNAKAN KETIKA SEBUAH CLASS IKAN TIDAK ADA OVERRIDE DI STAGE CHILD,
        // SOALNYA TIAP STAGE SYARAT SPAWN BEDA2 MAKANYA DI PISAH JADI FUNCTION SENDIRI AGAR BISA DI OVERRIDE, HARUSNYA DI FUNGSI RENDER
        if (fishSpawnTimer <= 0 && activeFish.size() < 5) {

            // INI RANDOM IKAN MUNCUL DI BARIS MANA DARI 1-5 KEKNYA
            int randomBaris = (int) (Math.random() * baris);

            // INI NGEPRINT IKAN E NDE MANA POSISINYA
            // DI X , DIBUAT KOLOM + 1 * UKURAN LEBAR , KENAPA + 1?? SOAL E SUPAYA NGEPRINT DI PALING KANAN KAN MAP NYA GK FULL
            float spawnX = mapX + (kolom + 1) * ukuranLebar ;
            // DI Y , DIBUAT RANDOM BARIS * UKURAN TINGGI (LOGIKA BIASA SUPAYA NGEPRINT SESUAI BARIS E)
            // KENAPA KOK + UKURAN TINGGI /8 ??? SUPAYA KEK NGAWANG DIKIT
            float spawnY = mapY + randomBaris * ukuranTinggi + ukuranTinggi / 8; // Sesuaikan offset Y ikan

            //NAH INI DI MASUKAN KE ARRAY LIST YANG NAMPUNG IKAN (YANG LAGI HIDUP)
            activeFish.add(new normalFish(spawnX, spawnY, 25, 25)); //WDTH HEIGHT UKURAN IKAN GK MUNGKIN KOTAK IKAN E

            // FISH SPAWN TIMER SELALU -1 , MAKA E NILAI BERUBAH2 TERUS, KETIKA UDH 0 IKAN E MUNCUL, JADI HARUS DI JADIKAN 15 LAGI
            // MAKANYA DATA CD DI SIMPAN
            fishSpawnTimer = FISH_SPAWN_INTERVAL;
            Gdx.app.log("GameScreen", "Spawning fish at row: " + randomBaris);
        }
    }

    protected void spawnOrb()
    {
        int randomKolom = rand.nextInt(0,kolom);
        float munculDiX = mapX + randomKolom * ukuranLebar; // KOLOM = X
        float munculDiY = game.viewport.getWorldHeight(); // BARIS = Y

        float stopY = mapY + rand.nextInt(0,4) * ukuranTinggi;

        Orb O = new Orb(munculDiX,munculDiY, 30F,stopY,50);
        activeOrb.add(O);
    }



    @Override
    public void render(float delta) {// FUNGSI RENDER YANG MEMPERBARUI SCREEN TIAP DETIK NON STOP
        ScreenUtils.clear(Color.BLACK); // KALO TIDAK ADA APA APA MAKA SCREEN BLACK

        // SETTINGAN SCREEN VIRTUAL
        game.viewport.apply();
        game.batch.setProjectionMatrix(game.viewport.getCamera().combined);

        // MEMULAI FUNGSI GAMBAR JADI GAMBAR HANYA BISA DILAKUKAN JIKA SUDAH BATCH BEGIN
        game.batch.begin();

        //GAMBAR BACKGROUND
        game.batch.draw(background,0,0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());

        if(!gameEnd) {

            //GAMBAR TANAMAN JIKA ADA DI ARRAY 2D TUMBUHAN, ISINYA OBJECT TANAMAN, SAAT AKSES OBJECT TANAMAN, DI DALEM NYA SUDAH DI SET TEXTURE DLL.
            for (int a = 0; a < baris; a++) {
                for (int b = 0; b < kolom; b++) {
                    if (mapPlants[a][b] != null) {
                        //MEMGHITUNG X, DI KALI DENGAN KOLOM , SOAL E NILAI X BERDASARKAN KOLOM, KOLOM KANA KANAN KIRI (X)
                        float plantX = mapX + b * ukuranLebar;
                        // MENGHITUNG Y , DI KALI DENGAN BARIS, SOAL E NILAI Y BERDASARKAN BARISNYA, BARIS KAN ATAS BAWAH (Y)
                        float plantY = mapY + a * ukuranTinggi; //LOGIKA perhitungan Y dari baris

                        // DATA TEXTURE SUDAH ADA DI DALAM TUMBUHAN , SISA PANGGIL FUNCTION DRAW DI TUMBUHAN


                        //untuk kubi gk boleh di set gitu karena dia butuh gerak ke kanan maka dari itu pengecualian

                        mapPlants[a][b].setPosition(plantX, plantY);



                        //INI HARUS DISET AGAR BISA DIPAKAI PROYEKTIL MENGUKUR LETAK X Y PERTAMA KALI, KARNA DATA WIDH HEIGHT TDK TERIMSPAN BEDA DGN IKAN
                        mapPlants[a][b].setWidth(ukuranLebar);
                        mapPlants[a][b].setHeight(ukuranTinggi);

                        //khusus untuk skipi untuk memperbarui TIme buat texture nya
                        if (mapPlants[a][b] instanceof skipi) {
                            ((skipi) mapPlants[a][b]).update(delta);
                        }



                        mapPlants[a][b].draw(game.batch, mapPlants[a][b].getX(),mapPlants[a][b].getY(), ukuranLebar, ukuranTinggi);


                        //LOGIKA UNTUK CD TUMBUHAN
                        mapPlants[a][b].setAttackTimer(mapPlants[a][b].getAttackTimer() - delta);

                        if (mapPlants[a][b].getAttackTimer() <= 0) {
                            mapPlants[a][b].nembak(activeProyektil, activeFish, activeOrb);
                            mapPlants[a][b].setAttackTimer(mapPlants[a][b].getAttackCd());
                        }


                        //MEMBUAT HITBOX TUMBUHAN
                        Rectangle tumbuhanHitBox = new Rectangle(plantX, plantY, ukuranLebar / 2, ukuranTinggi / 2);

                        // Menggunakan Array terpisah untuk ikan yang menyerang tumbuhan ini
                        ArrayList<Ikan> ikanYangMenyerang = new ArrayList<>();

                        for (Ikan fish : activeFish) {
                            Rectangle fishHitBox = new Rectangle(fish.getX(), fish.getY(), fish.getWidth() / 2, fish.getHeight() / 2);
                            if (fishHitBox.overlaps(tumbuhanHitBox)) {
                                ikanYangMenyerang.add(fish);
                            }
                        }

                        boolean tumbuhanMati = false;
                        for (Ikan fish : ikanYangMenyerang) {
                            fish.setSpeed(0); // Ikan berhenti ketika menabrak tumbuhan

                            if (fish.getSpeed() == 0) {
                                fish.setAttackTimer(fish.getAttackTimer() - delta);
                            }

                            if (fish.getAttackTimer() <= 0) {
                                mapPlants[a][b].setDarah(mapPlants[a][b].getDarah() - fish.getDamage());
                                fish.setAttackTimer(fish.getAttackCd());
                                Gdx.app.log("GameScreen", "Darah tumbuhan : " + mapPlants[a][b].getDarah());
                            }

                            if (mapPlants[a][b].getDarah() <= 0) {
                                mapPlants[a][b].dispose();
                                mapPlants[a][b] = null;
                                tumbuhanMati = true;
                                break; // Tumbuhan sudah mati, keluar dari loop ikan yang menyerang tumbuhan ini
                            }
                        }

                        if (tumbuhanMati) {
                            for (Ikan fish : ikanYangMenyerang) {
                                fish.setSpeed(fish.getSpeedAwal());
                            }
                        }
                    }
                }
            }


            for (int i = activeProyektil.size() - 1; i >= 0; i--) {
                proyektil p = activeProyektil.get(i);
                p.update(delta); // Perbarui posisi proyektil GERAK KE KANAN TERUS
                p.draw(game.batch);

                Rectangle TEMBAK = new Rectangle(p.getX(), p.getY(), p.getWidth() / 3, p.getHeight());

                Iterator<Ikan> ikanProyektil = activeFish.iterator();
                while (ikanProyektil.hasNext()) {
                    Ikan fish = ikanProyektil.next();

                    Rectangle FISH_KENA_TEMBAK = new Rectangle(fish.getX(), fish.getY(), fish.getWidth() / 2, fish.getHeight() / 2);

                    if (p.isActive() && TEMBAK.overlaps(FISH_KENA_TEMBAK)) {
                        fish.setDarah(fish.getDarah() - p.getDamage());
                        Gdx.app.log("GameScreen", "FISH DARAH" + fish.getDarah());
                        p.setActive(false);

                        //SUARA ATAU EFEK HIT TARUH SINI

                        if (fish.getDarah() <= 0) {
                            fish.dispose();
                            ikanProyektil.remove();
                        }
                        break;
                    }
                }

                if (!p.isActive() || p.getX() > game.viewport.getWorldWidth()) {
                    activeProyektil.remove(i);
                }


            }

            orbTimer -= delta;
            if (orbTimer <= 0) {
                spawnOrb();
                orbTimer = rand.nextInt(orbMinTime, orbMaxTime);
            }

            for (int A = activeOrb.size() - 1; A >= 0; A--) {
                Orb orb = activeOrb.get(A);
                orb.setY(orb.getY() - orb.getSpeedY() * delta);
                orb.draw(game.batch);

                if (!orb.isStop() && orb.getY() <= orb.getTargetStopY()) {
                    orb.setY(orb.getTargetStopY());
                    orb.setSpeedY(0);
                    orb.setStop(true);

                    //bisa kasih suara di sini
                }
            }

            // PANGGIL FUNCTION SPAWN FISH MMG HARUSNYA DI RENDER , TAPI DIPISAH KE FUNCTION LAIN SPY BS OVERRIDE
            if (!gameOver && !stageComplete) {
                spawnFish(delta);
            }

            //INI UNTUK LOOPING DATA IKAN MENGGUNAKAN ITERATOR
            Iterator<Ikan> fishIterator = activeFish.iterator();
            //SELAMA DI DALAM ITERATOR MASIH ADA IKAN DIA AKAN LOOP
            while (fishIterator.hasNext()) {
                Ikan fish = fishIterator.next();

                fish.setX(fish.getX() - fish.getSpeed() * delta); // Kecepatan ikan

                // Perbarui posisi ikan (misal, bergerak ke kiri)
                fish.draw(game.batch);

                // Hapus ikan jika sudah keluar layar dari kiri
                if (fish.getX() + fish.getWidth() < mapX) { // Jika ikan sudah melewati batas kiri grid
                    gameOver = true;
                    fish.dispose();
                    fishIterator.remove();
                    Gdx.app.log("GameScreen", "Fish removed (off-screen)");
                    gameEnd =true;
                }
                // Di sini Anda juga bisa menambahkan logika jika ikan mencapai base (kiri layar)
            }

            // Cek kondisi kemenangan
            if (activeFish.isEmpty() && !gameOver && totalFishSatuStage < 0) {
                stageComplete = true;
                gameEnd =true;
            }

            XYMouse.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            game.viewport.unproject(XYMouse);

            //KETIKA CLICK

            //PENJELASAN ARRAY LEBIH LANJUT TENTANG TUMBUHAN.
            //JADI ANNGAP MATRIX IKUT MUTER KE BAWAH JANGAN ANGGAP 0,0 DI KIRI ATAS MELAINKAN KIRI BAWAH SETELAH ITU INDEX DI CONVERT JADI XY LAYAR


            if (Gdx.input.justTouched()) {
                float mapXmin = mapX;
                float lebar = kolom * ukuranLebar;
                float mapYmin = mapY;
                float tinggi = mapY + baris * ukuranTinggi;

                //INI CEK APAKAH DI RANGE UI KIRI TANAMAN SEDANG DI CLICK
                if (isMouseOver(5, 120, 42, 16) && currency >= 100 && levelSkrg >= 1) {
                    ikonTumbuhanDipilih = 1;
                }
                if (isMouseOver(5, 104, 42, 16) && currency >= 50 && levelSkrg >= 2) {
                    ikonTumbuhanDipilih = 2;
                }
                if (isMouseOver(5, 88, 42, 16) && currency >= 50 && levelSkrg >= 3) {
                    ikonTumbuhanDipilih = 3;
                }
                if (isMouseOver(5, 72, 42, 16) && currency >= 300 && levelSkrg >= 4) {
                    ikonTumbuhanDipilih = 4;
                }


                //LOGIKA MENGAMBIL ORB KETIKA CLICK
                Iterator<Orb> orbIterator = activeOrb.iterator();
                while (orbIterator.hasNext()) {
                    Orb O = orbIterator.next();

                    Rectangle orbHitBox = new Rectangle(O.getX(), O.getY(), O.getWidth(), O.getHeight());

                    if (orbHitBox.contains(XYMouse.x, XYMouse.y)) {
                        currency += O.getUang();
                        O.dispose();
                        orbIterator.remove();
                    }

                }


                //INI CEK APAKAH CLICK DI RANGE MAP
                if (isMouseOver(mapXmin, mapYmin, lebar, tinggi)) {
                    int barisDiclick = (int) ((XYMouse.y - mapY) / ukuranTinggi);
                    int kolomDiclick = (int) ((XYMouse.x - mapX) / ukuranLebar);


                    //INI CEK INDEX BERAPA YANG DI PILIH
                    if (ikonTumbuhanDipilih == 1 && currency >= 100) //POMPI UI KIRI
                    {
                        currency -= 100;
                        mapPlants[barisDiclick][kolomDiclick] = new pompi();
                    }

                    if (ikonTumbuhanDipilih == 2 && currency >= 50) {
                        currency -= 50;
                        mapPlants[barisDiclick][kolomDiclick] = new bembi();
                    }

                    if (ikonTumbuhanDipilih == 3 && currency >= 50) {
                        currency -= 50;
                        mapPlants[barisDiclick][kolomDiclick] = new vigi();
                    }

                    if (ikonTumbuhanDipilih == 4 && currency >= 300) {
                        currency -= 300;
                        mapPlants[barisDiclick][kolomDiclick] = new skipi();
                    }
                    ikonTumbuhanDipilih = -1;

                } else {
                    Gdx.app.log("GameScreen", "Click tidak di map");
                }
            }
            game.font.draw(game.batch, "" + currency, 30, 52);
        }
        else {
            endScreenTimer += delta;
            if(gameOver)
            {
                game.batch.draw(loseScreenTexture, 0, 0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            }
            else if(stageComplete)
            {
                game.batch.draw(winScreenTexture, 0, 0, game.viewport.getWorldWidth(), game.viewport.getWorldHeight());
            }

            if(endScreenTimer >= END_SCREEN_DURATION)
            {
                if(stageComplete)
                {
                    game.StageSelesai(game.getCurrentLevel());
                    game.setScreen(new StageMenu(game));
                }
                else {
                    game.setScreen(new StageMenu(game));
                }
            }
        }
        game.batch.end();
    }

    @Override
    public void resize (int width, int height) {
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

        // Dispose fish using an iterator for safe removal
        Iterator<Ikan> fishDisposeIterator = activeFish.iterator();
        while (fishDisposeIterator.hasNext()) {
            Ikan fish = fishDisposeIterator.next();
            fish.dispose();
            fishDisposeIterator.remove();
        }
        activeFish.clear(); // Ensure the list is empty after disposal

        for (int r = 0; r < baris; r++) {
            for (int c = 0; c < kolom; c++) {
                if (mapPlants[r][c] != null) {
                    mapPlants[r][c].dispose();
                    mapPlants[r][c] = null; // Set to null after disposing
                }
            }
        }
    }

    public boolean isMouseOver(float x,float y,float width,float height)
    {
        return XYMouse.x >= x && XYMouse.x <= x + width && XYMouse.y >= y && XYMouse.y <= y + height;
    }

    public boolean isGameOver() { return gameOver; }
    public boolean isStageComplete() { return stageComplete; }
}
