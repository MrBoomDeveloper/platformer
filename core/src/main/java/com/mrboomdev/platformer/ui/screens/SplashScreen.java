package com.mrboomdev.platformer.ui.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mrboomdev.platformer.scenes.gameplay.GameplayScreen;
import com.mrboomdev.platformer.MainGame;
import com.mrboomdev.platformer.util.SizeUtil;

public class SplashScreen implements Screen {
	private MainGame game;
	private SpriteBatch batch;
	private Sprite logo, gradient;
	private float progress = 0;
	private final float LOGO_STAY_DURATION = 1.4f;
	
	public SplashScreen(MainGame game) {
		this.game = game;
	}

  @Override
  public void show() {
	  batch = new SpriteBatch();
	  
	  Texture logoTexture = new Texture(Gdx.files.internal("img/brand/dev_logo.png"));
	  Texture gradientTexture = new Texture(Gdx.files.internal("img/brand/gradient.png"));
	  
	  logo = new Sprite(logoTexture);
	  logo.setScale(.4f);
	  logo.setCenter(
	  	Gdx.graphics.getWidth() / 2, 
		  Gdx.graphics.getHeight() / 2
	  );
	  gradient = new Sprite(gradientTexture);
	  gradient.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
  }

  @Override
  public void render(float delta) {
	  Gdx.gl.glClearColor(17, 7, 31, progress);
	  batch.begin();
	  
	  progress += delta;
	  if(progress < 1) {
		  logo.setAlpha(progress);
		  gradient.setAlpha(progress);
	  } else if(progress > LOGO_STAY_DURATION + 1) {
		  float screenAlpha = (progress < LOGO_STAY_DURATION + 2) ? (LOGO_STAY_DURATION + 2 - progress) : 0;
		  logo.setAlpha(screenAlpha);
		  gradient.setAlpha(screenAlpha);
	  } else {
		  logo.setAlpha(1);
		  gradient.setAlpha(1);
	  }
	  
	  logo.draw(batch);
	  gradient.draw(batch);
	  
	  batch.end();
	  
	  if(progress > (LOGO_STAY_DURATION + 2.3)) {
		  game.setScreen(new GameplayScreen());
	  }
  }

  @Override
  public void pause() {}

  @Override
  public void resume() {}

  @Override
  public void hide() {}

  @Override
  public void dispose() {
	  batch.dispose();
  }
  
  @Override
  public void resize(int width, int height) {}
}