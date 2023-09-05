package e3;

public class TextEditor {

    private Command saveComand;

    public TextEditor(){
        saveComand = new SaveCommand();
    }

    public void onPressSaveButton(){
        System.out.println("[Saved button]");
        saveComand.execute();
    }
    public void onPressSaveOption(){
        System.out.println("[Menu]");
        saveComand.execute();
    }
    public void onShortcut(){
        System.out.println("[Shortcut]");
        saveComand.execute();
    }
}
