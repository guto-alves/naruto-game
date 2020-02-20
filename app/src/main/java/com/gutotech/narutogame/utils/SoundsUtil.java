package com.gutotech.narutogame.utils;

import android.content.Context;
import android.media.MediaPlayer;

import androidx.annotation.RawRes;

import com.gutotech.narutogame.R;

import java.security.SecureRandom;

public class SoundsUtil {
    private static final SecureRandom random = new SecureRandom();

    private static final int TOTAL_VILLAGE_MUSICS = 11;
    private static final int TOTAL_BATTLE_MUSICS = 10;

    private int[] mVillageMusics = new int[]{R.raw.e_o_treino, R.raw.entregar, R.raw.eu_sou_naruto,
            R.raw.luz_do_dia_de_konoha, R.raw.modo_de_enganar, R.raw.morning,
            R.raw.naruto_daily_life, R.raw.noite, R.raw.tarde_de_konoha, R.raw.tema_kakashi,
            R.raw.tema_konohamaru};

    private int[] mBattleMusics = new int[]{R.raw.estado_colados, R.raw.precisa_ser_forte,
            R.raw.situacao_ma, R.raw.confronto, R.raw.mal, R.raw.vingador, R.raw.raikiri,
            R.raw.strong_and_strike, R.raw.raiva, R.raw.naruto_main_theme};

    private Context mContext;

    private MediaPlayer mMediaPlayer;

    private int mLastSoundIndex = -1;

    public enum MusicType {NORMAL, BATTLE}

    private MusicType mMusicType;

    public SoundsUtil(Context context) {
        mContext = context;
        mMusicType = MusicType.NORMAL;
        prepare();
    }

    private void prepare() {
        mMediaPlayer = MediaPlayer.create(mContext, generateMusic());
        mMediaPlayer.setOnCompletionListener(mp -> {
            release();
            prepare();
            start();
        });
    }

    public void start() {
        mMediaPlayer.start();
    }

    public void pause() {
        mMediaPlayer.pause();
    }

    public void release() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @RawRes
    private int generateMusic() {
        if (mMusicType == MusicType.NORMAL) {
            return getVillageMusic();
        } else {
            return getBattleSound();
        }
    }

    @RawRes
    private int getVillageMusic() {
        int soundIndex = random.nextInt(TOTAL_VILLAGE_MUSICS);

        if (soundIndex == mLastSoundIndex) {
            soundIndex = (soundIndex + 1) % TOTAL_VILLAGE_MUSICS;
        }

        mLastSoundIndex = soundIndex;

        return mVillageMusics[soundIndex];
    }

    @RawRes
    private int getBattleSound() {
        int soundIndex = random.nextInt(TOTAL_BATTLE_MUSICS);

        if (soundIndex == mLastSoundIndex) {
            soundIndex = (soundIndex + 1) % TOTAL_BATTLE_MUSICS;
        }

        mLastSoundIndex = soundIndex;

        return mBattleMusics[soundIndex];
    }

    public void setMusicType(MusicType musicType) {
        mMusicType = musicType;
        release();
        prepare();
        start();
    }
}
