package com.chrischurchwell.radioheadlazershow.cloud;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PointCloud {

	private List<Point> points = new ArrayList<Point>();
	
	public void loadCSV(File csv) {
		
		try {
			FileInputStream inputStream = new FileInputStream(csv);
			Scanner scanner = new Scanner(inputStream);
			while (scanner.hasNextLine()) {
				String[] data = scanner.nextLine().toLowerCase().trim().split(",");
				
				//structure is x, y, z, intensity
				Point point = new Point(
						Float.valueOf(data[0]),
						Float.valueOf(data[1]),
						Float.valueOf(data[2]),
						Integer.valueOf(data[3])
						);
				
				points.add(point);
			}
			
			scanner.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getPointCount() {
		return points.size();
	}
	
	public List<Point> getPoints() {
		return points;
	}
}
