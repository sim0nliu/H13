package unittesting.slides.mocking.simple;

public class Brutus {
    Hellor hello = new Hellor();

    public String bruter() {
        return hello.hello();
    }

    public String bruter(int i) {
        return hello.hello(i * 2);
    }

}
