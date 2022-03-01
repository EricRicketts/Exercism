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
    private void addNodeToFirstAndLastNodeList(Node<T> node) { this.firstAndLastNodesList.add(node); }


    private void insertFirstNode(Node<T> node) {
        this.addNodeToFirstAndLastNodeList(node);
    }

    private void pushNode(Node<T> node) {
        this.getLastNode().setNextNode(node);
        node.setPreviousNode(this.getLastNode());
        this.setLastNode(node);
    }

    private void pushSecondNode(Node<T> node) {
        this.addNodeToFirstAndLastNodeList(node);
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
            this.firstAndLastNodesList.remove(1);
            this.addNodeToFirstAndLastNodeList(newLastNode);
            this.setLastNode(newLastNode);
        } else if (this.listHasTwoNodes()) {
            lastNodeValue = this.getLastNode().getNodeValue();
            this.getFirstNode().setNextNode(null);
            this.firstAndLastNodesList.remove(1);
        } else {
            lastNodeValue = this.getFirstNode().getNodeValue();
            this.firstAndLastNodesList.remove(0);
        }
        return lastNodeValue;
    }


    /*
        list size = 1
            - return the value of the node
            - remove the node from the list
        list size = 2
            - return the value of the first node
            - remove the node from the list
            - the last node previous should point to null
        list size > 2
            - return the value of the first node
            - store the next value of the first node in a variable
            - set the first node in the list to be the second value
            - set the previous value to be of the first node to be null
    */

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
/*
    [1, 2]
    1 - previous is null, next is 2
    2 - previous is 1, next is null
    [1, 2, 3]
    1 - previous is null, next is 2, remains the same
    2 - previous is 1, now next is set to 3
    3 - previous is set to 2, nex is set to null
    when 3 is added, 2 now needs to point to 3 as its next node
    - push method
        - the value comes in we do the following checks
        - if both first and last nodes are null
            - create a node
            - put it as the first node
            - set its previous and next as null
        - if the fist node is not null and the second node is null
            - create a node
            - put it as the second node
            - set it's previous to the first node
            - the next of the first node is now the second node
        - if neither first and second nodes are null
            - create a node
            -
*/