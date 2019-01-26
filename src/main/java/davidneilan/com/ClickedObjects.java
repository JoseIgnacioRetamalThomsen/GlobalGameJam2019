package davidneilan.com;

public class ClickedObjects {
    private Item item;
    private SceneObject sceneObject;

    public boolean hasItem() {
        return item != null;
    }

    public boolean hasSceneObject() {
        return sceneObject != null;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SceneObject getSceneObject() {
        return sceneObject;
    }

    public void setSceneObject(SceneObject sceneObject) {
        this.sceneObject = sceneObject;
    }
}
