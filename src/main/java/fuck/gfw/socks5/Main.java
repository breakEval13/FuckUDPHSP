package fuck.gfw.socks5;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import fuck.gfw.socks5.misc.Config;
import fuck.gfw.socks5.network.NioLocalServer;
import fuck.gfw.client.Client;
import fuck.gfw.socks5.misc.Util;
import fuck.gfw.socks5.network.proxy.IProxy;
import fuck.gfw.socks5.network.proxy.ProxyFactory;
import fuck.gfw.socks5.ss.CryptFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static  JSONObject template = null;
    public static void main(String[] args) {
            startCommandLine();
    }

    private static void startCommandLine() {
        new Client();
        LoadConfig();
        Config config = new Config();
        config.loadFromJson(template);


        try {
            //LocalServer server = new LocalServer(config);
            NioLocalServer server = new NioLocalServer(config);
            Thread t = new Thread(server);
            t.start();
            t.join();
        } catch (Exception e) {
            logger.warning("Unable to start server: " + e.toString());
        }
    }
    private static void printUsage() {
        System.out.println("Support Proxy Error");
        for (IProxy.TYPE t : ProxyFactory.getSupportedProxyTypes()) {
            System.out.printf("  %s\n", t.toString().toLowerCase());
        }
        System.out.println("Support Ciphers:");
        for (String s : CryptFactory.getSupportedCiphers()) {
            System.out.printf("  %s\n", s);
        }
        System.out.println("Error");
    }
    public static void LoadConfig(){
        File confFile = new File(Constant.CONF_FILE);
        Scanner confFileScanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            confFileScanner = new Scanner(confFile, "utf-8");
            while (confFileScanner.hasNextLine()) {
                buffer.append(confFileScanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block

        } finally {
            if (confFileScanner != null) {
                confFileScanner.close();
            }
        }
        template =   JSON.parseObject(buffer.toString());
    }
}
