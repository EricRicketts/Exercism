import java.util.ArrayList;
import java.util.List;

class Node<T> {
    private final T nodeValue;
    private Node<T> nextNode;
    private Node<T> previousNode;

    Node(T value) { this.nodeValue = value; }

    T getNodeValue() { return this.nodeValue; }

    Node<T> getNextNode() { return this.nextNode; }
    void setNextNode(Node<T> nextNode) { this.nextNode = nextNode; }

    Node<T> getPreviousNode() { return this.previousNode; }
    void setPreviousNode(Node<T> previousNode) { this.previousNode = previousNode; }
}

public class DoublyLinkedList<T> {
    private final List<Node<T>> firstAndLastNodesList;
    private final ListStatus listStatus;

    public DoublyLinkedList() {
        this.firstAndLastNodesList = new ArrayList<>(2);
        this.listStatus = new ListStatus();
    }

    private Node<T> getFirstNode() { return this.firstAndLastNodesList.get(0); }
    private void setFirstNode(Node<T> node) { this.firstAndLastNodesList.set(0, node); }
    private Node<T> getLastNode() { return this.firstAndLastNodesList.get(1); }
    private void setLastNode(Node<T> node) { this.firstAndLastNodesList.set(1, node); }

    private int sizeOfFirstAndLastNodesList() { return this.firstAndLastNodesList.size(); }
    private void pushNodeToFirstAndLastNodeList(Node<T> node) { this.firstAndLastNodesList.add(node); }
    private void removeLastNodeFromFirstAndLastNodeList() { this.firstAndLastNodesList.remove(1); }
    private void removeFirstNodeFromFirstAndLastNodeList() { this.firstAndLastNodesList.remove(0); }
    private void unshiftNodeToFirstAndLastNodeList(Node<T> node) { this.firstAndLastNodesList.add(0, node); }


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
        this.unshiftNodeToFirstAndLastNodeList(node);
        this.getLastNode().setPreviousNode(node);
        this.setFirstNode(node);
        this.getFirstNode().setNextNode(this.getLastNode());
    }

    public T pop() {
        T lastNodeValue;
        if (this.listStatus.listHasMoreThanTwoNodes()) {
            lastNodeValue = this.getLastNode().getNodeValue();
            Node<T> newLastNode = this.getLastNode().getPreviousNode();
            newLastNode.setNextNode(null);
            this.removeLastNodeFromFirstAndLastNodeList();
            this.pushNodeToFirstAndLastNodeList(newLastNode);
            this.setLastNode(newLastNode);
        } else if (this.listStatus.listHasTwoNodes()) {
            lastNodeValue = this.getLastNode().getNodeValue();
            this.getFirstNode().setNextNode(null);
            this.removeLastNodeFromFirstAndLastNodeList();
        } else {
            lastNodeValue = this.getFirstNode().getNodeValue();
            this.removeFirstNodeFromFirstAndLastNodeList();
        }
        return lastNodeValue;
    }

    public void push(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.listStatus.listHasNoNodes()) {
            this.insertFirstNode(newNode);
        } else if (this.listStatus.listHasOneNode()) {
            this.pushSecondNode(newNode);
        } else {
            this.pushNode(newNode);
        }
    }

    public T shift() {
        T firstNodeValue = this.getFirstNode().getNodeValue();
        if (this.listStatus.listHasMoreThanTwoNodes()) {
            Node<T> newFirstNode = this.getFirstNode().getNextNode();
            newFirstNode.setPreviousNode(null);
            this.removeFirstNodeFromFirstAndLastNodeList();
            this.unshiftNodeToFirstAndLastNodeList(newFirstNode);
            this.setFirstNode(newFirstNode);
        } else if (this.listStatus.listHasTwoNodes()) {
            this.getLastNode().setPreviousNode(null);
            this.removeFirstNodeFromFirstAndLastNodeList();
        } else {
            this.removeFirstNodeFromFirstAndLastNodeList();
        }
        return firstNodeValue;
    }

    public void unshift(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.listStatus.listHasNoNodes()) {
            this.insertFirstNode(newNode);
        } else if (this.listStatus.listHasOneNode()) {
            this.unshiftSecondNode(newNode);
        } else {
            this.unshiftNode(newNode);
        }
    }

    class ListStatus {
        private boolean listHasMoreThanTwoNodes() {
            return sizeOfFirstAndLastNodesList() == 2 &&
                    getFirstNode().getNextNode() != getLastNode() &&
                    getLastNode().getPreviousNode() != getFirstNode();
        }

        private boolean listHasNoNodes() { return sizeOfFirstAndLastNodesList() == 0; }

        private boolean listHasOneNode() { return sizeOfFirstAndLastNodesList() == 1; }

        private boolean listHasTwoNodes() {
            return sizeOfFirstAndLastNodesList() == 2 &&
                    getFirstNode().getNextNode() == getLastNode() &&
                    getLastNode().getPreviousNode() == getFirstNode();
        }
    }
}