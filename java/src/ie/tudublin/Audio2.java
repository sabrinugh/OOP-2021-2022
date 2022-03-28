package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import ddf.minim.analysis.WindowFunction;
import processing.core.PApplet;

/*

*/

public class Audio2 extends PApplet
{
    Minim minim; // Allows access to audio file library
    AudioPlayer ap; // Audio player - plays audio from device, encapsulate audio in program
    AudioInput ai; // Takes audio from microphone
    AudioBuffer ab; // Mix of audio left and right channels and arrange into array list

    // 16 bits = sameple size, or resolution
    // 44, 600 = 
    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    FFT fft; // Fast fourier transfer

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        ai = minim.getLineIn(Minim.MONO, width, 44100, 16); // 44100 = sameple rate, 16 = resolution
        ab = ai.mix; 
        // ap = minim.loadFile("heroplanet.mp3", 1024); // 1024 is the frame size 
        // ap.play();
        // ab = ap.mix;
        colorMode(RGB);

        fft = new FFT(1024, 44100); // timesize is the frame size (1024) and the sample size
        
        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    float off = 0;

    public void draw()
    {
        background(0);
        stroke(255);

        float halfH = height/2;

        for (int i=0; i<ab.size(); i++) {
            line(i, halfH, i, halfH+ab.get(i) * halfH); // ab.get(i) adjusts to screen.
        }

        fft.window(FFT.HAMMING);
        fft.forward(ab); // Audio buffer and 
        
        stroke(0, 255, 40);
        for (int i=0; i<fft.specSize(); i++) {
            line(i, 0, i, fft.getBand(i) * 10); // 0 means top of screen
        }

        int maxIndex = 0;
        
        
        for (int i=0; i<fft.specSize(); i++) {
            if (fft.getBand(i) > fft.getBand(maxIndex)) {
                maxIndex = i;
            }
        }

        float freq = fft.indexToFreq(maxIndex);
        textSize(75);
        fill(255);

        text("Freq: "+ freq, 100, 200);
        
    }        
}
