package com.example.commandes.health;

import com.example.commandes.Repository.CommandeRepository;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CommandeHealthIndicator implements HealthIndicator {

    private final CommandeRepository commandeRepository;

    public CommandeHealthIndicator(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public Health health() {
        if (commandeRepository.count() > 0) {
            return Health.up().withDetail("status", "UP").build();
        }
        return Health.down().withDetail("status", "DOWN").build();
    }
}
