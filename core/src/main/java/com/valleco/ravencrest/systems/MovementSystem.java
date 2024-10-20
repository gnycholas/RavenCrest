package com.valleco.ravencrest.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.valleco.ravencrest.components.PositionComponent;
import com.valleco.ravencrest.components.VelocityComponent;

public class MovementSystem extends IteratingSystem {

    public MovementSystem() {
        // Processar apenas entidades com PositionComponent e VelocityComponent
        super(Family.all(PositionComponent.class, VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = entity.getComponent(PositionComponent.class);
        VelocityComponent velocity = entity.getComponent(VelocityComponent.class);

        // Atualizar a posição com base na velocidade
        position.position.x += velocity.velocity.x * deltaTime;
        position.position.y += velocity.velocity.y * deltaTime;
    }
}
