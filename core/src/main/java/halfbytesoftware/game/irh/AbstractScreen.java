package halfbytesoftware.game.irh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class AbstractScreen implements Screen {
    // variables
    protected IGameServices m_gameServices;
    protected Stage m_stage;
    private float m_fpsTime;
    private int m_fpsFrames;
    private final Label m_fpsLabel;

    // methods
    public AbstractScreen(IGameServices game_services){
        this.m_gameServices = game_services;
        this.m_stage = new Stage(new FitViewport(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT));

        // fps
        this.m_fpsTime = 0.0f;
        this.m_fpsFrames = 0;
        this.m_fpsLabel = new Label("FPS: 0", GameAssetManager.getInstance().getLabelStyle(24));
        this.m_fpsLabel.setPosition(4, 4);
        this.m_stage.addActor(this.m_fpsLabel);
    }

    @Override
    public void dispose() {
        this.m_stage.dispose();
    }

    @Override
    public void render(float delta) {
        // fps
        this.m_fpsFrames += 1;
        this.m_fpsTime += delta;
        if (this.m_fpsTime >= 3.0f){
            this.m_fpsTime -= 3.0f;
            this.m_fpsLabel.setText("FPS: " + this.m_fpsFrames / 3);
            this.m_fpsFrames = 0;
            this.m_fpsLabel.toFront();
        }

        // update
        this.m_stage.act(delta);

        // draw
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.m_stage.draw();
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(this.m_stage);
    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resize(int width, int height) {
        this.m_stage.getViewport().update(width, height);
    }

    public Stage getStage(){
        return this.m_stage;
    }

    public void fadeIn(){
        Image image = new Image(GameAssetManager.getInstance().getTexture("pixel.png"));
        image.setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        image.setColor(0, 0, 0, 1);
        image.addAction(Actions.sequence(
                Actions.fadeOut(Config.SCREEN_TRANSITION_FADE_DURATION, Interpolation.circleIn),
                Actions.removeActor()
        ));
        this.m_stage.addActor(image);
    }

    public void fadeOut(){
        Image image = new Image(GameAssetManager.getInstance().getTexture("pixel.png"));
        image.setSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
        image.setColor(0, 0, 0, 0);
        image.addAction(Actions.sequence(
                Actions.fadeIn(Config.SCREEN_TRANSITION_FADE_DURATION, Interpolation.circleOut),
                Actions.removeActor()
        ));
        this.m_stage.addActor(image);
    }
}
