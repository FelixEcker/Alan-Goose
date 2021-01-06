// 
// Decompiled by Procyon v0.5.36
// 

package geese.viii;

import javax.sound.sampled.LineUnavailableException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import java.io.ByteArrayInputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Util
{
    public static void generateTone(Clip clip) throws LineUnavailableException {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
        else {
            clip = AudioSystem.getClip();
        }
        final boolean addHarmonic = true;
        final int intSR = 11025;
        final int intFPW = 10000;
        final float sampleRate = (float)intSR;
        final int wavelengths = 20;
        final byte[] buf = new byte[2 * intFPW * wavelengths];
        final AudioFormat af = new AudioFormat(sampleRate, 8, 2, true, false);
        final int maxVol = 127;
        for (int i = 0; i < intFPW * wavelengths; ++i) {
            final double angle = i * 2 / (float)intFPW * 3.141592653589793;
            buf[i * 2] = getByteValue(angle);
            if (addHarmonic) {
                buf[i * 2 + 1] = getByteValue(2.0 * angle);
            }
            else {
                buf[i * 2 + 1] = buf[i * 2];
            }
        }
        try {
            final byte[] b = buf;
            final AudioInputStream ais = new AudioInputStream(new ByteArrayInputStream(b), af, buf.length / 2);
            clip.open(ais);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static byte getByteValue(final double angle) {
        final int maxVol = 127;
        return new Integer((int)Math.round(Math.sin(angle) * maxVol)).byteValue();
    }
}
