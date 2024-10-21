package com.valleco.ravencrest.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.valleco.ravencrest.entities.EntityFactory;
import com.valleco.ravencrest.systems.RenderingSystem;
import com.valleco.ravencrest.systems.InputSystem;
import com.valleco.ravencrest.systems.MovementSystem;

public class GameScreen implements Screen {

    Texture playerTexture, npcTexture;

    private Engine engine;
    private SpriteBatch batch;

    @Override
    public void show() {
        engine = new Engine();
        batch = new SpriteBatch();

        // Adicionar sistemas ao engine
        engine.addSystem(new RenderingSystem(batch));
        engine.addSystem(new InputSystem());
        engine.addSystem(new MovementSystem());  // Novo: Adicionando o MovementSystem

        // Criar a entidade jogador
        playerTexture = new Texture(Gdx.files.internal("assets/PlaceHolders/Sprites/idol1.png"));
        engine.addEntity(EntityFactory.createPlayer(100, 100, playerTexture));

        // Criar a entidade NPC que se move automaticamente
        npcTexture = new Texture(Gdx.files.internal("assets/PlaceHolders/Sprites/Eidol1.png"));
        engine.addEntity(EntityFactory.createMovingNPC(200, 200, npcTexture, 50f, 0f));  // Movimento na direção X
    }

    @Override
    public void render(float delta) {
        // Limpar a tela com uma cor preta
        ScreenUtils.clear(0, 0, 0, 0, true);

        // Atualizar o engine (que processa todos os sistemas, incluindo Movement e Input)
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        playerTexture.dispose();
        npcTexture.dispose();
    }
}
