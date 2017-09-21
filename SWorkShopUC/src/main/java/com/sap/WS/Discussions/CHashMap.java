package com.sap.WS.Discussions;

import java.util.Map;
import java.util.Objects;

public class CHashMap<K,V> {

	private int capacity = 4;
	private int size =4;
	
	private Entry<K, V> []table;
	
	static class Entry<K,V> {
		final K key;
		V value;
		final int hash;
		Entry<K,V> next;
		
		public Entry(K key, V value, int hash, Entry next) {
			super();
			this.key = key;
			this.value = value;
			this.hash = hash;
			this.next = next;
		}
		 
		public int hashCode() {
			return Objects.hashCode(key) ^ Objects.hash(value) ;
		}
		
		  public final boolean equals(Object o) {
	            if (o == this)
	                return true;
	            if (o instanceof Map.Entry) {
	                Map.Entry<?,?> e = (Map.Entry<?,?>)o;
	                if (Objects.equals(key, e.getKey()) &&
	                    Objects.equals(value, e.getValue()))
	                    return true;
	            }
	            return false;
	        }
	}
	
	public CHashMap() {
		table = new Entry [capacity];
	}
	
	
	
	public int hash(K key) {
		return key.hashCode() & capacity;
	}
	
	public V get(K key){
	
		int hash = hash(key);
		if(table[hash] == null)
			return null;
		else {
			Entry<K, V> tempEntry = table[hash];
			while(tempEntry!=null) {
				if(tempEntry.key.equals(key)) {
					return tempEntry.value;
				}
				tempEntry = tempEntry.next;
			}
			return null;
		}
	}
	
	public void put(K key, V value) {
		int hash = hash(key);
		Entry<K, V> putEntry = new Entry<K, V>(key, value,hash, null);
		
		if(key == null)
			return ;
		
		if(table[hash] == null)
			table[hash] = putEntry;
		else {
			Entry<K, V> previousNode = null;
			Entry<K, V> currentNode = table[hash];
			
			while(currentNode != null) {
				if(currentNode.key.equals(key)){
					if(previousNode == null){
						putEntry.next = currentNode.next;
						table[hash] = putEntry;
						return;
					}else{
						previousNode.next = currentNode;
						putEntry.next = currentNode.next;
						return;
					}
				}
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			
		}
	}
}
