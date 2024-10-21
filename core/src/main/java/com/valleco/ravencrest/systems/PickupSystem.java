package com.valleco.ravencrest.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.valleco.ravencrest.components.PickupComponent;
import com.valleco.ravencrest.components.PositionComponent;

public class PickupSystem extends IteratingSystem {

    private static final float PICKUP_RADIUS = 10f; // Raio de coleta
    private final Entity player; // Referência ao jogador

    public PickupSystem(Entity player) {
        // O sistema deve processar todas as entidades que possuem PositionComponent e PickupComponent
        super(Family.all(PositionComponent.class, PickupComponent.class).get());
        this.player = player;
    }

    @Override
    protected void processEntity(Entity item, float deltaTime) {
        PositionComponent itemPosition = item.getComponent(PositionComponent.class);
        PositionComponent playerPosition = player.getComponent(PositionComponent.class);

        // Verificar a distância entre o jogador e o item
        float distance = playerPosition.position.dst(itemPosition.position);

        // Se a distância for menor que o raio de coleta, remover o item
        if (distance < PICKUP_RADIUS) {
            getEngine().removeEntity(item); // Remover o item do jogo
        }
    }
}

