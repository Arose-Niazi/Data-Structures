public class Graph {
    private Vertice[] VerticesArray;
    private int[][] Connections;
    private int vertices;

    private int lastIndex;

    public Graph(int vertices) {
        this.vertices=vertices;

        lastIndex=0;
        VerticesArray = new Vertice[vertices];
        Connections = new int[vertices][vertices];
    }

    public Vertice addVertice(String name)
    {
        Vertice v = new Vertice(name);
        VerticesArray[lastIndex++] = v;
        return v;
    }

    public void setAdjacent(Vertice to,Vertice from, int distance)
    {
        int toIndex = getIndex(to);
        if(toIndex == -1)
        {
            System.out.println("Please enter valid starting vertice.");
            return;
        }
        int fromIndex = getIndex(from);
        if(fromIndex == -1)
        {
            System.out.println("Please enter valid ending vertice.");
            return;
        }
        Connections[toIndex][fromIndex] = distance;
    }

    private int getIndex(Vertice v)
    {
        for(int i=0; i<vertices; i++)
            if(VerticesArray[i] == v)
                return i;
        return -1;
    }

    public Vertice searchVertice(String name)
    {
        for(int i=0; i<vertices; i++)
        {
            if(name.equals(VerticesArray[i].name))
                return VerticesArray[i];
        }
        return null;
    }

    public void displayAdjacentVertices(Vertice v)
    {
        int index = getIndex(v);
        System.out.print("Adjacent Vertice/distance: ");
        for(int i=0; i<vertices; i++)
        {
            if(Connections[index][i] > 0)
            {
                System.out.print(VerticesArray[i].name + "/" + Connections[index][i] + "\t");
            }
        }
        System.out.println(" ");
    }
}
