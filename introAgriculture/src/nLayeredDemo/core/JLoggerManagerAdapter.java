package nLayeredDemo.core;

import nLayeredDemo.JLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService {
    @Override
    public void logtosystem(String message) {
        //projemize eklemek istediğimiz yeni projeyi burada newleyip kullanabiliriz.Bu projenin referansını da logger servise verip kullanıma hazır hale getirdik
        JLoggerManager manager = new JLoggerManager();
        manager.log(message);
    }
}
