package org.ez18n.sample;

import org.ez18n.runtime.BundleFactory;
import org.ez18n.runtime.Desktop;

public class PostCard {

	private final Messages messages;

	public PostCard(Messages resources) {
		this.messages = resources;
	}

	public String getText() {
		return messages.loveMeTender();
	}

	public String getLoveText(String name) {
		return messages.doYouLove(name);
	}

	public static final void main(String... args) {
		final Messages bundle = BundleFactory.get(Messages.class, Desktop.class);
		System.out.println(bundle.doYouLove("Mum"));
	}
}
