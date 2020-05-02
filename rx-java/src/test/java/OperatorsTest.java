import org.junit.Test;
import rx.Observable;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class OperatorsTest {

    @Test
    public void map() throws Exception {
        Observable
                .just("Hello world!")
                .map(s -> s.hashCode())
                .subscribe(System.out::println);
    }

    @Test
    public void flatMap() throws Exception {
        Observable
                .from(new String[]{"Hello world!", "1"})
                .flatMap(Observable::just)
                .subscribe(System.out::println);
    }

}
