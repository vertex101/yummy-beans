package vertex101.yummybeans.twitch;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.Socket;

public class TwitchBot implements Runnable {
    private String server;
    protected void server(String server) {
        this.server = server;
    }
    protected String server() {
        return this.server;
    }

    private int port;
    protected void port(int port) {
        this.port = port;
    }
    protected int port() {
        return this.port;
    }

    private String user, passw, chan;
    protected void user(String user) {
        this.user = user;
    }
    protected String user() {
        return this.user;
    }
    protected void passw(String passw) {
        this.passw = passw;
    }
    protected String passw() {
        return this.passw;
    }
    protected void chan(String chan) {
        this.chan = chan;
    }
    protected String chan() {
        return this.chan;
    }

    private boolean isActive;
    protected void isActive(boolean bool) {
        this.isActive = bool;
    }
    protected boolean isActive() {
        return this.isActive;
    }

    public static void main(String args[]) {
        System.out.println("Starting program.");
        try {
            new TwitchBot().start();
        } catch (java.io.IOException e) {
        }
    }

    protected TwitchBot() {
        System.out.println("Initializing.");
        this.server("irc.twitch.tv");
        this.port(6667);
        this.user("vertex101");
        this.passw("oauth:gqtby4psmbxehbvakff45ywcv2ok0w");
        this.chan("#domosplace");
    }

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    protected void start() throws java.io.IOException {
        this.socket = new Socket(this.server(), this.port());
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        if (socket.isConnected()) {
            out.write("NICK " + this.user() + "\r\n");
            out.write("PASS " + this.passw() + "\r\n");
            out.write("JOIN " + this.chan() + "\r\n");
            out.flush();
            this.isActive(true);
            System.out.println("Starting thread.");
            new Thread(this).start();
        }
    }

    public void run() {
        String buffer;
        while (this.isActive()) {
            try {
                while ((buffer = in.readLine()) != null) {
                    if (buffer.startsWith("PING")) {
                        out.write("PONG " + buffer.substring(5) + "\r\n");
                        out.flush();
                    }
                }
            } catch (java.io.IOException e) {
            }
        }
    }
}
