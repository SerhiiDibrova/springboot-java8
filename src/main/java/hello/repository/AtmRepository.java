package hello.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AtmRepository {
    private Map<String, AtmState> atmState;
    private Lock lock;

    public AtmRepository() {
        this.atmState = new ConcurrentHashMap<>();
        this.lock = new ReentrantLock();
    }

    public void saveAtm(String id, AtmState state) {
        try {
            lock.lock();
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id cannot be null or empty");
            }
            if (state == null) {
                throw new IllegalArgumentException("State cannot be null");
            }
            atmState.put(id, state);
        } catch (Exception e) {
            throw new RuntimeException("Error saving ATM state", e);
        } finally {
            lock.unlock();
        }
    }

    public AtmState getAtm(String id) {
        try {
            lock.lock();
            if (id == null || id.isEmpty()) {
                throw new IllegalArgumentException("Id cannot be null or empty");
            }
            return atmState.get(id);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving ATM state", e);
        } finally {
            lock.unlock();
        }
    }

    public static class AtmState {
        private String status;
        private int cash;

        public AtmState(String status, int cash) {
            this.status = status;
            this.cash = cash;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getCash() {
            return cash;
        }

        public void setCash(int cash) {
            this.cash = cash;
        }
    }
}