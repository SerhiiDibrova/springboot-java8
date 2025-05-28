package hello.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtmRepository {
    private Map<String, Object> atmState;
    private Lock lock;

    public AtmRepository() {
        this.atmState = new ConcurrentHashMap<>();
        this.lock = new ReentrantLock();
    }

    public void saveAtm(String id, Object state) {
        try {
            lock.lock();
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id cannot be null or empty");
            }
            if (state == null) {
                throw new IllegalArgumentException("State cannot be null");
            }
            atmState.put(id, state);
        } finally {
            lock.unlock();
        }
    }

    public Object getAtm(String id) {
        try {
            lock.lock();
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id cannot be null or empty");
            }
            return atmState.get(id);
        } finally {
            lock.unlock();
        }
    }

    public void updateAtm(String id, Object state) {
        try {
            lock.lock();
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id cannot be null or empty");
            }
            if (state == null) {
                throw new IllegalArgumentException("State cannot be null");
            }
            if (atmState.containsKey(id)) {
                atmState.put(id, state);
            } else {
                throw new IllegalStateException("ATM with id " + id + " does not exist");
            }
        } finally {
            lock.unlock();
        }
    }

    public void deleteAtm(String id) {
        try {
            lock.lock();
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id cannot be null or empty");
            }
            if (atmState.containsKey(id)) {
                atmState.remove(id);
            } else {
                throw new IllegalStateException("ATM with id " + id + " does not exist");
            }
        } finally {
            lock.unlock();
        }
    }
}