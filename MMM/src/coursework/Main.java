package coursework;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {

    private static Investors investors = new Investors();
    public static Investors getInvestors() {
        return investors;
    }

    public static void main(String[] args) throws IOException, IllegalArgumentException {
        try {
            investors.setInvestorsList(Database.LoadFromDatabase());
        }
        catch (Exception e){
            investors = new Investors();
        }
        serverHandler();
    }

    public static void serverHandler() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);
        server.createContext("/back", new ServerHandler());
        server.start();
        System.out.println(System.lineSeparator() + "Server started at:\tlocalhost:8001");
    }
}
