// Copyright 2019 Sebastian Kuerten
//
// This file is part of gson-utils.
//
// gson-utils is free software: you can redistribute it and/or modify
// it under the terms of the GNU Lesser General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// gson-utils is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU Lesser General Public License for more details.
//
// You should have received a copy of the GNU Lesser General Public License
// along with gson-utils. If not, see <http://www.gnu.org/licenses/>.

package de.topobyte.gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonWriter;

public class GsonUtil
{

	public static JsonElement parse(String string)
	{
		JsonParser parser = new JsonParser();
		return parser.parse(string);
	}

	public static JsonElement parse(Reader reader)
	{
		JsonParser parser = new JsonParser();
		return parser.parse(reader);
	}

	public static JsonElement parse(InputStream input)
	{
		Reader reader = new InputStreamReader(input);
		JsonParser parser = new JsonParser();
		return parser.parse(reader);
	}

	public static String prettyPrint(JsonElement element) throws IOException
	{
		StringWriter sw = new StringWriter();
		JsonWriter writer = new JsonWriter(sw);
		writer.setIndent("  ");

		Streams.write(element, writer);
		return sw.toString();
	}

}