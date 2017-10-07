/**
 * @author lkh
 *
 */
public class Path {
	private final int weight; 
	private  Node destinationNode;
	private  Node srcNode; 
	
	public Path(int weight, Node destinationNode, Node srcNode) {
		super();
		this.weight = weight;
		this.destinationNode = destinationNode;
		this.srcNode = srcNode;
	}
	public Path(int weight, Node destinationNode) {
		super();
		this.weight = weight;
		this.destinationNode = destinationNode;
		
	}

	public int getWeight() {
		return weight;
	}

	public Node getDestinationNode() {
		return destinationNode;
	}

	public Node getSrcNode() {
		return srcNode;
	}
	
	public void setSrcNode(Node node) {
		this.srcNode = node;
	}
	
	@Override
	public boolean equals(Object objectToCompare){
		if(objectToCompare instanceof Path){
			Path pathToCompare = (Path) objectToCompare;
			if((this.srcNode.equals(pathToCompare.getSrcNode()) && 
					this.destinationNode.equals(pathToCompare.getDestinationNode())) 
				||
				(this.srcNode.equals(pathToCompare.getDestinationNode()) 
						&& this.destinationNode.equals(pathToCompare.getSrcNode()))){
					return true; 
			}
		}
		return false;
	}
	
}
