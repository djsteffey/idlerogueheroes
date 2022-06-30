package halfbytesoftware.game.irh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.Align;

import java.util.Random;

public class Utils {
    // random
    private static final Random s_random = new Random();
    public static int randomInt(int min, int max){
        return Utils.s_random.nextInt(max - min) + min;
    }
    public static long randomLong(long min, long max){
        return (long)(Math.random() * (max - min)) + min;
    }
    public static float randomFloat(float min, float max){
        return Utils.s_random.nextFloat() * (max - min) + min;
    }
    public static boolean randomBool(float chance){
        return randomFloat(0.0f, 1.0f) < chance;
    }
    public static boolean randomBool(){
        return randomBool(0.50f);
    }
    public static Color randomColor(){
        return new Color(Utils.randomFloat(0, 1), Utils.randomFloat(0, 1), Utils.randomFloat(0, 1), 1);
    }
    public static Vector2 randomVector2(float min, float max){
        float angle = Utils.randomFloat(0, (float)(2 * Math.PI));
        float mag = Utils.randomFloat(min, max);
        return new Vector2((float)(Math.sin(angle) * mag), (float)(Math.cos(angle) * mag));
    }

    // ids
    private static long s_nextId = 0;
    public static long generateId(){
        return Utils.s_nextId++;
    }

    // color
    public static Color colorMultiply(Color color, float amount){
        color.r *= amount;
        color.g *= amount;
        color.b *= amount;
        return color;
    }
    public static Color colorAlpha(Color color, float alpha){
        color.a = alpha;
        return color;
    }

    // distance
    public static float getEuclideanDistance(float x1, float y1, float x2, float y2){
        float dx = x2 - x1;
        float dy = y2 - y1;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }
    public static Vector2 getDirection(float x1, float y1, float x2, float y2){
        return new Vector2((x2 - x1), (y2 - y1));
    }
    public static float getDistance(Actor a, Actor b){
        return Utils.getEuclideanDistance(a.getX(Align.center), a.getY(Align.center), b.getX(Align.center), b.getY(Align.center));
    }

    // collisions
    public static boolean circleRectangleCollision(float cx, float cy, float cr, float rx, float ry, float rw, float rh, float radiusMultiplier){
        // http://www.jeffreythompson.org/collision-detection/circle-rect.php

        // temporary variables to set edges for testing
        float testX = cx;
        float testY = cy;

        // which edge is closest?
        if (cx < rx){
            testX = rx;      // test left edge
        }
        else if (cx > rx + rw){
            testX = rx + rw;   // right edge
        }
        if (cy < ry){
            testY = ry;      // bottom edge
        }
        else if (cy > ry + rh){
            testY = ry + rh;   // top edge
        }

        // get distance from closest edges
        float distX = cx - testX;
        float distY = cy - testY;
        float distanceSquared = (distX * distX) + (distY * distY);

        // if the distance is less than the radius, collision!
        if (distanceSquared <= cr * cr * radiusMultiplier * radiusMultiplier) {
            return true;
        }
        return false;
    }

    // misc
    public static void enableButton(Button button, boolean enable){
        button.setDisabled(!enable);
        button.setTouchable(enable ? Touchable.enabled : Touchable.disabled);
    }
    public static String formatDouble(double value, int places){
        // power is based on places
        long power = (long) Math.pow(10, places);

        // whole number multiplied out
        long working = (long) (value * power);

        // compute whole part
        long whole = working / power;

        // compute fraction
        long fraction = working % power;

        // get rid of training zeros for the fraction
        while (fraction > 0 && fraction % 10 == 0){
            fraction /= 10;
        }

        // done
        if (fraction > 0){
            return "" + whole + "." + fraction;
        }
        else {
            return "" + whole;
        }
    }
}
