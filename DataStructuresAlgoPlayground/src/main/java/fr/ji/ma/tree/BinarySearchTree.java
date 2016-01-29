package fr.ji.ma.tree;

public class BinarySearchTree<T extends Comparable<T>> {
	private Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public Node<T> find(T targetValue) {
		Node<T> current = root;
		while (current != null) {
			if (targetValue.compareTo(current.getValue()) > 0)
				current = current.getRight();

			else if (targetValue.compareTo(current.getValue()) < 0)
				current = current.getLeft();

			else
				return current;
		}

		return null;
	}

	public void insert(T newVal) {
		Node<T> newNode = new Node<T>(newVal);

		Node<T> current = root;
		while (true) {
			if (current != null) {
				if (newVal.compareTo(current.getValue()) < 0) {
					if (current.getLeft() == null) {
						current.setLeft(newNode);
						return;
					} else
						current = current.getLeft();
				} else if (newVal.compareTo(current.getValue()) > 0) {
					if (current.getRight() == null) {
						current.setRight(newNode);
						return;
					} else
						current = current.getRight();
				}
			}

			else {
				// insert to root;
				root = newNode;
				return;
			}
		}
	}

	/**
	 * delete one given value in the current BST if exists
	 * 
	 * @param deleteVal
	 *            given value
	 */
	public void delete(T deleteVal) {
		Node<T> current = this.root;
		Node<T> parent = this.root;
		int flag = 0; // 0 means root, -1 means left child, 1 means right child

		while (current != null) {
			if (current.getValue().compareTo(deleteVal) > 0) {
				parent = current;
				current = current.getLeft();
				flag = -1;
			} else if (current.getValue().compareTo(deleteVal) < 0) {
				parent = current;
				current = current.getRight();
				flag = 1;
			} else {
				// element to be deleted is found and it's a leaf node without
				// zero child
				if (current.getLeft() == null && current.getRight() == null) {
					switch (flag) {
					case -1:
						parent.setLeft(null);
						break;
					case 0:
						this.root = null;
						break;
					case 1:
						parent.setRight(null);
						break;
					default:
						break;
					}
					return;
				}

				// element to be deleted has only one child
				if (!(current.getLeft() == null && current.getRight() == null)) {
					Node<T> child = current.getLeft() == null ? current.getRight() : current.getLeft();
					switch (flag) {
					case -1:
						parent.setLeft(child);
						break;
					case 0:
						this.root = child;
						break;
					case 1:
						parent.setRight(child);
						break;
					default:
						break;
					}
					return;
				}
				
				// element to be deleted has two children
				if (current.getLeft() != null && current.getRight() != null) {
					
				}
			}
		}
		
		return;
	}

	public void recursiveInOrderTraverse(Node<T> localRoot) {
		if (localRoot != null) {
			recursiveInOrderTraverse(localRoot.getLeft());

			System.out.println(localRoot.getValue().toString());

			recursiveInOrderTraverse(localRoot.getRight());
		}
	}

	public void recursivePreOrderTraverse(Node<T> localRoot) {
		if (localRoot != null) {
			System.out.println(localRoot.getValue().toString());
			recursivePreOrderTraverse(localRoot.getLeft());
			recursivePreOrderTraverse(localRoot.getRight());
		}
	}

	public void recursivePostOrderTraverse(Node<T> localRoot) {
		if (localRoot != null) {
			recursivePostOrderTraverse(localRoot.getLeft());
			recursivePostOrderTraverse(localRoot.getRight());
			System.out.println(localRoot.getValue().toString());
		}
	}

	public Node<T> getMinimum() {
		Node<T> min = this.root;
		while (min.getLeft() != null)
			min = min.getLeft();
		return min;
	}

	public Node<T> getMaxmimum() {
		Node<T> max = this.root;
		while (max.getRight() != null)
			max = max.getRight();
		return max;
	}
}
