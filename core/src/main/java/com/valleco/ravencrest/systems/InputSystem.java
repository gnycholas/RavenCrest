package com.valleco.ravencrest.systems;

import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.valleco.ravencrest.components.PlayerComponent;
import com.valleco.ravencrest.components.PositionComponent;
import com.valleco.ravencrest.components.AnimationComponent;
import com.valleco.ravencrest.enums.Direction;

public class InputSystem extends IteratingSystem {

    private static final float SPEED = 100f; // Velocidade de movimento

    public InputSystem(){
        // O sistema só vai processar entidades que possuem o PositionComponent
        super(Family.all(PositionComponent.class, PlayerComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime){
        PositionComponent position = entity.getComponent(PositionComponent.class);
        AnimationComponent animation = entity.getComponent(AnimationComponent.class);

        // Verificar as entradas de teclado e ajustar a posição
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            position.position.x -= SPEED * deltaTime;
            if(animation != null) animation.direction = Direction.LEFT;
        } else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            position.position.x += SPEED * deltaTime;
            if(animation != null) animation.direction = Direction.RIGHT;
        } else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            position.position.y += SPEED * deltaTime;
            if(animation != null) animation.direction = Direction.UP;
        } else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            position.position.y -= SPEED * deltaTime;
            if(animation != null) animation.direction = Direction.DOWN;
        }
    }
}
