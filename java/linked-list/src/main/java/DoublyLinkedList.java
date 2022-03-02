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
    private final HeadAndTail headAndTail;

    public DoublyLinkedList() {
        this.headAndTail = new HeadAndTail();
    }

    public T pop() {
        T tailNodeValue = this.getTailNodeValue();
        if (this.headAndTail.listHasMoreThanHeadOrTailNodes()) {
            this.popFromListWithMoreThanHeadOrTailNodes();
        } else if (this.headAndTail.listHasOnlyHeadAndTailNodes()) {
            this.popFromListWhichOnlyHasHeadAndTailNodes();
        } else {
            this.headAndTail.removeHeadNodeFromHeadAndTailNodeList();
        }
        return tailNodeValue;
    }

    public void push(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.headAndTail.listHasNoHeadOrTail()) {
            this.headAndTail.pushHeadNode(newNode);
        } else if (this.headAndTail.listHasOnlyHeadNode()) {
            this.headAndTail.pushTailNode(newNode);
        } else {
            this.headAndTail.pushNode(newNode);
        }
    }

    public T shift() {
        T headNodeValue = this.headAndTail.getHeadNode().getNodeValue();
        if (this.headAndTail.listHasMoreThanHeadOrTailNodes()) {
            this.shiftFromListWithMoreThanHeadOrTailNodes();
        } else if (this.headAndTail.listHasOnlyHeadAndTailNodes()) {
            this.shiftFromListWhichOnlyHasHeadAndTailNodes();
        } else {
            this.headAndTail.removeHeadNodeFromHeadAndTailNodeList();
        }
        return headNodeValue;
    }

    public void unshift(T t) {
        Node<T> newNode = new Node<>(t);
        if (this.headAndTail.listHasNoHeadOrTail()) {
            this.headAndTail.pushHeadNode(newNode);
        } else if (this.headAndTail.listHasOnlyHeadNode()) {
            this.headAndTail.unshiftTailNode(newNode);
        } else {
            this.headAndTail.unshiftNode(newNode);
        }
    }

    private T getTailNodeValue() {
        return this.headAndTail.sizeHeadAndTailNodeList() >= 2 ?
            this.headAndTail.getTailNode().getNodeValue() :
            this.headAndTail.getHeadNode().getNodeValue();
    }

    private void popFromListWhichOnlyHasHeadAndTailNodes() {
        this.headAndTail.getHeadNode().setNextNode(null);
        this.headAndTail.removeTailNodeFromHeadAndTailNodeList();
    }

    private void popFromListWithMoreThanHeadOrTailNodes() {
        Node<T> newTailNode = this.headAndTail.getTailNode().getPreviousNode();
        newTailNode.setNextNode(null);
        this.headAndTail.removeTailNodeFromHeadAndTailNodeList();
        this.headAndTail.pushNodeOntoHeadAndTailNodeList(newTailNode);
        this.headAndTail.setTailNode(newTailNode);
    }

    private void shiftFromListWhichOnlyHasHeadAndTailNodes() {
        this.headAndTail.getTailNode().setPreviousNode(null);
        this.headAndTail.removeHeadNodeFromHeadAndTailNodeList();
    }

    private void shiftFromListWithMoreThanHeadOrTailNodes() {
        Node<T> newFirstNode = this.headAndTail.getHeadNode().getNextNode();
        newFirstNode.setPreviousNode(null);
        this.headAndTail.removeHeadNodeFromHeadAndTailNodeList();
        this.headAndTail.unshiftNodeOntoHeadAndTailNodeList(newFirstNode);
        this.headAndTail.setHeadNode(newFirstNode);
    }


    class HeadAndTail {
        private final List<Node<T>> list;

        HeadAndTail() { this.list = new ArrayList<Node<T>>(2); }

        private Node<T> getHeadNode() { return this.list.get(0); }
        private void setHeadNode(Node<T> node) { this.list.set(0, node); }
        private Node<T> getTailNode() { return this.list.get(1); }
        private void setTailNode(Node<T> node) { this.list.set(1, node); }

        private void pushNodeOntoHeadAndTailNodeList(Node<T> node) { this.list.add(node); }
        private void removeTailNodeFromHeadAndTailNodeList() { this.list.remove(1); }
        private void removeHeadNodeFromHeadAndTailNodeList() { this.list.remove(0); }
        private void unshiftNodeOntoHeadAndTailNodeList(Node<T> node) { this.list.add(0, node); }

        private void pushHeadNode(Node<T> node) {
            this.pushNodeOntoHeadAndTailNodeList(node);
        }

        private void pushNode(Node<T> node) {
            this.getTailNode().setNextNode(node);
            node.setPreviousNode(this.getTailNode());
            this.setTailNode(node);
        }

        private void pushTailNode(Node<T> node) {
            this.pushNodeOntoHeadAndTailNodeList(node);
            this.getHeadNode().setNextNode(node);
            this.setTailNode(node);
            this.getTailNode().setPreviousNode(this.getHeadNode());
        }

        private void unshiftNode(Node<T> node) {
            this.getHeadNode().setPreviousNode(node);
            node.setNextNode(this.getHeadNode());
            this.setHeadNode(node);
        }

        private void unshiftTailNode(Node<T> node) {
            this.unshiftNodeOntoHeadAndTailNodeList(node);
            this.getTailNode().setPreviousNode(node);
            this.setHeadNode(node);
            this.getHeadNode().setNextNode(this.getTailNode());
        }

        private boolean listHasMoreThanHeadOrTailNodes() {
            return this.sizeHeadAndTailNodeList() == 2 &&
                this.getHeadNode().getNextNode() != this.getTailNode() &&
                this.getTailNode().getPreviousNode() != this.getHeadNode();
        }

        private boolean listHasNoHeadOrTail() { return this.sizeHeadAndTailNodeList() == 0; }

        private boolean listHasOnlyHeadNode() { return this.sizeHeadAndTailNodeList() == 1; }

        private boolean listHasOnlyHeadAndTailNodes() {
            return this.sizeHeadAndTailNodeList() == 2 &&
                this.getHeadNode().getNextNode() == this.getTailNode() &&
                this.getTailNode().getPreviousNode() == this.getHeadNode();
        }

        private int sizeHeadAndTailNodeList() { return this.list.size(); }
    }
}