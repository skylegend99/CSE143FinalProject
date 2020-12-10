// Import all of the package we need in this class.
// LevenshteinDistance package could autocorrect spelling error
import java.util.*;
import java.io.*;
import org.apache.commons.text.WordUtils;
import org.apache.commons.text.similarity.LevenshteinDistance;
public class Function {
	// Information of each TA
	private Map<String, Information> info;

	// Evaluation of each TA
	private Map<String, Evaluation> eva;

	// Used to Autocorrect words
	private LevenshteinDistance distance;

	// Construct tree root
	private Node overallRoot;


	// Initializes the fields.
	public Function(int course)  {
		info = constructInfo(course);
		eva = constructEva();
		distance = new LevenshteinDistance();
		overallRoot = constructNode();
	}

	// Constructs a map based on the given course to store the information of TA.
	public Map<String, Information> constructInfo(int course) {
		try {
			Map<String, Information> data = new HashMap<>();
			Scanner input = new Scanner(new File("datasets/" + course + ".csv"));
			while (input.hasNextLine()) {
				String[] line = input.nextLine().split(",");
				data.put(line[0], Information.fromCsv(line[0], line[1], line[2], line[3], line[4], input.nextLine()));
			}
			return data;
		} catch (Exception FileNotFoundException) {
			System.out.println("File not found");
		}
		return null;
	}

	// Construcs a map to store the evaluations of TA.
	public Map<String, Evaluation> constructEva() {
		try {
			Map<String, Evaluation> data = new HashMap<>();
			Scanner input = new Scanner(new File("datasets/evaluation.csv"));
			while (input.hasNextLine()) {
				String[] line = input.nextLine().split(";");
				data.put(line[0], Evaluation.fromCsv(line[1], line[2], line[3], line[4], line[5]));
			}
			return data;
		} catch (Exception FileNotFoundException) {
			System.out.println("File not found");
		}
		return null;
	}

	// Constructs the tree.
	public Node constructNode() {
		return constructNode(new ArrayList<>(eva.keySet()), overallRoot, 0);
	}

	// Constructs the tree based on the List, Node and an integer as parameters.
	private Node constructNode(List<String> nameList, Node root, int i) {
		if (i < nameList.size()) {
			String name = nameList.get(i);
			Evaluation rootEva = eva.get(name);
			root = new Node(rootEva, name);
			root.left = constructNode(nameList, root.left, 2 * i + 1);
			root.right = constructNode(nameList, root.right, 2 * i + 2);
		}
		return root;
	}

	// Constructs the Node based on a set.
	public void rating(Set<String> features) {
		overallRoot = rating(overallRoot, features);
	}

	// Constructs and returns the Node.
	private Node rating(Node root, Set<String> features) {
		if (root != null) {
			rating(root.left, features);
			rating(root.right, features);
			Evaluation evaluation = root.evaluation;
			if (features.contains(evaluation.amPm)) {
				root.data++;
			}
			if (features.contains(evaluation.color)) {
				root.data++;
			}
			if (features.contains(evaluation.pace)) {
				root.data++;
			}
			if (features.contains(evaluation.style)) {
				root.data++;
			}
			for (String feature : evaluation.personality) {
				if (features.contains(feature)) {
					root.data++;
				}
			}
		}
		return root;
	}

	// Returns the root with the largest value as a string
	public String largest() {
		return largest(overallRoot).name;
	}

	// Computes the root with the largest value
	private Node largest(Node root) {
		if (root.isLeaf()){
			return root;
		} else if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {
			int current = root.data;
			Node left = largest(root.left);
			Node right = largest(root.right);
			Node max = left.data > right.data? left : right;
			max = max.data > current? max : root;
			return max;
		}
	}

	// Returns whether to scan as a boolean
	public Boolean scan(String name) {
		name = WordUtils.capitalizeFully(name);
		if (info.containsKey(name)) {
			return true;
		}
		return false;
	}

	// Add infomation of ta to info
	public Information search(String name) {
		name = WordUtils.capitalizeFully(name);
		if (!info.containsKey(name)) {
			int min = Integer.MAX_VALUE;
			String correct = "";
			for (String key : info.keySet()) {
				int temp = distance.apply(key, name);
				if (temp < min) {
					min = temp;
					correct = key;
				}
			}
			return info.get(correct);
		} else {
			return info.get(name);
		}
	}

	// Returns the evaluation as a set
	public Set<String> getEvaName() {
		return eva.keySet();
	}

	// Constructs the Node
	private static class Node {
		public Evaluation evaluation;
		public String name;
		public int data;
		public Node left;
		public Node right;

		public Node(Evaluation evaluation, String name) {
			this(evaluation, name, 0, null, null);
		}

		// Accesses the node
		public Node(Evaluation evaluation, String name, int data, Node left, Node right) {
			this.evaluation = evaluation;
			this.name = name;
			this.data = data;
			this.left = left;
			this.right = right;
		}

		// Returns true if and only if this node is a leaf node.
		public boolean isLeaf() {
			return left == null && right == null;
		}
	}
}
