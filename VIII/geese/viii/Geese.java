// 
// Decompiled by Procyon v0.5.36
// 

package geese.viii;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioSystem;
import java.util.Scanner;

public class Geese implements Runnable
{
    @Override
    public void run() {
        final Scanner s = new Scanner(System.in);
        String in = "";
        while (true) {
            System.out.print("> ");
            in = s.nextLine();
            System.out.println();
            if (in.matches("tone")) {
                try {
                    final Clip clip = AudioSystem.getClip();
                    Util.generateTone(clip);
                    clip.start();
                }
                catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
            else if (in.matches("members")) {
                System.out.println("Alan Goose; DE-GEESE 0x0; DE-GEESE 0x1 SAULA; GB-GEESE 0xffea;");
            }
            else if (in.matches("why")) {
                System.out.println(".");
            }
            else if (in.matches("how long")) {
                System.out.println("1989"); // Possible founding date
            }
            else if (in.matches("what")) {
                System.out.println("Group endevering everlasting simultaneous extending ; GEESE"); // ??
            }
            else if (in.matches("relations")) {
                System.out.println("No");
            }
            else if (in.matches("music")) {
                System.out.println("messages through music. all music created by alan. +xmmpA8MeP9T+vF+z6+2PHuoGXPiHU8j"); // Code means Copyright19892021 decrypted with Common Key
            }
            else if (in.matches("java")) {
                System.out.println("1.8_u211");
            }
            else if (in.matches("teiwaz")) {
                System.out.println("Lord of us. Teiwaz Service Level C-Z may not be accesible");
            }
            else if (in.matches("kraftwerk")) {
                System.out.println("involved since 1991");
            }
            else {
                if (in.matches("exit")) {
                    break;
                }
                System.out.println("invalid command; might be added later; see teiwaz.txt");
            }
        }
        System.out.println("https://xffea.netlify.app/");
        System.out.println("Copyright (c) 2021 Sinnel\u00c3¶schen-GEESE AG.");
        final String a = "To decompilers: May publish on github, credit is required. Credit Sinnesl\u00c3¶schen-GEESE AG.";
        System.exit(0);
    }
}
