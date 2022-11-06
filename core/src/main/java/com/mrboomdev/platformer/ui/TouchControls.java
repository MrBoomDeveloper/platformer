package com.mrboomdev.platformer.ui;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mrboomdev.platformer.GameplayScene;
import com.mrboomdev.platformer.ui.Joystick;

public class TouchControls implements InputProcessor {
    public Joystick joystick;
    private SpriteBatch sprites;
    
    public TouchControls(SpriteBatch sprites) {
        this.sprites = sprites;
        joystick = new Joystick(sprites);
    }
    
    public void render() {
        joystick.render();
    }
    
    private void touchDetected(int x, int y) {
        joystick.update(x, y);
    }
    
    
	@Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        joystick.reset();
    	return false;
    }
    
    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        touchDetected(x, y);
        return false;
    }
    
    @Override
    public boolean touchDragged(int x, int y, int pointer) {
        touchDetected(x, y);
        return false;
    }
    
    
    @Override
    public boolean keyUp(int a) { return false; }
    
    @Override
    public boolean keyDown(int a) { return false; }
    
    @Override
    public boolean mouseMoved(int a, int b) { return false; }
    
    @Override
    public boolean keyTyped(char a) { return false; }
    
    @Override
    public boolean scrolled(float a, float b) { return false; }
}