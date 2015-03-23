package de.knoobie.project.clannadutils.interfaces;

import de.knoobie.project.clannadutils.bo.DBResult;

public interface DBService<T> {
    
    public DBResult add(T args);
    public DBResult update(T args);
    public DBResult remove(T args);
    public T findBy(long id);
    public T findBy(int vgmdbID);
    
}
