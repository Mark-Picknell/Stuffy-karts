package com.picknell.game.stuffykarts;

import com.jme3.app.SimpleApplication;

/**
 * Shared Stuffy Karts game application.
 *
 * Platform-specific launchers live in the desktop and Android modules.
 */
public final class StuffyKarts extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(false);
    }
}
