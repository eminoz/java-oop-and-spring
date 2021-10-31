package nLayeredDemo.core;

public interface LoggerService {
    //baskalarının projlerini entegre ederken önce kendi interface mizi yazarık.Yazmazsak biz o logger projesine bağımlı kalmış oluruz
    void logtosystem(String message);
}
