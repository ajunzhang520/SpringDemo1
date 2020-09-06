package leecode.math;

/**
 * ajunzhang
 * 2020/4/6 11:07
 **/
public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);
        TreeNode g = new TreeNode(7);
        TreeNode h = new TreeNode(8);

        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = null;

        d.left = null;
        d.right = null;

        e.left = g;
        e.right = h;

        f.left = null;
        f.right = null;

        g.left = null;
        g.right = null;

        h.left = null;
        h.right = null;

        LowestCommonAncestor test = new LowestCommonAncestor();
        TreeNode common = test.lowestCommonAncestor(a, d, e);
        System.out.println(common.val);
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
