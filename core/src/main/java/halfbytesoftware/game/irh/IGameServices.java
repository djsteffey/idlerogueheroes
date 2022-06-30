package halfbytesoftware.game.irh;

public interface IGameServices {
    IPlatformServices getPlatformServices();
    void setNextScreen(AbstractScreen screen);
}
