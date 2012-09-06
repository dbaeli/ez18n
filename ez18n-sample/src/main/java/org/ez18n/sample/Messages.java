package org.ez18n.sample;

import org.ez18n.apt.Label;
import org.ez18n.apt.LabelBundle;

@LabelBundle
public interface Messages {

  @Label("Love Me Tender")
  String loveMeTender();

  @Label("I love {0}")
  String doYouLove(String name);

}
