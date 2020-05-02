package com.firstquad.sandbox.concurrency.tasks.philosopher;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class Fork {
    private AtomicBoolean isUsing = new AtomicBoolean();
    private Fork nextFork = null;

    public Fork(boolean isUsing) {
        this.isUsing.set(isUsing);
    }

    public Fork(boolean isUsing, Fork nextFork) {
        this.isUsing.set(isUsing);
        this.nextFork = nextFork;
    }

    public boolean isUsing() {
        return isUsing.get();
    }

    public void setIsUsing(Boolean isUsing) {
        this.isUsing.set(isUsing);
    }

    public Fork getNextFork() {
        return nextFork;
    }

    public void setNextFork(Fork nextFork) {
        this.nextFork = nextFork;
    }
}
