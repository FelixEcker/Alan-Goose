// 
// Decompiled by Procyon v0.5.36
// 

package geese.schauen;

import java.io.InputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.UnsupportedEncodingException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] args) {
        if (args.length == 0) {
            System.out.println("MISSING ARGUMENTS");
            System.exit(0);
        }
        final String key = args[0];
        if (!key.matches("HaltedeineAugenoffen")) {
            System.out.println("INVALID KEY");
            return;
        }
        final Scanner s = new Scanner(System.in);
        while (true) {
            System.out.print("]");
            final String in = s.nextLine();
            final String s2;
            switch ((s2 = in).hashCode()) {
                case -1686520627: {
                    if (!s2.equals("umdrehung2")) {
                        continue;
                    }
                    doAction();
                    continue;
                }
            }
        }
    }
    
    private static void doAction() {
        final InputStream inputStream = Main.class.getResourceAsStream("/ascii-art.txt");
        InputStreamReader streamReader = null;
        try {
            streamReader = new InputStreamReader(inputStream, "UTF-8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        final BufferedReader in = new BufferedReader(streamReader);
        try {
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=================================================================================");
        System.out.println("Die Jagd ist offen\nSzd69qs1/bgvxgn4xbr4NQ==");
    }
}
