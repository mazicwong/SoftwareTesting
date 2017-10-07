
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NodeNetwork {
	
	private List<Node> nodes; 
	
	public NodeNetwork(){
		this.setNodes(new ArrayList<Node>());
	}
	
	public NodeNetwork(List<Node> nodes){
		this.setNodes(nodes);
	}
	
	public NodeNetwork(Node... nodes){
		this.setNodes(Arrays.asList(nodes));
	}
	
	void addNode(Node node){
		this.getNodes().add(node);
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}
	
	@Override
	public String toString(){
		StringBuilder builder = new StringBuilder();
		for(Node currNode: nodes){
			builder.append(String.format("{ (%s) ", currNode.getName()));
			for(Path path: currNode.getPaths()){
				builder.append(String.format(" --> (%s)", path.getDestinationNode().getName()));
			}
			builder.append(String.format("} %s ", "\n"));
		}
		return builder.toString();
	}
	
}
