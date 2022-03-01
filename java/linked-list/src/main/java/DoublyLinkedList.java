import java.util.ArrayList;
import java.util.List;

class Node<T> {
    private T nodeValue;
    private Node<T> nextNode;
    private Node<T> previousNode;

    Node(T value) { this.nodeValue = value; }

    T getNodeValue() { return this.nodeValue; }
    void setNodeValue(T value) { this.nodeValue = value; }

    Node<T> getNextNode() { return this.nextNode; }
    void setNextNode(Node<T> nextNode) { this.nextNode = nextNode; }

    Node<T> getPreviousNode() { return this.previousNode; }
    void setPreviousNode(Node<T> previousNode) { this.previousNode = previousNode; }
}

public class DoublyLinkedList<T> {
    private final List<Node<T>> firstAndLastNodesList;

    public DoublyLinkedList() {
        this.firstAndLastNodesList = new ArrayList<>(2);
    }
    private Node<T> getFirstNode() { return this.firstAndLastNodesList.get(0); }
    private void setFirstNode(Node<T> node) { this.firstAndLastNodesList.set(0, node); }
    private Node<T> getLastNode() { return this.firstAndLastNodesList.get(1); }
    private void setLastNode(Node<T> node) { this.firstAndLastNodesList.set(1, node); }

    private int sizeOfFirstAndLastNodesList() { return this.firstAndLastNodesList.size(); }
    private void pushNodeToFirstAndLastNodeList(Node<T> node) { this.firstAndLastNodesList.add(node); }
    private void removeLastNodeFromFirstAndLastNodeList() { this.firstAndLastNodesList.remove(1); }


    private void insertFirstNode(Node<T> node) {
        this.pushNodeToFirstAndLastNodeList(node);
    }

    private void pushNode(Node<T> node) {
        this.getLastNode().setNextNode(node);
        node.setPreviousNode(this.getLastNode());
        this.setLastNode(node);
    }

    private void pushSecondNode(Node<T> node) {
        this.pushNodeToFirstAndLastNodeList(node);
        this.getFirstNode().setNextNode(node);
        this.setLastNode(node);
        this.getLastNode().setPreviousNode(this.getFirstNode());
    }

    private void unshiftNode(Node<T> node) {
       this.getFirstNode().setPreviousNode(node);
       node.setNextNode(this.getFirstNode());
       this.setFirstNode(node);
    }

    private void unshiftSecondNode(Node<T> node) {
        this.firstAndLastNodesList.add(0, node);
        this.getLastNode().setPreviousNode(node);
        this.setFirstNode(node);
        this.getFirstNode().setNextNode(this.getLastNode());
    }

    private boolean listHasMoreThanTwoNodes() {
        return this.sizeOfFirstAndLastNodesList() == 2 &&
            this.getFirstNode().getNextNode() != this.getLastNode() &&
            this.getLastNode().getPreviousNode() != this.getFirstNode();
    }
    private boolean listHasNoNodes() { return this.sizeOfFirstAndLastNodesList() == 0; }
    private boolean listHasOneNode() { return this.sizeOfFirstAndLastNodesList() == 1; }
    private boolean listHasTwoNodes() {
        return this.sizeOfFirstAndLastNodesList() == 2 &&
            this.getFirstNode().getNextNode() == this.getLastNode() &&
            this.getLastNode().getPreviousNode() == this.getFirstNode();
    }
    public T pop() {
        T lastNodeValue;
        if (this.listHasMoreThanTwoNodes()) {
            lastNodeValue = this.getLastNode().getNodeValue();
            Node<T> newLastNode = this.getLastNode().getPreviousNode();
            newLastNode.setNextNode(null);
            this.removeLastNodeFromFirstAndLastNodeList();
            this.pushNodeToFirstAndLastNodeList(newLastNode);
            this.setLastNode(newLastNode);
        } else if (this.listHasTwoNodes()) {
            lastNodeValue = this.getLastNode().getNodeValue();
            this.getFirstNode().setNextNode(null);
            this.removeLastNodeFromFirstAndLastNodeList();
        } else {
            lastNodeValue = this.getFirstNode().getNodeValue();
            this.firstAndLastNodesList.remove(0);
        }
        return lastNodeValue;
    }

    public void push(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.listHasNoNodes()) {
            this.insertFirstNode(newNode);
        } else if (this.listHasOneNode()) {
            this.pushSecondNode(newNode);
        } else {
            this.pushNode(newNode);
        }
    }

    public T shift() {
        T firstNodeValue = this.getFirstNode().getNodeValue();
        if (this.listHasMoreThanTwoNodes()) {
            Node<T> newFirstNode = this.getFirstNode().getNextNode();
            newFirstNode.setPreviousNode(null);
            this.firstAndLastNodesList.remove(0);
            this.firstAndLastNodesList.add(0, newFirstNode);
            this.setFirstNode(newFirstNode);
        } else if (this.listHasTwoNodes()) {
            this.getLastNode().setPreviousNode(null);
            this.firstAndLastNodesList.remove(0);
        } else {
            this.firstAndLastNodesList.remove(0);
        }
        return firstNodeValue;
    }

    public void unshift(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.listHasNoNodes()) {
            this.insertFirstNode(newNode);
        } else if (this.listHasOneNode()) {
            this.unshiftSecondNode(newNode);
        } else {
            this.unshiftNode(newNode);
        }
    }

}