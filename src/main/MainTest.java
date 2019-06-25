package main;

import java.sql.Connection;

import dbDATA.*;

public class MainTest {

	public static void main(String[] args) {
		MiniDTO dto = DBCheck.dbSelectDTOSettion("danielLim");
		System.out.println(dto.getPw());
		
		
	}

}
