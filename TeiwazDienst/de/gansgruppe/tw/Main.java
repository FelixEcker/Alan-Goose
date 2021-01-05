// 
// Decompiled by Procyon v0.5.36
// 

package de.gansgruppe.tw;

import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.util.Scanner;

public class Main
{
    public static void main(final String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidAlgorithmParameterException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, IOException {
        System.out.println("Programm-Parameter (erforderlich) Schl\u00fcssel , Text");
        System.out.println("Teiwaz Dienst v1a (Level a)");
        System.out.println("1: Entschl\u00fcsseln");
        System.out.println("2: Verschl\u00fcsseln");
        final Scanner s = new Scanner(System.in);
        while (true) {
            final String in = s.nextLine();
            if (in.length() == 1) {
                final char ch = in.toCharArray()[0];
                if (!Character.isDigit(ch)) {
                    continue;
                }
                final int option = Integer.parseInt(String.valueOf(ch));
                String key = "";
                switch (option) {
                    case 1: {
                        final LXVIII lxviii = new LXVIII();
                        for (int i = 1; i < args.length; ++i) {
                            if (!args[i].matches(args[args.length - 1])) {
                                key = String.valueOf(key) + args[i] + " ";
                            }
                            else {
                                key = String.valueOf(key) + args[i];
                            }
                        }
                        System.out.println(lxviii.decrypt(key, args[0]));
                        continue;
                    }
                    case 2: {
                        final LXVIII lxviii = new LXVIII();
                        for (int i = 1; i < args.length; ++i) {
                            key = String.valueOf(key) + args[i];
                        }
                        System.out.println(lxviii.encrypt(key, args[0]));
                        continue;
                    }
                    default: {
                        System.exit(0);
                        continue;
                    }
                }
            }
        }
    }
}
