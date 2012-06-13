package org.ez18n.sample;

import org.ez18n.apt.Label;
import org.ez18n.apt.LabelBundle;

@LabelBundle
public interface SampleResources {

    @Label("Love Me Tender")
    String loveMeTender();
}
