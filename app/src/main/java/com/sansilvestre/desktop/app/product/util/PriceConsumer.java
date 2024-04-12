package com.sansilvestre.desktop.app.product.util;

import java.awt.event.KeyEvent;

@FunctionalInterface
public interface PriceConsumer {

    void proccess(KeyEvent e);

}