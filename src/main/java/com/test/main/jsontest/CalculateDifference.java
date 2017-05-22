package com.test.main.jsontest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.flipkart.zjsonpatch.JsonDiff;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class CalculateDifference
{

	static final String	LOC1	= "C:/C_DRIVE/WORKSPACE/WAP-ECLIPSE/email-poc/src/main/java/com/test/main/jsontest/t1.json";
	static final String	LOC2	= "C:/C_DRIVE/WORKSPACE/WAP-ECLIPSE/email-poc/src/main/java/com/test/main/jsontest/t2.json";

	public static void main(String[] args)
	{
		try
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode source = mapper.readTree(getJSONString(LOC1));
			JsonNode target = mapper.readTree(getJSONString(LOC2));
			JsonNode diff = JsonDiff.asJson(source, target);

			printPretty(diff.toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private static String getJSONString(String fileLocation) throws Exception
	{
		File file = new File(fileLocation);
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null)
		{
			buffer.append(line);
		}

		reader.close();
		//System.out.println(buffer);
		return buffer.toString();
	}

	public static void printPretty(String uglyJSONString)
	{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(uglyJSONString);
		String prettyJsonString = gson.toJson(je);
		System.out.println(prettyJsonString);
	}
}
