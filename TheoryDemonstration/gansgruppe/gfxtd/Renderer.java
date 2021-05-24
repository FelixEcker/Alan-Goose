// 
// Decompiled by Procyon v0.5.36
// 

package gansgruppe.gfxtd;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Component;
import java.awt.Canvas;
import javax.swing.JFrame;

public class Renderer extends JFrame
{
    private Canvas cvs;
    
    public Renderer() {
        super("Theory Demonstration by GansGruppe");
        this.setSize(640, 480);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setLocationRelativeTo(null);
        (this.cvs = new Canvas()).setSize(this.getWidth(), this.getHeight());
        this.add(this.cvs);
        this.setVisible(true);
    }
    
    public void render() {
        final BufferStrategy bs = this.cvs.getBufferStrategy();
        if (bs == null) {
            this.cvs.createBufferStrategy(3);
            return;
        }
        final Graphics g = bs.getDrawGraphics();
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        DemoRender.render(g, this.getWidth());
        g.dispose();
        bs.show();
    }
}
