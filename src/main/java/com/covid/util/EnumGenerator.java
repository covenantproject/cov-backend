package com.covid.util;


import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;

public class EnumGenerator {
	
	public static Map<String, String> map = new HashMap<>();
	
	public static List<String> read(File file)throws Exception {
		List<String> result = Files.readAllLines(file.toPath());
		return result;
		
	}
	
	public static void write(String file, String content)throws Exception{
		File f = new File(file);
		Files.write(f.toPath(), content.getBytes(), StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE);
		
	}
	
	public static String toModelName(String tableName){
		String[] tokens = tableName.split("_");
		String result = "";
		
		for(String item: tokens){
			result += item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase();
		}
		return result;
	}

	
	public static String toVarName(String input){
		String result = toModelName(input);
		result = result.substring(0, 1).toLowerCase() + result.substring(1);
		
		return result;
	}
	
	public static void main(String args[])throws Exception{
		map.put("emer_contact_1_rel_to_pat", "relationship_type");
		map.put("emer_contact_2_rel_to_pat", "relationship_type");
		map.put("next_of_kin_1_rel_to_pat", "relationship_type");
		map.put("next_of_kin_2_rel_to_pat", "relationship_type");
		map.put("rel_type", "provider_role");
		map.put("quar_islt_request_status", "request_status");
		map.put("medical_request_status", "request_status");
		map.put("supplies_request_status", "request_status");
		map.put("request_status", "request_status");
		map.put("heartbeat_status", "app_heartbeat_status");
		
		
		String reg = ".+\\([ ]*\\w+[ ]+IN[ ]*\\(.+";
		File file = new File("/Users/peterhuang/git/cov-backend/DB Script/2_Documentation_Constraints.sql");
		List<String> lines = read(file);
		for(String line: lines) {
			if(line.matches(reg)) {
				//System.out.println(line);
				int index = line.indexOf("CHECK (")+"CHECK (".length();
				int end = line.indexOf("IN", index);
				String name = line.substring(index, end).trim();
				if(map.get(name) != null) {
					name = map.get(name);
				}
				
				index = line.indexOf("(", index) + 1;
				end = line.indexOf(")", index);
				String rv = line.substring(index, end);
				rv = rv.replaceAll("'", "");

				String[] values = rv.split(",");
				Set<String> set = Sets.newHashSet(values);
				
				
				String enumName = toModelName(name);
				String out = "package com.covid.model.type;\n" 
						+"\n" 
						+ "public enum "+enumName+" {\n"; 
				for(String v: set) {
					out += "\t"+toVarName(v).trim()+",\n";
				}
				
				out += "\t;\n";
				out += "}\n";
				String of = "/Users/peterhuang/git/cov-backend/src/main/java/com/covid/model/type/"+enumName+".java";
				write(of, out);
				System.out.println(out);
				
			}
		}
	}
	
	
}
