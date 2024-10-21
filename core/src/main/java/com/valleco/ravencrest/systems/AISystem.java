package com.valleco.ravencrest.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.valleco.ravencrest.components.AIComponent;
import com.valleco.ravencrest.components.PositionComponent;
import com.valleco.ravencrest.components.VelocityComponent;

public class AISystem extends IteratingSystem {

    public AISystem() {
        // Processar todas as entidades que têm AIComponent, PositionComponent e VelocityComponent
        super(Family.all(AIComponent.class, PositionComponent.class, VelocityComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = entity.getComponent(PositionComponent.class);
        VelocityComponent velocity = entity.getComponent(VelocityComponent.class);
        AIComponent ai = entity.getComponent(AIComponent.class);

        // Atualizar a posição do NPC com base na velocidade atual
        position.position.x += velocity.velocity.x * deltaTime;
        position.position.y += velocity.velocity.y * deltaTime;

        // Incrementar a distância movida
        ai.distanceMoved += velocity.velocity.len() * deltaTime;

        // Verificar se o NPC já percorreu a distância necessária (30f)
        if (ai.distanceMoved >= ai.distanceToMove) {
            // Resetar a distância movida
            ai.distanceMoved = 0;

            // Escolher uma nova direção aleatória (cima, baixo, esquerda, direita)
            chooseNewDirection(velocity);
        }
    }

    // Metodo para escolher uma nova direção aleatória
    private void chooseNewDirection(VelocityComponent velocity) {
        float speed = 30f;  // Velocidade de movimento

        // Escolher aleatoriamente uma das quatro direções
        int direction = (int) (Math.random() * 4);  // Número aleatório entre 0 e 3

        switch (direction) {
            case 0:  // Direita
                velocity.velocity.set(speed, 0);
                break;
            case 1:  // Esquerda
                velocity.velocity.set(-speed, 0);
                break;
            case 2:  // Cima
                velocity.velocity.set(0, speed);
                break;
            case 3:  // Baixo
                velocity.velocity.set(0, -speed);
                break;
        }
    }
}
