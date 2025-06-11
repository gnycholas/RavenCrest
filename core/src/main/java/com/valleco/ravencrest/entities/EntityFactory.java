package com.valleco.ravencrest.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.valleco.ravencrest.enums.Direction;
import com.valleco.ravencrest.components.*;

public class EntityFactory {

    public static Entity createPlayer(float x, float y, TextureAtlas atlas) {
        Entity entity = new Entity();

        PositionComponent position = new PositionComponent();
        position.position.set(x, y);

        RenderComponent render = new RenderComponent();
        render.region = atlas.findRegion("down", 0);

        AnimationComponent animation = new AnimationComponent();
        animation.animations.put(Direction.DOWN,
            new Animation<>(0.15f, atlas.findRegions("down"), Animation.PlayMode.LOOP));
        animation.animations.put(Direction.UP,
            new Animation<>(0.15f, atlas.findRegions("up"), Animation.PlayMode.LOOP));
        animation.animations.put(Direction.LEFT,
            new Animation<>(0.15f, atlas.findRegions("side"), Animation.PlayMode.LOOP));
        animation.animations.put(Direction.RIGHT,
            new Animation<>(0.15f, atlas.findRegions("side"), Animation.PlayMode.LOOP));

        PlayerComponent player = new PlayerComponent();

        HealthComponent health = new HealthComponent();

        entity.add(position);
        entity.add(render);
        entity.add(animation);
        entity.add(player);
        entity.add(health);

        return entity;
    }

    public static Entity createMovingNPC(float x, float y, Texture texture, float velocityX, float velocityY) {
        Entity entity = new Entity();

        PositionComponent position = new PositionComponent();
        position.position.set(x, y);

        RenderComponent render = new RenderComponent();
        render.region = new TextureRegion(texture);

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
        render.region = new TextureRegion(texture);

        PickupComponent pickup = new PickupComponent(); // Componente que marca o item como coletável

        entity.add(position);
        entity.add(render);
        entity.add(pickup);

        return entity;
    }

}
