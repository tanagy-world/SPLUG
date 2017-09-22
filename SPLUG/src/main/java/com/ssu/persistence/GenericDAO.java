package com.ssu.persistence;

import java.util.List;

public interface GenericDAO<E, K> {
	public void register(E vo);

	public boolean loginCheck(E vo);

	public E get(K userid);

	public int delete(K userid);

	public List<E> getList();

	public boolean idCheck(String id);

}
