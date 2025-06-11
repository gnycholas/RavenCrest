package com.valleco.ravencrest.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.valleco.ravencrest.enums.Direction;
import java.util.EnumMap;
import java.util.Map;

public class AnimationComponent implements Component {
    public Map<Direction, Animation<TextureRegion>> animations = new EnumMap<>(Direction.class);
    public Animation<TextureRegion> currentAnimation;
    public float stateTime = 0f;
    public Direction direction = Direction.DOWN;
}
