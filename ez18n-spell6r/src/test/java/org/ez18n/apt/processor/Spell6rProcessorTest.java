package org.ez18n.apt.processor;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

/**
 */
public class Spell6rProcessorTest {
  @Test
  public void testConstructor(){
    Spell6rMessagesProcessor processor = new Spell6rMessagesProcessor();
    assertNotNull(processor);
  }
}
