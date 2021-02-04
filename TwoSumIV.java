import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}


public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> tree = new HashSet<>();
        return findtar(root,k,tree);
    }
    public boolean findtar(TreeNode root, int k, Set<Integer> tree ){
        if (root == null){
            return false;
        }
        if (tree.contains(k- root.val)){
            return true;
        }
        tree.add(root.val);
        return findtar(root.left,k,tree) || findtar(root.right,k,tree);
    }

    public static void main(String[] args) {
        //driver code to call findTarget() //input bst and target
    }
}
