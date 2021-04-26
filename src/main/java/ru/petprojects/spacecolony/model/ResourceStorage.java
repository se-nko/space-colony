package ru.petprojects.spacecolony.model;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import ru.petprojects.spacecolony.model.resources.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourceStorage {

    int capacity, freeSpace;
    Stack<Resource> storage;

    public ResourceStorage(int capacity) {
        this.capacity = capacity;
        this.freeSpace = capacity;
        this.storage = new Stack<>();
    }

    public synchronized void put(Resource resource) {
        if ((freeSpace - resource.getWeight()) > 0) {
            storage.push(resource);
            freeSpace -= resource.getWeight();
        }
    }

    public int getSize() {
        return freeSpace;
    }

    public synchronized void clear() {
        storage.clear();
        freeSpace = capacity;

    }

    public List<Resource> getAllResources() {
        return new ArrayList<>(storage);
    }
}
