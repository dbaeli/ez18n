package org.ez18n.sample;

public class PostCard {
    private final SampleResources resources;

    public PostCard(SampleResources resources) {
        this.resources = resources;
    }
    
    public String getText() {
        return resources.loveMeTender();
    }
}
