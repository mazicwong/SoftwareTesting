
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Prim {

	private NodeNetwork nodeNet;

	public Prim(NodeNetwork nodeNet) {
		this.nodeNet = nodeNet;
	}

	public List<Node> findWholeCaravaneWithPrim() {
		if (!nodeNet.getNodes().isEmpty()) {
			Node node = nodeNet.getNodes().get(0);

			ArrayList<Node> foundNodes = new ArrayList<Node>();
			List<Node> primNodes = findWholeCaravaneWithPrim(node, foundNodes,
					1);
			printNodes(primNodes);
			return primNodes;
		}
		return Collections.EMPTY_LIST;
	}
	
	public void printWholeCaravaneWithPrim() {
		if (!nodeNet.getNodes().isEmpty()) {
			Node node = nodeNet.getNodes().get(0);

			ArrayList<Node> foundNodes = new ArrayList<Node>();
			
			StringBuilder primPath = findWholeCaravaneWithPrim(node, foundNodes,
					1, new StringBuilder());
			primPath.deleteCharAt(primPath.lastIndexOf(","));
			
		}
		
	}


	private List<Node> findWholeCaravaneWithPrim(Node startNode,
			List<Node> foundNodes, int k) {

		Path smallPath = null;
		StringBuilder sBuilder = new StringBuilder("{");

		List<Path> possibilities = getPossibilities(startNode, foundNodes);

		Iterator<Path> pathIt = possibilities.iterator();
		while (pathIt.hasNext()) {
			Path currentPath = pathIt.next();
			if (foundNodes.contains(currentPath.getDestinationNode())) {
				continue;
			}
			sBuilder.append(String.format("(%s - %d -> %s), ", currentPath
					.getSrcNode().getName(), currentPath.getWeight(), currentPath
					.getDestinationNode().getName()));
			
			if (smallPath == null) {
				smallPath = currentPath;
				continue;
			}
			if (smallPath.getWeight() > currentPath.getWeight()) {
				smallPath = currentPath;
			}

		}
		sBuilder.append("}");

		if (smallPath != null) {
			
			foundNodes.add(smallPath.getDestinationNode());
			return findWholeCaravaneWithPrim(smallPath.getDestinationNode(),
					foundNodes, ++k);
		}

		return foundNodes;
	}

	private StringBuilder findWholeCaravaneWithPrim(Node startNode,
			List<Node> foundNodes, int k, StringBuilder pathExpl) {

		Path smallPath = null;
		StringBuilder sBuilder = new StringBuilder("{");

		List<Path> possibilities = getPossibilities(startNode, foundNodes);

		Iterator<Path> pathIt = possibilities.iterator();
		while (pathIt.hasNext()) {
			Path currentPath = pathIt.next();
			if (foundNodes.contains(currentPath.getDestinationNode())) {
				continue;
			}
			sBuilder.append(String.format("(%s - %d -> %s), ", currentPath
					.getSrcNode().getName(), currentPath.getWeight(), currentPath
					.getDestinationNode().getName()));
			if (smallPath == null) {
				smallPath = currentPath;
				continue;
			}
			if (smallPath.getWeight() > currentPath.getWeight()) {
				smallPath = currentPath;
			}

		}
		sBuilder.append("}");

		if (smallPath != null) {
			pathExpl.append(String.format(" (%s-- %d --> %s) ,  ", smallPath
					.getSrcNode().getName(), smallPath.getWeight(), smallPath
					.getDestinationNode().getName()));

			foundNodes.add(smallPath.getDestinationNode());
			return findWholeCaravaneWithPrim(smallPath.getDestinationNode(),
					foundNodes, ++k, pathExpl);
		}

		return pathExpl;
	}

	private List<Path> getPossibilities(Node startNode, List<Node> foundNodes) {
		List<Path> allPossiblePaths = new ArrayList<Path>();
		allPossiblePaths.addAll(startNode.getPaths());
		for (Node node : foundNodes) {
			allPossiblePaths.addAll(node.getPaths());
		}
		return allPossiblePaths;
	}

	private void printNodes(List<Node> primNodes) {
		StringBuilder builder = new StringBuilder("{");
		for (Node node : primNodes) {
			builder.append(String.format(" %s,", node.getName()));
		}
		builder.deleteCharAt(builder.lastIndexOf(","));
		builder.append("}");

	}

}
