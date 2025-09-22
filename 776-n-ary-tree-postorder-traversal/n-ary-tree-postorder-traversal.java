/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> ans;
    public List<Integer> postorder(Node root) {
        ans = new ArrayList();
        postOrder(root);
        return ans;
    }
    private void postOrder(Node root){
        if(root == null)
            return;
        for(Node temp: root.children)
            postOrder(temp);
        ans.add(root.val);
    }
}