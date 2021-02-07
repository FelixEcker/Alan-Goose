// 
// Decompiled by Procyon v0.5.36
// 

package de.gansgruppe.tda.client;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Writer;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.InetAddress;

public class Client implements Runnable
{
    private Thread t;
    public InetAddress host;
    public Socket socket;
    public ObjectOutputStream oos;
    public ObjectInputStream ois;
    public static int hostPort;
    
    static {
        Client.hostPort = 2803;
    }
    
    public Client() {
        this.socket = null;
        this.oos = null;
        this.ois = null;
    }
    
    @Override
    public void run() {
        System.out.println("Public Access Interface for TEIWAZ");
        System.out.println("The Public Access Interface has a limited bandwidth and non 100% uptime.\nACCESS NOT GUARANTEED");
        try {
            this.socket = new Socket("84.186.134.197", Client.hostPort);
            final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            while (true) {
                final char[] buffer = new char[200];
                final int anzahlZeichen = bufferedReader.read(buffer, 0, 200);
                final String nachricht = new String(buffer, 0, anzahlZeichen);
                String[] split;
                for (int length = (split = nachricht.split("\r\n")).length, i = 0; i < length; ++i) {
                    final String s = split[i];
                    MessageProcessor.process(s, printWriter);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void start() {
        (this.t = new Thread(this, "CChat-Client")).start();
    }
}
