package logger;

import entities.Event;

import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger{
    private int cacheSize;
    private List<Event> cache;

    public CacheFileEventLogger(int cacheSize, String filename) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if(cache.size() == cacheSize){
            writeEvensFromCache();
            cache.clear();
        }
    }

    private void destroy(){
        if(!cache.isEmpty()){
            writeEvensFromCache();
        }
    }

    private void writeEvensFromCache() {
        for(Event event : cache){
            super.logEvent(event);
        }
    }
}
