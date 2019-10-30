package mx.gob.impi.chatbot.persistence.support;

import ch.qos.logback.core.rolling.RollingFileAppender;

public class CustomAppender<E> extends RollingFileAppender<E> {
    // https://stackoverflow.com/questions/32344977/logback-rollingfileappender-rolling-at-fixed-time
    private long start = System.currentTimeMillis();
    private int rollOverTimeInMinutes = 60;

    @Override
    public void rollover() {
        long currentTime = System.currentTimeMillis();
        int maxIntervalSinceLastLoggingInMillis = rollOverTimeInMinutes * 60 * 1000;

        if ((currentTime - start) >= maxIntervalSinceLastLoggingInMillis) {
            super.rollover();
            this.start = System.currentTimeMillis();
        }
    }
}

