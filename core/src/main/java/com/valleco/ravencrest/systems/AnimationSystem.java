package com.valleco.ravencrest.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.valleco.ravencrest.components.AnimationComponent;
import com.valleco.ravencrest.components.RenderComponent;

public class AnimationSystem extends IteratingSystem {
    public AnimationSystem() {
        super(Family.all(AnimationComponent.class, RenderComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        AnimationComponent anim = entity.getComponent(AnimationComponent.class);
        anim.stateTime += deltaTime;
        RenderComponent render = entity.getComponent(RenderComponent.class);
        render.region = anim.animations.get(anim.direction).getKeyFrame(anim.stateTime);
    }
}
