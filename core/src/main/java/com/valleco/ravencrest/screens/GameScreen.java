package com.valleco.ravencrest.screens;

import com.badlogic.ashley.core.Engine;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.valleco.ravencrest.entities.EntityFactory;
import com.valleco.ravencrest.systems.InputSystem;
import com.valleco.ravencrest.systems.RenderingSystem;

public class GameScreen implements Screen {

    private Engine engine;
    private SpriteBatch batch;

    @Override
    public void show() {
        engine = new Engine();
        batch = new SpriteBatch();

        // Adicionar sistemas ao engine
        engine.addSystem(new RenderingSystem(batch));
        engine.addSystem(new InputSystem());

        // Criar a entidade jogador e adicionar ao engine
        Texture playerTexture = new Texture(Gdx.files.internal("assets/PlaceHolders/Sprites/idol1.png"));
        engine.addEntity(EntityFactory.createPlayer(100, 100, playerTexture));
    }

    @Override
    public void render(float delta) {
        // Apagar as imagens antigtas que foram armazendas no Buffer
        ScreenUtils.clear(1, 1, 1, 1, true);
        // Atualiza o engine, que processa os sistemas (incluindo o RenderingSystem)
        engine.update(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
