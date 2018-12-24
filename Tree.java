package JavaExcersie;

import java.util.LinkedList;
import java.util.Queue;

//http://www.cnblogs.com/zyoung/p/7455916.html

/*
public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}
*/
public class Tree {
	TreeNode last;
	TreeNode nlast;
	TreeNode first;
	TreeNode nfirst;

	public void printTreeByLevel2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.peek();
			System.out.print(queue.poll().data + " ");
			if (t.left != null) {
				queue.add(t.left);
			}
			if (t.right != null) {
				queue.add(t.right);
			}
		}
	}

	public void printTreeByLevel(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		last = root;
		nlast = root;
		while (!queue.isEmpty()) {
			TreeNode t = queue.peek();
			System.out.print(queue.poll().data + " ");
			if (t.left != null) {
				queue.add(t.left);
				nlast = t.left;
			}
			if (t.right != null) {
				queue.add(t.right);
				nlast = t.right;
			}
			// 如果当前输出结点是最右结点，那么换行
			if (last == t) {
				System.out.println();
				last = nlast;
			}
		}
	}

	public void printTheMostRightNodes(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		last = root;
		nlast = root;
		while (!queue.isEmpty()) {
			TreeNode t = queue.peek();
			queue.poll();
			if (t.left != null) {
				queue.add(t.left);
				nlast = t.left;
			}
			if (t.right != null) {
				queue.add(t.right);
				nlast = t.right;
			}
			// 如果当前输出结点是最右结点，那么输出
			if (last == t) {
				System.out.print(t.data + " ");
				System.out.println();
				last = nlast;
			}
		}
	}

	public void printTheMostLeftNodes(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		first = root;
		nfirst = null;
		while (!queue.isEmpty()) {
			TreeNode t = queue.peek();
			queue.poll();
			if (t.left != null) {
				queue.add(t.left);
				if (null == nfirst) {
					nfirst = t.left;
				}
			}
			if (t.right != null) {
				queue.add(t.right);
				if (null == nfirst) {
					nfirst = t.right;
				}
			}
			// 如果当前输出结点是最左结点，那么输出
			if (first == t) {
				System.out.print(t.data + " ");
				System.out.println();
				first = nfirst;
				nfirst = null;
			}
		}
	}

	public static void main(String[] args) {
		// 构建二叉树
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		root.right.left.left.right = new TreeNode(9);
		root.right.left.left.right.left = new TreeNode(10);
		root.right.left.left.right.right = new TreeNode(11);
		Tree test = new Tree();
		test.printTreeByLevel2(root);
		System.out.println();
		System.out.println();
		test.printTreeByLevel(root);
		System.out.println();
		System.out.println();
		test.printTheMostRightNodes(root);
		System.out.println();
		System.out.println();
		test.printTheMostLeftNodes(root);
	}
}