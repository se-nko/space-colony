package ru.petprojects.spacecolony.model.units;

import lombok.extern.slf4j.Slf4j;
import ru.petprojects.spacecolony.model.ResourceStorage;
import ru.petprojects.spacecolony.model.resources.Helium;
import ru.petprojects.spacecolony.model.resources.Uranium;

@Slf4j
public class Harvester extends Unit implements Runnable {

    private final int ENERGY_CONSUMPTION = 2;

    private ResourceStorage storage;

    public Harvester(ResourceStorage storage) {
        super.armor = 5;
        super.health = 100;
        super.energy = 100;
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (energy > 0) {
                Thread.sleep(5000);
                double random = Math.random() * 50;
                if (random >= 0 && random <= 15) {
                    storage.put(new Helium());
                    log.info(String.format("The harvester № %d has got a helium", Thread.currentThread().getId()));
                }
                if (random > 35 && random <= 50) {
                    storage.put(new Uranium());
                    log.info(String.format("The harvester № %d has got an uranium", Thread.currentThread().getId()));
                }
                energy -= ENERGY_CONSUMPTION;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        finally {
            log.info(String.format("The harvester № %d has stopped", Thread.currentThread().getId()));
        }
    }
}
