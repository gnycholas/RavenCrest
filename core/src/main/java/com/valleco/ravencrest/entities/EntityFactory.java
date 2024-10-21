package com.valleco.ravencrest.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.valleco.ravencrest.components.*;

public class EntityFactory {

    public static Entity createPlayer(float x, float y, Texture texture) {
        Entity entity = new Entity();

        PositionComponent position = new PositionComponent();
        position.position.set(x, y);

        RenderComponent render = new RenderComponent();
        render.texture = texture;

        PlayerComponent player = new PlayerComponent();

        HealthComponent health = new HealthComponent();

        entity.add(position);
        entity.add(render);
        entity.add(player);
        entity.add(health);

        return entity;
    }

    public static Entity createMovingNPC(float x, float y, Texture texture, float velocityX, float velocityY) {
        Entity entity = new Entity();

        PositionComponent position = new PositionComponent();
        position.position.set(x, y);

        RenderComponent render = new RenderComponent();
        render.texture = texture;

        VelocityComponent velocity = new VelocityComponent();
        velocity.velocity.set(velocityX, velocityY); // Definir a velocidade de movimento

        AIComponent ai = new AIComponent();

        entity.add(position);
        entity.add(render);
        entity.add(velocity);
        entity.add(ai);

        return entity;
    }

    public static Entity createItem(float x, float y, Texture texture) {
        Entity entity = new Entity();

        PositionComponent position = new PositionComponent();
        position.position.set(x, y);

        RenderComponent render = new RenderComponent();
        render.texture = texture;

        PickupComponent pickup = new PickupComponent(); // Componente que marca o item como coletável

        entity.add(position);
        entity.add(render);
        entity.add(pickup);

        return entity;
    }

}
