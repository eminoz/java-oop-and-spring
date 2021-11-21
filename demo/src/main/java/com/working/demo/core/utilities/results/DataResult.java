package com.working.demo.core.utilities.results;

public class DataResult<T> extends Result {

    private T data;

    public DataResult(T data, boolean success, String message) {
        //Bu super base sınıfın constracterlarını çalıştırmaya yarıyor.Gönderilen success ve message bilgilerini base sınıfa yollamış oluyoruz
        super(success, message);
        this.data = data;
    }

    public DataResult(T data, boolean success) {
        super(success);
        this.data = data;
    }

    public T getData() {
        return this.data;
    }
}
