package com.valleco.ravencrest.entities;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.graphics.Texture;
import com.valleco.ravencrest.components.PositionComponent;
import com.valleco.ravencrest.components.RenderComponent;

public class EntityFactory {

    public static Entity createPlayer(float x, float y, Texture texture){
        Entity entity = new Entity();

        PositionComponent position = new PositionComponent();
        position.position.set(x, y);

        RenderComponent render = new RenderComponent();
        render.texture = texture;

        entity.add(position);
        entity.add(render);

        return entity;
    }

}
