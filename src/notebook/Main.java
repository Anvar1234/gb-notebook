package notebook;

import notebook.controller.NotebookFacade;


public class Main {
    public static void main(String[] args) {
        NotebookFacade notebook = new NotebookFacade();
        notebook.run();
    }
}
