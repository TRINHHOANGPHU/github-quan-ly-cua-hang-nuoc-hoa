package DAL_NhapHang;

import java.util.ArrayList;

public interface DALinterface<T> {
	
	public boolean insert(T t);
	
	public boolean delete(T t);
	
	public boolean update(T t);
	
	public T getById(int id);
	
	public ArrayList<T> getAll();
	
}
