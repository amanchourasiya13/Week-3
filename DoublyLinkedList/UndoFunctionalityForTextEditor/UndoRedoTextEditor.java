package day1.DoublyLinkedList.UndoFunctionalityForTextEditor;

class TextState {
    String textContent;
    TextState next;
    TextState prev;

    public TextState(String textContent) {
        this.textContent = textContent;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private TextState currentState;
    private int historySize;
    private int currentSize;
    private int maxHistorySize;

    public TextEditor(int maxHistorySize) {
        this.currentState = null;
        this.historySize = 0;
        this.maxHistorySize = maxHistorySize;
    }

    // Add new state to the history
    public void addTextState(String newText) {
        TextState newState = new TextState(newText);

        if (currentState == null) {
            currentState = newState; // first state in the history
        } else {
            currentState.next = newState;
            newState.prev = currentState;
            currentState = newState; // Move to the new current state
        }

        // If history size exceeds the maximum limit, remove the oldest state
        if (historySize >= maxHistorySize) {
            removeOldestState();
        } else {
            historySize++;
        }
    }

    // Undo functionality (go back to previous state)
    public void undo() {
        if (currentState == null || currentState.prev == null) {
            System.out.println("No previous state to undo.");
        } else {
            currentState = currentState.prev;
            System.out.println("Undo: " + currentState.textContent);
        }
    }

    // Redo functionality (go forward to next state after undo)
    public void redo() {
        if (currentState == null || currentState.next == null) {
            System.out.println("No next state to redo.");
        } else {
            currentState = currentState.next;
            System.out.println("Redo: " + currentState.textContent);
        }
    }

    // Display the current state of the text
    public void displayCurrentState() {
        if (currentState == null) {
            System.out.println("No text content available.");
        } else {
            System.out.println("Current state: " + currentState.textContent);
        }
    }

    // Remove the oldest state when history exceeds the max size
    private void removeOldestState() {
        if (currentState == null) return;

        // Remove the oldest state (head of the doubly linked list)
        TextState temp = currentState;
        while (temp.prev != null) {
            temp = temp.prev;
        }

        if (temp.next != null) {
            temp.next.prev = null; // Disconnect the next node from the removed node
        }

        temp = null; // Remove reference to the oldest node
        historySize--; // Decrease the history size
    }
}

public class UndoRedoTextEditor {
    public static void main(String[] args) {
        // Create a text editor with a history limit of 10 states
        TextEditor editor = new TextEditor(10);

        // Add some text states
        editor.addTextState("Hello");
        editor.addTextState("Hello, World");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World!!");

        // Display current state
        editor.displayCurrentState();

        // Undo some actions
        editor.undo(); // Should go back to "Hello, World!"
        editor.undo(); // Should go back to "Hello, World"
        editor.undo(); // Should go back to "Hello"
        editor.undo(); // No previous state, should show an error

        // Redo some actions
        editor.redo(); // Should go forward to "Hello, World"
        editor.redo(); // Should go forward to "Hello, World!"
        editor.redo(); // No next state, should show an error

        // Display the current state after all operations
        editor.displayCurrentState();

        // Add more states and exceed the history limit
        for (int i = 0; i < 15; i++) {
            editor.addTextState("State " + i);
        }

        // Display the final state
        editor.displayCurrentState();
    }
}

