package com.ssu.persistence;

import java.util.List;

public interface GenericDAO<E, K> {
	public K getTime();
	public void register(E vo);
	public E get(K userid);
	public List<E> getList();
}
