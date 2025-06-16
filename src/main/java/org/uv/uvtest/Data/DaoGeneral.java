/*
 * Interface DAO
 */
package org.uv.uvtest.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rodrigo08
 */
public interface DaoGeneral<T> {
    
    public boolean add(T pojo);
    public boolean delete(T pojo);
    public boolean update(T pojo);
    public T read(int Cod_emp);
    public List<T> readAll();
    
}
