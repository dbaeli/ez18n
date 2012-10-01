package org.ez18n.apt.processor;

import org.junit.Test;
import org.spell6r.Spell6rChecker;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 */
public class Spell6rProcessorTest {
  @Test
  public void testConstructor(){
    Spell6rMessagesProcessor processor = new Spell6rMessagesProcessor();
    assertNotNull(processor);
  }

  @Test
  public void testSpellChecker() {
    Spell6rMessagesProcessor spellEn = new Spell6rMessagesProcessor();
    assertTrue(spellEn.spell.isCorrect("Hello"));
    assertTrue(spellEn.spell.isCorrect("Spellme"));
  }

}
