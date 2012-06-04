package com.google.gwt.sample.stockwatcher.client;

import org.ez18n.apt.Label;
import org.ez18n.apt.LabelBundle;

@LabelBundle
public interface LabelResources {

    @Label("Symbol")
    String symbol();

    @Label("Price")
    String price();

    @Label("Change")
    String change();

    @Label("Remove")
    String remove();

    @Label("Last update : ")
    String lastUpdate();
    
    @Label("Add")
    String add();
}
