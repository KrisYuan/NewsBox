package com.awesomekris.android.newsbox.utils;

import junit.framework.Assert;

import java.util.concurrent.Callable;

/**
 * Created by kris on 16/10/3.
 */
public abstract class PollingCheck {
    private static final long TIME_SLICE = 50;
    private long mTimeout = 3000;

    public PollingCheck() {
    }

    public PollingCheck(long timeout) {
        mTimeout = timeout;
    }

    protected abstract boolean check();

    public void run() {
        if (check()) {
            return;
        }

        long timeout = mTimeout;
        while (timeout > 0) {
            try {
                Thread.sleep(TIME_SLICE);
            } catch (InterruptedException e) {
                Assert.fail("unexpected InterruptedException");
            }

            if (check()) {
                return;
            }

            timeout -= TIME_SLICE;
        }

        Assert.fail("unexpected timeout");
    }

    public static void check(CharSequence message, long timeout, Callable<Boolean> condition)
            throws Exception {
        while (timeout > 0) {
            if (condition.call()) {
                return;
            }

            Thread.sleep(TIME_SLICE);
            timeout -= TIME_SLICE;
        }

        Assert.fail(message.toString());
    }
}
