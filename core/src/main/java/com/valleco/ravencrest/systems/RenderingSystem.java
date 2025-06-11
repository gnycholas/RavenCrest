package com.valleco.ravencrest.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.valleco.ravencrest.components.PositionComponent;
import com.valleco.ravencrest.components.RenderComponent;

public class RenderingSystem extends IteratingSystem {

    private final SpriteBatch batch;

    // Construtor do sistema, configurando para operar em entidades com PositionComponent e RenderComponent
    public RenderingSystem(SpriteBatch batch){
        super(Family.all(PositionComponent.class, RenderComponent.class).get());
        this.batch = batch;
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime){
        PositionComponent position = entity.getComponent(PositionComponent.class);
        RenderComponent render = entity.getComponent(RenderComponent.class);

        batch.begin();
        if(render.region != null) {
            batch.draw(render.region, position.position.x, position.position.y);
        }
        batch.end();
    }
}
