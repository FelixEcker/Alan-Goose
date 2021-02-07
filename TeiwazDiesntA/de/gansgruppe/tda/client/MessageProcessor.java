// 
// Decompiled by Procyon v0.5.36
// 

package de.gansgruppe.tda.client;

import java.io.PrintWriter;
import java.util.Scanner;

public class MessageProcessor
{
    private static final Scanner scan;
    
    static {
        scan = new Scanner(System.in);
    }
    
    public static void process(String nachricht, final PrintWriter writer) {
        nachricht = nachricht.replace("\r", "");
        nachricht = nachricht.replace("\n", "");
        if (nachricht.matches("%REQUIRE_KEY%")) {
            System.out.print("ACCESS KEY: ");
            final String in = MessageProcessor.scan.nextLine();
            writer.println("%KEY=" + in + "%");
            writer.flush();
        }
        else if (nachricht.matches("&KEY_INVALID&")) {
            System.out.println("ERROR: INVALID KEY");
        }
        else if (nachricht.startsWith("<MESSAGE_LINE>")) {
            System.out.println(nachricht.split("<MESSAGE_LINE>")[1]);
        }
        else if (nachricht.matches("%AWAITING_INPUT%")) {
            System.out.print("> ");
            final String in = MessageProcessor.scan.nextLine();
            writer.println(in);
            writer.flush();
        }
    }
}
