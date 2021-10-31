package oooIntro;

public class Category {
    private int id;
    private String name;

    //this main is category can run that is empty
    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //fonksiyonun başında int olması olması o fonksiyonunun değerinin sadece okunabilceğı anlamına geliyor
    public int getId() {
        return id;
    }
    //fonksiyonun başında void  olması o fonksiyonunun değerinin dışarıdan erişilip değiştirilebilceği anlamına geliyor
    public void setId(int id) {
        this.id = id +1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
