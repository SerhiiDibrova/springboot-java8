package hello.service;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class SettingsService {
    private static Settings settingsCache;
    private static final Lock lock = new ReentrantLock();

    public Settings getSettings() {
        if (settingsCache == null) {
            lock.lock();
            try {
                if (settingsCache == null) {
                    YamlConfigService yamlConfigService = new YamlConfigService();
                    settingsCache = yamlConfigService.loadSettings();
                    if (settingsCache == null) {
                        throw new RuntimeException("Failed to load settings");
                    }
                }
            } finally {
                lock.unlock();
            }
        }
        return settingsCache;
    }
}