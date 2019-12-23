package com.eric.tank.collidor;

import com.eric.tank.GameModel;
import com.eric.tank.GameObjects;

public interface Collidor {
    boolean collide(GameObjects o1, GameObjects o2);
}
