/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlay implements LineListener {
//    private AudioClip clip;
//    private AudioClip bgm;

    private Clip audioClip;
    private boolean playCompleted;
    private Object lock;
    private boolean loop;
    private AudioInputStream audioStream;
    private URL url;
    private Thread thread;

    public MusicPlay(String str) {

        try {
            long t = System.currentTimeMillis();
            url = getClass().getResource(str);

            audioStream = AudioSystem.getAudioInputStream(url);
            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);
            audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.addLineListener(this);
            audioClip.open(audioStream);
            //System.out.println("loading : " + (System.currentTimeMillis() - t));

        } catch (UnsupportedAudioFileException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

//    public MusicPlay(String str){
//        bgm = Applet.newAudioClip(getClass().getResource(str));
//    }
    public void loop() {
        loop = true;
        lock = new Object();

        thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                playCompleted = false;
                audioClip.start();
                int i = 0;
                synchronized (lock) {
                    while (!playCompleted) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            // treat interrupt as exit request
                            break;
                        }
                    }
                }
                audioClip.close();
            }

        });
        thread.start();
    }

    public void stop() {
        playCompleted = true;
//        audioClip.close();
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.START) {
           // System.out.println("Playback started.");

        } else if (type == LineEvent.Type.STOP) {
            if (!loop) {
                playCompleted = true;
            } else {
                audioClip.setMicrosecondPosition(0);
                audioClip.start();
            }
            //System.out.println("Playback completed.");
        }

    }

    public void play() {
        new Thread(new Runnable() {
            private boolean playCompleted;

            @Override
            public void run() {
                playCompleted = false;
                try {

                    audioStream = AudioSystem.getAudioInputStream(url);
                    AudioFormat format = audioStream.getFormat();

                    DataLine.Info info = new DataLine.Info(Clip.class, format);
                    Clip audioClip = (Clip) AudioSystem.getLine(info);
                    audioClip.addLineListener(new LineListener() {
                        @Override
                        public void update(LineEvent event) {
                            if (event.getType() == LineEvent.Type.STOP) {
                                playCompleted = true;
                            }
                        }
                    });
                    audioClip.open(audioStream);
                    audioClip.start();
                    while (!playCompleted) {
                        // wait for the playback completes
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    audioClip.close();

                } catch (LineUnavailableException | IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(MusicPlay.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }).start();
    }
}
