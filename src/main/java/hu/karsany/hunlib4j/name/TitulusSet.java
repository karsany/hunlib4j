package hu.karsany.hunlib4j.name;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class TitulusSet implements Set<String> {

    private static TitulusSet titulusSet;
    private static Set<String> titulusok;

    private TitulusSet() throws IOException {
        InputStream resourceAsStream = this.getClass().getResourceAsStream("/name/TITULUS.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(resourceAsStream, Charset.forName("UTF-8"));
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        titulusok = new HashSet<String>();

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            titulusok.add(line.toUpperCase().trim());
        }
    }

    public static TitulusSet getInstance() {
        if (titulusSet == null) {
            try {
                titulusSet = new TitulusSet();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        return titulusSet;
    }

    @Override
    public int size() {
        return titulusok.size();
    }

    @Override
    public boolean isEmpty() {
        return titulusok.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return titulusok.contains(o);
    }

    @Override
    public Iterator<String> iterator() {
        return titulusok.iterator();
    }

    @Override
    public Object[] toArray() {
        return titulusok.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return titulusok.toArray(a);
    }

    @Override
    public boolean add(String s) {
        throw new UnsupportedOperationException("Titulusokhoz futás közben hozzáadni nem lehet.");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Titulusok közül futás közben törölni nem lehet.");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return titulusok.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException("Titulusokhoz futás közben hozzáadni nem lehet.");
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Titulusok közül futás közben törölni nem lehet.");
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Titulusok közül futás közben törölni nem lehet.");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Titulusok közül futás közben törölni nem lehet.");
    }
}
