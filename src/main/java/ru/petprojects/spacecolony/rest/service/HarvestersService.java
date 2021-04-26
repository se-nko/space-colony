package ru.petprojects.spacecolony.rest.service;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.petprojects.spacecolony.model.resources.Garbage;
import ru.petprojects.spacecolony.model.resources.Helium;
import ru.petprojects.spacecolony.model.resources.Resource;
import ru.petprojects.spacecolony.model.resources.Uranium;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResourcesService {

    //TODO create thread safe container for resources
    List<Resource> resources;

    public Integer getCount() {
        return resources.size();
    }

    @PostConstruct
    public void postConstruct() {
        resources = new ArrayList<>();
        resources.add(new Garbage());
        resources.add(new Uranium());
        resources.add(new Uranium());
        resources.add(new Helium());
    }
}
