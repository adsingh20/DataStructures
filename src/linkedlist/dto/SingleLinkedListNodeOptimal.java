package linkedlist.dto;

public class SingleLinkedListNodeOptimal extends SingleLinkedListNode{

    boolean isVisited;

    public SingleLinkedListNodeOptimal(int data) {
        super(data);
        this.isVisited = false;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
