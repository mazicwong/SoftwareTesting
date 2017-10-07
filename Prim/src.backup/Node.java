
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Node {
	private List<Path> paths = new ArrayList<Path>();; 
	private final String name; 
	
	public Node(String name, Path... paths){
		this.paths.addAll(Arrays.asList(paths));
		this.name = name;
	}
	public Node(String name){
		this.name = name;
	}
	
	public List<Path> getPaths(){
		return paths;
	}
	
	public void addPathWithoutSource(Path path){
		if(path.getSrcNode() == null){
			path.setSrcNode(this);
		}
		this.addPathWithSource(path);
		
	}

	
	private void addPathWithSource(Path path) {
		if(!this.paths.contains(path)){
			paths.add(path);
			path.getDestinationNode().addPathWithSource(new Path(path.getWeight(), this, path.getDestinationNode()));
		}
	}
	public String getName(){
		return this.name;
	}
	
	@Override
	public boolean equals(Object objToCompare){
		if(objToCompare instanceof Node){
			Node nodeToCompare = (Node) objToCompare; 
			if(this.getName().equals(nodeToCompare.getName())){
				return true; 
			}
		}
		
		return false; 
	}

}
