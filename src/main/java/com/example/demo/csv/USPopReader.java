package com.example.demo.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.StatePop;

public class USPopReader {
	public List<StatePop> getUSPop() {
		List<StatePop> statesPop = new ArrayList<>();
		try ( BufferedReader reader = new BufferedReader(new InputStreamReader(USPopReader.class.getResourceAsStream("/data/uspop.csv"))) ) {
			for ( int i = 0; i <= 50; ++i ) {
				String[] d = reader.readLine().split(",");
				if ( i == 0 ) continue;
				for ( int y = 1999; y <= 2018; ++y) {
					if ( y == 1999) continue; 
					statesPop.add(StatePop.builder().year(y).state(d[0]).population(Long.decode(d[y-1999])).build());
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statesPop;
	}
}
