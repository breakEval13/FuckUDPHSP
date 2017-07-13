package fuck.gfw.socks5;

import fuck.gfw.socks5.misc.Config;
import fuck.gfw.socks5.network.NioLocalServer;
import fuck.gfw.client.Client;
import fuck.gfw.socks5.misc.Util;
import fuck.gfw.socks5.network.proxy.IProxy;
import fuck.gfw.socks5.network.proxy.ProxyFactory;
import fuck.gfw.socks5.ss.CryptFactory;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
            startCommandLine();
    }

    private static void startCommandLine() {
        new Client();
        Config config;

        config = parseArgument();
        if (config == null) {
            printUsage();
            return;
        }

        Util.saveFile(Constant.CONF_FILE, config.saveToJson());

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

    private static Config parseArgument() {
        Config config = new Config("127.0.0.1", 1085, "0.0.0.0", 1081, "aes-256-cfb", "YjM010$#*(O^#*990", IProxy.TYPE.SOCKS5);

        return config;
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
}
