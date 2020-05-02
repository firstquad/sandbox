import rx.Observable;
import rx.Subscriber;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class MainHW {

    Observable<String> myObservable = Observable.unsafeCreate(
            new Observable.OnSubscribe<String>() {
                @Override
                public void call(Subscriber<? super String> sub) {
                    sub.onNext("Hello, world!");
                    sub.onCompleted();
                }
            }
    );

    static Subscriber<String> mySubscriber = new Subscriber<String>() {
        @Override
        public void onNext(String s) {
            System.out.println(s);
        }

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
        }
    };

    public static void main(String[] args) {
        new MainHW().myObservable.subscribe(mySubscriber);
    }
}
