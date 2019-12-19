public class HashTable {

    private int size;
    private String[] table;

    public HashTable(int size) {
        this.size = size;
        table = new String[size];
        for(int i=0; i<size; i++) table[i] = null;
    }

    private int getIndexToInsert(String s)
    {
        int hash=0;
        for (char c: s.toCharArray()) {
            hash+=(int) c;
        }
        return hash % size;
    }

    public boolean insert(String key)
    {
        int index = getIndexToInsert(key);
        //System.out.println("The hash size " + index);
        return insertToIndex(key, index, 0);
    }

    private boolean insertToIndex(String key, int index, int current)
    {
        if(current == size) return false;
        if(table[index] == null)
        {
            table[index]=key;
            return true;
        }
        return insertToIndex(key,(++index) % size,++current);
    }

    public int getHashIndex(String key)
    {
        int index = searchToIndex(key, getIndexToInsert(key), 0);
        if(index == -1)
            System.out.println("ERROR: Not found!");
        return index;
    }

    private int searchToIndex(String key, int index, int current)
    {
        if(current == size) return -1;
        if(table[index] == null) return -1;
        if(table[index].equals(key)) return index;
        return -1;
    }
}
