package ru.petprojects.spacecolony.rest.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.petprojects.spacecolony.model.ResourceStorage;
import ru.petprojects.spacecolony.model.units.Harvester;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HarvestersService {

    @Value("${harvesters.count}")
    String HARVESTERS_COUNT;

    final ResourceStorage resourceStorage;
    ThreadPoolExecutor executor;

    public void create() {
        executor.execute(new Harvester(resourceStorage));
    }

    public Integer getActiveCount() {
        return  executor.getActiveCount();
    }

    @PostConstruct
    public void postConstruct() {
        int poolSize = 3;
        try {
            poolSize = Integer.parseInt(HARVESTERS_COUNT);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(poolSize);
    }

}
