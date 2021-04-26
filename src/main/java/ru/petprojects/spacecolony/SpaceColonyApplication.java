package ru.petprojects.spacecolony;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.petprojects.spacecolony.model.ResourceStorage;

@Slf4j
@SpringBootApplication
public class SpaceColonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpaceColonyApplication.class, args);
	}

	@Bean
	public ResourceStorage resourceStorage(@Value("${storage.capacity}") String capacity) {
		int c = 100;
		try {
			c = Integer.parseInt(capacity);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return new ResourceStorage(c);
	}

}
