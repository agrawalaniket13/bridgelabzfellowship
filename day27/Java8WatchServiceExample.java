import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;

public class Java8WatchServiceExample {
    private final WatchService watcher;
    private final Map<WatchKey, Path> dirWatchers;
    private WatchKey Key;

    /* Creates a WatchService and registers the given directory */
    Java8WatchServiceExample(Path dir) throws IOException{
        this.watcher = FileSystems.getDefault().newWatchService();
        this.dirWatchers = new HashMap<WatchKey, Path>();
        scanAndRegisterDirectories(dir);
    }

    /* Register the given directories with the WatchService; */
    private void registerDirWatchers(Path dir) throws IOException{
        WatchKey key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
        dirWatchers.put(key, dir);
    }

    /* Register the given directories and all its sub-directories, with the WatchService */
    private void scanAndRegisterDirectories(final Path start) throws IOException{
        // register directories and sub-directories
        Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
                registerDirWatchers(dir);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /* Process all events for keys queued to the watcher */
    @SuppressWarnings({"rawtypes","unchecked"})
    void processEvents(){
        while (true){
            WatchKey key;
            try{
                key = watcher.take();
            } catch (InterruptedException x){
                return;
            }
            Path dir = dirWatchers.get(key);
            if (dir == null) continue;
            for (WatchEvent<?> event : key.pollEvents()){
                WatchEvent.Kind Kind = event.kind();
                Path name = ((WatchEvent<Path>)event).context();
                Path child = dir.resolve(name);
                System.out.format("%s: %s\n", event.kind().name(),child);

                if (Kind == ENTRY_CREATE){
                    try {
                        if (Files.isDirectory(child)) scanAndRegisterDirectories(child));
                    } catch (IOException x){}
                } else if (Kind.equals(ENTRY_DELETE)){
                    if (Files.isDirectory(child)) dirWatchers.remove(Key);
                }
            }
            // reset key and remove from set if directories no longer accessible
            boolean valid = key.reset();
            if (!valid){
                dirWatchers.remove(Key);
                if (dirWatchers.isEmpty()) break;
            }
        }
    }
}
