package com.google.gwt.sample.stockwatcher.client;

import org.ez18n.apt.Label;
import org.ez18n.apt.LabelBundle;

@LabelBundle
public interface LabelResources {

    @Label(value = "Symbol", mobile = "SYMBOL")
    String symbol();

    @Label(value = "Price", mobile = "PRICE")
    String price();

    @Label(value = "Change", mobile = "CHANGE")
    String change();

    @Label(value = "Remove", mobile = "REMOVE")
    String remove();

    @Label("Last update : ")
    String lastUpdate();

    @Label("Add")
    String add();
}
