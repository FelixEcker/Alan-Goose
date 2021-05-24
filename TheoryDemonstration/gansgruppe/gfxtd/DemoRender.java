// 
// Decompiled by Procyon v0.5.36
// 

package gansgruppe.gfxtd;

import java.awt.Font;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.Color;
import java.awt.Graphics;

public class DemoRender
{
    static int img;
    
    public static void render(final Graphics g, final int width) {
        g.setColor(Color.BLUE);
        g.fillRect(ThreadLocalRandom.current().nextInt(width) / 10, ThreadLocalRandom.current().nextInt(width) / 10, ThreadLocalRandom.current().nextInt(width) / 10, ThreadLocalRandom.current().nextInt(width) / 10);
        g.setColor(Color.RED);
        g.fillRect(ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width));
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(12); ++i) {
            g.setColor(new Color(ThreadLocalRandom.current().nextInt(255), ThreadLocalRandom.current().nextInt(255), ThreadLocalRandom.current().nextInt(255)));
            g.fillRect(ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width));
            g.setColor(new Color(ThreadLocalRandom.current().nextInt(255), ThreadLocalRandom.current().nextInt(255), ThreadLocalRandom.current().nextInt(255)));
            g.fill3DRect(ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width), ThreadLocalRandom.current().nextInt(width), true);
        }
        g.setFont(new Font("Courier New", 0, 25));
        g.setColor(Color.BLACK);
        g.drawString("Image: " + DemoRender.img, 0, 200);
        ++DemoRender.img;
    }
    
    static {
        DemoRender.img = 0;
    }
}
