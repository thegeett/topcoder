package gcjPractice.year2014.round1A;

import java.awt.List;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class FullBinaryTree {

	private static class Node {
		Node left;
		Node right;
		Node parent;
		int val;
		int child;

		public Node(Node left, Node right, Node parent, int val, int child) {
			this.left = left;
			this.right = right;
			this.parent = parent;
			this.val = val;
			this.child = child;
		}

		@Override
		public String toString() {
			return "Node [ val=" + val + ", child=" + child + "]";
		}

	}

	public static void main(String[] args) {
		String base = "C:\\programs\\GCJ\\FullBinaryTree\\";
		String input = base + "input.in";
		String output = base + "output.out";
		Scanner sc = null;
		PrintWriter pw = null;

		try {
			sc = new Scanner(new FileReader(input));
			pw = new PrintWriter(output);

			int t = sc.nextInt();
			sc.nextLine();
			int count = 1;
			while (t-- > 0) {
				int n = sc.nextInt();
				HashMap<Integer, java.util.List<Integer>> maps = new HashMap<Integer, java.util.List<Integer>>();
				HashMap<Integer, Integer> degree = new HashMap<Integer, Integer>();
				for (int i = 0; i < n - 1; i++) {
					int[] v = { sc.nextInt(), sc.nextInt() };
					for (Integer vi : v) {
						if (degree.containsKey(vi)) {
							int val = degree.get(vi);
							degree.put(vi, val + 1);
						} else {
							degree.put(vi, 1);
						}
					}
					ArrayList<Integer> list;
					if (maps.get(v[0]) != null) {
						list = (ArrayList<Integer>) maps.get(v[0]);
					} else {
						list = new ArrayList<Integer>();
					}
					list.add(v[1]);
					maps.put(v[0], list);

					if (maps.get(v[1]) != null) {
						list = (ArrayList<Integer>) maps.get(v[1]);
					} else {
						list = new ArrayList<Integer>();
					}
					list.add(v[0]);
					maps.put(v[1], list);
				}
				int result = slove(maps, degree, n);
				pw.println("Case #" + (count++) + ": " + result);
			} 

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (sc != null)
				sc.close();
			if (pw != null)
				pw.close();
		}

	}

	private static int slove(HashMap<Integer, java.util.List<Integer>> maps, HashMap<Integer, Integer> degree, int n) {
		ArrayList<Integer> rootNodes = new ArrayList<Integer>();
		for (Entry<Integer, java.util.List<Integer>> set : maps.entrySet()) {
			if (set.getValue().size() == 2) {
				rootNodes.add(set.getKey());
			}
		}
		int deletedNodeCount = 0;
		if (rootNodes.size() > 0) {
			deletedNodeCount = n;
			for (Integer r : rootNodes) {
				Node root = new Node(null, null, new Node(null, null, null, -1, 0), r, 0);
				root = makeTree(root, maps);
				int count = deleteNode(root, 0);
				deletedNodeCount = Math.min(count, deletedNodeCount);
			}
		}
		return deletedNodeCount;
	}

	private static int deleteNode(Node root, int count) {
		int c = count;
		if (root.child == 1) {
			if (root.left != null) {
				c += root.child;
				int g = deleteNode(root.left, c);
				c = g;
			}
			if (root.right != null) {
				c += root.child;
				int g = deleteNode(root.right, c);
				c = g;
			}
		} else {
			if (root.left != null)
				c = deleteNode(root.left, c);
			if (root.right != null)
				c = deleteNode(root.right, c);
		}
		return c;
	}

	private static Node makeTree(Node root, HashMap<Integer, java.util.List<Integer>> maps) {
		ArrayList<Integer> m = new ArrayList<Integer>(maps.get(root.val));
		for (Integer i : m) {
			if (root.left == null) {
				if (root.parent != null && i != root.parent.val) {
					root.left = makeTree(new Node(null, null, root, i, 0), maps);
				}
			} else {
				if (root.parent != null && i != root.parent.val) {
					root.right = makeTree(new Node(null, null, root, i, 0), maps);
				}
			}
		}
		int child = 0;
		if (root.left != null) {
			child++;
		}
		if (root.right != null) {
			child++;
		}
		root.child = child;
		return root;
	}
}
