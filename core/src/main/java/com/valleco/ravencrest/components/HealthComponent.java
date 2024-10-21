package com.valleco.ravencrest.components;

import com.badlogic.ashley.core.Component;

public class HealthComponent implements Component {
    public int health = 100;  // Vida inicial do jogador
    public int maxHealth = 100;  // Vida máxima do jogador
}
