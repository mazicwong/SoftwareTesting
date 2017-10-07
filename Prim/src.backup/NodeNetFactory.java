
public class NodeNetFactory {
	
	public static NodeNetwork buildNetwork(){
		Node v1 = new Node("V1");
		Node v2 = new Node("V2");
		Node v3 = new Node("V3");
		Node v4 = new Node("V4");
		Node v5 = new Node("V5");
		Node v6 = new Node("V6");
		Node v7 = new Node("V7");
		v1.addPathWithoutSource(new Path(4, v2));
		v1.addPathWithoutSource(new Path(1, v3));
		v1.addPathWithoutSource(new Path(5, v6));
		v1.addPathWithoutSource(new Path(3, v7));
		v1.addPathWithoutSource(new Path(6, v4));
		
		
		v2.addPathWithoutSource(new Path(1, v6));
		v2.addPathWithoutSource(new Path(3, v5));
		
		v3.addPathWithoutSource(new Path(8, v5));
		v3.addPathWithoutSource(new Path(9, v6));
		
		v4.addPathWithoutSource(new Path(5, v5));
		v4.addPathWithoutSource(new Path(5, v7));
		v4.addPathWithoutSource(new Path(4, v6));
		
		v5.addPathWithoutSource(new Path(2, v6));
		
		v6.addPathWithoutSource(new Path(6, v7));
		v6.addPathWithoutSource(new Path(9, v3));
		v6.addPathWithoutSource(new Path(4, v4));
		v6.addPathWithoutSource(new Path(5, v1));
		
		
		NodeNetwork network = new NodeNetwork(v1,v2,v3,v4,v5,v6,v7);
		
		return network; 
	}
}
