package com.valleco.ravencrest.components;

import com.badlogic.ashley.core.Component;

public class AIComponent implements Component {
    public float distanceMoved = 0;  // Distância que o NPC já se moveu na direção atual
    public float distanceToMove = 30f;  // Distância fixa que ele deve se mover
}
