package ru.petprojects.spacecolony.rest.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.petprojects.spacecolony.model.ResourceStorage;
import ru.petprojects.spacecolony.model.resources.Resource;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourcesService {

    final ResourceStorage storage;

    public Integer getCount() {
        return storage.getSize();
    }

    public List<Resource> getAll() {
        return storage.getAllResources();
    }

    public void clear() {
        storage.clear();
    }

}
