package com.zenika.formation;

import junit.framework.TestCase;

public class PersonTest extends TestCase{
	
	public void test1(){
		Person p = new Person();
		p.setName("Zenika");
		p.setFirstName("Zenika first name");
		
		assertEquals("Zenika", p.getName());
		assertEquals("Zenika first name", p.getFirstName());
	}

}
