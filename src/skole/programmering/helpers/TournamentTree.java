package skole.programmering.helpers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    int val;
    Node left, right;

    public Node(int val) {
        this.val = val;
    }

    void print() {
        System.out.print(val+" ");
        if(left != null)
            left.print();
        if(right != null)
            right.print();
    }
}

public class TournamentTree {

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        int[] random = Tabell.randPerm(25);
        for(int i = 0; i < 13; i++) {
            nodes.add(new Node((random[i])));
        }
        Queue<Node> queue = new LinkedList<>(nodes);
        while (queue.size() > 1) {
            queue.add(playMatch(queue.poll(), queue.poll()));
        }
        Node winner = queue.peek();
        winner.print();
    }

    public static Node playMatch(Node a, Node b) {
        Node winner = new Node((char)Math.max(a.val, b.val));
        winner.left = a;
        winner.right = b;
        return winner;
    }
}
