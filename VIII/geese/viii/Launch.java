// 
// Decompiled by Procyon v0.5.36
// 

package geese.viii;

public class Launch
{
    public static void main(final String[] args) {
        System.out.println("GEESE V8 ; UMDREHUNG 8 ; WELCOME");
        System.out.println("Created by GB-GEESE 0xffea");
        System.out.println("For distribution through Alan Goose\n");
        final Thread t = new Thread(new Geese());
        t.start();
    }
}
