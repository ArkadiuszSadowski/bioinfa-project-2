import java.util.ArrayList;

public class Connection {
    private String superString;
    private List<Vertex> mergedList = new ArrayList<Vertex>();
    private int cover = 0;

    public Connection(String s) {
        superString = s;
    }

    public String getSuperString() {
        return superString;
    }

    public void setSuperString(String s) {
        superString = s;
    }

    public List<Vertex> getCoveredVertexs() {
        return mergedList;
    }

    public void addCoveredVertexs(Vertex Vertex) {
        mergedList.Add(Vertex);
    }

    public int getSumCoverage() {
        return cover;
    }

    public void addSumCoverage(int coverage) {
        cover += coverage;
    }
}
