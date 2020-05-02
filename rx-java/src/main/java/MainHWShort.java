import rx.Observable;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class MainHWShort {

    public static void main(String[] args) {
        Observable
                .just("Hello world!")
                .subscribe(System.out::println);
    }
}
