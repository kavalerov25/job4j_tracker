package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringJoiner;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        String path = cachingDir + "/" + key;
        StringJoiner strings = new StringJoiner(",");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            bufferedReader.lines().forEach(strings::add);
            put(key, strings.toString());
        } catch (Exception err) {
            err.printStackTrace();
        }
        return strings.toString();
    }
}